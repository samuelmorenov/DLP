package semantic;

//import java.util.*;

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
		/** Reglas Semánticas */
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

		predicado(mismoTipo(node.getIzquierda().getTipo(), node.getDerecha().getTipo()),
				"Valores asignados de distinto tipo", node);
		predicado(tipoSimple(node.getIzquierda().getTipo()), "Valor de la izquierda debe ser simple", node);
		predicado(node.getIzquierda().isModificable() == true, "Valor de la izquierda no modificable", node);

		return null;

	}

	// class Sentencia_print { Expr expresiones; }
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
		/** Reglas Semánticas */
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
		/** Reglas Semánticas */
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
		// |sentencia_llamada_funcion.definicion.parametrosi|
		// sentencia_llamada_funcion.parametrosi.tipo ==
		// sentencia_llamada_funcion.definicion.parametrosi.tipo

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
		/** Reglas Semánticas */
		// expr_int.tipo = tipoInt
		// expr_int.modificable = false

		node.setTipo(new TipoInt());
		node.setModificable(false);

		return null;
	}

	// class Expr_real { String string; }
	public Object visit(Expr_real node, Object param) {
		/** Reglas Semánticas */
		// expr_real.tipo = tipoFloat
		// expr_real.modificable=false

		node.setTipo(new TipoFloat());
		node.setModificable(false);

		return null;
	}

	// class Expr_char { String string; }
	public Object visit(Expr_char node, Object param) {
		/** Reglas Semánticas */
		// expr_char.tipo=tipoChar
		// expr_chat.modificable=false

		node.setTipo(new TipoChar());
		node.setModificable(false);

		return null;
	}

	// class Expr_ident { String string; }
	public Object visit(Expr_ident node, Object param) {
		/** Reglas Semánticas */
		// expr_ident.tipo=expr_ident.definicion.tipo
		// expr_ident.modificable=true

		node.setModificable(true);
		if (node.getDefinicion_global() != null) {
			node.setTipo(node.getDefinicion_global().getTipo());

		}

		else if (node.getDefinicion_parametro() != null) {
			node.setTipo(node.getDefinicion_parametro().getTipo());
		}

		else if (node.getDefinicion_local() != null) {
			node.setTipo(node.getDefinicion_local().getTipo());
		}

		return null;

	}

	// class Expr_binaria { Expr izquierda; Operador operador; Expr derecha; }
	public Object visit(Expr_binaria node, Object param) {
		/** Reglas Semánticas */
		// expr_binaria.tipo=izquierda.tipo
		// expr_binaria.modificable=false
		/** Predicados */
		// si(operador es aritmético)
		// tipoSimple(izquierda.tipo)
		// si(operador es lógico)
		// tipoSimple(izquierda.tipo)
		// si(operador es booleano)
		// izquierda.tipo==tipoInt
		// mismoTipo(izquierda, derecha)

		super.visit(node, param);

		node.setTipo(node.getIzquierda().getTipo());
		node.setModificable(false);

		if (node.getOperador() instanceof Operador_aritmetico) {
			predicado(tipoSimple(node.getIzquierda().getTipo()), "Deben ser tipos simples", node);
			predicado(tipoSimple(node.getDerecha().getTipo()), "Deben ser tipos simples", node);
		}
		if (node.getOperador() instanceof Operador_comparacion) {
			predicado(tipoSimple(node.getIzquierda().getTipo()), "Deben ser tipos simples", node);
			predicado(tipoSimple(node.getDerecha().getTipo()), "Deben ser tipos simples", node);
			node.setTipo(new TipoInt());
		}
		if (node.getOperador() instanceof Operador_logico) {
			predicado(node.getIzquierda().getTipo().getClass().equals(new TipoInt().getClass()), "Deben ser entero",
					node);
			predicado(node.getDerecha().getTipo().getClass().equals(new TipoInt().getClass()), "Deben ser entero",
					node);
			node.setTipo(new TipoInt());
		}

		predicado(mismoTipo(node.getIzquierda().getTipo(), node.getDerecha().getTipo()),
				"Operacion con distintos tipos "
				// + "\n"
				// + node.getIzquierda()
				// + node.getIzquierda().getTipo()
				// + "\n"
				// + node.getDerecha()
				// + node.getDerecha().getTipo()
				, node);
		return null;
	}

	// class Expr_vector { Expr fuera; Expr dentro; }
	public Object visit(Expr_vector node, Object param) {
		/** Reglas Semánticas */
		// expr_vector.tipo = vector.definicion.tipo
		// expr_vector.modificable=true
		/** Predicados */
		// fuera.tipo==tipoArray
		// dentro.tipo==tipoInt


		super.visit(node, param);
		
		node.setTipo(((TipoArray)node.getFuera().getTipo()).getTipoElementos());
		node.setModificable(true);

		predicado(mismoTipo(node.getFuera().getTipo(), new TipoArray("", null)), "Debe ser tipo array", node);
		predicado(mismoTipo(node.getDentro().getTipo(), new TipoInt()), "Debe ser indice entero", node);

		return null;
	}

	// class Expr_punto { Expr izquierda; Expr derecha; }
	public Object visit(Expr_punto node, Object param) {
		/** Reglas Semánticas */
		// expr_punto.tipo = derecha.tipo
		// expr_punto.modificable=true
		/** Predicados */
		// izquierda.tipo == tipoStruct
		// derecha esta en izquierda.tipo.definicion.Definicion_campo_struct

		super.visit(node, param);

		// Valores por defecto:
		node.setTipo(new TipoInt()); // Si no se cambia es que da otro error y no necesita dar error de tipo
		node.setModificable(false);

		if (node.getIzquierda().getTipo() instanceof TipoStruct) {
			if (node.getDerecha() instanceof Expr_ident) {
				Struct definicion = ((TipoStruct) node.getIzquierda().getTipo()).getDefinicion();
				String nombreDerecha = ((Expr_ident) node.getDerecha()).getString();
				boolean existe = false;
				for (Definicion_campo_struct campoActual : definicion.getDefinicion_campo_struct()) {
					if (nombreDerecha.equals(campoActual.getNombre())) {
						node.getDerecha().setTipo(campoActual.getTipo());
						node.setTipo(campoActual.getTipo());
						node.setModificable(true);
						existe = true;
					}
				}
				predicado(existe, "Campo no definido", node);
			} else {
				predicado(false, "El campo del estuct no es un identificador", node);
			}
		} else {
			predicado(false, "Se requiere tipo struct", node);
		}
		return null;
	}

	// class Expr_parentesis { Expr expr; }
	public Object visit(Expr_parentesis node, Object param) {
		/** Reglas Semánticas */
		// expr_parentesis.tipo = expr.tipo
		// expr_parentesis.modificable=expr.modificable

		super.visit(node, param);

		node.setTipo(node.getExpr().getTipo());
		node.setModificable(node.getExpr().isModificable());

		return null;
	}

	// class Expr_cast { Tipo tipo; Expr expr; }
	public Object visit(Expr_cast node, Object param) {
		/** Reglas Semánticas */
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

	// class Expr_llamada_funcion { String nombre; List<Expr> parametros; }
	public Object visit(Expr_llamada_funcion node, Object param) {
		/** Reglas Semánticas */
		// expr_llamada_funcion.tipo = expr.tipo
		// expr_llamada_funcion.modificable=false
		/** Predicados */
		// |sentencia_llamada_funcion.parametrosi| ==
		// |sentencia_llamada_funcion.definicion.parametrosi|
		// sentencia_llamada_funcion.parametrosi.tipo ==
		// sentencia_llamada_funcion.definicion.parametrosi.tipo
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

		predicado(!mismoTipo(node.getDefinicion().getRetorno(), new TipoVoid()), "No tiene retorno", node);

		return null;
	}

	////////////////////////////////////////////////////
	//////////////// Metodos auxiliares ////////////////
	////////////////////////////////////////////////////
	private boolean tipoSimple(Tipo tipo) {
		return tipo instanceof TipoInt || tipo instanceof TipoFloat || tipo instanceof TipoChar;
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
			errorManager.notify("Comprobacion de tipos", mensajeError, posicionError);
	}

	private void predicado(boolean condicion, String mensajeError, AST node) {
		predicado(condicion, mensajeError, node.getStart());
	}

	@SuppressWarnings("unused")
	private void predicado(boolean condicion, String mensajeError) {
		predicado(condicion, mensajeError, (Position) null);
	}

	private ErrorManager errorManager;
}
