/**
 * @generated VGen (for ANTLR) 1.4.0
 */

package ast;

import visitor.*;

import org.antlr.v4.runtime.*;

//	tipoVar:tipo -> string:String

public class TipoVar extends AbstractTipo {

	public TipoVar(String string) {
		this.string = string;
	}

	public TipoVar(Object string) {
		this.string = (string instanceof Token) ? ((Token) string).getText() : (String) string;

		// Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
		// Obtiene la linea/columna a partir de las de los hijos.
		setPositions(string);
	}

	public String getString() {
		return string;
	}

	public void setString(String string) {
		this.string = string;
	}

	public Struct getDefinicion() {
		return definicion;
	}

	public void setDefinicion(Struct definicion) {
		this.definicion = definicion;
	}

	@Override
	public Object accept(Visitor v, Object param) {
		return v.visit(this, param);
	}

	@Override
	public int getSize() {
		this.calcularSize();
		return this.size;
	}

	private void calcularSize() {
		if (this.size == -1) {
			this.size = 0;
			for (int i = 0; i < definicion.getDefinicion_campo_struct().size(); i++) {
				Definicion_campo_struct def = this.definicion.getDefinicion_campo_struct().get(i);
				def.setAddress(this.size);
				this.size += def.getTipo().getSize();
				System.out.println(this.size + " " + def.getNombre());
			}
		}

	}

	private String string;
	private Struct definicion;
	private int size = -1;

	public String toString() {
		return "{string:" + getString() + "}";
	}

}
