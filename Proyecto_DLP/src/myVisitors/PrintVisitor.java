package myVisitors;

import ast.*;
import visitor.DefaultVisitor;

public class PrintVisitor extends DefaultVisitor {

	// class Program { List<Bloque> bloque; }
	public Object visit(Program node, Object param) {

		// super.visit(node, param);

		if (node.getBloque() != null)
			for (Bloque child : node.getBloque())
				child.accept(this, param);

		return null;
	}

	// class Definicion_variables { String nombre; Tipo tipo; }
	public Object visit(Definicion_variables node, Object param) {
		// super.visit(node, param);
		System.out.print("var " + node.getNombre() + ":");

		if (node.getTipo() != null)
			node.getTipo().accept(this, param);

		System.out.println(";");

		return null;
	}

	// class Definicion_struct { String nombre; Tipo tipo; }
	public Object visit(Definicion_struct node, Object param) {
		// super.visit(node, param);
		System.out.print(node.getNombre() + ":");

		if (node.getTipo() != null)
			node.getTipo().accept(this, param);

		System.out.println(";");

		return null;
	}

	// class Definicion_funcion { String nombre; Tipo tipo; }
	public Object visit(Definicion_funcion node, Object param) {

		// super.visit(node, param);

		System.out.print("var " + node.getNombre() + ":");

		if (node.getTipo() != null)
			node.getTipo().accept(this, param);

		System.out.println(";");

		return null;
	}

	// class Tamanio_vector { int numero; }
	public Object visit(Tamanio_vector node, Object param) {
		System.out.print(node.getNumero());
		return null;
	}

	// class TipoInt { }
	public Object visit(TipoInt node, Object param) {
		System.out.print("int");
		return null;
	}

	// class TipoFloat { }
	public Object visit(TipoFloat node, Object param) {
		System.out.print("float");
		return null;
	}

	// class TipoChar { }
	public Object visit(TipoChar node, Object param) {
		System.out.print("char");
		return null;
	}

	// class TipoVar { String string; }
	public Object visit(TipoVar node, Object param) {
		System.out.print(node.getString());
		return null;
	}

	// class TipoArray { String tamanio; Tipo tipo; }
	public Object visit(TipoArray node, Object param) {

		// super.visit(node, param);

		System.out.print("[" + node.getTamanio() + "]");

		if (node.getTipo() != null)
			node.getTipo().accept(this, param);

		return null;
	}

	// class Struct { String nombre; List<Definicion_struct> definicion_struct; }
	public Object visit(Struct node, Object param) {

		// super.visit(node, param);
		System.out.println("struct " + node.getNombre() + "{");
		if (node.getDefinicion_struct() != null)
			for (Definicion_struct child : node.getDefinicion_struct())
				child.accept(this, param);
		System.out.println("};");

		return null;
	}

	// class Funcion { String nombre; List<Parametro> parametros; List<Tipo>
	// retorno; List<Sentencia> sentencia; }
	public Object visit(Funcion node, Object param) {

		// super.visit(node, param);
		System.out.print(node.getNombre() + "(");
		if (node.getParametros() != null) {
			for (int i = 0; i < node.getParametros().size(); i++) {
				Parametro child = node.getParametros().get(i);
				child.accept(this, param);
				if (i != node.getParametros().size() - 1)
					System.out.print(", ");
			}
		}
		System.out.print(")");
		if (node.getRetorno() != null) {
			
			for (Tipo child : node.getRetorno()) {
				System.out.print(": ");
				child.accept(this, param);
			}

		}
		System.out.println(" {");
		if (node.getSentencia() != null)
			for (Sentencia child : node.getSentencia())
				child.accept(this, param);

		System.out.println("}");
		return null;
	}

	// class Parametro { String nombre; Tipo tipo; }
	public Object visit(Parametro node, Object param) {

		// super.visit(node, param);
		System.out.print(node.getNombre() + " ");
		if (node.getTipo() != null)
			node.getTipo().accept(this, param);

		return null;
	}

	// class Sentencia_asignacion { Expr izquierda; Expr derecha; }
	public Object visit(Sentencia_asignacion node, Object param) {

		// super.visit(node, param);

		if (node.getIzquierda() != null)
			node.getIzquierda().accept(this, param);
		System.out.print(" = ");
		if (node.getDerecha() != null)
			node.getDerecha().accept(this, param);
		System.out.println(";");
		return null;
	}

	// class Sentencia_print { Expr expresiones; }
	public Object visit(Sentencia_print node, Object param) {

		// super.visit(node, param);
		System.out.print("print ");
		if (node.getExpresiones() != null)
			node.getExpresiones().accept(this, param);
		System.out.println(";");
		return null;
	}

