/**
 * @generated VGen (for ANTLR) 1.7.0
 */

package ast;

import visitor.*;

//	tipo_Float:tipo -> 

public class Tipo_Float extends AbstractTipo {
	
	public int getSize() {
		return 4;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}


	public String toString() {
       return "{Tipo_Float}";
   }
}
