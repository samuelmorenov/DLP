/**
 * @generated VGen (for ANTLR) 1.7.0
 */

package ast;

import java.util.*;
import org.antlr.v4.runtime.*;

import visitor.*;

//	sentencia_llamada_funcion:sentencia -> nombre:String  parametros:expr*

public class Sentencia_llamada_funcion extends AbstractSentencia {

	public Sentencia_llamada_funcion(String nombre, List<Expr> parametros) {
		this.nombre = nombre;
		this.parametros = parametros;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(parametros);
	}

	public Sentencia_llamada_funcion(Object nombre, Object parametros) {
		this.nombre = (nombre instanceof Token) ? ((Token)nombre).getText() : (String) nombre;
		this.parametros = this.<Expr>getAstFromContexts(parametros);

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

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private String nombre;
	private List<Expr> parametros;

	public String toString() {
       return "{nombre:" + getNombre() + ", parametros:" + getParametros() + "}";
   }
}
