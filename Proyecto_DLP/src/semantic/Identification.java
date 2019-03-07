package semantic;

import java.util.*;

import ast.*;
import main.*;
import visitor.*;

public class Identification extends DefaultVisitor {

	public Identification(ErrorManager errorManager) {
		this.errorManager = errorManager;
	}

	/*
	 * Poner aqui los visit necesarios. Si se ha usado VGen, solo hay que copiarlos
	 * de la clase 'visitor/_PlantillaParaVisitors.txt'.
	 */

	// class Funcion { String nombre; List<Parametro> parametros; List<Tipo>
	// retorno; List<Sentencia> sentencia; }
	public Object visit(Funcion node, Object param) {
		Funcion definicion = funciones.get(node.getNombre());
		predicado(definicion == null, "Funcion ya definida: " + node.getNombre(), node);
		funciones.put(node.getNombre(), node);
		super.visit(node, param);
		return null;
	}

	// class Expr_llamada { String nombre; List<Expr> parametros; }
	public Object visit(Expr_llamada node, Object param) {
		Funcion definicion = funciones.get(node.getNombre());
		predicado(definicion != null, "Funcion no definida: " + node.getNombre(), node);
		node.setDefinicion(definicion); // Enlazar referencia con definicion
		super.visit(node, param);
		return null;
	}

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
}
