/**
 * @generated VGen (for ANTLR) 1.4.0
 */

package ast;

import visitor.*;

import org.antlr.v4.runtime.*;

//	operador_logico:operador -> operador_logico:operador

public class Operador_logico extends AbstractOperador {

	public Operador_logico(Operador operador_logico) {
		this.operador_logico = operador_logico;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(operador_logico);
	}

	public Operador_logico(Object operador_logico) {
		this.operador_logico = (Operador) ((operador_logico instanceof ParserRuleContext) ? getAST(operador_logico) : operador_logico);

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(operador_logico);
	}

	public Operador getOperador_logico() {
		return operador_logico;
	}
	public void setOperador_logico(Operador operador_logico) {
		this.operador_logico = operador_logico;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private Operador operador_logico;

	public String toString() {
       return "{operador_logico:" + getOperador_logico() + "}";
   }
}
