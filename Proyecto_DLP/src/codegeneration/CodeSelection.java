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
		visitChildren(node.getBloque(), param);// define[[bloquei]]

		return null;
	}

	public Object visit(Funcion node, Object param) {

		int localesSize = 0;
		int parametrosSize = 0;
		int retornoSize = 0;
		retornoSize = node.getRetorno().getSize();
		for (Definicion_variable_local e : node.getLocales()) {
			localesSize += e.getTipo().getSize();
		}
		for (Parametro e : node.getParametros()) {
			parametrosSize += e.getTipo().getSize();
		}

		out(node.getNombre() + ":");// {nombre}:
		out("enter " + localesSize);// ENTER {sumatorio localesi.tipo.size}
		visitChildren(node.getSentencias(), param);// ejecuta[[sentenciasi]]

		if (node.getRetorno() instanceof TipoVoid)// si retorno == VOID
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
			out("pushb 32"); //PUSHB [[finCadena]]
			out("outb"); //OUTB
		}
		if (node.getFincadena().equals("ln")) {
			out("pushb 10");//PUSHB [[finCadena]]
			out("outb");//OUTB
		}
		return null;
	}

	// class Sentencia_read { Expr expresiones; }
	public Object visit(Sentencia_read node, Object param) {
		line(node);// #LINE {end.line}
		super.visit(node, CodeFunction.VALUE);// value[[expresiones]]
		out("in", node.getExpresiones().getTipo());// IN<expresiones.tipo>
		return null;
	}

	// class Sentencia_if { Expr condicion; List<Sentencia> sentencias;
	// List<Sentencia> sino; }
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

	// class Sentencia_while { Expr condicion; List<Sentencia> sentencias; }
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

	// class Sentencia_llamada_funcion { String nombre; List<Expr> parametros; }
	public Object visit(Sentencia_llamada_funcion node, Object param) {
		line(node);// #LINE {end.line}
		visitChildren(node.getParametros(), param);// valor[[parametrosi]]
		out("call " + node.getNombre());// CALL {nombre}
		if (!(node.getDefinicion().getRetorno() instanceof TipoVoid)) {// si
																		// sentencia_llamada_funcion.definicion.retorno
																		// != tipoVoid
			out("pop", node.getDefinicion().getRetorno());// POP< sentencia_llamada_funcion.definición.retorno>
		}
		return null;
	}

	// class Sentencia_return { Expr expresion; }
	public Object visit(Sentencia_return node, Object param) {
		int retorno = 0;
		int localesi = 0;
		int parametrosi = 0;
		retorno = node.getFuncionActual().getRetorno().getSize();
		for (Definicion_variable_local child : node.getFuncionActual().getLocales())
			localesi = localesi + child.getTipo().getSize();
		for (Parametro child : node.getFuncionActual().getParametros())
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

	// class Expr_int { String string; }
	public Object visit(Expr_int node, Object param) {
		assert (param == CodeFunction.VALUE);
		out("push " + node.getString()); // PUSH {value}
		return null;
	}

	// class Expr_real { String string; }
	public Object visit(Expr_real node, Object param) {
		assert (param == CodeFunction.VALUE);
		out("pushf " + node.getString());// PUSHF {value}
		return null;
	}

	// class Expr_char { String string; }
	public Object visit(Expr_char node, Object param) {
		assert (param == CodeFunction.VALUE);
		out("pushb " + (int) node.getString().charAt(1));// PUSHB {value}
		return null;
	}

	// class Expr_ident { String string; }
	public Object visit(Expr_ident node, Object param) {

		if (((CodeFunction) param) == CodeFunction.VALUE) {
			visit(node, CodeFunction.ADDRESS); // address [[expr_ident]]
			out("load", node.getTipo()); // LOAD< expr_ident.type>
		}

		else { // Funcion.DIRECCION
			assert (param == CodeFunction.ADDRESS);

			if (node.getDefinicion_global() != null)
				out("pusha " + node.getDefinicion_global().getAddress());

			else if (node.getDefinicion_parametro() != null) {
				out("pusha BP");
				out("push " + node.getDefinicion_parametro().getAddress());
				out("add");
			}

			else if (node.getDefinicion_local() != null) {
				out("pusha BP");
				out("pusha " + Math.abs(node.getDefinicion_local().getAddress()));
				out("sub");
			}
		}
		return null;
	}

	// class Expr_binaria { Expr izquierda; Operador operador; Expr derecha; }
	public Object visit(Expr_binaria node, Object param) {
		assert (param == CodeFunction.VALUE);
		node.getIzquierda().accept(this, CodeFunction.VALUE);//value[[izquierda]]
		node.getDerecha().accept(this, CodeFunction.VALUE);//value[[derecha]]
		out(instruccion.get(node.getOperador().getString()), node.getIzquierda().getTipo());
		return null;
	}

	// class Expr_vector { Expr fuera; Expr dentro; }
	public Object visit(Expr_vector node, Object param) {
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

	// class Expr_negada { Operador operador; Expr derecha; }
	public Object visit(Expr_negada node, Object param) {
		assert (param == CodeFunction.VALUE);
		node.getDerecha().accept(this, CodeFunction.VALUE);// value[[derecha]]
		out(instruccion.get(node.getOperador().getString()), node.getDerecha().getTipo());// {operador.instruccion}
		return null;
	}

	// class Expr_punto { Expr izquierda; Expr derecha; }
	public Object visit(Expr_punto node, Object param) {
		node.getIzquierda().accept(this, CodeFunction.ADDRESS); // address[[izquierda]]
		out("push " + node.getDerecha().getTipo().getSize()); //PUSH {derecha.tipo.size}
		out("add");// ADD
		
		if (((CodeFunction) param) == CodeFunction.VALUE) {
			out("load", node.getTipo()); // LOAD< expr_ident.type>
		}
		return null;
	}

	// class Expr_parentesis { Expr expr; }
	public Object visit(Expr_parentesis node, Object param) {
		node.getExpr().accept(this, CodeFunction.VALUE); // value[[expr]]
		return null;
	}

	// class Expr_cast { Tipo tipo_convertido; Expr expr; }
	public Object visit(Expr_cast node, Object param) {
		node.getExpr().accept(this, CodeFunction.VALUE); // value[[expr]]
		String de = Character.toString(node.getExpr().getTipo().getSuffix());
		String a = Character.toString(node.getTipo_convertido().getSuffix());
		out(de + "2" + a); // {expr.tipo}2{tipo_convertido}
		return null;
	}

	// class Expr_llamada_funcion { String nombre; List<Expr> parametros; }
	public Object visit(Expr_llamada_funcion node, Object param) {
		for (Expr child : node.getParametros())
			child.accept(this, param);// valor[[parametrosi]]
		out("call " + node.getNombre());// CALL {nombre}
		return null;
	}
	//////////////////////////////////////////

	private void out(String instruction) {
		writer.println(instruction);
		//System.out.println(instruction); // TODO - Comentar para que no se imprima por pantalla la generacion de codigo
	}

	private void out(String instruccion, Tipo tipo) {
		if (tipo instanceof TipoInt) {
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
