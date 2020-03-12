/**
 * @generated VGen (for ANTLR) 1.7.0
 */

package visitor;

import ast.*;
import java.util.*;

/*
DefaultVisitor. Implementación base del visitor para ser derivada por nuevos visitor.
	No modificar esta clase. Para crear nuevos visitor usar el fichero "_PlantillaParaVisitors.txt".
	DefaultVisitor ofrece una implementación por defecto de cada nodo que se limita a visitar los nodos hijos.
*/
public class DefaultVisitor implements Visitor {

	//	class Program { List<Definicion> definicion; }
	public Object visit(Program node, Object param) {
		visitChildren(node.getDefinicion(), param);
		return null;
	}

	//	class Definicion_variable { String nombre;  Tipo tipo;  Ambito ambito; }
	public Object visit(Definicion_variable node, Object param) {
		if (node.getTipo() != null)
			node.getTipo().accept(this, param);
		return null;
	}

	//	class Definicion_struct { String nombre;  List<Campo_struct> campo_struct; }
	public Object visit(Definicion_struct node, Object param) {
		visitChildren(node.getCampo_struct(), param);
		return null;
	}

	//	class Definicion_funcion { String nombre;  List<Definicion_variable> parametros;  Tipo retorno;  List<Definicion_variable> locales;  List<Sentencia> sentencias; }
	public Object visit(Definicion_funcion node, Object param) {
		visitChildren(node.getParametros(), param);
		if (node.getRetorno() != null)
			node.getRetorno().accept(this, param);
		visitChildren(node.getLocales(), param);
		visitChildren(node.getSentencias(), param);
		return null;
	}

	//	class Campo_struct { String nombre;  Tipo tipo; }
	public Object visit(Campo_struct node, Object param) {
		if (node.getTipo() != null)
			node.getTipo().accept(this, param);
		return null;
	}

	//	class Sentencia_asignacion { Expr izquierda;  Expr derecha; }
	public Object visit(Sentencia_asignacion node, Object param) {
		if (node.getIzquierda() != null)
			node.getIzquierda().accept(this, param);
		if (node.getDerecha() != null)
			node.getDerecha().accept(this, param);
		return null;
	}

	//	class Sentencia_print { Expr expresiones;  String fincadena; }
	public Object visit(Sentencia_print node, Object param) {
		if (node.getExpresiones() != null)
			node.getExpresiones().accept(this, param);
		return null;
	}

	//	class Sentencia_read { Expr expresiones; }
	public Object visit(Sentencia_read node, Object param) {
		if (node.getExpresiones() != null)
			node.getExpresiones().accept(this, param);
		return null;
	}

	//	class Sentencia_if { Expr condicion;  List<Sentencia> sentencias;  List<Sentencia> sino; }
	public Object visit(Sentencia_if node, Object param) {
		if (node.getCondicion() != null)
			node.getCondicion().accept(this, param);
		visitChildren(node.getSentencias(), param);
		visitChildren(node.getSino(), param);
		return null;
	}

	//	class Sentencia_while { Expr condicion;  List<Sentencia> sentencias; }
	public Object visit(Sentencia_while node, Object param) {
		if (node.getCondicion() != null)
			node.getCondicion().accept(this, param);
		visitChildren(node.getSentencias(), param);
		return null;
	}

	//	class Sentencia_llamada_funcion { String nombre;  List<Expr> parametros; }
	public Object visit(Sentencia_llamada_funcion node, Object param) {
		visitChildren(node.getParametros(), param);
		return null;
	}

	//	class Sentencia_return { Expr expresion; }
	public Object visit(Sentencia_return node, Object param) {
		if (node.getExpresion() != null)
			node.getExpresion().accept(this, param);
		return null;
	}

	//	class Tipo_Int {  }
	public Object visit(Tipo_Int node, Object param) {
		return null;
	}

	//	class Tipo_Float {  }
	public Object visit(Tipo_Float node, Object param) {
		return null;
	}

	//	class Tipo_Char {  }
	public Object visit(Tipo_Char node, Object param) {
		return null;
	}

	//	class Tipo_Void {  }
	public Object visit(Tipo_Void node, Object param) {
		return null;
	}

	//	class Tipo_Struct { String nombre; }
	public Object visit(Tipo_Struct node, Object param) {
		return null;
	}

	//	class Tipo_Array { String tamanio;  Tipo tipoElementos; }
	public Object visit(Tipo_Array node, Object param) {
		if (node.getTipoElementos() != null)
			node.getTipoElementos().accept(this, param);
		return null;
	}

	//	class Expr_int { String string; }
	public Object visit(Expr_int node, Object param) {
		return null;
	}

	//	class Expr_real { String string; }
	public Object visit(Expr_real node, Object param) {
		return null;
	}

	//	class Expr_char { String string; }
	public Object visit(Expr_char node, Object param) {
		return null;
	}

	//	class Expr_ident { String string; }
	public Object visit(Expr_ident node, Object param) {
		return null;
	}

	//	class Expr_binaria { Expr izquierda;  Operador operador;  Expr derecha; }
	public Object visit(Expr_binaria node, Object param) {
		if (node.getIzquierda() != null)
			node.getIzquierda().accept(this, param);
		if (node.getOperador() != null)
			node.getOperador().accept(this, param);
		if (node.getDerecha() != null)
			node.getDerecha().accept(this, param);
		return null;
	}

	//	class Expr_negada { Operador operador;  Expr derecha; }
	public Object visit(Expr_negada node, Object param) {
		if (node.getOperador() != null)
			node.getOperador().accept(this, param);
		if (node.getDerecha() != null)
			node.getDerecha().accept(this, param);
		return null;
	}

	//	class Expr_cast { Tipo tipo_convertido;  Expr expr; }
	public Object visit(Expr_cast node, Object param) {
		if (node.getTipo_convertido() != null)
			node.getTipo_convertido().accept(this, param);
		if (node.getExpr() != null)
			node.getExpr().accept(this, param);
		return null;
	}

	//	class Expr_acceso_vector { Expr fuera;  Expr dentro; }
	public Object visit(Expr_acceso_vector node, Object param) {
		if (node.getFuera() != null)
			node.getFuera().accept(this, param);
		if (node.getDentro() != null)
			node.getDentro().accept(this, param);
		return null;
	}

	//	class Expr_acceso_struct { Expr izquierda;  Expr derecha; }
	public Object visit(Expr_acceso_struct node, Object param) {
		if (node.getIzquierda() != null)
			node.getIzquierda().accept(this, param);
		if (node.getDerecha() != null)
			node.getDerecha().accept(this, param);
		return null;
	}

	//	class Expr_llamada_funcion { String nombre;  List<Expr> parametros; }
	public Object visit(Expr_llamada_funcion node, Object param) {
		visitChildren(node.getParametros(), param);
		return null;
	}

	//	class Operador_aritmetico { String string; }
	public Object visit(Operador_aritmetico node, Object param) {
		return null;
	}

	//	class Operador_logico { String string; }
	public Object visit(Operador_logico node, Object param) {
		return null;
	}

	//	class Operador_comparacion { String string; }
	public Object visit(Operador_comparacion node, Object param) {
		return null;
	}

    // Método auxiliar -----------------------------
    protected void visitChildren(List<? extends AST> children, Object param) {
        if (children != null)
            for (AST child : children)
                child.accept(this, param);
    }
}
