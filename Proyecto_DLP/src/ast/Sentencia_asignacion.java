/**
 * @generated VGen (for ANTLR) 1.7.0
 */

package ast;

import visitor.*;

//	sentencia_asignacion:sentencia -> izquierda:expr  derecha:expr

public class Sentencia_asignacion extends AbstractSentencia {

	public Sentencia_asignacion(Expr izquierda, Expr derecha) {
		this.izquierda = izquierda;
		this.derecha = derecha;

		// Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
		// Obtiene la linea/columna a partir de las de los hijos.
		setPositions(izquierda, derecha);
	}

	public Sentencia_asignacion(Object izquierda, Object derecha) {
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
