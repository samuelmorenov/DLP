/**
 * @generated VGen (for ANTLR) 1.4.0
 */

package ast;

import visitor.*;

import org.antlr.v4.runtime.*;

//	expr_cast:expr -> tipo:tipo  expr:expr

public class Expr_cast extends AbstractExpr {

	public Expr_cast(Tipo tipo, Expr expr) {
		this.tipo = tipo;
		this.expr = expr;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(tipo, expr);
	}

	public Expr_cast(Object tipo, Object expr) {
		this.tipo = (Tipo) ((tipo instanceof ParserRuleContext) ? getAST(tipo) : tipo);
		this.expr = (Expr) ((expr instanceof ParserRuleContext) ? getAST(expr) : expr);

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(tipo, expr);
	}

	public Tipo getTipo() {
		return tipo;
	}
	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public Expr getExpr() {
		return expr;
	}
	public void setExpr(Expr expr) {
		this.expr = expr;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private Tipo tipo;
	private Expr expr;

	public String toString() {
       return "{tipo:" + getTipo() + ", expr:" + getExpr() + "}";
   }
}
