/**
 * @generated VGen (for ANTLR) 1.4.0
 */

package ast;

import visitor.*;

import org.antlr.v4.runtime.*;

//	tipoArray:tipo -> tamanio:String  tipo:tipo

public class TipoArray extends AbstractTipo {

	public TipoArray(String tamanio, Tipo tipo) {
		this.tamanio = tamanio;
		this.tipoElementos = tipo;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(tipo);
	}

	public TipoArray(Object tamanio, Object tipo) {
		this.tamanio = (tamanio instanceof Token) ? ((Token)tamanio).getText() : (String) tamanio;
		this.tipoElementos = (Tipo) ((tipo instanceof ParserRuleContext) ? getAST(tipo) : tipo);

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(tamanio, tipo);
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
	public void setTipoElementos(Tipo tipo) {
		this.tipoElementos = tipo;
	}
	public int getSize() {
		return this.tipoElementos.getSize() * Integer.parseInt(this.tamanio); //TODO Añadido ??
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private String tamanio;
	private Tipo tipoElementos;

	public String toString() {
       return "{tamanio:" + getTamanio() + ", tipo:" + getTipoElementos() + "}";
   }
}