/**
 * @generated VGen (for ANTLR) 1.4.0
 */

package ast;

import java.util.*;
import visitor.*;

import org.antlr.v4.runtime.*;

//	sentencia_llamada_funcion:sentencia -> nombre:String  parametros:expr*

public class Sentencia_llamada_funcion extends AbstractSentencia {

	public Sentencia_llamada_funcion(String nombre, List<Expr> parametros) {
		this.nombre = nombre;
		this.parametros = parametros;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(parametros);
	}

	@SuppressWarnings("unchecked")
	public Sentencia_llamada_funcion(Object nombre, Object parametros) {
		this.nombre = (nombre instanceof Token) ? ((Token)nombre).getText() : (String) nombre;
		this.parametros = (List<Expr>) parametros;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(nombre, parametros);
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Expr> getParametros() {
		return parametros;
	}
	public void setParametros(List<Expr> parametros) {
		this.parametros = parametros;
	}
	

	public Funcion getDefinicion() {
		return definicion;
	}

	public void setDefinicion(Funcion definicion) {
		this.definicion = definicion;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private String nombre;
	private List<Expr> parametros;
	private Funcion definicion;

	public String toString() {
       return "{nombre:" + getNombre() + ", parametros:" + getParametros() + "}";
   }

}
