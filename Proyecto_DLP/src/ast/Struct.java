/**
 * @generated VGen (for ANTLR) 1.4.0
 */

package ast;

import java.util.*;
import visitor.*;

import org.antlr.v4.runtime.*;

//	struct:bloque -> nombre:String  definicion:definicion*

public class Struct extends AbstractBloque {

	public Struct(String nombre, List<Definicion> definicion) {
		this.nombre = nombre;
		this.definicion = definicion;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(definicion);
	}

	@SuppressWarnings("unchecked")
	public Struct(Object nombre, Object definicion) {
		this.nombre = (nombre instanceof Token) ? ((Token)nombre).getText() : (String) nombre;
		this.definicion = (List<Definicion>) definicion;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(nombre, definicion);
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Definicion> getDefinicion() {
		return definicion;
	}
	public void setDefinicion(List<Definicion> definicion) {
		this.definicion = definicion;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private String nombre;
	private List<Definicion> definicion;

	public String toString() {
       return "{nombre:" + getNombre() + ", definicion:" + getDefinicion() + "}";
   }
}
