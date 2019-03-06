grammar Grammar;
import Lexicon;

@parser::header {
    import ast.*;
}

start returns[Program ast]
	: bloques { $ast = new Program($bloques.ast); }
	;


bloques	returns[List<Bloque> ast = new ArrayList<Bloque>()]
	: (bloque 	{ $ast.add($bloque.ast); })* EOF
	;

	
bloque 	returns[Bloque ast]
	: definicion_1 	{ $ast = new Definicion_1($definicion_1.ast.getNombre(), $definicion_1.ast.getEntero(), $definicion_1.ast.getTipo()); }
	| struct 	{ $ast = new Struct($struct.ast.getNombre(), $struct.ast.getDefinicion_2()); }
	| funcion 	{ $ast = new Funcion($funcion.ast.getNombre(), $funcion.ast.getParametros(), $funcion.ast.getRetorno(), $funcion.ast.getSentencia()); }
	;
	
definicion_1 	returns[Definicion_1 ast]
	:'var' IDENT ':' lista tipo ';'	{ $ast = new Definicion_1($IDENT, $lista.ast, $tipo.ast); }
	;
	
	
struct 	returns[Struct ast]
	: 'struct' IDENT '{' definiciones '}' ';'	{ $ast = new Struct($IDENT, $definiciones.ast); }
	;
	
funcion 	returns[Funcion ast]
	: IDENT '(' parametros ')' retorno '{' sentencias '}' 	{ $ast = new Funcion($IDENT, $parametros.ast, $retorno.ast, $sentencias.ast); }
	;
	
retorno	returns[List<Tipo> ast = new ArrayList<Tipo>()]
	: (':' tipo 	{ $ast.add($tipo.ast); })?
	;
	
lista 	returns[List<Entero> ast = new ArrayList<Entero>()]
	: ('[' INT_CONSTANT ']' 	{ $ast.add(new Entero($INT_CONSTANT)); })* 
	;
	
tipo 	returns[Tipo ast]
	: 'int'	{ $ast = new TipoInt(); }
	| 'float' 	{ $ast = new TipoFloat(); }
	| 'char' 	{ $ast = new TipoChar(); }
	| IDENT 	{ $ast = new TipoVar($IDENT); }
	;


definiciones 	returns[List<Definicion_2> ast = new ArrayList<Definicion_2>()]
	: (definicion_2 	{ $ast.add($definicion_2.ast); })* 
	;
	
definicion_2 	returns[Definicion_2 ast]
	: IDENT ':' lista tipo ';' 	{ $ast = new Definicion_2($IDENT, $lista.ast, $tipo.ast); }
	;
	
parametros 	returns[List<Parametro> ast = new ArrayList<Parametro>()]
	: (parametro { $ast.add($parametro.ast); } (',' parametro 	{ $ast.add($parametro.ast); })*)?
	//:(parametro (',' parametro)*)?
	;
	
parametro 	returns[Parametro ast]
	: IDENT ':' tipo 	{ $ast = new Parametro($IDENT, $tipo.ast); }
	;

sentencias	returns[List<Sentencia> ast = new ArrayList<Sentencia>()]
	: (sentencia	{ $ast.add($sentencia.ast); }	)*
	;	
	
sentencia	returns[Sentencia ast]
	: definicion_3	{ $ast = $definicion_3.ast; }
	| sentencia_asignacion	{ $ast = $sentencia_asignacion.ast; }
	| sentencia_print	{ $ast = $sentencia_print.ast; }
	| sentencia_printlnVacia	{ $ast = $sentencia_printlnVacia.ast; }
	| sentencia_read	{ $ast = $sentencia_read.ast; }
	| sentencia_if	{ $ast = $sentencia_if.ast; }
	| sentencia_ifelse	{ $ast = $sentencia_ifelse.ast; }
	| sentencia_while	{ $ast = $sentencia_while.ast; }
	| sentencia_return	{ $ast = $sentencia_return.ast; }
	| sentencia_returnVacia	{ $ast = $sentencia_returnVacia.ast; }
	| sentencia_expresion { $ast = $sentencia_expresion.ast; }
	;
	
