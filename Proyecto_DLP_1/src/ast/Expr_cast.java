/**
 * @generated VGen (for ANTLR) 1.4.0
 */

package ast;

import visitor.*;

import org.antlr.v4.runtime.*;

//	expr_cast:expr -> tipo_convertido:tipo  expr:expr

public class Expr_cast extends AbstractExpr {

	public Expr_cast(Tipo tipo_convertido, Expr expr) {
		this.tipo_convertido = tipo_convertido;
		this.expr = expr;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(tipo_convertido, expr);
	}

	public Expr_cast(Object tipo_convertido, Object expr) {
		this.tipo_convertido = (Tipo) ((tipo_convertido instanceof ParserRuleContext) ? getAST(tipo_convertido) : tipo_convertido);
		this.expr = (Expr) ((expr instanceof ParserRuleContext) ? getAST(expr) : expr);

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(tipo_convertido, expr);
	}

	public Tipo getTipo_convertido() {
		return tipo_convertido;
	}
	public void setTipo_convertido(Tipo tipo_convertido) {
		this.tipo_convertido = tipo_convertido;
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

	private Tipo tipo_convertido;
	private Expr expr;

	public String toString() {
       return "{tipo_convertido:" + getTipo_convertido() + ", expr:" + getExpr() + "}";
   }
}
