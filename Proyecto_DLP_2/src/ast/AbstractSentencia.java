/**
 * @generated VGen (for ANTLR) 1.7.0
 */

package ast;

public abstract class AbstractSentencia extends AbstractAST implements Sentencia {

	public Definicion_funcion getFuncionActual() {
		return funcionActual;
	}

	public void setFuncionActual(Definicion_funcion funcionActual) {
		this.funcionActual = funcionActual;
	}

	private Definicion_funcion funcionActual;

}
