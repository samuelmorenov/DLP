/**
 * @generated VGen (for ANTLR) 1.7.0
 */

package ast;

public abstract class AbstractExpr extends AbstractAST implements Expr {

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public boolean isModificable() {
		return modificable;
	}

	public void setModificable(boolean modificable) {
		this.modificable = modificable;
	}

	private Tipo tipo;
	private boolean modificable;
}
