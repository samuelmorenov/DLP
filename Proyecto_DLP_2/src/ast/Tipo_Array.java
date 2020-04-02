/**
 * @generated VGen (for ANTLR) 1.7.0
 */

package ast;

import org.antlr.v4.runtime.*;

import visitor.*;

//	tipo_Array:tipo -> tamanio:String  tipoElementos:tipo

public class Tipo_Array extends AbstractTipo {

	public Tipo_Array(String tamanio, Tipo tipoElementos) {
		this.tamanio = tamanio;
		this.tipoElementos = tipoElementos;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(tipoElementos);
	}

	public Tipo_Array(Object tamanio, Object tipoElementos) {
		this.tamanio = (tamanio instanceof Token) ? ((Token)tamanio).getText() : (String) tamanio;
		this.tipoElementos = (Tipo) getAST(tipoElementos);

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(tamanio, tipoElementos);
	}

	public String getTamanio() {
		return tamanio;
	}
	public void setTamanio(String tamanio) {
		this.tamanio = tamanio;
	}

	public Tipo getTipoElementos() {
		return tipoElementos;
	}
	public void setTipoElementos(Tipo tipoElementos) {
		this.tipoElementos = tipoElementos;
	}
	
	@Override
	public int getSize() {
		return this.tipoElementos.getSize() * Integer.parseInt(this.tamanio);
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private String tamanio;
	private Tipo tipoElementos;

	public String toString() {
       return "{tamanio:" + getTamanio() + ", tipoElementos:" + getTipoElementos() + "}";
   }
}
