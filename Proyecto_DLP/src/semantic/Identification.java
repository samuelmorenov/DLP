package semantic;

import java.util.*;

import ast.*;
import main.*;
import visitor.*;

public class Identification extends DefaultVisitor {

	public Identification(ErrorManager errorManager) {
		this.errorManager = errorManager;
	}

//	/*
//	 * Poner aqui los visit necesarios. Si se ha usado VGen, solo hay que copiarlos
//	 * de la clase 'visitor/_PlantillaParaVisitors.txt'.
//	 */
//
//	// class Funcion { String nombre; List<Parametro> parametros; List<Tipo>
//	// retorno; List<Sentencia> sentencia; }
//	public Object visit(Funcion node, Object param) {
//		Funcion definicion = funciones.get(node.getNombre());
//		predicado(definicion == null, "Funcion ya definida: " + node.getNombre(), node);
//		funciones.put(node.getNombre(), node);
//		
//		
//		parametros.set();
//		variables_locales.set();
//		if (node.getParametros() != null)
//			for (Parametro child : node.getParametros())
//				child.accept(this, param);
//
//		if (node.getRetorno() != null)
//			for (Tipo child : node.getRetorno())
//				child.accept(this, param);
//
//		if (node.getSentencia() != null)
//			for (Sentencia child : node.getSentencia())
//				child.accept(this, param);
//		variables_locales.reset();
//		parametros.reset();
//		
//		
//		return null;
//	}
//
//	// class Expr_llamada { String nombre; List<Expr> parametros; }
//	public Object visit(Expr_llamada_funcion node, Object param) {
//		Funcion definicion = funciones.get(node.getNombre());
//		predicado(definicion != null, "Funcion no definida: " + node.getNombre(), node);
//		node.setDefinicion(definicion); // Enlazar referencia con definicion
//		super.visit(node, param);
//		return null;
//	}
//
//	
//	//	class Struct { String nombre;  List<Definicion_variable_struct> definicion_variable_struct; }
//	public Object visit(Struct node, Object param) {
//		Struct definicion = estructuras.get(node.getNombre());
//		predicado(definicion == null, "Struct ya definido: " + node.getNombre(), node);
//		estructuras.put(node.getNombre(), node);
//
//		campos_struct.set();
//		if (node.getDefinicion_variable_struct() != null)
//			for (Definicion_variable_struct child : node.getDefinicion_variable_struct())
//				child.accept(this, param);
//		campos_struct.reset();
//		
//		
//		return null;
//	}
//	
//	//	class Definicion_variable_struct { String nombre;  Tipo tipo; }
//	public Object visit(Definicion_variable_struct node, Object param) {
//
//		Definicion_variable_struct definicion = campos_struct.getFromAny(node.getNombre());
//		predicado(definicion == null, "Campo ya definido: " + node.getNombre(), node);
//		node.setDefinicion(definicion); // Enlazar referencia con definicion
//		campos_struct.put(node.getNombre(), node);
//		super.visit(node, param);
//		return null;
//	}
//	
//	//	class TipoVar { String string; }
//	public Object visit(TipoVar node, Object param) {
//		Struct definicion = estructuras.get(node.getString());
//		predicado(definicion != null, "Struct no definido: " + node.getString(), node);
//		node.setDefinicion(definicion); // Enlazar referencia con definicion
//		super.visit(node, param);
//		return null;
//	}
//	
//	//	class Parametro { String nombre;  Tipo tipo; }
//	public Object visit(Parametro node, Object param) {
//		Parametro definicion = parametros.getFromAny(node.getNombre());
//		predicado(definicion == null, "Parametro repetido: " + node.getNombre(), node);
//		node.setDefinicion(definicion); // Enlazar referencia con definicion
//		parametros.put(node.getNombre(), node);
//		super.visit(node, param);
//		return null;
//	}
//	
//	//	class Definicion_variable { String nombre;  Tipo tipo; }
//	public Object visit(Definicion_variable node, Object param) {
//		Definicion_variable definicion = variables_globales.getFromAny(node.getNombre());
//		predicado(definicion == null, "Variable ya definida: " + node.getNombre(), node);
//		node.setDefinicion(definicion); // Enlazar referencia con definicion
//		variables_globales.put(node.getNombre(), node);
//		super.visit(node, param);
//		return null;
//	}
//	
//	
//	//	class Definicion_variable_funcion { String nombre;  Tipo tipo; }
//	public Object visit(Definicion_variable_funcion node, Object param) {
//
//		Parametro definicion1 = parametros.getFromAny(node.getNombre());
//		Definicion_variable_funcion definicion2 = variables_locales.getFromAny(node.getNombre());
//		
//		//TODO: revisar que este bien el predicado
//		predicado(definicion1 == null && definicion2 == null, "Variable local ya definida: " + node.getNombre(), node);
//		node.setDefinicion(definicion2); // Enlazar referencia con definicion
//		variables_locales.put(node.getNombre(), node);
//		super.visit(node, param);
//		return null;
//	}
//	
//	//	class Expr_ident { String string; }
//	public Object visit(Expr_ident node, Object param) {
//		Parametro definicion_parametro = parametros.getFromAny(node.getString());
//		Definicion_variable_funcion definicion_local = variables_locales.getFromAny(node.getString());
//		Definicion_variable definicion_global = variables_globales.getFromAny(node.getString());
//		predicado(definicion_parametro != null || definicion_local != null || definicion_global != null, "Variable no definida: " + node.getString(), node);
//		
//		if(definicion_parametro != null) {
//			node.setDefinicion(definicion_parametro);
//			return null;
//		}
//		if(definicion_local != null) {
//			node.setDefinicion(definicion_local);
//			return null;
//		}
//		if(definicion_global != null) {
//			node.setDefinicion(definicion_global);
//			return null;
//		}
//		return null;
//	}

