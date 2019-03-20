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
		
		node.setTipo(node.getIzquierda().getTipo());
		node.setModificable(false);

		super.visit(node, param);

		return null;
	}

	//	class Expr_vector { Expr fuera;  Expr dentro; }
	public Object visit(Expr_vector node, Object param) {
		
		//expr_vector.tipo = tipoArray
		//expr_vector.modificable=false
		node.setTipo(new TipoArray(0, node.getFuera().getTipo())); //TODO: revisar el 0

		super.visit(node, param);

		return null;
	}

	//	class Expr_punto { Expr izquierda;  Expr derecha; }
	public Object visit(Expr_punto node, Object param) {
		
		//expr_punto = tipoStruct
		//expr_punto.modificable=false
		node.setTipo(new TipoStruct());
		node.setModificable(false);


		super.visit(node, param);

		return null;
	}

	//	class Expr_parentesis { Expr expr; }
	public Object visit(Expr_parentesis node, Object param) {
		
		//expr_parentesis.tipo = expr.tipo
		//expr_parentesis.modificable=expr.modificable
		node.setTipo(node.getExpr().getTipo());
		node.setModificable(node.getExpr().isModificable());


		super.visit(node, param);

		return null;
	}

	//	class Expr_cast { Tipo tipo;  Expr expr; }
	public Object visit(Expr_cast node, Object param) {
		
		//expr_cast.tipo = tipo.tipo
		//expr_cast.modificable=false
		node.setTipo(node.getTipo_convertido());
		node.setModificable(false);


		super.visit(node, param);
		return null;
	}

	//	class Expr_llamada_funcion { String nombre;  List<Expr> parametros; }
	public Object visit(Expr_llamada_funcion node, Object param) {
		
		//expr_llamada_funcion.tipo = expr.tipo
		//expr_llamada_funcion.modificable=false
		if(node.getDefinicion().getRetorno().size() == 0) {
			node.setTipo(null);
		}
		else {
			node.setTipo(node.getDefinicion().getRetorno().get(1));
		}
		node.setModificable(false);
		super.visit(node, param);

		return null;
	}

	//	class Operador_aritmetico { String string; }
	public Object visit(Operador_aritmetico node, Object param) {
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
