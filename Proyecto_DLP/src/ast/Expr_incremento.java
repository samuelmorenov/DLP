/**
 * @generated VGen (for ANTLR) 1.7.0
 */

package ast;

import visitor.*;

//	expr_incremento:expr -> izquierda:expr  operador:operador

//TODO: Añadido con el operador incremento
public class Expr_incremento extends AbstractExpr {

	public Expr_incremento(Expr izquierda, Operador operador) {
		this.izquierda = izquierda;
		this.operador = operador;

		// Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
		// Obtiene la linea/columna a partir de las de los hijos.
		setPositions(izquierda, operador);
	}

	public Expr_incremento(Object izquierda, Object operador) {
		this.izquierda = (Expr) getAST(izquierda);
		this.operador = (Operador) getAST(operador);

		// Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
		// Obtiene la linea/columna a partir de las de los hijos.
		setPositions(izquierda, operador);
	}

	public Expr getIzquierda() {
		return izquierda;
	}

	public void setIzquierda(Expr izquierda) {
		this.izquierda = izquierda;
	}

	public Operador getOperador() {
		return operador;
	}

	public void setOperador(Operador operador) {
		this.operador = operador;
	}

	@Override
	public Object accept(Visitor v, Object param) {
		return v.visit(this, param);
	}

	private Expr izquierda;
	private Operador operador;

	public String toString() {
		return "{izquierda:" + getIzquierda() + ", operador:" + getOperador() + "}";
	}
}