	/**
	 * predicado. Metodo auxiliar para implementar los predicados. Borrar si no se
	 * quiere usar.
	 *
	 * Ejemplos de uso (suponiendo que existe un metodo "esPrimitivo"):
	 *
	 * 1. predicado(esPrimitivo(expr.tipo), "La expresion debe ser de un tipo
	 * pimitivo", expr.getStart()); 2. predicado(esPrimitivo(expr.tipo), "La
	 * expresion debe ser de un tipo pimitivo", expr); 3.
	 * predicado(esPrimitivo(expr.tipo), "La expresion debe ser de un tipo
	 * primitivo");
	 *
	 * NOTA: El metodo getStart() (ejemplo 1) indica la linea/columna del fichero
	 * fuente donde estaba el nodo (y asi poder dar informacion mas detallada de la
	 * posicion del error). Si se usa VGen, dicho metodo habra sido generado en
	 * todos los nodos del AST. No es obligatorio llamar a getStart() (ejemplo 2),
	 * ya que si se pasa el nodo, se usara por defecto dicha posicion. Si no se
	 * quiere imprimir la posicion del fichero, se puede omitir el tercer argumento
	 * (ejemplo 3).
	 *
	 * @param condicion
	 *            Debe cumplirse para que no se produzca un error
	 * @param mensajeError
	 *            Se imprime si no se cumple la condicion
	 * @param posicionError
	 *            Fila y columna del fichero donde se ha producido el error.
	 */
	private void predicado(boolean condicion, String mensajeError, Position posicionError) {
		if (!condicion)
			errorManager.notify("Identificacion", mensajeError, posicionError);
	}

	private void predicado(boolean condicion, String mensajeError, AST node) {
		predicado(condicion, mensajeError, node.getStart());
	}

	private void predicado(boolean condicion, String mensajeError) {
		predicado(condicion, mensajeError, (Position) null);
	}

	private ErrorManager errorManager;
	private Map<String, Funcion> funciones = new HashMap<String, Funcion>();
	private Map<String, Struct> estructuras = new HashMap<String, Struct>();
//	private ContextMap<String, Definicion_variable_struct> campos_struct = new ContextMap<String, Definicion_variable_struct>();
//	private ContextMap<String, Parametro> parametros = new ContextMap<String, Parametro>();
//	private ContextMap<String, Definicion_variable> variables_globales = new ContextMap<String, Definicion_variable>();
//	private ContextMap<String, Definicion_variable_funcion> variables_locales = new ContextMap<String, Definicion_variable_funcion>();

}
