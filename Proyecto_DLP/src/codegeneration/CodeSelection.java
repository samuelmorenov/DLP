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
		out("CALL main");// CALL main
		out("halt");// HALT
		visitChildren(node.getBloque(), param);// define[[bloquei]]

		return null;
	}

	public Object visit(Funcion node, Object param) {

		int localesSize = 0;
		int parametrosSize = 0;
		for (Definicion_variable_local e : node.getLocales())
			localesSize += e.getTipo().getSize();
		for (Parametro e : node.getParametros())
			parametrosSize += e.getTipo().getSize();

		out(node.getNombre() + ":");// {nombre}:
		out("enter " + localesSize);// ENTER {sumatorio localesi.tipo.size}
		super.visit(node, param);// ejecuta[[sentenciasi]]
		if (node.getRetorno() instanceof TipoVoid)// si retorno == VOID
			out("RET 0" + localesSize + parametrosSize);// RET 0, {sumatorio localesi.tipo.size}, {sumatorio
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
		super.visit(node, param); // value[[expresiones]]
		out("out", node.getExpresiones().getTipo()); // OUT<expresiones.tipo>
		return null;
	}

	// class Sentencia_read { Expr expresiones; }
	public Object visit(Sentencia_read node, Object param) {
		line(node);// #LINE {end.line}
		super.visit(node, param);// value[[expresiones]]
		out("in", node.getExpresiones().getTipo());// IN<expresiones.tipo>
		return null;
	}

	// class Sentencia_if { Expr condicion; List<Sentencia> sentencias;
	// List<Sentencia> sino; }
	public Object visit(Sentencia_if node, Object param) {
		// TODO
		line(node);// #LINE {end.line}
		int contadorIf = ++contadorGeneralIF;// {contadorIF = ++contadorGeneralIF}
		// if{contadorIf}:
		// valor[[condicion]]
		// jz else{contadorIf}
		// ejecuta[[sentenciasi]]
		// jmp finIf{contadorIf}
		// else{contadorIf}:
		// ejecuta[[sinoi]]
		// finIf{contadorIf}:

		// super.visit(node, param);

		// if (node.getCondicion() != null)
		// node.getCondicion().accept(this, param);
		//
		// if (node.getSentencias() != null)
		// for (Sentencia child : node.getSentencias())
		// child.accept(this, param);
		//
		// if (node.getSino() != null)
		// for (Sentencia child : node.getSino())
		// child.accept(this, param);

		return null;
	}

	// class Sentencia_while { Expr condicion; List<Sentencia> sentencias; }
	public Object visit(Sentencia_while node, Object param) {
		// TODO
		line(node);// #LINE {end.line}
		// {contadorWhile = ++contadorGeneralWhile}
		// while{contadorWhile}:
		// valor[[condicion]]
		// jz finWhile{contadorWhile}
		// ejecuta[[sentenciasi]]
		// jmp while{contadorWhile}
		// finWhile{contadorWhile}:

		// super.visit(node, param);

		// if (node.getCondicion() != null)
		// node.getCondicion().accept(this, param);
		//
		// if (node.getSentencias() != null)
		// for (Sentencia child : node.getSentencias())
		// child.accept(this, param);

		return null;
	}

	// class Sentencia_llamada_funcion { String nombre; List<Expr> parametros; }
	public Object visit(Sentencia_llamada_funcion node, Object param) {
		// TODO
		line(node);// #LINE {end.line}
		// valor[[parametrosi]]
		// CALL {nombre}
		// si sentencia_llamada_funcion.definicion.retorno != tipoVoid
		// POP< sentencia_llamada_funcion.definición.retorno>

		// super.visit(node, param);

		// if (node.getParametros() != null)
		// for (Expr child : node.getParametros())
		// child.accept(this, param);

		return null;
	}

	// class Sentencia_return { Expr expresion; }
	public Object visit(Sentencia_return node, Object param) {
		// TODO
		line(node);// #LINE {end.line}
		// si expresion != null
		// valor[[expr]]
		// RET {sentencia_return.funcion.retorno.size},
		// {sumatorio sentencia_return.funcion.localesi.tipo.size},
		// {sumatorio sentencia_return.funcion.parametrosi.tipo.size}

		// super.visit(node, param);

		// if (node.getExpresion() != null)
		// node.getExpresion().accept(this, param);

		return null;
	}

	// class Expr_int { String string; }
	public Object visit(Expr_int node, Object param) {
		assert (param == CodeFunction.VALUE);
		out("pushi " + node.getString()); // PUSHI {value}
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
		out("pushb " + node.getString());// PUSHB {value}
		return null;
	}

	// class Expr_ident { String string; }
	public Object visit(Expr_ident node, Object param) {

		if (((CodeFunction) param) == CodeFunction.VALUE) {
			visit(node, CodeFunction.ADDRESS); // address [[expr_ident]]
			out("load", node.getTipo()); // LOAD< expr_ident.type>
		} else { // Funcion.DIRECCION
			assert (param == CodeFunction.ADDRESS);

			if (node.getDefinicion_global() != null)
				out("pusha " + node.getDefinicion_global().getAddress());
			else if (node.getDefinicion_parametro() != null)
				out("pusha " + node.getDefinicion_parametro().getAddress());
			else if (node.getDefinicion_local() != null)
				out("pusha " + node.getDefinicion_local().getAddress());
		}
		return null;
	}

	// class Expr_binaria { Expr izquierda; Operador operador; Expr derecha; }
	public Object visit(Expr_binaria node, Object param) {
		assert (param == CodeFunction.VALUE);
		node.getIzquierda().accept(this, CodeFunction.VALUE);
		node.getDerecha().accept(this, CodeFunction.VALUE);
		out(instruccion.get(node.getOperador().getString()), node.getTipo());
		return null;
	}

	// class Expr_vector { Expr fuera; Expr dentro; }
	public Object visit(Expr_vector node, Object param) {
		node.getFuera().accept(this, CodeFunction.ADDRESS); // address[[fuera]]
		node.getDentro().accept(this, CodeFunction.VALUE); // value[[dentro]]
		out("pusha " + node.getTipo().getSize()); // PUSHA {tipo.size}
		out("mul");// MUL
		out("add");// ADD
		return null;
	}

	// class Expr_punto { Expr izquierda; Expr derecha; }
	public Object visit(Expr_punto node, Object param) {
		node.getIzquierda().accept(this, CodeFunction.ADDRESS); // address[[izquierda]]
		node.getDerecha().accept(this, CodeFunction.ADDRESS); // address[[derecha]]
		out("add");// ADD
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
		// TODO
		// valor[[parametrosi]]
		// CALL {nombre}

		// super.visit(node, param);

		// if (node.getParametros() != null)
		// for (Expr child : node.getParametros())
		// child.accept(this, param);

		return null;
	}
	//////////////////////////////////////////

	private void out(String instruction) {
		writer.println(instruction);
		// System.out.println(instruction); // Borrar para que no se imprima por
		// pantalla
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
