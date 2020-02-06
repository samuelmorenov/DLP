/**
 * @generated VGen (for ANTLR) 1.4.0
 */

package ast;

import visitor.*;

//import org.antlr.v4.runtime.*;

//	tipoChar:tipo -> 

public class TipoChar extends AbstractTipo {

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}
	
	public int getSize() {
		return 1;
	}


	public String toString() {
       return "{TipoChar}";
   }

	@Override
	public char getSuffix() {
        return 'b'; // Añadido suffix b
	}
}
