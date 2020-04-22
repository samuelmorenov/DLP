/**
 * @generated VGen (for ANTLR) 1.7.0
 */

package ast;

import visitor.*;

//	tipo_Void:tipo -> 

public class Tipo_Void extends AbstractTipo {

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

	@Override
	public Object accept(Visitor v, Object param) {
		return v.visit(this, param);
	}

	public String toString() {
		return "{Tipo_Void}";
	}
}
