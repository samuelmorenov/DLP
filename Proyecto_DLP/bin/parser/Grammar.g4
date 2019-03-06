grammar Grammar;
import Lexicon;

@parser::header {
    import ast.*;
}

start 															returns[List<Bloque> ast = new ArrayList<Bloque>()]
	: (bloque 													{ $ast.add($bloque.ast); })* EOF
	;
	
bloque 															returns[Bloque ast]
	: definicion_var 											{ $ast = new Definicion($definicion_var.ast); }
	| struct 													{ $ast = new Struct($struct.ast); }
	| funcion 													{ $ast = new Funcion($funcion.ast); }
	;
	
definicion_var 													returns[Definicion_var ast]
	:'var' definicion 											{ $ast = new Definicion_var($definicion.ast); }
	;
	
definicion 														returns[Definicion ast]
	: IDENT ':' vector tipo ';' 								{ $ast = new definicion($IDENT, $vector.ast, $tipo.ast); }
	;
	
vector 															returns[List<$INT_CONSTANT> ast = new ArrayList<$INT_CONSTANT>()]
	: ('[' INT_CONSTANT ']' 									{ $ast.add($INT_CONSTANT); })* 
	;
	
tipo 															returns[Tipo ast]
	: 'int'														{ $ast = new TipoInt(); }
	| 'float' 													{ $ast = new TipoFloat(); }
	| 'char' 													{ $ast = new TipoChar(); }
	| IDENT 													{ $ast = $IDENT; }
	;

struct 															returns[Struct ast]
	: 'struct' IDENT '{' definiciones '}' ';'					{ $ast = new Struct($IDENT, $definiciones.ast); }
	;

definiciones 													returns[List<Definicion> ast = new ArrayList<Definicion>()]
	: (definicion 												{ $ast.add($definicion.ast); })* 
	;
	
funcion 														returns[Funcion ast]
	: IDENT '(' parametros ')' (':' tipo) '{' sentencias '}' 	{ $ast = new Definicion($IDENT, $parametros.ast, $tipo.ast, $sentencias.ast); }
	| IDENT '(' parametros ')' '{' sentencias '}' 				{ $ast = new Definicion($IDENT, $parametros.ast, $sentencias.ast); }
	;

parametros 														returns[List<Parametro> ast = new ArrayList<Bloque>()]
	: (parametro { $ast.add($parametro.ast); } (',' parametro 	{ $ast.add($parametro.ast); })*)?
	;
	
parametro 														returns[Parametro ast]
	: IDENT ':' tipo 											{ $ast = new Parametro($IDENT, $tipo.ast); }
	;
	
	
sentencias 														returns[Sentencias ast]
	: 'cuerpo'													{ $ast = new Cuerpo(); }
	;
	
	
/*
	
sentencias
	: sentencia*
	;
	
sentencia
	: 'var' definicion
	| sentencia_asignacion
	| sentencia_print
	| sentencia_read
	| sentencia_if
	| sentencia_while
	| sentencia_return
	| expr ';'
	;
	
sentencia_asignacion
	: expr '=' expr ';'
	;
	
sentencia_print
	: 'print' expr ';'
	| 'printsp' expr ';'
	| 'println' expr? ';'
	;
	
sentencia_read
	: 'read' expr ';'
	;
	
sentencia_if
	: 'if' '(' expr ')' '{' sentencias '}' 
	| 'if' '(' expr ')' '{' sentencias '}' 'else' '{' sentencias '}'
	;

sentencia_while
	: 'while' '(' expr ')' '{' sentencias '}'
	;
	
	
sentencia_return
	: 'return' expr? ';'
	;
	
expr
	: constante
	| expr operador expr
	| expr ('['expr']')
	| expr '.' expr
	| '(' expr ')'
	| 'cast' '<' tipo '>' '(' expr ')'
	| IDENT '(' (expr (',' expr)*)? ')'
	;

constante
	: INT_CONSTANT
	| REAL_CONSTANT
	| IDENT
	| CHAR_CONSTANT
	;
	
operador
	: ('*'|'/')
	| ('+'|'-')
	| ('=='|'!=')
	| ('<'|'>'|'>='|'<=')
	| '&&'
	| '||'
	;
	
*/