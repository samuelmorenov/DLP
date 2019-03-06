/**
 * @generated VGen (for ANTLR) 1.4.0
 */

package ast;

import java.util.*;
import visitor.*;

import org.antlr.v4.runtime.*;

//	definicion_2 -> nombre:String  tamanio_vector:tamanio_vector*  tipo:tipo

public class Definicion_2 extends AbstractAST  {

	public Definicion_2(String nombre, List<Tamanio_vector> tamanio_vector, Tipo tipo) {
		this.nombre = nombre;
		this.tamanio_vector = tamanio_vector;
		this.tipo = tipo;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(tamanio_vector, tipo);
	}

	@SuppressWarnings("unchecked")
	public Definicion_2(Object nombre, Object tamanio_vector, Object tipo) {
		this.nombre = (nombre instanceof Token) ? ((Token)nombre).getText() : (String) nombre;
		this.tamanio_vector = (List<Tamanio_vector>) tamanio_vector;
		this.tipo = (Tipo) ((tipo instanceof ParserRuleContext) ? getAST(tipo) : tipo);

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(nombre, tamanio_vector, tipo);
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Tamanio_vector> getTamanio_vector() {
		return tamanio_vector;
	}
	public void setTamanio_vector(List<Tamanio_vector> tamanio_vector) {
		this.tamanio_vector = tamanio_vector;
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
	private List<Tamanio_vector> tamanio_vector;
	private Tipo tipo;

	public String toString() {
       return "{nombre:" + getNombre() + ", tamanio_vector:" + getTamanio_vector() + ", tipo:" + getTipo() + "}";
   }
}
