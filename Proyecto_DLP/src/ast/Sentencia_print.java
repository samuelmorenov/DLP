/**
 * @generated VGen (for ANTLR) 1.4.0
 */

package ast;

import visitor.*;

import org.antlr.v4.runtime.*;

//	sentencia_print:sentencia -> expresiones:expr  fincadena:String

public class Sentencia_print extends AbstractSentencia {

	public Sentencia_print(Expr expresiones, String fincadena) {
		this.expresiones = expresiones;
		this.fincadena = fincadena;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(expresiones);
	}

	public Sentencia_print(Object expresiones, Object fincadena) {
		this.expresiones = (Expr) ((expresiones instanceof ParserRuleContext) ? getAST(expresiones) : expresiones);
		this.fincadena = (fincadena instanceof Token) ? ((Token)fincadena).getText() : (String) fincadena;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(expresiones, fincadena);
	}

	public Expr getExpresiones() {
		return expresiones;
	}
	public void setExpresiones(Expr expresiones) {
		this.expresiones = expresiones;
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

	private Expr expresiones;
	private String fincadena;

	public String toString() {
       return "{expresiones:" + getExpresiones() + ", fincadena:" + getFincadena() + "}";
   }
}
