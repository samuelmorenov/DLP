grammar Grammar;
import Lexicon;

start
	: bloque* EOF
	;
	
bloque
	: 'var' definicion
	| struct
	| funcion
	;
	
definicion
	: IDENT ':' ('[' INT_CONSTANT ']')* tipo ';'
	;
	
tipo
	: 'int'
	| 'float'
	| 'char'
	|IDENT
	;

struct
	: 'struct' IDENT '{' definicion* '}' ';'
	;
	
funcion
	: IDENT '(' parametros ')' retorno '{' sentencia* '}'
	;
	
llamada_funcion
	: IDENT '(' parametros ')'
	;
	

parametros
	: (parametro (',' parametro)*)?
	;
	
parametro
	: IDENT ':' tipo; 
	
retorno
	: (':' tipo)?
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
	: expr '=' expr ';'//IDENT('.' IDENT)* '=' expr ';'
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
	: 'if' '(' expr ')' '{' sentencia+ '}' 
	| 'if' '(' expr ')' '{' sentencia+ '}' 'else' '{' sentencia+ '}'
	;

sentencia_while
	: 'while' '(' expr ')' '{' sentencia+ '}'
	;
	
	
sentencia_return
	: 'return' expr? ';'
	;
	
expr
	: token
	| expr operador expr
	| expr ('['expr']')+
	| expr '.' expr
	| '(' expr ')'
	| 'cast' '<' tipo '>' '(' expr ')'
	| IDENT '(' (expr (',' expr)*)? ')'
	;

token
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