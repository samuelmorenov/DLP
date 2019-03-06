/**
 * @generated VGen (for ANTLR) 1.4.0
 */

package ast;

import visitor.*;

import org.antlr.v4.runtime.*;

//	sentencia -> cuerpo:String

public class Sentencia extends AbstractAST  {

	public Sentencia(String cuerpo) {
		this.cuerpo = cuerpo;
	}

	public Sentencia(Object cuerpo) {
		this.cuerpo = (cuerpo instanceof Token) ? ((Token)cuerpo).getText() : (String) cuerpo;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(cuerpo);
	}

	public String getCuerpo() {
		return cuerpo;
	}
	public void setCuerpo(String cuerpo) {
		this.cuerpo = cuerpo;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private String cuerpo;

	public String toString() {
       return "{cuerpo:" + getCuerpo() + "}";
   }
}
