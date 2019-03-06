/**
 * @generated VGen (for ANTLR) 1.4.0
 */

package ast;

import java.util.*;
import visitor.*;

import org.antlr.v4.runtime.*;

//	variable:bloque -> nombre:String  entero:entero*  tipo:tipo

public class Variable extends AbstractBloque {

	public Variable(String nombre, List<Entero> entero, Tipo tipo) {
		this.nombre = nombre;
		this.entero = entero;
		this.tipo = tipo;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(entero, tipo);
	}

	@SuppressWarnings("unchecked")
	public Variable(Object nombre, Object entero, Object tipo) {
		this.nombre = (nombre instanceof Token) ? ((Token)nombre).getText() : (String) nombre;
		this.entero = (List<Entero>) entero;
		this.tipo = (Tipo) ((tipo instanceof ParserRuleContext) ? getAST(tipo) : tipo);

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(nombre, entero, tipo);
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Entero> getEntero() {
		return entero;
	}
	public void setEntero(List<Entero> entero) {
		this.entero = entero;
	}

	public Tipo getTipo() {
		return tipo;
	}
	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private String nombre;
	private List<Entero> entero;
	private Tipo tipo;

	public String toString() {
       return "{nombre:" + getNombre() + ", entero:" + getEntero() + ", tipo:" + getTipo() + "}";
   }
}
