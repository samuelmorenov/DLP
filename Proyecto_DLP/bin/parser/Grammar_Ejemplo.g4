grammar Grammar
	;

import Lexicon
	;

@parser::header {
    import ast.*;
}

start returns[Program ast]
	: 'DATA' variables 'CODE' sentences EOF { $ast = new Program($variables.list, $sentences.list); }
	;

variables returns[List<VarDefinition> list = new ArrayList<VarDefinition>()]
	: (variable { $list.add($variable.ast); })*
	;

sentences returns[List<Sentence> list = new ArrayList<Sentence>()]
	: (sentence { $list.add($sentence.ast); })*
	;

tipo returns[Type ast]
	: 'float'	{  $ast = new RealType(); }
	| 'int'		{  $ast = new IntType(); }
	;

variable returns[VarDefinition ast]
	: tipo IDENT ';' { $ast = new VarDefinition($tipo.ast, $IDENT); }
	;

sentence returns[Sentence ast]
	: 'print' expr ';'	{ $ast = new Print($expr.ast); }
	| expr '=' expr ';'	{ $ast = new Assignment($ctx.expr(0), $ctx.expr(1)); }
	;

expr returns[Expression ast]
	: left=expr op=('*' | '/') right=expr	{ $ast = new ArithmeticExpression($left.ast, $op, $right.ast); }
	| expr op=('+' | '-') expr				{ $ast = new ArithmeticExpression($ctx.expr(0), $op, $ctx.expr(1)); }
	| '(' expr ')'							{ $ast = $expr.ast; }
	| IDENT									{ $ast = new Variable($IDENT); }
	| INT_CONSTANT							{ $ast = new IntConstant($INT_CONSTANT); }
	| REAL_CONSTANT							{ $ast = new RealConstant($REAL_CONSTANT); }
	;

