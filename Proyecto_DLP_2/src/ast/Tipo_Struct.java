/**
 * @generated VGen (for ANTLR) 1.7.0
 */

package ast;

import org.antlr.v4.runtime.*;

import visitor.*;

//	tipo_Struct:tipo -> nombre:String

public class Tipo_Struct extends AbstractTipo {

	public Tipo_Struct(String nombre) {
		this.nombre = nombre;
	}

	public Tipo_Struct(Object nombre) {
		this.nombre = (nombre instanceof Token) ? ((Token)nombre).getText() : (String) nombre;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(nombre);
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private String nombre;

	public String toString() {
       return "{nombre:" + getNombre() + "}";
   }
}
