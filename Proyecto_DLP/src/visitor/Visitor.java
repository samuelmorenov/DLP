/**
 * @generated VGen (for ANTLR) 1.4.0
 */

package visitor;

import ast.*;

public interface Visitor {
	public Object visit(Program node, Object param);
	public Object visit(Definicion_variable_global node, Object param);
	public Object visit(Struct node, Object param);
	public Object visit(Definicion_campo_struct node, Object param);
	public Object visit(Funcion node, Object param);
	public Object visit(Definicion_variable_local node, Object param);
	public Object visit(Parametro node, Object param);
	public Object visit(Sentencia_asignacion node, Object param);
	public Object visit(Sentencia_print node, Object param);
	public Object visit(Sentencia_read node, Object param);
	public Object visit(Sentencia_if node, Object param);
	public Object visit(Sentencia_while node, Object param);
	public Object visit(Sentencia_llamada_funcion node, Object param);
	public Object visit(Sentencia_return node, Object param);
	public Object visit(TipoInt node, Object param);
	public Object visit(TipoFloat node, Object param);
	public Object visit(TipoChar node, Object param);
	public Object visit(TipoStruct node, Object param);
	public Object visit(TipoArray node, Object param);
	public Object visit(TipoVoid node, Object param);
	public Object visit(Expr_int node, Object param);
	public Object visit(Expr_real node, Object param);
	public Object visit(Expr_char node, Object param);
	public Object visit(Expr_ident node, Object param);
	public Object visit(Expr_binaria node, Object param);
	public Object visit(Expr_vector node, Object param);
	public Object visit(Expr_punto node, Object param);
	public Object visit(Expr_parentesis node, Object param);
	public Object visit(Expr_cast node, Object param);
	public Object visit(Expr_llamada_funcion node, Object param);
	public Object visit(Operador_aritmetico node, Object param);
	public Object visit(Operador_logico node, Object param);
	public Object visit(Operador_booleano node, Object param);
}
