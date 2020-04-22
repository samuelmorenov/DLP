package codegeneration;

import java.io.*;
import java.util.*;

import ast.*;
import visitor.*;

enum CodeFunction {
	ADDRESS, VALUE
}

public class CodeSelection extends DefaultVisitor {

	private Map<String, String> instruccion = new HashMap<String, String>();

	public CodeSelection(Writer writer, String sourceFile) {
		this.writer = new PrintWriter(writer);
		this.sourceFile = sourceFile;

		instruccion.put("+", "add");
		instruccion.put("-", "sub");
		instruccion.put("*", "mul");
		instruccion.put("/", "div");

		instruccion.put("&&", "and");
		instruccion.put("||", "or");
		instruccion.put("!", "not");

		instruccion.put(">", "gt");
		instruccion.put("<", "lt");
		instruccion.put(">=", "ge");
		instruccion.put("<=", "le");
		instruccion.put("==", "eq");
		instruccion.put("!=", "ne");

	}

	public Object visit(Program node, Object param) {
		out("#source \"" + sourceFile + "\""); // #SOURCE {file}
		out("call main");// CALL main
		out("halt");// HALT
		visitChildren(node.getDefinicion(), param);// define[[bloquei]]

		return null;
	}

	//////////////////////////////////////////////
	////////////// OPCIONAL: /////////////////////
	//////////////////////////////////////////////

	// class Definicion_variable { String nombre; Tipo tipo; Ambito ambito; }
	public Object visit(Definicion_variable node, Object param) {

		super.visit(node, param);
		out("#global " + node.getNombre() + ":" + node.getTipo().getMemoryAllocationString());
		// #global <nombre>:<tipo>

		return null;
	}

	// class Definicion_struct { String nombre; List<Campo_struct> campo_struct; }
	public Object visit(Definicion_struct node, Object param) {

		out("#type " + node.getNombre() + ": {");// #type Punto: {
		super.visit(node, param);// x:int y:int
		out("}");// }

		return null;
	}

	// class Campo_struct { String nombre; Tipo tipo; }
	public Object visit(Campo_struct node, Object param) {

		super.visit(node, param);
		out(node.getNombre() + ":" + node.getTipo().getMemoryAllocationString());
		// <nombre>:<tipo>

		return null;
	}

	//////////////////////////////////////////////
	////////////// OPCIONAL: /////////////////////
	//////////////////////////////////////////////

	public Object visit(Definicion_funcion node, Object param) {

		int localesSize = 0;
		int parametrosSize = 0;
		int retornoSize = 0;
		retornoSize = node.getRetorno().getSize();
		for (Definicion_variable e : node.getLocales()) {
			localesSize += e.getTipo().getSize();
		}
		for (Definicion_variable e : node.getParametros()) {
			parametrosSize += e.getTipo().getSize();
		}

		out(node.getNombre() + ":");// {nombre}:
		out("enter " + localesSize);// ENTER {sumatorio localesi.tipo.size}
		visitChildren(node.getSentencias(), param);// ejecuta[[sentenciasi]]

		if (node.getRetorno() instanceof Tipo_Void)// si retorno == VOID
			out("ret " + retornoSize + ", " + localesSize + ", " + parametrosSize);
		// RET {retorno.size}, {sumatorio localesi.tipo.size}, {sumatorio
		// parametrosi.tipo.size}

		return null;
	}

	public Object visit(Sentencia_asignacion node, Object param) {
		line(node);// #LINE {end.line}
		node.getIzquierda().accept(this, CodeFunction.ADDRESS); // address[[izquierda]]
		node.getDerecha().accept(this, CodeFunction.VALUE); // value[[derecha]]
		out("store", node.getIzquierda().getTipo()); // STORE<izquierda.tipo>
		return null;
	}

	public Object visit(Sentencia_print node, Object param) {
		line(node);// #LINE {end.line}
		super.visit(node, CodeFunction.VALUE); // value[[expresiones]]
		out("out", node.getExpresiones().getTipo()); // OUT<expresiones.tipo>
		if (node.getFincadena().equals("sp")) {
			out("pushb 32"); // PUSHB [[finCadena]]
			out("outb"); // OUTB
		}
		if (node.getFincadena().equals("ln")) {
			out("pushb 10");// PUSHB [[finCadena]]
			out("outb");// OUTB
		}
		return null;
	}

