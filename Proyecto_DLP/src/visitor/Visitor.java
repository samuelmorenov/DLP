/**
 * @generated VGen (for ANTLR) 1.4.0
 */

package visitor;

import ast.*;

public interface Visitor {
	public Object visit(Program node, Object param);
	public Object visit(Definicion_1 node, Object param);
	public Object visit(Tamanio_vector node, Object param);
	public Object visit(TipoInt node, Object param);
	public Object visit(TipoFloat node, Object param);
	public Object visit(TipoChar node, Object param);
	public Object visit(TipoVar node, Object param);
	public Object visit(Struct node, Object param);
	public Object visit(Definicion_2 node, Object param);
	public Object visit(Funcion node, Object param);
	public Object visit(Parametro node, Object param);
	public Object visit(Definicion_3 node, Object param);
	public Object visit(Sentencia_asignacion node, Object param);
	public Object visit(Sentencia_print node, Object param);
	public Object visit(Sentencia_printlnVacia node, Object param);
	public Object visit(Sentencia_read node, Object param);
	public Object visit(Sentencia_if node, Object param);
	public Object visit(Sentencia_ifelse node, Object param);
	public Object visit(Sentencia_while node, Object param);
	public Object visit(Sentencia_return node, Object param);
	public Object visit(Sentencia_returnVacia node, Object param);
	public Object visit(Sentencia_expresion node, Object param);
	public Object visit(Expr_int node, Object param);
	public Object visit(Expr_real node, Object param);
	public Object visit(Expr_char node, Object param);
	public Object visit(Expr_ident node, Object param);
	public Object visit(Expr_binaria node, Object param);
	public Object visit(Expr_vector node, Object param);
	public Object visit(Expr_punto node, Object param);
	public Object visit(Expr_parentesis node, Object param);
	public Object visit(Expr_cast node, Object param);
	public Object visit(Expr_llamada node, Object param);
	public Object visit(Operador node, Object param);
}
