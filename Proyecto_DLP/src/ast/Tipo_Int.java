/**
 * @generated VGen (for ANTLR) 1.7.0
 */

package ast;

import visitor.*;

//	tipo_Int:tipo -> 

public class Tipo_Int extends AbstractTipo {
	
	public int getSize() {
		return 2;
	}
	
	@Override
	public char getSuffix() {
        return 'i';
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}


	public String toString() {
       return "{Tipo_Int}";
   }
}
