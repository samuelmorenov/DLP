/**
 * @generated VGen (for ANTLR) 1.4.0
 */

package ast;

import visitor.*;

import org.antlr.v4.runtime.*;

//	operador_booleano:operador -> operador_booleano:operador

public class Operador_booleano extends AbstractOperador {

	public Operador_booleano(Operador operador_booleano) {
		this.operador_booleano = operador_booleano;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(operador_booleano);
	}

	public Operador_booleano(Object operador_booleano) {
		this.operador_booleano = (Operador) ((operador_booleano instanceof ParserRuleContext) ? getAST(operador_booleano) : operador_booleano);

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(operador_booleano);
	}

	public Operador getOperador_booleano() {
		return operador_booleano;
	}
	public void setOperador_booleano(Operador operador_booleano) {
		this.operador_booleano = operador_booleano;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private Operador operador_booleano;

	public String toString() {
       return "{operador_booleano:" + getOperador_booleano() + "}";
   }
}
