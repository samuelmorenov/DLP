/**
 * @generated VGen (for ANTLR) 1.4.0
 */

package ast;

import visitor.*;

import org.antlr.v4.runtime.*;

//	tipoFloat:tipo -> 

public class TipoFloat extends AbstractTipo {

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	@Override
	public int getSize() {
		return 4; //TODO A�adido
	}

	public String toString() {
       return "{TipoFloat}";
   }
}
