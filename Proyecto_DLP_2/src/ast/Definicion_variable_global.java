/**
 * @generated VGen (for ANTLR) 1.7.0
 */

package ast;

import org.antlr.v4.runtime.*;

import visitor.*;

//	definicion_variable_global:definicion -> variable:variable

public class Definicion_variable_global extends AbstractDefinicion {

	public Definicion_variable_global(Variable variable) {
		this.variable = variable;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(variable);
	}

	public Definicion_variable_global(Object variable) {
		this.variable = (Variable) getAST(variable);

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(variable);
	}

	public Variable getVariable() {
		return variable;
	}
	public void setVariable(Variable variable) {
		this.variable = variable;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private Variable variable;

	public String toString() {
       return "{variable:" + getVariable() + "}";
   }
}
