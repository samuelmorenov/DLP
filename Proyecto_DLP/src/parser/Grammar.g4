grammar Grammar;
import Lexicon;

@parser::header {
    import ast.*;
}

start returns[List<Bloque> list = new ArrayList<Bloque>()]
	: (bloque { $list.add($bloque.ast); })* EOF
	;
	
bloque returns[Bloque ast]
	: 'var' definicion { $ast = new Definicion($definicion.ast); }
	| struct { $ast = new Struct($struct.ast); }
	| funcion { $ast = new Funcion($funcion.ast); }
	;
	
definicion returns[Definicion ast]
	: IDENT ':' vector tipo ';' { $ast = new definicion($IDENT, $vector.list, $tipo.ast); }
	;
	
vector returns[List<$IDENT> list = new ArrayList<$IDENT>()]
	: ('[' INT_CONSTANT ']' { $list.add($IDENT); })* 
	;
	
tipo returns[Tipo ast]
	: 'int' {  $ast = new TipoInt(); }
	| 'float' {  $ast = new TipoFloat(); }
	| 'char' {  $ast = new TipoChar(); }
	| IDENT
	;

struct
	: 'struct' IDENT '{' definiciones '}' ';'
	;

definiciones
	: definicion*
	;
	
funcion
	: IDENT '(' parametros ')' (':' tipo)? '{' sentencias '}'
	;

parametros
	: (IDENT ':' tipo;  (',' IDENT ':' tipo; )*)?
	;
	
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