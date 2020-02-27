/**
 * @generated VGen (for ANTLR) 1.7.0
 */

package ast;

import java.util.*;
import org.antlr.v4.runtime.*;

import visitor.*;

//	definicion_struct:definicion -> nombre:String  campo_struct:campo_struct*

public class Definicion_struct extends AbstractDefinicion {

	public Definicion_struct(String nombre, List<Campo_struct> campo_struct) {
		this.nombre = nombre;
		this.campo_struct = campo_struct;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(campo_struct);
	}

	public Definicion_struct(Object nombre, Object campo_struct) {
		this.nombre = (nombre instanceof Token) ? ((Token)nombre).getText() : (String) nombre;
		this.campo_struct = this.<Campo_struct>getAstFromContexts(campo_struct);

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(nombre, campo_struct);
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Campo_struct> getCampo_struct() {
		return campo_struct;
	}
	public void setCampo_struct(List<Campo_struct> campo_struct) {
		this.campo_struct = campo_struct;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private String nombre;
	private List<Campo_struct> campo_struct;

	public String toString() {
       return "{nombre:" + getNombre() + ", campo_struct:" + getCampo_struct() + "}";
   }
}