	public Object visit(Sentencia_read node, Object param) {
		line(node);// #LINE {end.line}
		super.visit(node, CodeFunction.VALUE);// value[[expresiones]]
		out("in", node.getExpresiones().getTipo());// IN<expresiones.tipo>
		return null;
	}

	public Object visit(Sentencia_if node, Object param) {
		line(node);// #LINE {end.line}
		String contadorIf = String.valueOf(++contadorGeneralIF);// {contadorIF = ++contadorGeneralIF}
		node.getCondicion().accept(this, param);// valor[[condicion]]
		out("jz else" + contadorIf);// jz else{contadorIf}
		visitChildren(node.getSentencias(), param);// ejecuta[[sentenciasi]]
		out("jmp finElse" + contadorIf);// jmp finIf{contadorIf}
		out("else" + contadorIf + ":");// else{contadorIf}:
		visitChildren(node.getSino(), param);// ejecuta[[sinoi]]
		out("finElse" + contadorIf + ":");// finIf{contadorIf}:
		return null;
	}

	public Object visit(Sentencia_while node, Object param) {
		line(node);// #LINE {end.line}
		String contadorWhile = String.valueOf(++contadorGeneralWhile);// {contadorWhile = ++contadorGeneralWhile}
		out("while" + contadorWhile + ":");// while{contadorWhile}:
		node.getCondicion().accept(this, param);// valor[[condicion]]
		out("jz finWhile" + contadorWhile);// jz finWhile{contadorWhile}
		visitChildren(node.getSentencias(), param);// ejecuta[[sentenciasi]]
		out("jmp while" + contadorWhile);// jmp while{contadorWhile}
		out("finWhile" + contadorWhile + ":");// finWhile{contadorWhile}:
		return null;
	}

	public Object visit(Sentencia_llamada_funcion node, Object param) {
		line(node);// #LINE {end.line}
		visitChildren(node.getParametros(), param);// valor[[parametrosi]]
		out("call " + node.getNombre());// CALL {nombre}
		if (!(node.getDefinicion().getRetorno() instanceof Tipo_Void)) {// si
																		// sentencia_llamada_funcion.definicion.retorno
																		// != tipoVoid
			out("pop", node.getDefinicion().getRetorno());// POP< sentencia_llamada_funcion.definici�n.retorno>
		}
		return null;
	}

	public Object visit(Sentencia_return node, Object param) {
		int retorno = 0;
		int localesi = 0;
		int parametrosi = 0;
		retorno = node.getFuncionActual().getRetorno().getSize();
		for (Definicion_variable child : node.getFuncionActual().getLocales())
			localesi = localesi + child.getTipo().getSize();
		for (Definicion_variable child : node.getFuncionActual().getParametros())
			parametrosi = localesi + child.getTipo().getSize();

		if (node.getExpresion() != null) {// si expresion != null
			line(node);// #LINE {end.line}
			node.getExpresion().accept(this, param);// valor[[expr]]
		}
		out("ret " + retorno + // RET {sentencia_return.funcion.retorno.size},
				", " + localesi + // {sumatorio sentencia_return.funcion.localesi.tipo.size},
				", " + parametrosi);// {sumatorio sentencia_return.funcion.parametrosi.tipo.size}
		return null;
	}

	public Object visit(Expr_int node, Object param) {
		assert (param == CodeFunction.VALUE);
		out("push " + node.getString()); // PUSH {value}
		return null;
	}

	public Object visit(Expr_real node, Object param) {
		assert (param == CodeFunction.VALUE);
		out("pushf " + node.getString());// PUSHF {value}
		return null;
	}

	public Object visit(Expr_char node, Object param) {
		assert (param == CodeFunction.VALUE);
		out("pushb " + (int) node.getString().charAt(1));// PUSHB {value}
		return null;
	}

