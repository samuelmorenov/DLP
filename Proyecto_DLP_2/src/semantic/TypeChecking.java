/**
 * Tutorial de Diseño de Lenguajes de Programación
 * @author Raúl Izquierdo
 */

package semantic;

import ast.*;
import main.*;
import visitor.*;

public class TypeChecking extends DefaultVisitor {

	public TypeChecking(ErrorManager errorManager) {
		this.errorManager = errorManager;
	}

	// class Definicion_funcion { String nombre; List<Definicion_variable>
	// parametros; Tipo retorno; List<Definicion_variable> locales; List<Sentencia>
	// sentencias; }
	public Object visit(Definicion_funcion node, Object param) {
		/** Predicados */
		// tipoSimple(retorno.tipo)
		// tipoSimple(parametrosi)

		/** Reglas Semanticas */
		// sentenciasi.funcionActual = definicion_funcion

		for (int i = 0; i < node.getSentencias().size(); i++) {
			node.getSentencias().get(i).setFuncionActual(node);
		}

		super.visit(node, param);

		predicado(tipoSimple(node.getRetorno()) || mismoTipo(node.getRetorno(), new Tipo_Void()),
				"Retorno de tipo no simple", node);

		if (node.getParametros() != null) {
			for (Definicion_variable s : node.getParametros()) {
				predicado(tipoSimple(s.getTipo()),
						"Los parametros de una funcion debe ser de tipo primitivo: " + s.getNombre(), node);
			}
		}

		return null;

	}

	// class Sentencia_asignacion { Expr izquierda; Expr derecha; }
	public Object visit(Sentencia_asignacion node, Object param) {
		/** Predicados */
		// mismoTipo(izquierda.tipo, derecha.tipo)
		// tipoSimple(izquierda.tipo)
		// izquierda.modificable == true

		super.visit(node, param);

		predicado(mismoTipo(node.getIzquierda().getTipo(), node.getDerecha().getTipo()),
				"Valores asignados de distinto tipo", node);
		predicado(tipoSimple(node.getIzquierda().getTipo()), "Valor de la izquierda debe ser simple", node);
		predicado(node.getIzquierda().isModificable() == true, "Valor de la izquierda no modificable", node);

		return null;
	}

	// class Sentencia_print { Expr expresiones; String fincadena; }
	public Object visit(Sentencia_print node, Object param) {
		/** Predicados */
		// tipoSimple(expresiones.tipo)

		super.visit(node, param);

		predicado(tipoSimple(node.getExpresiones().getTipo()), "Solo se pueden imprimir tipos simples ", node);

		return null;
	}

	// class Sentencia_read { Expr expresiones; }
	public Object visit(Sentencia_read node, Object param) {
		/** Predicados */
		// tipoSimple(expresiones.tipo)
		// expresiones.modificable==true

		super.visit(node, param);

		predicado(tipoSimple(node.getExpresiones().getTipo()), "Debe ser un tipo simple", node);
		predicado(node.getExpresiones().isModificable() == true, "Debe ser modificable", node);

		return null;
	}

	// class Sentencia_if { Expr condicion; List<Sentencia> sentencias;
	// List<Sentencia> sino; }
	public Object visit(Sentencia_if node, Object param) {
		/** Predicados */
		// condicion.tipo==tipoInt
		/** Reglas Semanticas */
		// Sentenciasi.funcionActual = sentencia_if. funcionActual

		for (int i = 0; i < node.getSentencias().size(); i++) {
			node.getSentencias().get(i).setFuncionActual(node.getFuncionActual());
		}

		super.visit(node, param);

		predicado(mismoTipo(node.getCondicion().getTipo(), new Tipo_Int()), "La condicion debe ser de tipo entero",
				node);
		return null;
	}

