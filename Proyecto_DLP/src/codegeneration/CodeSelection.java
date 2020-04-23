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
		// #SOURCE {file}
		out("#source \"" + sourceFile + "\"");
		// CALL main
		out("call main");
		// HALT
		out("halt");
		// define[[definicioni]]
		visitChildren(node.getDefinicion(), param);

		return null;
	}

	// class Definicion_variable { String nombre; Tipo tipo; Ambito ambito; }
	public Object visit(Definicion_variable node, Object param) {

		super.visit(node, param);
		// #global <nombre>:<tipo>
		out("#global " + node.getNombre() + ":" + node.getTipo().getMemoryAllocationString());
		return null;
	}

	// class Definicion_struct { String nombre; List<Campo_struct> campo_struct; }
	public Object visit(Definicion_struct node, Object param) {
		// #type Punto: {
		out("#type " + node.getNombre() + ": {");
		// <nombre>:<tipo>
		super.visit(node, param);
		// }
		out("}");
		return null;
	}

	public Object visit(Definicion_funcion node, Object param) {

		// TODO: Metadatos
		// #func <nombre>
		out("#func " + node.getNombre());
		// #param <nombre>:<tipo>
		for (Definicion_variable e : node.getParametros()) {
			out("#param " + e.getNombre() + ":" + e.getTipo().getMemoryAllocationString());
		}
		// #ret <tipo> / #ret void
		out("#ret " + node.getRetorno().getMemoryAllocationString());
		// #local <nombre>:<tipo>
		for (Definicion_variable e : node.getLocales()) {
			out("#local " + e.getNombre() + ":" + e.getTipo().getMemoryAllocationString());
		}

		// Generacion de codigo

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

		// {nombre}:
		out(node.getNombre() + ":");
		// ENTER {sumatorio localesi.tipo.size}
		out("enter " + localesSize);
		// ejecuta[[sentenciasi]]
		visitChildren(node.getSentencias(), param);

		// si retorno == VOID
		if (node.getRetorno() instanceof Tipo_Void) {
			// RET
			// {retorno.size},
			// {sumatorio localesi.tipo.size},
			// {sumatorio parametrosi.tipo.size}
			out("ret " + retornoSize + ", " + localesSize + ", " + parametrosSize);
		}

		return null;
	}

	// class Campo_struct { String nombre; Tipo tipo; }
	public Object visit(Campo_struct node, Object param) {

		super.visit(node, param);
		// <nombre>:<tipo>
		out(node.getNombre() + ":" + node.getTipo().getMemoryAllocationString());
		return null;
	}

	public Object visit(Sentencia_asignacion node, Object param) {
		// #LINE {end.line}
		line(node);
		// address[[izquierda]]
		node.getIzquierda().accept(this, CodeFunction.ADDRESS);
		// value[[derecha]]
		node.getDerecha().accept(this, CodeFunction.VALUE);
		// STORE<izquierda.tipo>
		out("store", node.getIzquierda().getTipo());
		return null;
	}

	public Object visit(Sentencia_print node, Object param) {
		// #LINE {end.line}
		line(node);
		// value[[expresiones]]
		super.visit(node, CodeFunction.VALUE);
		// OUT<expresiones.tipo>
		out("out", node.getExpresiones().getTipo());
		if (node.getFincadena().equals("sp")) {
			// PUSHB [[finCadena]]
			out("pushb 32");
			// OUTB
			out("outb");
		}
		if (node.getFincadena().equals("ln")) {
			// PUSHB [[finCadena]]
			out("pushb 10");
			// OUTB
			out("outb");
		}
		return null;
	}

	public Object visit(Sentencia_read node, Object param) {
		// #LINE {end.line}
		line(node);
		// value[[expresiones]]
		super.visit(node, CodeFunction.VALUE);
		// IN<expresiones.tipo>
		out("in", node.getExpresiones().getTipo());
		return null;
	}

	public Object visit(Sentencia_if node, Object param) {
		// #LINE {end.line}
		line(node);
		// {contadorIF = ++contadorGeneralIF}
		String contadorIf = String.valueOf(++contadorGeneralIF);
		// valor[[condicion]]
		node.getCondicion().accept(this, param);
		// jz else{contadorIf}
		out("jz else" + contadorIf);
		// ejecuta[[sentenciasi]]
		visitChildren(node.getSentencias(), param);
		// jmp finIf{contadorIf}
		out("jmp finElse" + contadorIf);
		// else{contadorIf}:
		out("else" + contadorIf + ":");
		// ejecuta[[sinoi]]
		visitChildren(node.getSino(), param);
		// finIf{contadorIf}:
		out("finElse" + contadorIf + ":");
		return null;
	}

	public Object visit(Sentencia_while node, Object param) {
		// #LINE {end.line}
		line(node);
		// {contadorWhile = ++contadorGeneralWhile}
		String contadorWhile = String.valueOf(++contadorGeneralWhile);
		// while{contadorWhile}:
		out("while" + contadorWhile + ":");
		// valor[[condicion]]
		node.getCondicion().accept(this, param);
		// jz finWhile{contadorWhile}
		out("jz finWhile" + contadorWhile);
		// ejecuta[[sentenciasi]]
		visitChildren(node.getSentencias(), param);
		// jmp while{contadorWhile}
		out("jmp while" + contadorWhile);
		// finWhile{contadorWhile}:
		out("finWhile" + contadorWhile + ":");
		return null;
	}

	public Object visit(Sentencia_llamada_funcion node, Object param) {
		// #LINE {end.line}
		line(node);
		// valor[[parametrosi]]
		visitChildren(node.getParametros(), param);
		// CALL {nombre}
		out("call " + node.getNombre());
		// si sentencia_llamada_funcion.definicion.retorno != tipoVoid
		if (!(node.getDefinicion().getRetorno() instanceof Tipo_Void)) {
			// POP< sentencia_llamada_funcion.definición.retorno>
			out("pop", node.getDefinicion().getRetorno());
		}
		return null;
	}

	public Object visit(Sentencia_return node, Object param) {
		int retorno = 0;
		int localesi = 0;
		int parametrosi = 0;
		retorno = node.getFuncionActual().getRetorno().getSize();
		for (Definicion_variable child : node.getFuncionActual().getLocales()) {
			localesi = localesi + child.getTipo().getSize();
		}
		for (Definicion_variable child : node.getFuncionActual().getParametros()) {
			parametrosi = parametrosi + child.getTipo().getSize();
		}

		// si expresion != null
		if (node.getExpresion() != null) {
			// #LINE {end.line}
			line(node);
			// valor[[expr]]
			node.getExpresion().accept(this, CodeFunction.VALUE);
		}
		// RET {sentencia_return.funcion.retorno.size},
		out("ret " + retorno +
		// {sumatorio sentencia_return.funcion.localesi.tipo.size},
				", " + localesi +
				// {sumatorio sentencia_return.funcion.parametrosi.tipo.size}
				", " + parametrosi);
		return null;
	}

	public Object visit(Expr_int node, Object param) {
		assert (param == CodeFunction.VALUE);
		// PUSH {value}
		out("push " + node.getString());
		return null;
	}

	public Object visit(Expr_real node, Object param) {
		assert (param == CodeFunction.VALUE);
		// PUSHF {value}
		out("pushf " + node.getString());
		return null;
	}

	public Object visit(Expr_char node, Object param) {
		assert (param == CodeFunction.VALUE);
		// PUSHB {value}
		out("pushb " + (int) node.getString().charAt(1));
		return null;
	}

	public Object visit(Expr_uso_variable node, Object param) {

		if (((CodeFunction) param) == CodeFunction.VALUE) {
			// address [[expr_ident]]
			visit(node, CodeFunction.ADDRESS);
			// LOAD< expr_ident.type>
			out("load", node.getTipo());
		}

		// Funcion.DIRECCION
		else {
			// TODO: Comentar
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
		// value[[izquierda]]
		node.getIzquierda().accept(this, CodeFunction.VALUE);
		// value[[derecha]]
		node.getDerecha().accept(this, CodeFunction.VALUE);
		// TODO: Comentar
		out(instruccion.get(node.getOperador().getString()), node.getIzquierda().getTipo());
		return null;
	}

	public Object visit(Expr_acceso_vector node, Object param) {
		// address[[fuera]]
		node.getFuera().accept(this, CodeFunction.ADDRESS);
		// value[[dentro]]
		node.getDentro().accept(this, CodeFunction.VALUE);
		// PUSHA {tipo.size}
		out("push " + node.getTipo().getSize());
		// MUL
		out("mul");
		// ADD
		out("add");

		if (((CodeFunction) param) == CodeFunction.VALUE) {
			// LOAD{tipo.size}
			out("load", node.getTipo());
		}
		return null;
	}

	public Object visit(Expr_negada node, Object param) {
		assert (param == CodeFunction.VALUE);
		// value[[derecha]]
		node.getDerecha().accept(this, CodeFunction.VALUE);
		// {operador.instruccion}
		out(instruccion.get(node.getOperador().getString()), node.getDerecha().getTipo());
		return null;
	}

	// class Expr_acceso_struct { Expr struct; String campo; }
	public Object visit(Expr_acceso_struct node, Object param) {

		// 1 - Meter en la pila la direccion donde empieza la estructura
		// 2 - Meter en la pila el desplazamiento del campo dentro de su estructura
		// 3 - ADD
		// TODO: Comentar

		node.getStruct().accept(this, CodeFunction.ADDRESS);
		out("push " + node.getCampo_struct().getAddress());
		out("add");

		if (((CodeFunction) param) == CodeFunction.VALUE) {
			out("load", node.getTipo());
		}
		return null;

	}

	public Object visit(Expr_cast node, Object param) {
		// value[[expr]]
		node.getExpr().accept(this, CodeFunction.VALUE);
		String de = Character.toString(node.getExpr().getTipo().getSuffix());
		String a = Character.toString(node.getTipo_convertido().getSuffix());
		// {expr.tipo}2{tipo_convertido}
		out(de + "2" + a);
		return null;
	}

	public Object visit(Expr_llamada_funcion node, Object param) {
		// valor[[parametrosi]]
		for (Expr child : node.getParametros()) {
			child.accept(this, param);
		}
		// CALL {nombre}
		out("call " + node.getNombre());
		return null;
	}
	//////////////////////////////////////////

	private void out(String instruction) {
		writer.println(instruction);
		// TODO: Comentar para no mostrar la generacion de codigo
		// System.out.println(instruction);
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