	public Object visit(Expr_uso_variable node, Object param) {

		if (((CodeFunction) param) == CodeFunction.VALUE) {
			visit(node, CodeFunction.ADDRESS); // address [[expr_ident]]
			out("load", node.getTipo()); // LOAD< expr_ident.type>
		}

		else { // Funcion.DIRECCION
			assert (param == CodeFunction.ADDRESS);

			if (node.getDefinicion().getAmbito() == Ambito.GLOBAL) {
				out("pusha " + node.getDefinicion().getAddress());
			}

			if (node.getDefinicion().getAmbito() == Ambito.LOCAL) {
				out("pusha BP");
				out("push " + node.getDefinicion().getAddress());
				out("add");
			}

		}
		return null;
	}

	public Object visit(Expr_operacion node, Object param) {
		assert (param == CodeFunction.VALUE);
		node.getIzquierda().accept(this, CodeFunction.VALUE);// value[[izquierda]]
		node.getDerecha().accept(this, CodeFunction.VALUE);// value[[derecha]]
		out(instruccion.get(node.getOperador().getString()), node.getIzquierda().getTipo());
		return null;
	}

	public Object visit(Expr_acceso_vector node, Object param) {
		node.getFuera().accept(this, CodeFunction.ADDRESS); // address[[fuera]]
		node.getDentro().accept(this, CodeFunction.VALUE); // value[[dentro]]
		out("push " + node.getTipo().getSize()); // PUSHA {tipo.size}
		out("mul");// MUL
		out("add");// ADD

		if (((CodeFunction) param) == CodeFunction.VALUE) {
			out("load", node.getTipo()); // LOAD{tipo.size}
		}
		return null;
	}

	public Object visit(Expr_negada node, Object param) {
		assert (param == CodeFunction.VALUE);
		node.getDerecha().accept(this, CodeFunction.VALUE);// value[[derecha]]
		out(instruccion.get(node.getOperador().getString()), node.getDerecha().getTipo());// {operador.instruccion}
		return null;
	}

	// class Expr_acceso_struct { Expr struct; String campo; }
	public Object visit(Expr_acceso_struct node, Object param) {

		// super.visit(node, param);

		if (node.getStruct() != null) {
			node.getStruct().accept(this, CodeFunction.ADDRESS); // address[[struct]]
		}

		// TODO esta es la mejor manera?
		Campo_struct campo = node.getCampo_struct();
		if (campo == null)
			return null;

		out("push " + campo.getTipo().getSize()); // PUSH {tipo.size} //TODO comprobar esto
		System.out.println("¿1?");
		out("add");// ADD

		if (((CodeFunction) param) == CodeFunction.VALUE) {
			out("load", node.getTipo()); // LOAD< expr_ident.type> //TODO comprobar esto
			System.out.println("¿2?");
		}
		return null;

	}

	public Object visit(Expr_cast node, Object param) {
		node.getExpr().accept(this, CodeFunction.VALUE); // value[[expr]]
		String de = Character.toString(node.getExpr().getTipo().getSuffix());
		String a = Character.toString(node.getTipo_convertido().getSuffix());
		out(de + "2" + a); // {expr.tipo}2{tipo_convertido}
		return null;
	}

	public Object visit(Expr_llamada_funcion node, Object param) {
		for (Expr child : node.getParametros())
			child.accept(this, param);// valor[[parametrosi]]
		out("call " + node.getNombre());// CALL {nombre}
		return null;
	}
	//////////////////////////////////////////

	private void out(String instruction) {
		writer.println(instruction);
		// TODO: Comentar para no mostrar la generacion de codigo
		System.out.println(instruction);
	}

	private void out(String instruccion, Tipo tipo) {
		if (tipo instanceof Tipo_Int) {
			out(instruccion);
		} else {
			out(instruccion + tipo.getSuffix());
		}
	}

	private void line(AST node) {
		line(node.getEnd());
	}

	private void line(Position pos) {
		out("\n#line " + pos.getLine());
	}

	private PrintWriter writer;
	private String sourceFile;
	private int contadorGeneralIF = 0;
	private int contadorGeneralWhile = 0;
}
