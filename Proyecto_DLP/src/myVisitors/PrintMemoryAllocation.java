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

	public Object visit(Struct node, Object param) {
		System.out.println("Struct: " + node.getNombre() + " {");
		super.visit(node, param);
		System.out.println("}");
		return null;
	}

	public Object visit(Definicion_campo_struct node, Object param) {
		System.out.println("\tCampo: " + node.getNombre() + " // Dir: " + node.getAddress());
		super.visit(node, param);
		return null;
	}

	public Object visit(Definicion_variable_global node, Object param) {
		System.out.println("var: " + node.getNombre() + " // Dir: " + node.getAddress());
		super.visit(node, param);
		return null;
	}

	public Object visit(Funcion node, Object param) {
		System.out.println("Funcion: " + node.getNombre() + " (");

		if (node.getParametros() != null)
			for (Parametro child : node.getParametros()) {
				System.out.print("\t");
				child.accept(this, param);
			}
		System.out.println("\t) {");

		if (node.getLocales() != null)
			for (Definicion_variable_local child : node.getLocales()) {
				System.out.print("\t");
				child.accept(this, param);
			}

		System.out.println("}");

		return null;
	}

	public Object visit(Parametro node, Object param) {
		System.out.println(node.getNombre() + " // BP+" + node.getAddress());
		super.visit(node, param);
		return null;
	}

	public Object visit(Definicion_variable_local node, Object param) {
		System.out.println("var: " + node.getNombre() + " // BP" + node.getAddress());
		super.visit(node, param);
		return null;
	}

}