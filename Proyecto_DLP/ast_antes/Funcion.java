/**
 * @generated VGen (for ANTLR) 1.4.0
 */

package ast;

import java.util.*;
import visitor.*;

import org.antlr.v4.runtime.*;

//	funcion:bloque -> nombre:String  parametros:parametro*  retorno:tipo*  sentencia:sentencia*

public class Funcion extends AbstractBloque {

	public Funcion(String nombre, List<Parametro> parametros, List<Tipo> retorno, List<Sentencia> sentencia) {
		this.nombre = nombre;
		this.parametros = parametros;
		this.retorno = retorno;
		this.sentencia = sentencia;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(parametros, retorno, sentencia);
	}

	@SuppressWarnings("unchecked")
	public Funcion(Object nombre, Object parametros, Object retorno, Object sentencia) {
		this.nombre = (nombre instanceof Token) ? ((Token)nombre).getText() : (String) nombre;
		this.parametros = (List<Parametro>) parametros;
		this.retorno = (List<Tipo>) retorno;
		this.sentencia = (List<Sentencia>) sentencia;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(nombre, parametros, retorno, sentencia);
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

	public List<Sentencia> getSentencia() {
		return sentencia;
	}
	public void setSentencia(List<Sentencia> sentencia) {
		this.sentencia = sentencia;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private String nombre;
	private List<Parametro> parametros;
	private List<Tipo> retorno;
	private List<Sentencia> sentencia;

	public String toString() {
       return "{nombre:" + getNombre() + ", parametros:" + getParametros() + ", retorno:" + getRetorno() + ", sentencia:" + getSentencia() + "}";
   }
}