definicion_3 	returns[Definicion_3 ast]
	: 'var' IDENT ':' lista tipo ';' 	{ $ast = new Definicion_3($IDENT, $lista.ast, $tipo.ast); }
	;
	
	
sentencia_asignacion	returns[Sentencia_asignacion ast]
	: expr '=' expr ';'	{ $ast = new Sentencia_asignacion($ctx.expr(0).ast, $ctx.expr(1).ast); }
	;
	
sentencia_print	returns[Sentencia_print ast]
	: 'print' expr ';'	{ $ast = new Sentencia_print($expr.ast); }
	| 'printsp' expr ';'	{ $ast = new Sentencia_print($expr.ast); }
	| 'println' (expr) ';'	{ $ast = new Sentencia_print($expr.ast); }
	;

sentencia_printlnVacia returns[Sentencia_printlnVacia ast]
	: 'println' ';'{ $ast = new Sentencia_printlnVacia(); }
	;
	
sentencia_read	returns[Sentencia_read ast]
	: 'read' expr ';'	{ $ast = new Sentencia_read($expr.ast); }
	;
	
sentencia_if	returns[Sentencia_if ast]
	: 'if' '(' expr ')' '{' sentencias '}'	{ $ast = new Sentencia_if($expr.ast, $sentencias.ast); }
	;
	
sentencia_ifelse returns[Sentencia_ifelse ast]
	: 'if' '(' expr ')' '{' sentencias '}' 'else' '{' sentencias '}' { $ast = new Sentencia_ifelse($expr.ast, $ctx.sentencias(0).ast, $ctx.sentencias(1).ast); }
	;	
	


sentencia_while	returns[Sentencia_while ast]
	: 'while' '(' expr ')' '{' sentencias '}'	{ $ast = new Sentencia_while($expr.ast, $sentencias.ast); }
	;
	
sentencia_returnVacia returns[Sentencia_returnVacia ast]
	: 'return' ';'{ $ast = new Sentencia_returnVacia(); }
	;
	
sentencia_return returns[Sentencia_return ast]
	: 'return'(expr) ';'{ $ast = new Sentencia_return($expr.ast); }
	;

sentencia_expresion returns[Sentencia_expresion ast]
	: expr ';'	{ $ast = new Sentencia_expresion($expr.ast); }
	;
	
expr	returns[Expr ast]
	: INT_CONSTANT	{ $ast = new Expr_int($INT_CONSTANT); }
	| REAL_CONSTANT	{ $ast = new Expr_real($REAL_CONSTANT); }
	| CHAR_CONSTANT	{ $ast = new Expr_char($CHAR_CONSTANT); }
	| IDENT	{ $ast = new Expr_ident($IDENT); }
	| expr operador expr	{ $ast = new Expr_binaria($ctx.expr(0).ast, $operador.ast, $ctx.expr(1).ast); }
	| expr ('['expr']')	{ $ast = new Expr_vector($ctx.expr(0).ast, $ctx.expr(1).ast); }
	| expr '.' expr	{ $ast = new Expr_punto($ctx.expr(0).ast, $ctx.expr(1).ast); }
	| '(' expr ')'	{ $ast = new Expr_parentesis($expr.ast); }
	| 'cast' '<' tipo '>' '(' expr ')'	{ $ast = new Expr_cast($tipo.ast, $expr.ast); }
	| IDENT '(' parametros_llamada ')'	{ $ast = new Expr_llamada($IDENT, $parametros_llamada.ast); }
	;
	
parametros_llamada	returns[List<Expr> ast = new ArrayList<Expr>()]
	: (expr { $ast.add($ctx.expr(0).ast); } (',' expr{ $ast.add($ctx.expr(1).ast); })*)?
	;

	
operador returns[Operador ast]
	: op=('*'|'/')	{ $ast = new Operador($op.text); }
	| op=('+'|'-')	{ $ast = new Operador($op.text); }
	| op=('=='|'!=')	{ $ast = new Operador($op.text); }
	| op=('<'|'>'|'>='|'<=')	{ $ast = new Operador($op.text); }
	| op='&&'	{ $ast = new Operador($op.text); }
	| op='||'	{ $ast = new Operador($op.text); }
	;
