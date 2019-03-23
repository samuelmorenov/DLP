/**
 * @generated VGen (for ANTLR) 1.4.0
 */

package ast;

import visitor.*;

import org.antlr.v4.runtime.*;

//	expr_ident:expr -> string:String

public class Expr_ident extends AbstractExpr {

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

	public Parametro getDefinicion_parametro() {
		return definicion_parametro;
	}

	public void setDefinicion(Parametro definicion_parametro) {
		this.definicion_parametro = definicion_parametro;
	}


	public Definicion_variable_local getDefinicion_local() {
		return definicion_local;
	}

	public void setDefinicion_local(Definicion_variable_local definicion_local) {
		this.definicion_local = definicion_local;
	}

	public Definicion_variable_global getDefinicion_global() {
		return definicion_global;
	}

	public void setDefinicion_global(Definicion_variable_global definicion_global) {
		this.definicion_global = definicion_global;
	}

	public void setDefinicion_parametro(Parametro definicion_parametro) {
		this.definicion_parametro = definicion_parametro;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private String string;
	private Parametro definicion_parametro;
	private Definicion_variable_local definicion_local;
	private Definicion_variable_global definicion_global;

	public String toString() {
       return "{string:" + getString() + "}";
   }

}
