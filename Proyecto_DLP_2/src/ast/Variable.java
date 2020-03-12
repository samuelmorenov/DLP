/**
 * @generated VGen (for ANTLR) 1.7.0
 */

package ast;

import org.antlr.v4.runtime.*;

import visitor.*;

//	variable:definicion -> nombre:String  tipo:tipo  ambito:Ambito

public class Variable extends AbstractDefinicion {

	public Variable(String nombre, Tipo tipo, Ambito ambito) {
		this.nombre = nombre;
		this.tipo = tipo;
		this.ambito = ambito;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(tipo);
	}

	public Variable(Object nombre, Object tipo, Object ambito) {
		this.nombre = (nombre instanceof Token) ? ((Token)nombre).getText() : (String) nombre;
		this.tipo = (Tipo) getAST(tipo);
		this.ambito = (Ambito) ambito;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(nombre, tipo, ambito);
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

	public Ambito getAmbito() {
		return ambito;
	}
	public void setAmbito(Ambito ambito) {
		this.ambito = ambito;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private String nombre;
	private Tipo tipo;
	private Ambito ambito;

	public String toString() {
       return "{nombre:" + getNombre() + ", tipo:" + getTipo() + ", ambito:" + getAmbito() + "}";
   }
}
