grammar Grammar;
import Lexicon;

start
	: (variable | struct | funcion)* EOF;
	
variable
	: 'var' definicion;

definicion
	: IDENT ':' ('[' INT_CONSTANT ']')* (tipo|IDENT) ';';
	

tipo
	: 'int'
	| 'float'
	| 'char';

struct
	: 'struct' IDENT '{' definicion* '}' ';';
	
funcion
	: IDENT '(' parametros ')' salida '{' cuerpo '}';

parametros
	: (parametro (',' parametro)*)?;
	
parametro
	: IDENT ':' tipo; 
	
salida
	: (':' tipo)?;
	
cuerpo
	: variable* sentencia*;
	
sentencia
	: ('print'|'printsp') expr ';'
	| 'println' expr? ';'
	| ident_compuesto '=' expr ';'
	| 'if' '(' expr ')' '{' sentencia+ '}'
	| 'if' '(' expr ')' '{' sentencia+ '}' 'else' '{' sentencia+ '}'
	| 'while' '(' expr ')' '{' sentencia+ '}';
	
expr
	: INT_CONSTANT
	| REAL_CONSTANT
	| ident_compuesto
	| expr '+' expr
	| expr '!=' expr
	| '(' expr ')'
	| '<' tipo '>' '(' expr ')';
	
ident_compuesto
	: IDENT('.' IDENT)*;