/**
 * @generated VGen (for ANTLR) 1.7.0
 */

package ast;

import org.antlr.v4.runtime.*;

import visitor.*;

//	sentencia_read:sentencia -> expresiones:expr

public class Sentencia_read extends AbstractSentencia {

	public Sentencia_read(Expr expresiones) {
		this.expresiones = expresiones;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(expresiones);
	}

	public Sentencia_read(Object expresiones) {
		this.expresiones = (Expr) getAST(expresiones);

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(expresiones);
	}

	public Expr getExpresiones() {
		return expresiones;
	}
	public void setExpresiones(Expr expresiones) {
		this.expresiones = expresiones;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private Expr expresiones;

	public String toString() {
       return "{expresiones:" + getExpresiones() + "}";
   }
}
