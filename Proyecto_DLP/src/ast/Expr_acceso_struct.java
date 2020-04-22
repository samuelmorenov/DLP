/**
 * @generated VGen (for ANTLR) 1.7.0
 */

package ast;

import org.antlr.v4.runtime.*;

import visitor.*;

//	expr_acceso_struct:expr -> struct:expr  campo:String

public class Expr_acceso_struct extends AbstractExpr {

	public Expr_acceso_struct(Expr struct, String campo) {
		this.struct = struct;
		this.campo = campo;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(struct);
	}

	public Expr_acceso_struct(Object struct, Object campo) {
		this.struct = (Expr) getAST(struct);
		this.campo = (campo instanceof Token) ? ((Token)campo).getText() : (String) campo;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(struct, campo);
	}

	public Expr getStruct() {
		return struct;
	}
	public void setStruct(Expr struct) {
		this.struct = struct;
	}

	public String getCampo() {
		return campo;
	}
	public void setCampo(String campo) {
		this.campo = campo;
	}
	
	// TODO esta es la mejor manera?
	public Campo_struct getCampo_struct() {
		Definicion_struct def = ((Tipo_Struct) struct.getTipo()).getDefinicion();
		Campo_struct campoAux = null;
		for (Campo_struct cs : def.getCampo_struct()) {
			if (cs.getNombre().equals(campo)) {
				campoAux = cs;
			}
		}
		return campoAux;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private Expr struct;
	private String campo;

	public String toString() {
       return "{struct:" + getStruct() + ", campo:" + getCampo() + "}";
   }
}
