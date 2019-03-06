lexer grammar Lexicon;

//Lexico:

//Constante entera
INT_CONSTANT
	: [0-9]+;
	
//Constante real: debe tener obligatoriamente algún digito decimal
REAL_CONSTANT
	: [0-9]+ '.' [0-9]+;



IDENT
	: [a-zA-Z_][a-zA-Z0-9_]*;





LINE_COMMENT:		'//' .*? '\n'	-> skip;
MULTILINE_COMMENT:	'/*' .*? '*/'	-> skip;

WHITESPACE: [ \t\r\n]+ -> skip;
