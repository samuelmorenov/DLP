grammar Grammar;
import Lexicon;

//////////////////////		Programa		//////////////////////
start
	: definiciones EOF
	;
	
definiciones
	: definicion*
	;
	
definicion
	: variable_global
	| struct
	| funcion
	;
	
//////////////////////	Variables globales	//////////////////////
variable_global
	: 'var' IDENT ':' tipo ';'
	;
	
//////////////////////		Struct			//////////////////////
struct
	: 'struct' IDENT '{' campos_struct '}' ';'
	;
	
campos_struct
	: campo_struct* 
	;	
	
campo_struct
	: IDENT ':' tipo ';'
	;
	
//////////////////////		Funcion			//////////////////////
funcion 
	: IDENT '(' parametros ')' retorno '{' variables_locales sentencias '}'
	;
	
parametros
	:(parametro (',' parametro)*)?
	;
	
parametro 
	: IDENT ':' tipo
	;
	
retorno
	: ':' tipo
	| 
	;
	
//////////////////////	Variables Locales	//////////////////////
variables_locales
	: variable_local*
	;	

variable_local
	:'var' IDENT ':' tipo ';'
	;
	
////////////// Sentencias //////////////
sentencias 
	: sentencia*
	;	
		
sentencia
	: sentencia_asignacion
	| sentencia_print
	| sentencia_read
	| sentencia_if
	| sentencia_while
	| sentencia_llamada_funcion
	| sentencia_return
	;
	
sentencia_asignacion
	: expr '=' expr ';'
	;
	
sentencia_print
	: 'print' expr ';'
	| 'printsp' expr ';'
	| 'println' (expr) ';'
	| 'println' ';'
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
	
sentencia_llamada_funcion
	: IDENT '(' parametros_llamada ')' ';' 
	;
	
sentencia_return
	: 'return'(expr) ';'
	| 'return' ';'
	;
	
//////////////////////		Expresiones		//////////////////////
expr
	: INT_CONSTANT
	| REAL_CONSTANT
	| CHAR_CONSTANT
	| IDENT
	| '(' expr ')'
	| expr '.' expr
	| '!' expr 
	| expr operador expr
	| expr ('['expr']')
	| 'cast' '<' tipo '>' '(' expr ')'
	| IDENT '(' parametros_llamada ')'
	;
	
parametros_llamada
	: (expr (',' expr)*)?
	;
	
//////////////////////	Operadores			//////////////////////
operador
	: op=('*'|'/')
	| op=('+'|'-')
	| op=('=='|'!=') 
	| op=('<'|'>'|'>='|'<=')
	| op='&&'
	| op='||'
	;
	
//////////////////////		Tipo			//////////////////////
	
tipo 
	: 'int'
	| 'float'
	| 'char'
	| IDENT
	| tipo_array
	;
	
tipo_array
	: '[' INT_CONSTANT ']' tipo
	;