	// class Sentencia_read { Expr expresiones; }
	public Object visit(Sentencia_read node, Object param) {

		// super.visit(node, param);
		System.out.print("read ");
		if (node.getExpresiones() != null)
			node.getExpresiones().accept(this, param);
		System.out.println(";");
		return null;
	}

	// class Sentencia_if { Expr condicion; List<Sentencia> sentencias;
	// List<Sentencia> sino; }
	public Object visit(Sentencia_if node, Object param) {

		// super.visit(node, param);
		System.out.print("if (");
		if (node.getCondicion() != null)
			node.getCondicion().accept(this, param);
		System.out.println(") {");
		if (node.getSentencias() != null)
			for (Sentencia child : node.getSentencias())
				child.accept(this, param);
		System.out.println("}\nelse {");
		if (node.getSino() != null)
			for (Sentencia child : node.getSino())
				child.accept(this, param);
		System.out.println("}");
		return null;
	}

	// class Sentencia_while { Expr condicion; List<Sentencia> sentencias; }
	public Object visit(Sentencia_while node, Object param) {

		// super.visit(node, param);
		System.out.print("while (");
		if (node.getCondicion() != null)
			node.getCondicion().accept(this, param);
		System.out.println(") {");
		if (node.getSentencias() != null)
			for (Sentencia child : node.getSentencias())
				child.accept(this, param);
		System.out.println("}");
		return null;
	}

	// class Sentencia_return { Expr expresion; }
	public Object visit(Sentencia_return node, Object param) {

		// super.visit(node, param);
		System.out.print("return ");
		if (node.getExpresion() != null)
			node.getExpresion().accept(this, param);
		System.out.println(";");
		return null;
	}

	// class Sentencia_expresion { Expr expresion; }
	public Object visit(Sentencia_expresion node, Object param) {

		// super.visit(node, param);
		
		if (node.getExpresion() != null)
			node.getExpresion().accept(this, param);
		System.out.println(";");
		return null;
	}

	// class Expr_int { String string; }
	public Object visit(Expr_int node, Object param) {
		System.out.print(node.getString());
		return null;
	}

	// class Expr_real { String string; }
	public Object visit(Expr_real node, Object param) {
		System.out.print(node.getString());
		return null;
	}

	// class Expr_char { String string; }
	public Object visit(Expr_char node, Object param) {
		System.out.print(node.getString());
		return null;
	}

	// class Expr_ident { String string; }
	public Object visit(Expr_ident node, Object param) {
		System.out.print(node.getString());
		return null;
	}

	// class Expr_binaria { Expr izquierda; Operador operador; Expr derecha; }
	public Object visit(Expr_binaria node, Object param) {
		//TODO
		// super.visit(node, param);
		
		if (node.getIzquierda() != null)
			node.getIzquierda().accept(this, param);

		if (node.getOperador() != null)
			node.getOperador().accept(this, param);

		if (node.getDerecha() != null)
			node.getDerecha().accept(this, param);

		return null;
	}

	// class Expr_vector { Expr fuera; Expr dentro; }
	public Object visit(Expr_vector node, Object param) {

		// super.visit(node, param);

		if (node.getFuera() != null)
			node.getFuera().accept(this, param);
		System.out.print("[");
		if (node.getDentro() != null)
			node.getDentro().accept(this, param);
		System.out.print("]");
		return null;
	}

	// class Expr_punto { Expr izquierda; Expr derecha; }
	public Object visit(Expr_punto node, Object param) {

		// super.visit(node, param);

		if (node.getIzquierda() != null)
			node.getIzquierda().accept(this, param);
		System.out.print(".");
		if (node.getDerecha() != null)
			node.getDerecha().accept(this, param);

		return null;
	}

	// class Expr_parentesis { Expr expr; }
	public Object visit(Expr_parentesis node, Object param) {

		// super.visit(node, param);
		System.out.print("(");
		if (node.getExpr() != null)
			node.getExpr().accept(this, param);
		System.out.print(")");
		return null;
	}

	// class Expr_cast { Tipo tipo; Expr expr; }
	public Object visit(Expr_cast node, Object param) {

		// super.visit(node, param);
		System.out.print("cast <");
		if (node.getTipo() != null)
			node.getTipo().accept(this, param);
		System.out.print("> (");
		if (node.getExpr() != null)
			node.getExpr().accept(this, param);
		System.out.print(")");
		return null;
	}

	// class Expr_llamada { String nombre; List<Expr> parametros; }
	public Object visit(Expr_llamada node, Object param) {

		// super.visit(node, param);
		System.out.print(node.getNombre()+ "(");
		if (node.getParametros() != null)
			for (Expr child : node.getParametros())
				child.accept(this, param);
		System.out.print(")");
		return null;
	}

	// class Operador { String operador; }
	public Object visit(Operador node, Object param) {
		System.out.print(node.getOperador());
		return null;
	}
}
