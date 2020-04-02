/**
 * @generated VGen (for ANTLR) 1.7.0
 */

package ast;

import org.antlr.v4.runtime.*;

import visitor.*;

//	tipo_Struct:tipo -> nombre:String

public class Tipo_Struct extends AbstractTipo {

	private Definicion_struct definicion;

	public Tipo_Struct(String nombre) {
		this.nombre = nombre;
	}

	public Tipo_Struct(Object nombre) {
		this.nombre = (nombre instanceof Token) ? ((Token) nombre).getText() : (String) nombre;

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

	public Definicion_struct getDefinicion() {
		return definicion;
	}

	public void setDefinicion(Definicion_struct definicion) {
		this.definicion = definicion;
	}

	@Override
	public int getSize() {
		if (this.size == -1) {
			this.calcularSize();
		}
		return this.size;
	}

	private void calcularSize() {
		this.size = 0;
		for (int i = 0; i < definicion.getCampo_struct().size(); i++) {
			Campo_struct def = this.definicion.getCampo_struct().get(i);
			def.setAddress(this.size);
			this.size += def.getTipo().getSize();
		}
	}

	@Override
	public Object accept(Visitor v, Object param) {
		return v.visit(this, param);
	}

	private String nombre;
	private int size = -1;

	public String toString() {
		return "{nombre:" + getNombre() + "}";
	}

}
