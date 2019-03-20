package semantic;

import java.util.*;

import ast.*;
import main.*;
import visitor.*;

public class TypeChecking extends DefaultVisitor {

    public TypeChecking(ErrorManager errorManager) {
        this.errorManager = errorManager;
    }

    
	//	class Expr_int { String string; }
	public Object visit(Expr_int node, Object param) {
		node.setTipo(new TipoInt());
		node.setModificable(false);

		return null;
	}
	
	//	class Expr_real { String string; }
	public Object visit(Expr_real node, Object param) {
		node.setTipo(new TipoFloat());
		node.setModificable(false);
		return null;
	}

	//	class Expr_char { String string; }
	public Object visit(Expr_char node, Object param) {
		node.setTipo(new TipoChar());
		node.setModificable(false);
		return null;
	}

	//	class Expr_ident { String string; }
	public Object visit(Expr_ident node, Object param) {
		node.setModificable(true);
		
		if(node.getDefinicion_global() != null) {
			node.setTipo(node.getDefinicion_global().getTipo());
			return null;
		}
		if(node.getDefinicion_parametro() != null) {
			node.setTipo(node.getDefinicion_parametro().getTipo());
			return null;
		}
		if(node.getDefinicion_local() != null) {
			node.setTipo(node.getDefinicion_local().getTipo());
			return null;
		}
		
		return null;

		
	}

	//	class Expr_binaria { Expr izquierda;  Operador operador;  Expr derecha; }
	public Object visit(Expr_binaria node, Object param) {
		
		//predicado(mismoTipo(node.getIzquierda().getTipo() derecha.tipo) , "Struct ya definido: " + node.getNombre(), node);

		// super.visit(node, param);

		if (node.getIzquierda() != null)
			node.getIzquierda().accept(this, param);

		if (node.getOperador() != null)
			node.getOperador().accept(this, param);

		if (node.getDerecha() != null)
			node.getDerecha().accept(this, param);

		return null;
	}
	
	/////////////////////////////////////////////////////////////////////////
	//Metodos auxiliares:
	
	
	

    /**
     * predicado. Método auxiliar para implementar los predicados. Borrar si no se quiere usar.
     *
     * Ejemplos de uso (suponiendo que existe un método "esPrimitivo"):
     *
     *      1. predicado(esPrimitivo(expr.tipo), "La expresion debe ser de un tipo pimitivo", expr.getStart());
     *      2. predicado(esPrimitivo(expr.tipo), "La expresion debe ser de un tipo pimitivo", expr);
     *      3. predicado(esPrimitivo(expr.tipo), "La expresion debe ser de un tipo primitivo");
     *
     * NOTA: El método getStart() (ejemplo 1) indica la linea/columna del fichero fuente donde estaba el nodo
     * (y así poder dar informacion mas detallada de la posicion del error). Si se usa VGen, dicho método
     * habra sido generado en todos los nodos del AST.
     * No es obligatorio llamar a getStart() (ejemplo 2), ya que si se pasa el nodo, se usara por defecto dicha
     * posicion.
     * Si no se quiere imprimir la posicion del fichero, se puede omitir el tercer argumento (ejemplo 3).
     *
     * @param condicion     Debe cumplirse para que no se produzca un error
     * @param mensajeError  Se imprime si no se cumple la condicion
     * @param posicionError Fila y columna del fichero donde se ha producido el error.
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
