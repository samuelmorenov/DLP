/**
 * @generated VGen (for ANTLR) 1.4.0
 */

package visitor;

import ast.*;

public interface Visitor {
	public Object visit(Program node, Object param);
	public Object visit(Variable node, Object param);
	public Object visit(Entero node, Object param);
	public Object visit(TipoInt node, Object param);
	public Object visit(TipoFloat node, Object param);
	public Object visit(TipoChar node, Object param);
	public Object visit(TipoVar node, Object param);
	public Object visit(Struct node, Object param);
	public Object visit(Definicion node, Object param);
	public Object visit(Funcion node, Object param);
	public Object visit(Parametro node, Object param);
	public Object visit(Sentencia node, Object param);
}
