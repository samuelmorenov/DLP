/**
 * @generated VGen (for ANTLR) 1.4.0
 */

package ast;

import visitor.*;

import org.antlr.v4.runtime.*;

//	expr_punto:expr -> izquierda:expr  derecha:expr

public class Expr_punto extends AbstractExpr {

	public Expr_punto(Expr izquierda, Expr derecha) {
		this.izquierda = izquierda;
		this.derecha = derecha;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(izquierda, derecha);
	}

	public Expr_punto(Object izquierda, Object derecha) {
		this.izquierda = (Expr) ((izquierda instanceof ParserRuleContext) ? getAST(izquierda) : izquierda);
		this.derecha = (Expr) ((derecha instanceof ParserRuleContext) ? getAST(derecha) : derecha);

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(izquierda, derecha);
	}

	public Expr getIzquierda() {
		return izquierda;
	}
	public void setIzquierda(Expr izquierda) {
		this.izquierda = izquierda;
	}

	public Expr getDerecha() {
		return derecha;
	}
	public void setDerecha(Expr derecha) {
		this.derecha = derecha;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private Expr izquierda;
	private Expr derecha;

	public String toString() {
       return "{izquierda:" + getIzquierda() + ", derecha:" + getDerecha() + "}";
   }
}
