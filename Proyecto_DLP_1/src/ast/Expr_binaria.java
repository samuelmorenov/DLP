/**
 * @generated VGen (for ANTLR) 1.4.0
 */

package ast;

import visitor.*;

import org.antlr.v4.runtime.*;

//	expr_binaria:expr -> izquierda:expr  operador:operador  derecha:expr

public class Expr_binaria extends AbstractExpr {

	public Expr_binaria(Expr izquierda, Operador operador, Expr derecha) {
		this.izquierda = izquierda;
		this.operador = operador;
		this.derecha = derecha;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(izquierda, operador, derecha);
	}

	public Expr_binaria(Object izquierda, Object operador, Object derecha) {
		this.izquierda = (Expr) ((izquierda instanceof ParserRuleContext) ? getAST(izquierda) : izquierda);
		this.operador = (Operador) ((operador instanceof ParserRuleContext) ? getAST(operador) : operador);
		this.derecha = (Expr) ((derecha instanceof ParserRuleContext) ? getAST(derecha) : derecha);

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
