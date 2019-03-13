/**
 * @generated VGen (for ANTLR) 1.4.0
 */

package ast;

import visitor.*;

import org.antlr.v4.runtime.*;

//	operador_aritmetico:operador -> operador_aritmetico:operador

public class Operador_aritmetico extends AbstractOperador {

	public Operador_aritmetico(Operador operador_aritmetico) {
		this.operador_aritmetico = operador_aritmetico;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(operador_aritmetico);
	}

	public Operador_aritmetico(Object operador_aritmetico) {
		this.operador_aritmetico = (Operador) ((operador_aritmetico instanceof ParserRuleContext) ? getAST(operador_aritmetico) : operador_aritmetico);

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(operador_aritmetico);
	}

	public Operador getOperador_aritmetico() {
		return operador_aritmetico;
	}
	public void setOperador_aritmetico(Operador operador_aritmetico) {
		this.operador_aritmetico = operador_aritmetico;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private Operador operador_aritmetico;

	public String toString() {
       return "{operador_aritmetico:" + getOperador_aritmetico() + "}";
   }
}
