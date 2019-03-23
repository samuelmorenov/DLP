/**
 * @generated VGen (for ANTLR) 1.4.0
 */

package ast;

import java.util.*;
import visitor.*;

import org.antlr.v4.runtime.*;

//	struct:bloque -> nombre:String  definicion_variable_struct:definicion_variable_struct*

public class Struct extends AbstractBloque {

	public Struct(String nombre, List<Definicion_variable_struct> definicion_variable_struct) {
		this.nombre = nombre;
		this.definicion_variable_struct = definicion_variable_struct;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(definicion_variable_struct);
	}

	@SuppressWarnings("unchecked")
	public Struct(Object nombre, Object definicion_variable_struct) {
		this.nombre = (nombre instanceof Token) ? ((Token)nombre).getText() : (String) nombre;
		this.definicion_variable_struct = (List<Definicion_variable_struct>) definicion_variable_struct;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(nombre, definicion_variable_struct);
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Definicion_variable_struct> getDefinicion_variable_struct() {
		return definicion_variable_struct;
	}
	public void setDefinicion_variable_struct(List<Definicion_variable_struct> definicion_variable_struct) {
		this.definicion_variable_struct = definicion_variable_struct;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private String nombre;
	private List<Definicion_variable_struct> definicion_variable_struct;

	public String toString() {
       return "{nombre:" + getNombre() + ", definicion_variable_struct:" + getDefinicion_variable_struct() + "}";
   }
}
