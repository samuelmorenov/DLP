/**
 * @generated VGen (for ANTLR) 1.7.0
 */

package ast;

import org.antlr.v4.runtime.*;

import visitor.*;

//	sentencia_print_vacia:sentencia -> fincadena:String

public class Sentencia_print_vacia extends AbstractSentencia {

	public Sentencia_print_vacia(String fincadena) {
		this.fincadena = fincadena;
	}

	public Sentencia_print_vacia(Object fincadena) {
		this.fincadena = (fincadena instanceof Token) ? ((Token)fincadena).getText() : (String) fincadena;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(fincadena);
	}

	public String getFincadena() {
		return fincadena;
	}
	public void setFincadena(String fincadena) {
		this.fincadena = fincadena;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private String fincadena;

	public String toString() {
       return "{fincadena:" + getFincadena() + "}";
   }
}
