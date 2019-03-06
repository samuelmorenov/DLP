//package myVisitors;
//
//import ast.*;
//import visitor.DefaultVisitor;
//
///*
//Plantilla para Visitors.
//Para crear un nuevo Visitor cortar y pegar este codigo y ya se tendra un visitor que compila y
//que al ejecutarlo recorrera todo el arbol (sin hacer nada aun en el).
//Solo quedara añadir a cada metodo visit aquello adicional que se quiera realizar sobre su nodo del AST.
//*/
//
//public class MyPrintVisitor_V1 extends DefaultVisitor {
//
//	// ---------------------------------------------------------
//	// Tareas a realizar en cada metodo visit:
//	//
//	// Si en algun metodo visit NO SE QUIERE HACER NADA mas que recorrer los hijos entonces se puede
//	// borrar (dicho metodo se heredara de DefaultVisitor con el codigo de recorrido).
//	//
//	// Lo siguiente es para cuando se quiera AÑADIR alguna funcionalidad adicional a un visit:
//	//
//	// - El codigo que aparece en cada metodo visit es aquel que recorre los hijos. Es el mismo codigo
//	//		que esta implementado en el padre (DefaultVisitor). Por tanto la llamada a 'super.visit' y el
//	//		resto del codigo del metodo hacen lo mismo (por ello 'super.visit' esta comentado).
//	//
//	// - Lo HABITUAL sera borrar todo el codigo de recorrido dejando solo la llamada a 'super.visit'. De esta
//	//		manera, cada metodo visit se puede centrar en la tarea que tiene que realizar sobre su nodo del AST
//    //      (dejando que el padre se encargue del recorrido de los hijos).
//	//
//	// - La razon de que aparezca el codigo de recorrido de los hijos es por si se necesita realizar alguna
//	//		tarea DURANTE el mismo (por ejemplo ir comprobando su tipo). En este caso, ya se tiene implementado
//	//		dicho recorrido y solo habra que incrustar las acciones adicionales en el mismo. En este caso,
//	//		es la llamada a 'super.visit' la que debera ser borrada.
//	// ---------------------------------------------------------
//
//	//	class Program { List<Bloque> bloque; }
//	public Object visit(Program node, Object param) {
//
//		// super.visit(node, param);
//
//		if (node.getBloque() != null)
//			for (Bloque child : node.getBloque())
//				child.accept(this, param);
//
//		return null;
//	}
//
////	//	class Definicion_1 { String nombre;  List<Entero> entero;  Tipo tipo; }
////	public Object visit(Definicion_1 node, Object param) {
////		// super.visit(node, param);
////		System.out.print("var: "+node.getNombre() );
////		if (node.getTamanio_vector() != null)
////			for (Tamanio_vector child : node.getTamanio_vector())
////				child.accept(this, param);
////
////		if (node.getTipo() != null)
////			node.getTipo().accept(this, param);
////		System.out.print(":");
////
////		return null;
////	}
//
//	//	class Entero { int numero; }
//	public Object visit(Tamanio_vector node, Object param) {
//		System.out.print("["+node.getNumero()+"]");
//		return null;
//	}
//
//	//	class TipoInt {  }
//	public Object visit(TipoInt node, Object param) {
//		System.out.print("int");
//		return null;
//	}
//
//	//	class TipoFloat {  }
//	public Object visit(TipoFloat node, Object param) {
//		System.out.print("float");
//		return null;
//	}
//
//	//	class TipoChar {  }
//	public Object visit(TipoChar node, Object param) {
//		System.out.print("char");
//		return null;
//	}
//
//	//	class TipoVar { String string; }
//	public Object visit(TipoVar node, Object param) {
//		System.out.print(node.getString());
//		return null;
//	}
//
//	//	class Struct { String nombre;  List<Definicion_2> definicion_2; }
//	public Object visit(Struct node, Object param) {
//		System.out.println("struct "+node.getNombre()+" {");
//		super.visit(node, param);
//		System.out.println("};");
//		return null;
//	}
//
//	//	class Definicion_2 { String nombre;  List<Entero> entero;  Tipo tipo; }
////	public Object visit(Definicion_2 node, Object param) {
////
////		// super.visit(node, param);
////		System.out.print(node.getNombre() );
////		if (node.getTamanio_vector() != null)
////			for (Tamanio_vector child : node.getTamanio_vector())
////				child.accept(this, param);
////
////		if (node.getTipo() != null)
////			node.getTipo().accept(this, param);
////		System.out.print(":");
////
////		return null;
////	}
//
//	//	class Funcion { String nombre;  List<Parametro> parametros;  List<Tipo> retorno;  List<Sentencia> sentencia; }
//	// IDENT '(' parametros ')' retorno '{' sentencias '}' 
//	public Object visit(Funcion node, Object param) {
//
//		// super.visit(node, param);
//		System.out.print(node.getNombre()+"(");
//		if (node.getParametros() != null)
//			for (Parametro child : node.getParametros())
//				child.accept(this, param);
//		System.out.print(")");
//		if (node.getRetorno() != null)
//			for (Tipo child : node.getRetorno())
//				child.accept(this, param);
//		System.out.println("{");
//		if (node.getSentencia() != null)
//			for (Sentencia child : node.getSentencia()) {
//				System.out.print("   ");
//				child.accept(this, param);
//			}
//		System.out.println("}");
//		return null;
//	}
//
//	//	class Parametro { String nombre;  Tipo tipo; }
//	// IDENT ':' tipo 	{ $ast = new Parametro($IDENT, $tipo.ast); }
//	public Object visit(Parametro node, Object param) {
//
//		// super.visit(node, param);
//		System.out.print(node.getNombre()+ ":");
//		if (node.getTipo() != null)
//			node.getTipo().accept(this, param);
//		System.out.println();
//		return null;
//	}
//
//	//	class Definicion_3 { String nombre;  List<Tamanio_vector> tamanio_vector;  Tipo tipo; }
////	public Object visit(Definicion_3 node, Object param) {
////
////		// super.visit(node, param);
////		System.out.print("var: "+node.getNombre() );
////		if (node.getTamanio_vector() != null)
////			for (Tamanio_vector child : node.getTamanio_vector())
////				child.accept(this, param);
////
////		if (node.getTipo() != null)
////			node.getTipo().accept(this, param);
////		System.out.print(":");
////
////		return null;
////	}
//	
//	
//	//	class Sentencia_asignacion { Expr izquierda;  Expr derecha; }
//	public Object visit(Sentencia_asignacion node, Object param) {
//		//TODO
//		// super.visit(node, param);
//
//		if (node.getIzquierda() != null)
//			node.getIzquierda().accept(this, param);
//
//		if (node.getDerecha() != null)
//			node.getDerecha().accept(this, param);
//
//		return null;
//	}
//
//	//	class Sentencia_print { Expr expresiones; }
//	public Object visit(Sentencia_print node, Object param) {
//		//TODO
//		// super.visit(node, param);
//
//		if (node.getExpresiones() != null)
//			node.getExpresiones().accept(this, param);
//
//		return null;
//	}
//
//	//	class Sentencia_printlnVacia {  }
//	public Object visit(Sentencia_printlnVacia node, Object param) {
//		//TODO
//		return null;
//	}
//
//	//	class Sentencia_read { Expr expresiones; }
//	public Object visit(Sentencia_read node, Object param) {
//		//TODO
//		// super.visit(node, param);
//
//		if (node.getExpresiones() != null)
//			node.getExpresiones().accept(this, param);
//
//		return null;
//	}
//
//	//	class Sentencia_if { Expr condicion;  List<Sentencia> sentencias; }
//	public Object visit(Sentencia_if node, Object param) {
//		//TODO
//		// super.visit(node, param);
//
//		if (node.getCondicion() != null)
//			node.getCondicion().accept(this, param);
//
//		if (node.getSentencias() != null)
//			for (Sentencia child : node.getSentencias())
//				child.accept(this, param);
//
//		return null;
//	}
//
//	//	class Sentencia_ifelse { Expr condicion;  List<Sentencia> sentencias;  List<Sentencia> sino; }
//	public Object visit(Sentencia_ifelse node, Object param) {
//		//TODO
//		// super.visit(node, param);
//
//		if (node.getCondicion() != null)
//			node.getCondicion().accept(this, param);
//
//		if (node.getSentencias() != null)
//			for (Sentencia child : node.getSentencias())
//				child.accept(this, param);
//
//		if (node.getSino() != null)
//			for (Sentencia child : node.getSino())
//				child.accept(this, param);
//
//		return null;
//	}
//
//	//	class Sentencia_while { Expr condicion;  List<Sentencia> sentencias; }
//	public Object visit(Sentencia_while node, Object param) {
//		//TODO
//		// super.visit(node, param);
//
//		if (node.getCondicion() != null)
//			node.getCondicion().accept(this, param);
//
//		if (node.getSentencias() != null)
//			for (Sentencia child : node.getSentencias())
//				child.accept(this, param);
//
//		return null;
//	}
//
//	//	class Sentencia_return { Expr expresion; }
//	public Object visit(Sentencia_return node, Object param) {
//		//TODO
//		// super.visit(node, param);
//
//		if (node.getExpresion() != null)
//			node.getExpresion().accept(this, param);
//
//		return null;
//	}
//
//	//	class Sentencia_returnVacia {  }
//	public Object visit(Sentencia_returnVacia node, Object param) {
//		//TODO
//		return null;
//	}
//
//	//	class Sentencia_expresion { Expr expresion; }
//	public Object visit(Sentencia_expresion node, Object param) {
//		//TODO
//		// super.visit(node, param);
//
//		if (node.getExpresion() != null)
//			node.getExpresion().accept(this, param);
//
//		return null;
//	}
//
//	//	class Expr_int { String string; }
//	public Object visit(Expr_int node, Object param) {
//		//TODO
//		return null;
//	}
//
//	//	class Expr_real { String string; }
//	public Object visit(Expr_real node, Object param) {
//		//TODO
//		return null;
//	}
//
//	//	class Expr_char { String string; }
//	public Object visit(Expr_char node, Object param) {
//		//TODO
//		return null;
//	}
//
//	//	class Expr_ident { String string; }
//	public Object visit(Expr_ident node, Object param) {
//		//TODO
//		return null;
//	}
//
//	//	class Expr_binaria { Expr izquierda;  Operador operador;  Expr derecha; }
//	public Object visit(Expr_binaria node, Object param) {
//		//TODO
//		// super.visit(node, param);
//
//		if (node.getIzquierda() != null)
//			node.getIzquierda().accept(this, param);
//
//		if (node.getOperador() != null)
//			node.getOperador().accept(this, param);
//
//		if (node.getDerecha() != null)
//			node.getDerecha().accept(this, param);
//
//		return null;
//	}
//
//	//	class Expr_vector { Expr fuera;  Expr dentro; }
//	public Object visit(Expr_vector node, Object param) {
//		//TODO
//		// super.visit(node, param);
//
//		if (node.getFuera() != null)
//			node.getFuera().accept(this, param);
//
//		if (node.getDentro() != null)
//			node.getDentro().accept(this, param);
//
//		return null;
//	}
//
//	//	class Expr_punto { Expr izquierda;  Expr derecha; }
//	public Object visit(Expr_punto node, Object param) {
//		//TODO
//		// super.visit(node, param);
//
//		if (node.getIzquierda() != null)
//			node.getIzquierda().accept(this, param);
//
//		if (node.getDerecha() != null)
//			node.getDerecha().accept(this, param);
//
//		return null;
//	}
//
//	//	class Expr_parentesis { Expr expr; }
//	public Object visit(Expr_parentesis node, Object param) {
//		//TODO
//		// super.visit(node, param);
//
//		if (node.getExpr() != null)
//			node.getExpr().accept(this, param);
//
//		return null;
//	}
//
//	//	class Expr_cast { Tipo tipo;  Expr expr; }
//	public Object visit(Expr_cast node, Object param) {
//		//TODO
//		// super.visit(node, param);
//
//		if (node.getTipo() != null)
//			node.getTipo().accept(this, param);
//
//		if (node.getExpr() != null)
//			node.getExpr().accept(this, param);
//
//		return null;
//	}
//
//	//	class Expr_llamada { String nombre;  List<Expr> parametros; }
//	public Object visit(Expr_llamada node, Object param) {
//		//TODO
//		// super.visit(node, param);
//
//		if (node.getParametros() != null)
//			for (Expr child : node.getParametros())
//				child.accept(this, param);
//
//		return null;
//	}
//
//	//	class Operador { String operador; }
//	public Object visit(Operador node, Object param) {
//		//TODO
//		return null;
//	}
//}
