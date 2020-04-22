/**
 * @generated VGen (for ANTLR) 1.7.0
 */

package ast;

import visitor.*;

//	tipo_Error:tipo -> 

public class Tipo_Error extends AbstractTipo {

	@Override
	public Object accept(Visitor v, Object param) {
		return v.visit(this, param);
	}

	@Override
	public int getSize() {
		return 0;
	}

	@Override
	public char getSuffix() {
		return '?';
	}

	@Override
	public String getMemoryAllocationString() {
		return "?";
	}

	public String toString() {
		return "{Tipo_Error}";
	}

}
