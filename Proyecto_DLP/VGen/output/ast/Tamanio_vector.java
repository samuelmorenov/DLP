/**
 * @generated VGen (for ANTLR) 1.4.0
 */

package ast;

import visitor.*;

import org.antlr.v4.runtime.*;

//	tamanio_vector -> numero:int

public class Tamanio_vector extends AbstractAST  {

	public Tamanio_vector(int numero) {
		this.numero = numero;
	}

	public Tamanio_vector(Object numero) {
		this.numero = (numero instanceof Token) ? Integer.parseInt(((Token)numero).getText()) : (Integer) numero;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(numero);
	}

	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private int numero;

	public String toString() {
       return "{numero:" + getNumero() + "}";
   }
}