	// class Sentencia_while { Expr condicion; List<Sentencia> sentencias; }
	public Object visit(Sentencia_while node, Object param) {
		/** Predicados */
		// condicion.tipo==tipoInt
		/** Reglas Semanticas */
		// Sentenciasi.funcionActual = sentencia_while.funcionActual

		for (int i = 0; i < node.getSentencias().size(); i++) {
			node.getSentencias().get(i).setFuncionActual(node.getFuncionActual());
		}

		super.visit(node, param);

		predicado(mismoTipo(node.getCondicion().getTipo(), new Tipo_Int()), "La condicion debe ser de tipo entero",
				node);

		return null;
	}

	// class Sentencia_llamada_funcion { String nombre; List<Expr> parametros; }
	public Object visit(Sentencia_llamada_funcion node, Object param) {
		/** Predicados */
		// |sentencia_llamada_funcion.parametrosi| ==
		// |sentencia_llamada_funcion.definicion.parametrosi|
		// sentencia_llamada_funcion.parametrosi.tipo ==
		// sentencia_llamada_funcion.definicion.parametrosi.tipo

		super.visit(node, param);

		boolean mismoNumParametros = node.getParametros().size() == node.getFuncionActual().getParametros().size();
		predicado(mismoNumParametros, "Numero de argumentos incorrecto", node);
		if (!mismoNumParametros) {
			return null;
		}

		for (int i = 0; i < node.getParametros().size(); i++) {
			predicado(
					mismoTipo(node.getParametros().get(i).getTipo(),
							node.getFuncionActual().getParametros().get(i).getTipo()),
					"Tipo de los parametros no coincide", node);
		}

		return null;

	}

	// class Sentencia_return { Expr expresion; }
	public Object visit(Sentencia_return node, Object param) {
		/** Predicados */
		// si expresion == null
		// sentencia_return.funcionActual.tipo == tipoVoid
		// sino
		// sentencia_return.funcionActual.tipo == expresion.tipo

		super.visit(node, param);

		if (node.getExpresion() == null) {
			predicado(mismoTipo(node.getFuncionActual().getRetorno(), new Tipo_Void()),
					"Los return deben tener un valor de retorno", node.getFuncionActual());
		} else {
			predicado(mismoTipo(node.getFuncionActual().getRetorno(), node.getExpresion().getTipo()),
					"Tipo de retorno no coincide", node);
		}

		return null;
	}

	// class Expr_int { String string; }
	public Object visit(Expr_int node, Object param) {
		/** Reglas Semanticas */
		// expr_real.tipo = tipoFloat
		// expr_real.modificable=false

		node.setTipo(new Tipo_Float());
		node.setModificable(false);

		return null;
	}

	// class Expr_real { String string; }
	public Object visit(Expr_real node, Object param) {
		/** Reglas Semanticas */
		// expr_int.tipo = tipoInt
		// expr_int.modificable = false

		node.setTipo(new Tipo_Int());
		node.setModificable(false);
		return null;
	}

	// class Expr_char { String string; }
	public Object visit(Expr_char node, Object param) {
		/** Reglas Semanticas */
		// expr_char.tipo=tipoChar
		// expr_chat.modificable=false

		node.setTipo(new Tipo_Char());
		node.setModificable(false);
		return null;
	}

	// class Expr_uso_variable { String string; }
	public Object visit(Expr_uso_variable node, Object param) {
		/** Reglas Semanticas */
		// expr_uso_variable.tipo=expr_ident.definicion.tipo
		// expr_uso_variable.modificable=true

		node.setModificable(true);
		node.setTipo(node.getDefinicion().getTipo());

		return null;
	}

