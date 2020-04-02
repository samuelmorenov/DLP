package myVisitors;

import ast.*;
import visitor.DefaultVisitor;

public class PrintMemoryAllocation extends DefaultVisitor {

	public Object visit(Program node, Object param) {
		System.out.println();
		System.out.println("--------Asignacion de memoria--------");
		System.out.println();
		super.visit(node, param);
		System.out.println("-------------------------------------");
		return null;
	}

	public Object visit(Definicion_struct node, Object param) {
		System.out.println("Struct: " + node.getNombre() + " {");
		super.visit(node, param);
		System.out.println("}");
		return null;
	}

	public Object visit(Campo_struct node, Object param) {
		System.out.println("\tCampo: " + node.getNombre() + " // Dir: " + node.getAddress());
		super.visit(node, param);
		return null;
	}

	public Object visit(Definicion_variable node, Object param) {
		if (node.getAmbito() == Ambito.GLOBAL) {
			System.out.println("var: " + node.getNombre() + " // Dir: " + node.getAddress());
		}

		if (node.getAmbito() == Ambito.LOCAL) {
			int address = node.getAddress();
			if (address < 0) {
				System.out.println("var: " + node.getNombre() + " // BP" + address);
			} else {
				System.out.println(node.getNombre() + " // BP+" + address);
			}
		}
		super.visit(node, param);
		return null;
	}

	public Object visit(Definicion_funcion node, Object param) {
		System.out.println("Funcion: " + node.getNombre() + " (");

		if (node.getParametros() != null)
			for (Definicion_variable child : node.getParametros()) {
				System.out.print("\t");
				child.accept(this, param);
			}
		System.out.println("\t) {");

		if (node.getLocales() != null)
			for (Definicion_variable child : node.getLocales()) {
				System.out.print("\t");
				child.accept(this, param);
			}

		System.out.println("}");

		return null;
	}

}