package myVisitors;

//import ast.*;
import visitor.DefaultVisitor;

@Deprecated
public class PrintVisitor extends DefaultVisitor {
//
//	String tab = "   ";
//
//	// class Program { List<Definicion> definicion; }
//	public Object visit(Program node, Object param) {
//		super.visit(node, param);
//		return null;
//	}
//
//	// class Definicion_variable_global { Variable variable; }
//	public Object visit(Definicion_variable_global node, Object param) {
//		System.out.print("var ");
//		super.visit(node, param);
//		System.out.println(";");
//		return null;
//	}
//
//	// class Definicion_struct { String nombre; List<Campo_struct> campo_struct; }
//	public Object visit(Definicion_struct node, Object param) {
//		System.out.println("struct " + node.getNombre() + "{");
//		super.visit(node, param);
//		System.out.println("};");
//		return null;
//	}
//
//	// class Definicion_funcion { String nombre; List<Parametro> parametros; Tipo
//	// retorno; List<Variable_local> locales; List<Sentencia> sentencias; }
//	public Object visit(Definicion_funcion node, Object param) {
//
//		System.out.print(node.getNombre() + "(");
//		if (node.getParametros() != null)
//			for (Variable child : node.getParametros())
//				child.accept(this, param);
//		System.out.print(")");
//
//		if (node.getRetorno() != null) {
//			System.out.print(": ");
//			node.getRetorno().accept(this, param);
//		}
//		System.out.println(" {");
//
//		if (node.getLocales() != null)
//			for (Variable child : node.getLocales()) {
//				System.out.print(tab);
//				System.out.print("var ");
//				child.accept(this, param);
//				System.out.println(";");
//			}
//		if (node.getSentencias() != null)
//			for (Sentencia child : node.getSentencias()) {
//				System.out.print(tab);
//				child.accept(this, param);
//			}
//		System.out.println("}");
//
//		return null;
//	}
//
//	// class Variable { String nombre; Tipo tipo; }
//	public Object visit(Variable node, Object param) {
//		System.out.print(node.getNombre() + ":");
//		super.visit(node, param);
//		return null;
//	}
//
//	// class Campo_struct { String nombre; Tipo tipo; }
//	public Object visit(Campo_struct node, Object param) {
//
//		System.out.print(tab + node.getNombre() + ":");
//		super.visit(node, param);
//		System.out.println(";");
//
//		return null;
//	}
//
//	// class Sentencia_asignacion { Expr izquierda; Expr derecha; }
//	public Object visit(Sentencia_asignacion node, Object param) {
//		if (node.getIzquierda() != null)
//			node.getIzquierda().accept(this, param);
//		System.out.print(" = ");
//		if (node.getDerecha() != null)
//			node.getDerecha().accept(this, param);
//		System.out.println(";");
//		return null;
//	}
//
//	// class Sentencia_print { Expr expresiones; String fincadena; }
//	public Object visit(Sentencia_print node, Object param) {
//		System.out.print("print ");
//		super.visit(node, param);
//		System.out.print(";");
//		return null;
//	}
//
//	// class Sentencia_read { Expr expresiones; }
//	public Object visit(Sentencia_read node, Object param) {
//		System.out.print("read ");
//		super.visit(node, param);
//		System.out.println(";");
//		return null;
//	}
//
//	// class Sentencia_if { Expr condicion; List<Sentencia> sentencias;
//	// List<Sentencia> sino; }
//	public Object visit(Sentencia_if node, Object param) {
//		System.out.print("if(");
//		if (node.getCondicion() != null)
//			node.getCondicion().accept(this, param);
//		System.out.println(") {");
//		if (node.getSentencias() != null)
//			for (Sentencia child : node.getSentencias()) {
//				System.out.print(tab + tab);
//				child.accept(this, param);
//			}
//		System.out.println(tab + "}");
//		if (node.getSino() != null && !node.getSino().isEmpty()) {
//			System.out.println(tab + "else {");
//			for (Sentencia child : node.getSino()) {
//				System.out.print(tab + tab);
//				child.accept(this, param);
//			}
//			System.out.println(tab + "}");
//		}
//		return null;
//	}
//
//	// class Sentencia_while { Expr condicion; List<Sentencia> sentencias; }
//	public Object visit(Sentencia_while node, Object param) {
//
//		// super.visit(node, param);
//		System.out.print("while(");
//		if (node.getCondicion() != null)
//			node.getCondicion().accept(this, param);
//		System.out.println(") {");
//		if (node.getSentencias() != null)
//			for (Sentencia child : node.getSentencias()) {
//				System.out.print(tab + tab);
//				child.accept(this, param);
//			}
//		System.out.println(tab + "}");
//
//		return null;
//	}
//
//	// class Sentencia_llamada_funcion { String nombre; List<Expr> parametros; }
//	public Object visit(Sentencia_llamada_funcion node, Object param) {
//		System.out.print(node.getNombre() + "(");
//		super.visit(node, param);
//		System.out.println(");");
//		return null;
//	}
//
//	// class Sentencia_return { Expr expresion; }
//	public Object visit(Sentencia_return node, Object param) {
//		System.out.print("return");
//
//		if (node.getExpresion() != null) {
//			System.out.print("(");
//			node.getExpresion().accept(this, param);
//			System.out.print(")");
//		}
//		System.out.println(";");
//		return null;
//	}
//
//	// class Tipo_Int { }
//	public Object visit(Tipo_Int node, Object param) {
//		System.out.print("int");
//		return null;
//	}
//
//	// class Tipo_Float { }
//	public Object visit(Tipo_Float node, Object param) {
//		System.out.print("float");
//		return null;
//	}
//
//	// class Tipo_Char { }
//	public Object visit(Tipo_Char node, Object param) {
//		System.out.print("char");
//		return null;
//	}
//
//	// class Tipo_Void { }
//	public Object visit(Tipo_Void node, Object param) {
//		System.out.print("void");
//		return null;
//	}
//
//	// class Tipo_Struct { String nombre; }
//	public Object visit(Tipo_Struct node, Object param) {
//		System.out.print(node.getNombre());
//		return null;
//	}
//
//	// class Tipo_Array { String tamanio; Tipo tipoElementos; }
//	public Object visit(Tipo_Array node, Object param) {
//		System.out.print("[" + node.getTamanio() + "]");
//
//		// super.visit(node, param);
//
//		if (node.getTipoElementos() != null)
//			node.getTipoElementos().accept(this, param);
//
//		return null;
//	}
//
//	// class Expr_int { String string; }
//	public Object visit(Expr_int node, Object param) {
//		System.out.print(node.getString());
//		return null;
//	}
//
//	// class Expr_real { String string; }
//	public Object visit(Expr_real node, Object param) {
//		System.out.print(node.getString());
//		return null;
//	}
//
//	// class Expr_char { String string; }
//	public Object visit(Expr_char node, Object param) {
//		System.out.print(node.getString());
//		return null;
//	}
//
//	// class Expr_ident { String string; }
//	public Object visit(Expr_ident node, Object param) {
//		System.out.print(node.getString());
//		return null;
//	}
//
//	// class Expr_binaria { Expr izquierda; Operador operador; Expr derecha; }
//	public Object visit(Expr_binaria node, Object param) {
//		System.out.print("(");
//		super.visit(node, param);
//		System.out.print(")");
//		return null;
//	}
//
//	// class Expr_negada { Operador operador; Expr derecha; }
//	public Object visit(Expr_negada node, Object param) {
//
//		super.visit(node, param);
//
//		return null;
//	}
//
//	// class Expr_cast { Tipo tipo_convertido; Expr expr; }
//	public Object visit(Expr_cast node, Object param) {
//
//		// super.visit(node, param);
//		System.out.print("<");
//		if (node.getTipo_convertido() != null)
//			node.getTipo_convertido().accept(this, param);
//		System.out.print(">");
//		if (node.getExpr() != null)
//			node.getExpr().accept(this, param);
//
//		return null;
//	}
//
//	// class Expr_acceso_vector { Expr fuera; Expr dentro; }
//	public Object visit(Expr_acceso_vector node, Object param) {
//
//		// super.visit(node, param);
//
//		if (node.getFuera() != null)
//			node.getFuera().accept(this, param);
//		System.out.print("[");
//		if (node.getDentro() != null)
//			node.getDentro().accept(this, param);
//		System.out.print("]");
//		return null;
//	}
//
//	// class Expr_acceso_struct { Expr izquierda; Expr derecha; }
//	public Object visit(Expr_acceso_struct node, Object param) {
//
//		// super.visit(node, param);
//
//		if (node.getIzquierda() != null)
//			node.getIzquierda().accept(this, param);
//		System.out.print(".");
//		if (node.getDerecha() != null)
//			node.getDerecha().accept(this, param);
//
//		return null;
//	}
//
//	// class Expr_llamada_funcion { String nombre; List<Expr> parametros; }
//	public Object visit(Expr_llamada_funcion node, Object param) {
//
//		// super.visit(node, param);
//		System.out.print(node.getNombre() + "(");
//		if (node.getParametros() != null)
//			for (Expr child : node.getParametros())
//				child.accept(this, param);
//		System.out.print(")");
//		return null;
//	}
//
//	// class Operador_aritmetico { String string; }
//	public Object visit(Operador_aritmetico node, Object param) {
//		System.out.print(node.getString());
//		return null;
//	}
//
//	// class Operador_logico { String string; }
//	public Object visit(Operador_logico node, Object param) {
//		System.out.print(node.getString());
//		return null;
//	}
//
//	// class Operador_comparacion { String string; }
//	public Object visit(Operador_comparacion node, Object param) {
//		System.out.print(node.getString());
//		return null;
//	}
}
