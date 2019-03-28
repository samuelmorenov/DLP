package codegeneration;

import ast.*;
import visitor.*;

/**
 * Clase encargada de asignar direcciones a las variables.
 */
public class MemoryAllocation extends DefaultVisitor {

	public Object visit(Program node, Object param) {

		int currentAddress = 0;

		for (Bloque child : node.getBloque()) {

			if (child instanceof Definicion_variable_global) {
				Definicion_variable_global vg = (Definicion_variable_global) child;
				vg.setAddress(currentAddress);
				currentAddress += vg.getTipo().getSize();
			}
		}
		return null;
	}
	
	
	
	//	class Program { List<Bloque> bloque; }
	public Object visit(Program node, Object param) {

		// super.visit(node, param);

		if (node.getBloque() != null)
			for (Bloque child : node.getBloque())
				child.accept(this, param);

		return null;
	}
	
	//	class TipoVar { String string; }
	public Object visit(TipoVar node, Object param) {
		return null;
	}
	


}
