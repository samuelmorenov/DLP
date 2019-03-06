/**
 * @generated VGen (for ANTLR) 1.4.0
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

	//	class Program { List<Bloque> bloque; }
	public Object visit(Program node, Object param) {
		visitChildren(node.getBloque(), param);
		return null;
	}

	//	class Variable { String nombre;  List<Entero> entero;  Tipo tipo; }
	public Object visit(Variable node, Object param) {
		visitChildren(node.getEntero(), param);
		if (node.getTipo() != null)
			node.getTipo().accept(this, param);
		return null;
	}

	//	class Entero { int numero; }
	public Object visit(Entero node, Object param) {
		return null;
	}

	//	class TipoInt {  }
	public Object visit(TipoInt node, Object param) {
		return null;
	}

	//	class TipoFloat {  }
	public Object visit(TipoFloat node, Object param) {
		return null;
	}

	//	class TipoChar {  }
	public Object visit(TipoChar node, Object param) {
		return null;
	}

	//	class TipoVar { String string; }
	public Object visit(TipoVar node, Object param) {
		return null;
	}

	//	class Struct { String nombre;  List<Definicion> definicion; }
	public Object visit(Struct node, Object param) {
		visitChildren(node.getDefinicion(), param);
		return null;
	}

	//	class Definicion { String nombre;  List<Entero> entero;  Tipo tipo; }
	public Object visit(Definicion node, Object param) {
		visitChildren(node.getEntero(), param);
		if (node.getTipo() != null)
			node.getTipo().accept(this, param);
		return null;
	}

	//	class Funcion { String nombre;  List<Parametro> parametros;  List<Tipo> retorno;  List<Sentencia> sentencia; }
	public Object visit(Funcion node, Object param) {
		visitChildren(node.getParametros(), param);
		visitChildren(node.getRetorno(), param);
		visitChildren(node.getSentencia(), param);
		return null;
	}

	//	class Parametro { String nombre;  Tipo tipo; }
	public Object visit(Parametro node, Object param) {
		if (node.getTipo() != null)
			node.getTipo().accept(this, param);
		return null;
	}

	//	class Sentencia { String cuerpo; }
	public Object visit(Sentencia node, Object param) {
		return null;
	}

    // Método auxiliar -----------------------------
    protected void visitChildren(List<? extends AST> children, Object param) {
        if (children != null)
            for (AST child : children)
                child.accept(this, param);
    }
}
