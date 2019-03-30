/**
 * @generated VGen (for ANTLR) 1.4.0
 */

package ast;

import visitor.*;

import org.antlr.v4.runtime.*;

//	tipoStruct:tipo -> nombre:String

public class TipoStruct extends AbstractTipo {

	public TipoStruct(String nombre) {
		this.nombre = nombre;
	}

	public TipoStruct(Object nombre) {
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
	public int getSize() {
		this.calcularSize();
		return this.size;
	}

	
	public Struct getDefinicion() {
		return definicion;
	}

	public void setDefinicion(Struct definicion) {
		this.definicion = definicion;
	}

	private void calcularSize() {
		if (this.size == -1) {
			this.size = 0;
			for (int i = 0; i < definicion.getDefinicion_campo_struct().size(); i++) {
				Definicion_campo_struct def = this.definicion.getDefinicion_campo_struct().get(i);
				def.setAddress(this.size);
				this.size += def.getTipo().getSize();
				//System.out.println(this.size + " " + def.getNombre()); //TODO borrar
			}
		}

	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private String nombre;
	private Struct definicion;
	private int size = -1;

	public String toString() {
       return "{nombre:" + getNombre() + "}";
   }
}
