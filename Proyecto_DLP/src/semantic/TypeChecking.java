package semantic;

import java.util.*;

import ast.*;
import main.*;
import visitor.*;

public class TypeChecking extends DefaultVisitor {

	public TypeChecking(ErrorManager errorManager) {
		this.errorManager = errorManager;
	}

	// class Funcion { String nombre; List<Parametro> parametros; List<Tipo>
	// retorno; List<Sentencia> sentencia; }
	public Object visit(Funcion node, Object param) {
		/** Predicados */
		// tipoSimple(retorno.tipo)
		// tipoSimple(parametroi)
		/** Reglas Sem·nticas */
		// sentenciasi.funcionActual = defFuncion
		// si retorno == null
		// retorno = tipoVoid

		for (int i = 0; i < node.getSentencias().size(); i++) {
			node.getSentencias().get(i).setFuncionActual(node);
		}

		super.visit(node, param);

		for (int i = 0; i < node.getParametros().size(); i++) {
			predicado(tipoSimple(node.getParametros().get(i).getTipo()),
					"Los parametros de una funcion debe ser de tipo primitivo: "
							+ node.getParametros().get(i).getNombre(),
					node);
		}

		predicado(tipoSimple(node.getRetorno()) || mismoTipo(node.getRetorno(), new TipoVoid()),
				"Retorno de tipo no simple", node);

		return null;
	}

	// class Sentencia_asignacion { Expr izquierda; Expr derecha; }
	public Object visit(Sentencia_asignacion node, Object param) {
		/** Predicados */
		// mismoTipo(izquierda.tipo, derecha.tipo)
		// tipoSimple(izquierda.tipo)
		// izquierda.modificable == true

		super.visit(node, param);

		predicado(mismoTipo(node.getIzquierda().getTipo(), node.getDerecha().getTipo()), "Valores de distinto tipo",
				node);
		predicado(tipoSimple(node.getIzquierda().getTipo()), "Valor de la izquierda debe ser simple", node);
		predicado(node.getIzquierda().isModificable() == true, "Valor de la izquierda no modificable", node);

		return null;

	}

	// class Sentencia_print { Expr expresiones; }
	public Object visit(Sentencia_print node, Object param) {
		/** Predicados */
		// tipoSimple(expresiones.tipo)

		super.visit(node, param);

		if (mismoTipo(node.getExpresiones().getTipo(), new TipoVoid())) {
			predicado(false, "No tiene tipo de retorno", node);
		} else {
			predicado(tipoSimple(node.getExpresiones().getTipo()), "Solo se pueden imprimir tipos simples", node);
		}

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
		/** Reglas Sem·nticas */
		// Sentenciasi.funcionActual = sentencia_if. funcionActual

		for (int i = 0; i < node.getSentencias().size(); i++) {
			node.getSentencias().get(i).setFuncionActual(node.getFuncionActual());
		}

		super.visit(node, param);

		predicado(mismoTipo(node.getCondicion().getTipo(), new TipoInt()), "La condicion debe ser de tipo entero",
				node);
		return null;
	}

	// class Sentencia_while { Expr condicion; List<Sentencia> sentencias; }
	public Object visit(Sentencia_while node, Object param) {
		/** Predicados */
		// condicion.tipo==tipoInt
		/** Reglas Sem·nticas */
		// Sentenciasi.funcionActual = sentencia_while.funcionActual

		for (int i = 0; i < node.getSentencias().size(); i++) {
			node.getSentencias().get(i).setFuncionActual(node.getFuncionActual());
		}

		super.visit(node, param);

		predicado(mismoTipo(node.getCondicion().getTipo(), new TipoInt()), "La condicion debe ser de tipo entero",
				node);

		return null;
	}

	// class Sentencia_llamada_funcion { String nombre; List<Expr> parametros; }
	public Object visit(Sentencia_llamada_funcion node, Object param) {

		/** Predicados */
		// |sentencia_llamada_funcion.parametrosi| ==
		// |sentencia_llamada_funcion.funcionActual.parametrosi|
		// sentencia_llamada_funcion.parametrosi.tipo ==
		// sentencia_llamada_funcion.funcionActual.parametrosi.tipo
		// TODO

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
			predicado(mismoTipo(node.getFuncionActual().getRetorno(), new TipoVoid()),
					"Los return deben tener un valor de retorno", node.getFuncionActual());
		} else {
			predicado(mismoTipo(node.getFuncionActual().getRetorno(), node.getExpresion().getTipo()),
					"Tipo de retorno no coincide", node);
		}

