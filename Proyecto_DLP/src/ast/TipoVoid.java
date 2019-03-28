package ast;

import visitor.*;

public class TipoVoid extends AbstractTipo {

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	public String toString() {
       return "{TipoVoid}";
   }
}
