/**
 * @generated VGen (for ANTLR) 1.7.0
 */

package ast;

import org.antlr.v4.runtime.*;

import visitor.*;

//	expr_acceso_struct:expr -> izquierda:expr  derecha:expr

public class Expr_acceso_struct extends AbstractExpr {

	public Expr_acceso_struct(Expr izquierda, Expr derecha) {
		this.izquierda = izquierda;
		this.derecha = derecha;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(izquierda, derecha);
	}

	public Expr_acceso_struct(Object izquierda, Object derecha) {
		this.izquierda = (Expr) getAST(izquierda);
		this.derecha = (Expr) getAST(derecha);

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
