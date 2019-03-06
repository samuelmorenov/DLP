/**
 * @generated VGen (for ANTLR) 1.4.0
 */

package ast;

import java.util.*;
import visitor.*;

import org.antlr.v4.runtime.*;

//	sentencia_while:sentencia -> condicion:expr  sentencias:sentencia*

public class Sentencia_while extends AbstractSentencia {

	public Sentencia_while(Expr condicion, List<Sentencia> sentencias) {
		this.condicion = condicion;
		this.sentencias = sentencias;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(condicion, sentencias);
	}

	@SuppressWarnings("unchecked")
	public Sentencia_while(Object condicion, Object sentencias) {
		this.condicion = (Expr) ((condicion instanceof ParserRuleContext) ? getAST(condicion) : condicion);
		this.sentencias = (List<Sentencia>) sentencias;

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
