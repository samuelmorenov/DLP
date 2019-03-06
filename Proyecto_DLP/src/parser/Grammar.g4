grammar Grammar;
import Lexicon;

@parser::header {
    import ast.*;
}

start returns[Program ast]
	: bloques { $ast = new Program($bloques.ast); }
	;


bloques															returns[List<Bloque> ast = new ArrayList<Bloque>()]
	: (bloque 													{ $ast.add($bloque.ast); })* EOF
	;

	
bloque 															returns[Bloque ast]
	: variable 													{ $ast = new Variable($variable.ast.getNombre(), $variable.ast.getEntero(), $variable.ast.getTipo()); }
	| struct 													{ $ast = new Struct($struct.ast.getNombre(), $struct.ast.getDefinicion()); }
	| funcion 													{ $ast = new Funcion($funcion.ast.getNombre(), $funcion.ast.getParametros(), $funcion.ast.getRetorno(), $funcion.ast.getSentencia()); }
	;
	
variable 														returns[Variable ast]
	:'var' IDENT ':' lista tipo ';'								{ $ast = new Variable($IDENT, $lista.ast, $tipo.ast); }
	;
	
definicion 														returns[Definicion ast]
	: IDENT ':' lista tipo ';' 									{ $ast = new Definicion($IDENT, $lista.ast, $tipo.ast); }
	;
		
struct 															returns[Struct ast]
	: 'struct' IDENT '{' definiciones '}' ';'					{ $ast = new Struct($IDENT, $definiciones.ast); }
	;
	
funcion 														returns[Funcion ast]
	: IDENT '(' parametros ')' retorno '{' sentencias '}' 	{ $ast = new Funcion($IDENT, $parametros.ast, $retorno.ast, $sentencias.ast); }
	;
	
retorno															returns[List<Tipo> ast = new ArrayList<Tipo>()]
	: (':' tipo 												{ $ast.add($tipo.ast); })?
	;
	
lista 															returns[List<Entero> ast = new ArrayList<Entero>()]
	: ('[' INT_CONSTANT ']' 									{ $ast.add(new Entero($INT_CONSTANT)); })* 
	;
	
tipo 															returns[Tipo ast]
	: 'int'														{ $ast = new TipoInt(); }
	| 'float' 													{ $ast = new TipoFloat(); }
	| 'char' 													{ $ast = new TipoChar(); }
	| IDENT 													{ $ast = new TipoVar($IDENT); }
	;


definiciones 													returns[List<Definicion> ast = new ArrayList<Definicion>()]
	: (definicion 												{ $ast.add($definicion.ast); })* 
	;
	

parametros 														returns[List<Parametro> ast = new ArrayList<Parametro>()]
	: (parametro { $ast.add($parametro.ast); } (',' parametro 	{ $ast.add($parametro.ast); })*)?
	//:(parametro (',' parametro)*)?
	;
	
parametro 														returns[Parametro ast]
	: IDENT ':' tipo 											{ $ast = new Parametro($IDENT, $tipo.ast); }
	;

sentencias														returns[List<Sentencia> ast = new ArrayList<Sentencia>()]
	: (sentencia												{ $ast.add($sentencia.ast); }	)*
	;	

sentencia 														returns[Sentencia ast]
	: 'cuerpo;'													{ $ast = new Sentencia("cuerpo"); }
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