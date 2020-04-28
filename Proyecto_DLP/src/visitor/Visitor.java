/**
 * @generated VGen (for ANTLR) 1.7.0
 */

package visitor;

import ast.*;

public interface Visitor {
	public Object visit(Program node, Object param);
	public Object visit(Definicion_variable node, Object param);
	public Object visit(Definicion_struct node, Object param);
	public Object visit(Definicion_funcion node, Object param);
	public Object visit(Campo_struct node, Object param);
	public Object visit(Sentencia_asignacion node, Object param);
	public Object visit(Sentencia_print node, Object param);
	public Object visit(Sentencia_print_vacia node, Object param);
	public Object visit(Sentencia_read node, Object param);
	public Object visit(Sentencia_if node, Object param);
	public Object visit(Sentencia_while node, Object param);
	public Object visit(Sentencia_llamada_funcion node, Object param);
	public Object visit(Sentencia_return node, Object param);
	public Object visit(Tipo_Int node, Object param);
	public Object visit(Tipo_Float node, Object param);
	public Object visit(Tipo_Char node, Object param);
	public Object visit(Tipo_Void node, Object param);
	public Object visit(Tipo_Struct node, Object param);
	public Object visit(Tipo_Array node, Object param);
	public Object visit(Tipo_Error node, Object param);
	public Object visit(Expr_int node, Object param);
	public Object visit(Expr_real node, Object param);
	public Object visit(Expr_char node, Object param);
	public Object visit(Expr_uso_variable node, Object param);
	public Object visit(Expr_operacion node, Object param);
	public Object visit(Expr_negada node, Object param);
	public Object visit(Expr_cast node, Object param);
	public Object visit(Expr_acceso_vector node, Object param);
	public Object visit(Expr_acceso_struct node, Object param);
	public Object visit(Expr_llamada_funcion node, Object param);
	public Object visit(Operador_aritmetico node, Object param);
	public Object visit(Operador_logico node, Object param);
	public Object visit(Operador_comparacion node, Object param);
}
