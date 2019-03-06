/**
 * @generated VGen (for ANTLR) 1.4.0
 */

package ast;

import visitor.*;

import org.antlr.v4.runtime.*;

//	operador -> operador:String

public class Operador extends AbstractAST  {

	public Operador(String operador) {
		this.operador = operador;
	}

	public Operador(Object operador) {
		this.operador = (operador instanceof Token) ? ((Token)operador).getText() : (String) operador;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(operador);
	}

	public String getOperador() {
		return operador;
	}
	public void setOperador(String operador) {
		this.operador = operador;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private String operador;

	public String toString() {
       return "{operador:" + getOperador() + "}";
   }
}
