package codegeneration;

import ast.*;
import visitor.*;

/**
 * Clase encargada de asignar direcciones a las variables.
 */
public class MemoryAllocation extends DefaultVisitor {

//	public Object visit(Program node, Object param) {
//
//		int currentAddress = 0;
//
//		for (Bloque child : node.getBloque()) {
//
//			if (child instanceof Definicion_variable_global) {
//				Definicion_variable_global vg = (Definicion_variable_global) child;
//				vg.setAddress(currentAddress);
//				currentAddress += vg.getTipo().getSize();
//			}
//		}
//		return null;
//	}
}