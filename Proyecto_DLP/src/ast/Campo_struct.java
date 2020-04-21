/**
 * @generated VGen (for ANTLR) 1.7.0
 */

package ast;

import org.antlr.v4.runtime.*;

import visitor.*;

//	campo_struct -> nombre:String  tipo:tipo

public class Campo_struct extends AbstractAST {

	public Campo_struct(String nombre, Tipo tipo) {
		this.nombre = nombre;
		this.tipo = tipo;

		// Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
		// Obtiene la linea/columna a partir de las de los hijos.
		setPositions(tipo);
	}

	public Campo_struct(Object nombre, Object tipo) {
		this.nombre = (nombre instanceof Token) ? ((Token) nombre).getText() : (String) nombre;
		this.tipo = (Tipo) getAST(tipo);

		// Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
		// Obtiene la linea/columna a partir de las de los hijos.
		setPositions(nombre, tipo);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public int getAddress() {
		return address;
	}

	public void setAddress(int address) {
		this.address = address;
	}

	@Override
	public Object accept(Visitor v, Object param) {
		return v.visit(this, param);
	}

	private String nombre;
	private Tipo tipo;
	private int address;

	public String toString() {
		return "{nombre:" + getNombre() + ", tipo:" + getTipo() + "}";
	}

}
