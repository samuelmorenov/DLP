/**
 * @generated VGen (for ANTLR) 1.7.0
 */

package ast;

import org.antlr.v4.runtime.*;

import visitor.*;

//	expr_negada:expr -> operador:operador  derecha:expr

public class Expr_negada extends AbstractExpr {

	public Expr_negada(Operador operador, Expr derecha) {
		this.operador = operador;
		this.derecha = derecha;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(operador, derecha);
	}

	public Expr_negada(Object operador, Object derecha) {
		this.operador = (Operador) getAST(operador);
		this.derecha = (Expr) getAST(derecha);

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(operador, derecha);
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

	private Operador operador;
	private Expr derecha;

	public String toString() {
       return "{operador:" + getOperador() + ", derecha:" + getDerecha() + "}";
   }
}
