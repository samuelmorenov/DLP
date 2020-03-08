grammar Grammar;
import Lexicon;

@parser::header {
    import ast.*;
}

//////////////////////	Programa			//////////////////////
start 					returns[Program ast]
	: definiciones EOF 	{ $ast = new Program($definiciones.ast); }
	;
	
definiciones 		returns[List<Definicion> ast = new ArrayList<Definicion>()]
	: (definicion	{ $ast.add($definicion.ast); })*
	;
	
definicion 							returns[Definicion ast]
	: definicion_variable_global 	{ $ast = $definicion_variable_global.ast; }
	| definicion_struct 			{ $ast = $definicion_struct.ast; }
	| definicion_funcion			{ $ast = $definicion_funcion.ast; }
	;
	
//////////////////////	Variables globales	//////////////////////
definicion_variable_global 			returns[Definicion_variable_global ast]
	: 'var' IDENT ':' tipo ';'		{ $ast = new Definicion_variable_global($IDENT, $tipo.ast); }
	;
	
//////////////////////	Struct				//////////////////////
definicion_struct 									returns[Definicion_struct ast]
	: 'struct' IDENT '{' campos_struct '}' ';'		{ $ast = new Definicion_struct($IDENT, $campos_struct.ast); }
	;
	
campos_struct		returns[List<Campo_struct> ast = new ArrayList<Campo_struct>()]
	:(campo_struct 	{ $ast.add($campo_struct.ast); })* 
	;	
	
campo_struct				returns[Campo_struct ast]
	: IDENT ':' tipo ';' 	{ $ast = new Campo_struct($IDENT, $tipo.ast); }
	;
	
//////////////////////	Funcion				//////////////////////
definicion_funcion 																returns[Definicion_funcion ast]
	: IDENT '(' parametros ')' retorno '{' variables_locales sentencias '}'		{ $ast = new Definicion_funcion($IDENT, $parametros.ast, $retorno.ast, $variables_locales.ast, $sentencias.ast); }
	;
	
parametros  			returns[List<Parametro> ast = new ArrayList<Parametro>()]
	: (parametro 		{ $ast.add($parametro.ast); }
	(',' parametro 		{ $ast.add($parametro.ast); }
	)*)?
	;
	
parametro  				returns[Parametro ast]
	: IDENT ':' tipo 	{ $ast = new Parametro($IDENT, $tipo.ast); }
	;
	
retorno 			returns[Tipo ast]
	: (':' tipo		{ $ast = $tipo.ast; })
	| 				{ $ast = new Tipo_Void(); }
	;
	
//////////////////////	Variables Locales	//////////////////////
variables_locales		returns[List<Variable_local> ast = new ArrayList<Variable_local>()]
	: (variable_local 	{ $ast.add($variable_local.ast); })*
	;	

variable_local					returns[Variable_local ast]
	:'var' IDENT ':' tipo ';'	{ $ast = new Variable_local($IDENT, $tipo.ast); }
	;
	
//////////////////////	Sentencias			//////////////////////
sentencias 			returns[List<Sentencia> ast = new ArrayList<Sentencia>()]
	: (sentencia	{ $ast.add($sentencia.ast); }	)*
	;	
		
sentencia 							returns[Sentencia ast]
	: sentencia_asignacion			{ $ast = $sentencia_asignacion.ast; }
	| sentencia_print				{ $ast = $sentencia_print.ast; }
	| sentencia_read				{ $ast = $sentencia_read.ast; }
	| sentencia_if					{ $ast = $sentencia_if.ast; }
	| sentencia_while				{ $ast = $sentencia_while.ast; }
	| sentencia_llamada_funcion 	{ $ast = $sentencia_llamada_funcion.ast; }
	| sentencia_return				{ $ast = $sentencia_return.ast; }
	;
	
sentencia_asignacion 		returns[Sentencia_asignacion ast]
	: expr '=' expr ';'		{ $ast = new Sentencia_asignacion($ctx.expr(0).ast, $ctx.expr(1).ast); }
	;
	
sentencia_print 			returns[Sentencia_print ast]
	: 'print' expr ';'		{ $ast = new Sentencia_print($expr.ast, ""); }
	| 'printsp' expr ';'	{ $ast = new Sentencia_print($expr.ast, "sp"); }
	| 'println' (expr) ';'	{ $ast = new Sentencia_print($expr.ast, "ln"); }
	| 'println' ';' 		{ $ast = new Sentencia_print(null, "\\n"); }
	;
	