	// class Expr_operacion { Expr izquierda; Operador operador; Expr derecha; }
	public Object visit(Expr_operacion node, Object param) {
		/** Reglas Semanticas */
		// expr_operacion.tipo=izquierda.tipo
		// expr_operacion.modificable=false
		/** Predicados */
		// si(operador es aritmético)
		// tipoSimple(izquierda.tipo)
		// si(operador es booleano)
		// tipoSimple(izquierda.tipo)
		// si(operador es lógico)
		// izquierda.tipo==tipoInt
		// mismoTipo(izquierda, derecha)

		super.visit(node, param);

		node.setTipo(node.getIzquierda().getTipo());
		node.setModificable(false);

		if (node.getOperador() instanceof Operador_aritmetico) {
			predicado(tipoSimple(node.getIzquierda().getTipo()), "Deben ser tipos simples", node);
			// predicado(tipoSimple(node.getDerecha().getTipo()), "Deben ser tipos simples",
			// node);
		}
		if (node.getOperador() instanceof Operador_comparacion) {
			predicado(tipoSimple(node.getIzquierda().getTipo()), "Deben ser tipos simples", node);
			// predicado(tipoSimple(node.getDerecha().getTipo()), "Deben ser tipos simples",
			// node);
			// node.setTipo(new Tipo_Int());
		}
		if (node.getOperador() instanceof Operador_logico) {
			predicado(node.getIzquierda().getTipo().getClass().equals(new Tipo_Int().getClass()), "Deben ser entero",
					node);
			// predicado(node.getDerecha().getTipo().getClass().equals(new
			// Tipo_Int().getClass()), "Deben ser entero", node);
			// node.setTipo(new Tipo_Int());
		}

		predicado(mismoTipo(node.getIzquierda().getTipo(), node.getDerecha().getTipo()),
				"Operacion con distintos tipos ", node);

		return null;
	}

	// class Expr_negada { Operador operador; Expr derecha; }
	public Object visit(Expr_negada node, Object param) {
		/** Reglas Semanticas */
		// expr_binaria.tipo=derecha.tipo
		// expr_binaria.modificable=false
		/** Predicados */
		// derecha.tipo==tipoInt
		super.visit(node, param);
		node.setTipo(node.getDerecha().getTipo());
		node.setModificable(false);
		predicado(node.getDerecha().getTipo().getClass().equals(new Tipo_Int().getClass()), "Deben ser entero", node);
		return null;
	}

	// class Expr_cast { Tipo tipo_convertido; Expr expr; }
	public Object visit(Expr_cast node, Object param) {
		/** Reglas Semanticas */
		// expr_cast.tipo = tipo.tipo
		// expr_cast.modificable=false
		/** Predicados */
		// tipoSimple(expr_cast.tipo_convertido)
		// tipoSimple(expr_cast.expr.tipo)
		// !mismoTipo(expr.tipo_convertido, expr.tipo)

		node.setTipo(node.getTipo_convertido());
		node.setModificable(false);

		super.visit(node, param);

		predicado(tipoSimple(node.getTipo_convertido()), "Se debe convertira a un tipo simple", node);
		predicado(tipoSimple(node.getExpr().getTipo()), "Se debe convertira un tipo simple", node);
		predicado(!mismoTipo(node.getTipo_convertido(), node.getExpr().getTipo()),
				"No se pueden convertir si son del mismo tipo ", node);

		return null;
	}

	// class Expr_acceso_vector { Expr fuera; Expr dentro; }
	public Object visit(Expr_acceso_vector node, Object param) {
		/** Reglas Semanticas */
		// expr_acceso_vector.tipo = vector.definicion.tipo
		// expr_acceso_vector.modificable=true
		/** Predicados */
		// fuera.tipo==tipoArray
		// dentro.tipo==tipoInt

		super.visit(node, param);

		node.setTipo(((Tipo_Array) node.getFuera().getTipo()).getTipoElementos());
		node.setModificable(true);

		predicado(mismoTipo(node.getFuera().getTipo(), new Tipo_Array("", null)), "Debe ser tipo array", node);
		predicado(mismoTipo(node.getDentro().getTipo(), new Tipo_Int()), "Debe ser indice entero", node);

		return null;

	}

