/**
 * @generated VGen (for ANTLR) 1.4.0
 */

package ast;

import visitor.*;

import org.antlr.v4.runtime.*;

//	expr_vector:expr -> fuera:expr  dentro:expr

public class Expr_vector extends AbstractExpr {

	public Expr_vector(Expr fuera, Expr dentro) {
		this.fuera = fuera;
		this.dentro = dentro;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(fuera, dentro);
	}

	public Expr_vector(Object fuera, Object dentro) {
		this.fuera = (Expr) ((fuera instanceof ParserRuleContext) ? getAST(fuera) : fuera);
		this.dentro = (Expr) ((dentro instanceof ParserRuleContext) ? getAST(dentro) : dentro);

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(fuera, dentro);
	}

	public Expr getFuera() {
		return fuera;
	}
	public void setFuera(Expr fuera) {
		this.fuera = fuera;
	}

	public Expr getDentro() {
		return dentro;
	}
	public void setDentro(Expr dentro) {
		this.dentro = dentro;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private Expr fuera;
	private Expr dentro;

	public String toString() {
       return "{fuera:" + getFuera() + ", dentro:" + getDentro() + "}";
   }
}
