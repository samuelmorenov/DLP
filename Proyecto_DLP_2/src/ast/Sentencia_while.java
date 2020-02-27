/**
 * @generated VGen (for ANTLR) 1.7.0
 */

package ast;

import java.util.*;
import org.antlr.v4.runtime.*;

import visitor.*;

//	sentencia_while:sentencia -> condicion:expr  sentencias:sentencia*

public class Sentencia_while extends AbstractSentencia {

	public Sentencia_while(Expr condicion, List<Sentencia> sentencias) {
		this.condicion = condicion;
		this.sentencias = sentencias;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(condicion, sentencias);
	}

	public Sentencia_while(Object condicion, Object sentencias) {
		this.condicion = (Expr) getAST(condicion);
		this.sentencias = this.<Sentencia>getAstFromContexts(sentencias);

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(condicion, sentencias);
	}

	public Expr getCondicion() {
		return condicion;
	}
	public void setCondicion(Expr condicion) {
		this.condicion = condicion;
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

	private Expr condicion;
	private List<Sentencia> sentencias;

	public String toString() {
       return "{condicion:" + getCondicion() + ", sentencias:" + getSentencias() + "}";
   }
}