	// class Expr_acceso_struct { Expr struct; String campo; }
	public Object visit(Expr_acceso_struct node, Object param) {
		//TODO

		// super.visit(node, param);

		if (node.getStruct() != null)
			node.getStruct().accept(this, param);

		return null;
	}

	// class Expr_llamada_funcion { String nombre; List<Expr> parametros; }
	public Object visit(Expr_llamada_funcion node, Object param) {
		/** Reglas Semanticas */
		// expr_llamada_funcion.tipo = expr.tipo
		// expr_llamada_funcion.modificable=false
		/** Predicados */
		// |expr_llamada_funcion.parametrosi| ==
		// |expr_llamada_funcion.definicion.parametrosi|
		// expr_llamada_funcion.parametrosi.tipo ==
		// expr_llamada_funcion.definicion.parametrosi.tipo
		// expr_llamada_funcion.definicion.retorno =/= tipoVoid

		node.setTipo(node.getDefinicion().getRetorno());
		node.setModificable(false);

		super.visit(node, param);

		boolean mismoNumParametros = node.getParametros().size() == node.getDefinicion().getParametros().size();
		predicado(mismoNumParametros, "Numero de argumentos incorrecto", node);
		if (!mismoNumParametros) {
			return null;
		}

		for (int i = 0; i < node.getParametros().size(); i++) {
			predicado(
					mismoTipo(node.getParametros().get(i).getTipo(),
							node.getDefinicion().getParametros().get(i).getTipo()),
					"Tipo de los parametros no coincide", node);
		}

		predicado(!mismoTipo(node.getDefinicion().getRetorno(), new Tipo_Void()), "No tiene retorno", node);

		return null;
	}

	// # --------------------------------------------
	// Métodos auxiliares recomendados  -------------

	private boolean tipoSimple(Tipo tipo) {
		return tipo instanceof Tipo_Int || tipo instanceof Tipo_Float || tipo instanceof Tipo_Char;
	}

	private boolean mismoTipo(Tipo tipo1, Tipo tipo2) {
		return tipo1.getClass().equals(tipo2.getClass());
	}

	/**
	 * predicado. Método auxiliar para implementar los predicados. Borrar si no se
	 * quiere usar.
	 *
	 * Ejemplos de uso (suponiendo que existe un método "esPrimitivo(expr)"):
	 *
	 * 1. predicado(esPrimitivo(expr.tipo), "La expresión debe ser de un tipo
	 * primitivo", expr.getStart()); 2. predicado(esPrimitivo(expr.tipo), "La
	 * expresión debe ser de un tipo primitivo", expr); // Se asume getStart() 3.
	 * predicado(esPrimitivo(expr.tipo), "La expresión debe ser de un tipo
	 * primitivo");
	 *
	 * NOTA: El método getStart() (ejemplo 1) indica la linea/columna del fichero
	 * fuente donde estaba el nodo (y así poder dar información más detallada de la
	 * posición del error). Si se usa VGen, dicho método habrá sido generado en
	 * todos los nodos del AST. No es obligatorio llamar a getStart() (ejemplo 2),
	 * ya que si se pasa el nodo, se usará por defecto dicha posición. Si no se
	 * quiere imprimir la posición del fichero, se puede omitir el tercer argumento
	 * (ejemplo 3).
	 *
	 * @param condition     Debe cumplirse para que no se produzca un error
	 * @param errorMessage  Se imprime si no se cumple la condición
	 * @param posicionError Fila y columna del fichero donde se ha producido el
	 *                      error.
	 */

	private void predicado(boolean condition, String errorMessage, Position position) {
		if (!condition)
			errorManager.notify("Type Checking", errorMessage, position);
	}

	private void predicado(boolean condition, String errorMessage, AST node) {
		predicado(condition, errorMessage, node.getStart());
	}

//	private void predicado(boolean condition, String errorMessage) {
//		predicado(condition, errorMessage, (Position) null);
//	}

	private ErrorManager errorManager;
}
