package codegeneration;

import ast.*;
import visitor.*;

/**
 * Clase encargada de asignar direcciones a las variables.
 */
public class MemoryAllocation extends DefaultVisitor {

	public Object visit(Program node, Object param) {

		int direccionGlobales = 0;

		for (Bloque child : node.getBloque()) {

			if (child instanceof Definicion_variable_global) {
				Definicion_variable_global vg = (Definicion_variable_global) child;
				vg.setAddress(direccionGlobales);
				direccionGlobales += vg.getTipo().getSize();
			}
			

		}

		super.visit(node, param);
		
		for (Bloque child : node.getBloque()) {

			if (child instanceof Struct) {
				TipoStruct aux = new TipoStruct("aux") ;
				Struct st = (Struct) child;
				aux.setDefinicion(st);
				aux.getSize();
			}
			

		}
		
		return null;
	}

	// class Funcion { String nombre; List<Parametro> parametros; Tipo retorno;
	// List<Definicion_variable_local> locales; List<Sentencia> sentencias; }
	public Object visit(Funcion node, Object param) {

		int direccionLocales = 0;
		int direccionParametros = 4;

		// f(a:int, b:float, h:char) { // a = BP+9, b = BP+5, h = BP+4
		if (node.getParametros() != null) {
			for (int i = node.getParametros().size()-1; i >= 0; i--) {
				Parametro child = node.getParametros().get(i);
				child.setAddress(direccionParametros);
				direccionParametros = direccionParametros + child.getTipo().getSize();
			}
		}
		// var c:char; // BP-1
		// var d:int; // BP-3
		// var e:[2]Persona; // BP-63
		// var f:float; // BP-67
		if (node.getLocales() != null) {
			for (Definicion_variable_local child : node.getLocales()) {
				direccionLocales = direccionLocales - child.getTipo().getSize();
				child.setAddress(direccionLocales);
			}
		}

		return null;
	}
}