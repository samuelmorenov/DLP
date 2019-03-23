/**
 * @generated VGen (for ANTLR) 1.4.0
 */

package ast;

import java.util.*;
import visitor.*;

import org.antlr.v4.runtime.*;

//	funcion:bloque -> nombre:String  parametros:parametro*  retorno:tipo*  locales:definicion_variable_local*  sentencias:sentencia*

public class Funcion extends AbstractBloque {

	public Funcion(String nombre, List<Parametro> parametros, List<Tipo> retorno, List<Definicion_variable_local> locales, List<Sentencia> sentencias) {
		this.nombre = nombre;
		this.parametros = parametros;
		this.retorno = retorno;
		this.locales = locales;
		this.sentencias = sentencias;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(parametros, retorno, locales, sentencias);
	}

	@SuppressWarnings("unchecked")
	public Funcion(Object nombre, Object parametros, Object retorno, Object locales, Object sentencias) {
		this.nombre = (nombre instanceof Token) ? ((Token)nombre).getText() : (String) nombre;
		this.parametros = (List<Parametro>) parametros;
		this.retorno = (List<Tipo>) retorno;
		this.locales = (List<Definicion_variable_local>) locales;
		this.sentencias = (List<Sentencia>) sentencias;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(nombre, parametros, retorno, locales, sentencias);
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Parametro> getParametros() {
		return parametros;
	}
	public void setParametros(List<Parametro> parametros) {
		this.parametros = parametros;
	}

	public List<Tipo> getRetorno() {
		return retorno;
	}
	public void setRetorno(List<Tipo> retorno) {
		this.retorno = retorno;
	}

	public List<Definicion_variable_local> getLocales() {
		return locales;
	}
	public void setLocales(List<Definicion_variable_local> locales) {
		this.locales = locales;
	}

	public List<Sentencia> getSentencias() {
		return sentencias;
	}
	public void setSentencias(List<Sentencia> sentencias) {
		this.sentencias = sentencias;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private String nombre;
	private List<Parametro> parametros;
	private List<Tipo> retorno;
	private List<Definicion_variable_local> locales;
	private List<Sentencia> sentencias;

	public String toString() {
       return "{nombre:" + getNombre() + ", parametros:" + getParametros() + ", retorno:" + getRetorno() + ", locales:" + getLocales() + ", sentencias:" + getSentencias() + "}";
   }
}
