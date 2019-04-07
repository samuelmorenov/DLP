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

	// TODO: Naranja
	public Object visit(Program node, Object param) {
		out("#source \"" + sourceFile + "\""); // #SOURCE {file}
		visitChildren(node.getBloque(), param); // define[[bloquei]]
		out("halt");// HALT
		return null;
	}

	// TODO: Naranja
	public Object visit(Funcion node, Object param) {
		super.visit(node, param);// ejecuta[[sentenciasi]]
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
		out("out", node.getExpresiones().getTipo()); // OUT< expresiones.tipo>
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

	//////////////////////////////////////////

	private void out(String instruction) {
		writer.println(instruction);
		// System.out.println(instruction); // Borrar para que no se imprima por
		// pantalla
	}

	private void out(String instruccion, Tipo tipo) {
		out(instruccion + tipo.getSuffix());
	}

	private void line(AST node) {
		line(node.getEnd());
	}

	private void line(Position pos) {
		out("\n#line " + pos.getLine());
	}

	private PrintWriter writer;
	private String sourceFile;
}
