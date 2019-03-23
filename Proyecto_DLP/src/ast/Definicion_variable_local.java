/**
 * @generated VGen (for ANTLR) 1.4.0
 */

package ast;

import visitor.*;

import org.antlr.v4.runtime.*;

//	definicion_variable_local -> nombre:String  tipo:tipo

public class Definicion_variable_local extends AbstractAST  {

	public Definicion_variable_local(String nombre, Tipo tipo) {
		this.nombre = nombre;
		this.tipo = tipo;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(tipo);
	}

	public Definicion_variable_local(Object nombre, Object tipo) {
		this.nombre = (nombre instanceof Token) ? ((Token)nombre).getText() : (String) nombre;
		this.tipo = (Tipo) ((tipo instanceof ParserRuleContext) ? getAST(tipo) : tipo);

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

	public Definicion_variable_local getDefinicion() {
		return definicion;
	}

	public void setDefinicion(Definicion_variable_local definicion) {
		this.definicion = definicion;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private String nombre;
	private Tipo tipo;
	private Definicion_variable_local definicion;

	public String toString() {
       return "{nombre:" + getNombre() + ", tipo:" + getTipo() + "}";
   }


}
