/**
 * @generated VGen (for ANTLR) 1.4.0
 */

package ast;

import visitor.*;

import org.antlr.v4.runtime.*;

//	sentencia_return:sentencia -> expresion:expr

public class Sentencia_return extends AbstractSentencia {

	public Sentencia_return(Expr expresion) {
		this.expresion = expresion;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(expresion);
	}

	public Sentencia_return(Object expresion) {
		this.expresion = (Expr) ((expresion instanceof ParserRuleContext) ? getAST(expresion) : expresion);

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(expresion);
	}

	public Expr getExpresion() {
		return expresion;
	}
	public void setExpresion(Expr expresion) {
		this.expresion = expresion;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private Expr expresion;

	public String toString() {
       return "{expresion:" + getExpresion() + "}";
   }
}
