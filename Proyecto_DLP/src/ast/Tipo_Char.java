/**
 * @generated VGen (for ANTLR) 1.7.0
 */

package ast;

import visitor.*;

//	tipo_Char:tipo -> 

public class Tipo_Char extends AbstractTipo {

	public int getSize() {
		return 1;
	}
	
	@Override
	public char getSuffix() {
        return 'b';
	}

	@Override
	public Object accept(Visitor v, Object param) {
		return v.visit(this, param);
	}
	
	@Override
	public String getMemoryAllocationString() {
		return "char";
	}

	public String toString() {
		return "{Tipo_Char}";
	}
}
