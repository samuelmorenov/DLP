/**
 * @generated VGen (for ANTLR) 1.7.0
 */

package ast;

import org.antlr.v4.runtime.*;

import visitor.*;

//	expr_operacion:expr -> izquierda:expr  operador:operador  derecha:expr

public class Expr_operacion extends AbstractExpr {

	public Expr_operacion(Expr izquierda, Operador operador, Expr derecha) {
		this.izquierda = izquierda;
		this.operador = operador;
		this.derecha = derecha;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(izquierda, operador, derecha);
	}

	public Expr_operacion(Object izquierda, Object operador, Object derecha) {
		this.izquierda = (Expr) getAST(izquierda);
		this.operador = (Operador) getAST(operador);
		this.derecha = (Expr) getAST(derecha);

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(izquierda, operador, derecha);
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
	private Operador operador;
	private Expr derecha;

	public String toString() {
       return "{izquierda:" + getIzquierda() + ", operador:" + getOperador() + ", derecha:" + getDerecha() + "}";
   }
}
