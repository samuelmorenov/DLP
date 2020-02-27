/**
 * @generated VGen (for ANTLR) 1.7.0
 */

package ast;

import org.antlr.v4.runtime.*;

import visitor.*;

//	expr_acceso_vector:expr -> fuera:expr  dentro:expr

public class Expr_acceso_vector extends AbstractExpr {

	public Expr_acceso_vector(Expr fuera, Expr dentro) {
		this.fuera = fuera;
		this.dentro = dentro;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(fuera, dentro);
	}

	public Expr_acceso_vector(Object fuera, Object dentro) {
		this.fuera = (Expr) getAST(fuera);
		this.dentro = (Expr) getAST(dentro);

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