sentencia_read 			returns[Sentencia_read ast]
	: 'read' expr ';'	{ $ast = new Sentencia_read($expr.ast); }
	;
	
sentencia_if 															returns[Sentencia_if ast]
	: 'if' '(' expr ')' '{' sentencias '}'								{ $ast = new Sentencia_if($expr.ast, $sentencias.ast, new ArrayList<Sentencia>()); }
	| 'if' '(' expr ')' '{' sentencias '}' 'else' '{' sentencias '}' 	{ $ast = new Sentencia_if($expr.ast, $ctx.sentencias(0).ast, $ctx.sentencias(1).ast); }
	;	

sentencia_while 								returns[Sentencia_while ast]
	: 'while' '(' expr ')' '{' sentencias '}'	{ $ast = new Sentencia_while($expr.ast, $sentencias.ast); }
	;
	
sentencia_llamada_funcion 					returns[Sentencia_llamada_funcion ast]
	: IDENT '(' parametros_llamada ')' ';' 	{ $ast = new Sentencia_llamada_funcion($IDENT, $parametros_llamada.ast); }
	;
	
sentencia_return 			returns[Sentencia_return ast]
	: 'return'(expr) ';'	{ $ast = new Sentencia_return($expr.ast); }
	| 'return' ';'			{ $ast = new Sentencia_return(null); }
	;
	
//////////////////////	Expresiones			//////////////////////
expr 										returns[Expr ast]
	: INT_CONSTANT							{ $ast = new Expr_int($INT_CONSTANT); }
	| REAL_CONSTANT							{ $ast = new Expr_real($REAL_CONSTANT); }
	| CHAR_CONSTANT							{ $ast = new Expr_char($CHAR_CONSTANT); }
	| IDENT									{ $ast = new Expr_ident($IDENT); }
	| '(' expr ')'							{ $ast = $expr.ast; }
	| '!' expr 								{ $ast = new Expr_negada(new Operador_logico("!"), $expr.ast);}
	| expr op=('*'|'/') expr				{ $ast = new Expr_binaria($ctx.expr(0).ast, new Operador_aritmetico($op.text), $ctx.expr(1).ast); }
	| expr op=('+'|'-') expr				{ $ast = new Expr_binaria($ctx.expr(0).ast, new Operador_aritmetico($op.text), $ctx.expr(1).ast); }
	| expr op=('=='|'!=') expr				{ $ast = new Expr_binaria($ctx.expr(0).ast, new Operador_comparacion($op.text), $ctx.expr(1).ast); }
	| expr op=('<'|'>'|'>='|'<=') expr		{ $ast = new Expr_binaria($ctx.expr(0).ast, new Operador_comparacion($op.text), $ctx.expr(1).ast); }
	| expr op='&&' expr						{ $ast = new Expr_binaria($ctx.expr(0).ast, new Operador_logico($op.text), $ctx.expr(1).ast); }
	| expr op='||' expr						{ $ast = new Expr_binaria($ctx.expr(0).ast, new Operador_logico($op.text), $ctx.expr(1).ast); }
	| 'cast' '<' tipo '>' '(' expr ')'		{ $ast = new Expr_cast($tipo.ast, $expr.ast); }
	| expr '['expr']'						{ $ast = new Expr_acceso_vector($ctx.expr(0).ast, $ctx.expr(1).ast); }
	| expr '.' expr							{ $ast = new Expr_acceso_struct($ctx.expr(0).ast, $ctx.expr(1).ast); }
	| IDENT '(' parametros_llamada ')'		{ $ast = new Expr_llamada_funcion($IDENT, $parametros_llamada.ast); }
	;
	
	
parametros_llamada		returns[List<Expr> ast = new ArrayList<Expr>()]
	: (expr 			{ int iterador = 0; $ast.add($ctx.expr(iterador).ast); } 
	  (',' expr			{ iterador++; $ast.add($ctx.expr(iterador).ast); }
	  )*)?
	;
	
//////////////////////	Tipo				//////////////////////
tipo								returns[Tipo ast]
	: 'int'							{ $ast = new Tipo_Int(); }
	| 'float'						{ $ast = new Tipo_Float(); }
	| 'char'						{ $ast = new Tipo_Char(); }
	| IDENT							{ $ast = new Tipo_Struct($IDENT); }
	| '[' INT_CONSTANT ']' tipo		{ $ast = new Tipo_Array($INT_CONSTANT, $tipo.ast); }
	;
