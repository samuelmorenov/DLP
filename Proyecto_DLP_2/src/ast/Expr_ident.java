/**
 * @generated VGen (for ANTLR) 1.7.0
 */

package ast;

import org.antlr.v4.runtime.*;

import visitor.*;

//	expr_ident:expr -> string:String

public class Expr_ident extends AbstractExpr {
	
	private Definicion_variable definicion;

	public Expr_ident(String string) {
		this.string = string;
	}

	public Expr_ident(Object string) {
		this.string = (string instanceof Token) ? ((Token)string).getText() : (String) string;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(string);
	}

	public String getString() {
		return string;
	}
	public void setString(String string) {
		this.string = string;
	}
	
	

//	public Definicion_variable getDefinicion() {
//		return definicion;
//	}

	public void setDefinicion(Definicion_variable definicion) {
		this.definicion = definicion;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private String string;

	public String toString() {
       return "{string:" + getString() + "}";
   }
}
