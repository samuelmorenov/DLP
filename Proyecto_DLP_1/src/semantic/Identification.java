/**
 * Tutorial de Diseño de Lenguajes de Programación
 * @author Raúl Izquierdo
 */

package semantic;

import java.util.HashMap;
import java.util.Map;

import ast.*;
import main.*;
import visitor.*;

public class Identification extends DefaultVisitor {

	public Identification(ErrorManager errorManager) {
		this.errorManager = errorManager;
	}

	/////////////////// FUNCIONES

	// class Definicion_funcion { String nombre; List<Definicion_variable>
	// parametros; Tipo retorno; List<Definicion_variable> locales; List<Sentencia>
	// sentencias; }
	public Object visit(Definicion_funcion node, Object param) {
		// Predicado: funciones[nombre] == null
		Definicion_funcion definicion = funciones.get(node.getNombre());
		predicado(definicion == null, "Funcion ya definida: " + node.getNombre(), node);

		// Regla Semantica: funciones[nombre] = defFunc
		funciones.put(node.getNombre(), node);

		// Regla Semantica: {
		// variables.set()
		// visit(localesi)
		// visit(sentenciai)
		// variables.reset()
		// }
		variables.set();
		super.visit(node, param);
		variables.reset();

		return null;
	}

	// class Sentencia_llamada_funcion { String nombre; List<Expr> parametros; }
	public Object visit(Sentencia_llamada_funcion node, Object param) {
		// Predicado: funciones[nombre] != null
		Definicion_funcion definicion = funciones.get(node.getNombre());
		predicado(definicion != null, "Procedimiento no definido: " + node.getNombre(), node);
		// Regla Semantica: Sentencia_llamada_funcion.definicion = funciones[nombre]
		node.setDefinicion(definicion);

		super.visit(node, param);
		return null;
	}

	// class Expr_llamada_funcion { String nombre; List<Expr> parametros; }
	public Object visit(Expr_llamada_funcion node, Object param) {
		// Predicado: variables.busca(nombre) != null
		Definicion_funcion definicion = funciones.get(node.getNombre());
		predicado(definicion != null, "Funcion no definida: " + node.getNombre(), node);
		// Regla Semantica: Expr_llamada_funcion.definicion = funciones[nombre]
		node.setDefinicion(definicion);
		super.visit(node, param);
		return null;
	}

	/////////////////// VARIABLES

	// class Definicion_variable { String nombre; Tipo tipo; Ambito ambito; }
	public Object visit(Definicion_variable node, Object param) {

		// Predicado: variables.buscaActual(nombre) == null
		Definicion_variable definicion = variables.getFromTop(node.getNombre());
		predicado(definicion == null, "Variable local ya definida: " + node.getNombre(), node);

		// Regla Semantica: variables[nombre] = defVar
		variables.put(node.getNombre(), node);

		super.visit(node, param);
		return null;
	}

	// class Expr_uso_variable { String string; }
	public Object visit(Expr_uso_variable node, Object param) {
		// Predicado: variables.busca(nombre) != null
		Definicion_variable definicion = variables.getFromAny(node.getString());
		predicado(definicion != null, "Variable no definida: " + node.getString(), node);

		// Regla Semantica: Expr_ident.definicion = variables[nombre]
		node.setDefinicion(definicion);

		return null;
	}

	/////////////////// STRUCT

	// class Definicion_struct { String nombre; List<Campo_struct> campo_struct; }
	public Object visit(Definicion_struct node, Object param) {
		// Predicado: estructuras[nombre] == null
		Definicion_struct definicion = estructuras.get(node.getNombre());
		predicado(definicion == null, "Struct ya definido: " + node.getNombre(), node);

		// Regla Semantica: estructuras[nombre] = definicion
		estructuras.put(node.getNombre(), node);

		// Regla Semantica: {
		// campos_struct.set()
		// visit(campo_structi)
		// campos_struct.reset()
		// }
		campos_struct.set();
		super.visit(node, param);
		campos_struct.reset();

		return null;
	}

	// class Tipo_Struct { String nombre; }
	public Object visit(Tipo_Struct node, Object param) {
		// Predicado: estructuras.busca(nombre) != null
		Definicion_struct definicion = estructuras.get(node.getNombre());
		predicado(definicion != null, "Struct no definido: " + node.getNombre(), node);

		// Regla Semantica: Tipo_Struct.definicion = estructuras[nombre]
		node.setDefinicion(definicion);

		super.visit(node, param);
		return null;
	}

	/////////////////// CAMPOS STRUCT

	// class Campo_struct { String nombre; Tipo tipo; }
	public Object visit(Campo_struct node, Object param) {
		// Predicado: campos_struct[nombre] == null
		Campo_struct definicion = campos_struct.getFromAny(node.getNombre());
		predicado(definicion == null, "Campo ya definido: " + node.getNombre(), node);

		// Regla Semantica: campos_struct[nombre] = definicion
		campos_struct.put(node.getNombre(), node);

		super.visit(node, param);
		return null;
	}

	private void predicado(boolean condition, String errorMessage, Position position) {
		if (!condition)
			errorManager.notify("Identification", errorMessage, position);
	}

	private void predicado(boolean condition, String errorMessage, AST node) {
		predicado(condition, errorMessage, node.getStart());
	}

//	private void predicado(boolean condition, String errorMessage) {
//		predicado(condition, errorMessage, (Position) null);
//	}

	private ErrorManager errorManager;
	private Map<String, Definicion_funcion> funciones = new HashMap<String, Definicion_funcion>();
	private Map<String, Definicion_struct> estructuras = new HashMap<String, Definicion_struct>();
	private ContextMap<String, Campo_struct> campos_struct = new ContextMap<String, Campo_struct>();
	private ContextMap<String, Definicion_variable> variables = new ContextMap<String, Definicion_variable>();
}