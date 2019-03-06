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
	: definicion_variables 	{ $ast = $definicion_variables.ast; }
	| struct 	{ $ast = $struct.ast; }
	| funcion 	{ $ast = $funcion.ast; }
	;
	
definicion_variables 	returns[Definicion_variables ast]
	:'var' IDENT ':' tipo ';'	{ $ast = new Definicion_variables($IDENT, $tipo.ast); }
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
	
tipo 	returns[Tipo ast]
	: 'int'	{ $ast = new TipoInt(); }
	| 'float' 	{ $ast = new TipoFloat(); }
	| 'char' 	{ $ast = new TipoChar(); }
	| IDENT 	{ $ast = new TipoVar($IDENT); }
	| array		{ $ast = $array.ast; }
	;
	
array returns[TipoArray ast]
	: '[' INT_CONSTANT ']' tipo	{ $ast = new TipoArray($INT_CONSTANT, $tipo.ast); }
	;


definiciones 	returns[List<Definicion_struct> ast = new ArrayList<Definicion_struct>()]
	: (definicion_struct 	{ $ast.add($definicion_struct.ast); })* 
	;
	
definicion_struct 	returns[Definicion_struct ast]
	: IDENT ':' tipo ';'	{ $ast = new Definicion_struct($IDENT, $tipo.ast); }
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
	: definicion_funcion	{ $ast = $definicion_funcion.ast; }
	| sentencia_asignacion	{ $ast = $sentencia_asignacion.ast; }
	| sentencia_print	{ $ast = $sentencia_print.ast; }
	| sentencia_read	{ $ast = $sentencia_read.ast; }
	| sentencia_if	{ $ast = $sentencia_if.ast; }
	| sentencia_while	{ $ast = $sentencia_while.ast; }
	| sentencia_return	{ $ast = $sentencia_return.ast; }
	| sentencia_expresion { $ast = $sentencia_expresion.ast; }
	;
	
definicion_funcion 	returns[Definicion_funcion ast]
	: 'var' IDENT ':' tipo ';'	{ $ast = new Definicion_funcion($IDENT, $tipo.ast); }
	;
	
	
sentencia_asignacion	returns[Sentencia_asignacion ast]
	: expr '=' expr ';'	{ $ast = new Sentencia_asignacion($ctx.expr(0).ast, $ctx.expr(1).ast); }
	;
	
sentencia_print	returns[Sentencia_print ast]
	: 'print' expr ';'	{ $ast = new Sentencia_print($expr.ast); }
	| 'printsp' expr ';'	{ $ast = new Sentencia_print($expr.ast); }
	| 'println' (expr) ';'	{ $ast = new Sentencia_print($expr.ast); }
	| 'println' ';' { $ast = new Sentencia_print(null); }
	;
	
sentencia_read	returns[Sentencia_read ast]
	: 'read' expr ';'	{ $ast = new Sentencia_read($expr.ast); }
	;
	

sentencia_if	returns[Sentencia_if ast]
	: 'if' '(' expr ')' '{' sentencias '}'	{ $ast = new Sentencia_if($expr.ast, $sentencias.ast, new ArrayList<Sentencia>()); }
	| 'if' '(' expr ')' '{' sentencias '}' 'else' '{' sentencias '}' { $ast = new Sentencia_if($expr.ast, $ctx.sentencias(0).ast, $ctx.sentencias(1).ast); }
	;	


sentencia_while	returns[Sentencia_while ast]
	: 'while' '(' expr ')' '{' sentencias '}'	{ $ast = new Sentencia_while($expr.ast, $sentencias.ast); }
	;
	
sentencia_return returns[Sentencia_return ast]
	: 'return'(expr) ';'{ $ast = new Sentencia_return($expr.ast); }
	| 'return' ';'{ $ast = new Sentencia_return(null); }
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