		return null;
	}

	// class Expr_int { String string; }
	public Object visit(Expr_int node, Object param) {
		/** Reglas Sem·nticas */
		// expr_int.tipo = tipoInt
		// expr_int.modificable = false

		node.setTipo(new TipoInt());
		node.setModificable(false);

		return null;
	}

	// class Expr_real { String string; }
	public Object visit(Expr_real node, Object param) {
		/** Reglas Sem·nticas */
		// expr_real.tipo = tipoFloat
		// expr_real.modificable=false

		node.setTipo(new TipoFloat());
		node.setModificable(false);

		return null;
	}

	// class Expr_char { String string; }
	public Object visit(Expr_char node, Object param) {
		/** Reglas Sem·nticas */
		// expr_char.tipo=tipoChar
		// expr_chat.modificable=false

		node.setTipo(new TipoChar());
		node.setModificable(false);

		return null;
	}

	// class Expr_ident { String string; }
	public Object visit(Expr_ident node, Object param) {
		/** Reglas Sem·nticas */
		// expr_ident.tipo=expr_ident.definicion.tipo
		// expr_ident.modificable=true

		node.setModificable(true);
		if (node.getDefinicion_global() != null) {
			node.setTipo(node.getDefinicion_global().getTipo());
			return null;
		} else if (node.getDefinicion_parametro() != null) {
			node.setTipo(node.getDefinicion_parametro().getTipo());
			return null;
		} else if (node.getDefinicion_local() != null) {
			node.setTipo(node.getDefinicion_local().getTipo());
			return null;
		}

		System.out.println("Este mensaje no deberia salir"); // TODO borrar esto
		return null;

	}

	// class Expr_binaria { Expr izquierda; Operador operador; Expr derecha; }
	public Object visit(Expr_binaria node, Object param) {
		/** Reglas Sem·nticas */
		// expr_binaria.tipo=izquierda.tipo
		// expr_binaria.modificable=false
		/** Predicados */
		// si(operador es aritmÈtico)
		// tipoSimple(izquierda.tipo)
		// si(operador es lÛgico)
		// tipoSimple(izquierda.tipo)
		// si(operador es booleano)
		// izquierda.tipo==tipoInt
		// mismoTipo(izquierda, derecha)

		super.visit(node, param);

		node.setTipo(node.getIzquierda().getTipo());
		node.setModificable(false);

		if (node.getOperador().getClass().equals(new Operador_aritmetico("").getClass())) {
			predicado(tipoSimple(node.getIzquierda().getTipo()), "Deben ser tipos simples", node);
		}
		if (node.getOperador().getClass().equals(new Operador_logico("").getClass())) {
			predicado(tipoSimple(node.getIzquierda().getTipo()), "Deben ser tipos simples", node);
		}
		if (node.getOperador().getClass().equals(new Operador_booleano("").getClass())) {
			predicado(node.getIzquierda().getTipo().getClass().equals(new TipoInt().getClass()), "Deben ser entero",
					node);
		}
		predicado(mismoTipo(node.getIzquierda().getTipo(), node.getDerecha().getTipo()), "Valores de distinto tipo",
				node);

		return null;
	}

	// class Expr_vector { Expr fuera; Expr dentro; }
	public Object visit(Expr_vector node, Object param) {
		/** Reglas Sem·nticas */
		// expr_vector.tipo = tipoArray
		// expr_vector.modificable=false
		/** Predicados */
		// fuera.tipo==tipoArray
		// dentro.tipo==tipoInt

		node.setTipo(new TipoArray("0", node.getFuera().getTipo()));
		node.setModificable(false);

		super.visit(node, param);

		return null;
	}

	// class Expr_punto { Expr izquierda; Expr derecha; }
	public Object visit(Expr_punto node, Object param) {
		/** Reglas Sem·nticas */
		// expr_punto = tipoStruct
		// expr_punto.modificable=false

		node.setTipo(new TipoStruct());
		node.setModificable(false);

		super.visit(node, param);

		return null;
	}

	// class Expr_parentesis { Expr expr; }
	public Object visit(Expr_parentesis node, Object param) {
		/** Reglas Sem·nticas */
		// expr_parentesis.tipo = expr.tipo
		// expr_parentesis.modificable=expr.modificable

		node.setTipo(node.getExpr().getTipo());
		node.setModificable(node.getExpr().isModificable());

		super.visit(node, param);

		return null;
	}

	// class Expr_cast { Tipo tipo; Expr expr; }
	public Object visit(Expr_cast node, Object param) {
		/** Reglas Sem·nticas */
		// expr_cast.tipo = tipo.tipo
		// expr_cast.modificable=false

		node.setTipo(node.getTipo_convertido());
		node.setModificable(false);

		super.visit(node, param);

		return null;
	}

	// class Expr_llamada_funcion { String nombre; List<Expr> parametros; }
	public Object visit(Expr_llamada_funcion node, Object param) {
		/** Reglas Sem·nticas */
		// expr_llamada_funcion.tipo = expr.tipo
		// expr_llamada_funcion.modificable=false
		/** Predicados */
		// |expr_llamada_funcion.parametrosi| ==
		// |expr_llamada_funcion.funcionActual.parametrosi|
		// expr_llamada_funcion.parametrosi.tipo ==
		// expr_llamada_funcion.funcionActual.parametrosi.tipo
		// expr_llamada_funcion.funcionActual.retorno =/= tipoVoid
		// TODO

		node.setTipo(node.getDefinicion().getRetorno());
		node.setModificable(false);

		super.visit(node, param);

		return null;
	}

	// class Operador_aritmetico { String string; }
	public Object visit(Operador_aritmetico node, Object param) {
		return null;
	}

	////////////////////////////////////////////////////
	//////////////// Metodos auxiliares ////////////////
	////////////////////////////////////////////////////
	private boolean tipoSimple(Tipo tipo) {
		return tipo.getClass().equals(new TipoInt().getClass()) || tipo.getClass().equals(new TipoFloat().getClass())
				|| tipo.getClass().equals(new TipoChar().getClass());
	}

	private boolean mismoTipo(Tipo tipo1, Tipo tipo2) {
		return tipo1.getClass().equals(tipo2.getClass());
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
	 * fuente donde estaba el nodo (y as√≠ poder dar informacion mas detallada de la
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
			errorManager.notify("Comprobacion de tipos", mensajeError, posicionError);
	}

	private void predicado(boolean condicion, String mensajeError, AST node) {
		predicado(condicion, mensajeError, node.getStart());
	}

	private void predicado(boolean condicion, String mensajeError) {
		predicado(condicion, mensajeError, (Position) null);
	}

	private ErrorManager errorManager;
}
