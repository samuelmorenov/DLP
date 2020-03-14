/**
 * @generated VGen (for ANTLR) 1.7.0
 */

package ast;

import org.antlr.v4.runtime.*;

import visitor.*;

//	expr_uso_variable:expr -> string:String

public class Expr_uso_variable extends AbstractExpr {

	private Definicion_variable definicion;

	public Expr_uso_variable(String string) {
		this.string = string;
	}

	public Expr_uso_variable(Object string) {
		this.string = (string instanceof Token) ? ((Token) string).getText() : (String) string;

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
