// Generated from src\parser\Grammar.g4 by ANTLR 4.7.2
package parser;

    import ast.*;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GrammarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, INT_CONSTANT=16, 
		REAL_CONSTANT=17, CHAR_CONSTANT=18, IDENT=19, LINE_COMMENT=20, MULTILINE_COMMENT=21, 
		WHITESPACE=22;
	public static final int
		RULE_start = 0, RULE_bloques = 1, RULE_bloque = 2, RULE_variable = 3, 
		RULE_definicion = 4, RULE_struct = 5, RULE_funcion = 6, RULE_retorno = 7, 
		RULE_lista = 8, RULE_tipo = 9, RULE_definiciones = 10, RULE_parametros = 11, 
		RULE_parametro = 12, RULE_sentencias = 13, RULE_sentencia = 14;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "bloques", "bloque", "variable", "definicion", "struct", "funcion", 
			"retorno", "lista", "tipo", "definiciones", "parametros", "parametro", 
			"sentencias", "sentencia"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'var'", "':'", "';'", "'struct'", "'{'", "'}'", "'('", "')'", 
			"'['", "']'", "'int'", "'float'", "'char'", "','", "'cuerpo;'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, "INT_CONSTANT", "REAL_CONSTANT", "CHAR_CONSTANT", 
			"IDENT", "LINE_COMMENT", "MULTILINE_COMMENT", "WHITESPACE"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Grammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public GrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class StartContext extends ParserRuleContext {
		public Program ast;
		public BloquesContext bloques;
		public BloquesContext bloques() {
			return getRuleContext(BloquesContext.class,0);
		}
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(30);
			((StartContext)_localctx).bloques = bloques();
			 ((StartContext)_localctx).ast =  new Program(((StartContext)_localctx).bloques.ast); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BloquesContext extends ParserRuleContext {
		public List<Bloque> ast = new ArrayList<Bloque>();
		public BloqueContext bloque;
		public TerminalNode EOF() { return getToken(GrammarParser.EOF, 0); }
		public List<BloqueContext> bloque() {
			return getRuleContexts(BloqueContext.class);
		}
		public BloqueContext bloque(int i) {
			return getRuleContext(BloqueContext.class,i);
		}
		public BloquesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bloques; }
	}

	public final BloquesContext bloques() throws RecognitionException {
		BloquesContext _localctx = new BloquesContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_bloques);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(38);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__3) | (1L << IDENT))) != 0)) {
				{
				{
				setState(33);
				((BloquesContext)_localctx).bloque = bloque();
				 _localctx.ast.add(((BloquesContext)_localctx).bloque.ast); 
				}
				}
				setState(40);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(41);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BloqueContext extends ParserRuleContext {
		public Bloque ast;
		public VariableContext variable;
		public StructContext struct;
		public FuncionContext funcion;
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public StructContext struct() {
			return getRuleContext(StructContext.class,0);
		}
		public FuncionContext funcion() {
			return getRuleContext(FuncionContext.class,0);
		}
		public BloqueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bloque; }
	}

	public final BloqueContext bloque() throws RecognitionException {
		BloqueContext _localctx = new BloqueContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_bloque);
		try {
			setState(52);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				enterOuterAlt(_localctx, 1);
				{
				setState(43);
				((BloqueContext)_localctx).variable = variable();
				 ((BloqueContext)_localctx).ast =  new Variable(((BloqueContext)_localctx).variable.ast.getNombre(), ((BloqueContext)_localctx).variable.ast.getEntero(), ((BloqueContext)_localctx).variable.ast.getTipo()); 
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 2);
				{
				setState(46);
				((BloqueContext)_localctx).struct = struct();
				 ((BloqueContext)_localctx).ast =  new Struct(((BloqueContext)_localctx).struct.ast.getNombre(), ((BloqueContext)_localctx).struct.ast.getDefinicion()); 
				}
				break;
			case IDENT:
				enterOuterAlt(_localctx, 3);
				{
				setState(49);
				((BloqueContext)_localctx).funcion = funcion();
				 ((BloqueContext)_localctx).ast =  new Funcion(((BloqueContext)_localctx).funcion.ast.getNombre(), ((BloqueContext)_localctx).funcion.ast.getParametros(), ((BloqueContext)_localctx).funcion.ast.getRetorno(), ((BloqueContext)_localctx).funcion.ast.getSentencia()); 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariableContext extends ParserRuleContext {
		public Variable ast;
		public Token IDENT;
		public ListaContext lista;
		public TipoContext tipo;
		public TerminalNode IDENT() { return getToken(GrammarParser.IDENT, 0); }
		public ListaContext lista() {
			return getRuleContext(ListaContext.class,0);
		}
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public VariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable; }
	}

	public final VariableContext variable() throws RecognitionException {
		VariableContext _localctx = new VariableContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_variable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(54);
			match(T__0);
			setState(55);
			((VariableContext)_localctx).IDENT = match(IDENT);
			setState(56);
			match(T__1);
			setState(57);
			((VariableContext)_localctx).lista = lista();
			setState(58);
			((VariableContext)_localctx).tipo = tipo();
			setState(59);
			match(T__2);
			 ((VariableContext)_localctx).ast =  new Variable(((VariableContext)_localctx).IDENT, ((VariableContext)_localctx).lista.ast, ((VariableContext)_localctx).tipo.ast); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DefinicionContext extends ParserRuleContext {
		public Definicion ast;
		public Token IDENT;
		public ListaContext lista;
		public TipoContext tipo;
		public TerminalNode IDENT() { return getToken(GrammarParser.IDENT, 0); }
		public ListaContext lista() {
			return getRuleContext(ListaContext.class,0);
		}
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public DefinicionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_definicion; }
	}

	public final DefinicionContext definicion() throws RecognitionException {
		DefinicionContext _localctx = new DefinicionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_definicion);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62);
			((DefinicionContext)_localctx).IDENT = match(IDENT);
			setState(63);
			match(T__1);
			setState(64);
			((DefinicionContext)_localctx).lista = lista();
			setState(65);
			((DefinicionContext)_localctx).tipo = tipo();
			setState(66);
			match(T__2);
			 ((DefinicionContext)_localctx).ast =  new Definicion(((DefinicionContext)_localctx).IDENT, ((DefinicionContext)_localctx).lista.ast, ((DefinicionContext)_localctx).tipo.ast); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StructContext extends ParserRuleContext {
		public Struct ast;
		public Token IDENT;
		public DefinicionesContext definiciones;
		public TerminalNode IDENT() { return getToken(GrammarParser.IDENT, 0); }
		public DefinicionesContext definiciones() {
			return getRuleContext(DefinicionesContext.class,0);
		}
		public StructContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_struct; }
	}

	public final StructContext struct() throws RecognitionException {
		StructContext _localctx = new StructContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_struct);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(69);
			match(T__3);
			setState(70);
			((StructContext)_localctx).IDENT = match(IDENT);
			setState(71);
			match(T__4);
			setState(72);
			((StructContext)_localctx).definiciones = definiciones();
			setState(73);
			match(T__5);
			setState(74);
			match(T__2);
			 ((StructContext)_localctx).ast =  new Struct(((StructContext)_localctx).IDENT, ((StructContext)_localctx).definiciones.ast); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FuncionContext extends ParserRuleContext {
		public Funcion ast;
		public Token IDENT;
		public ParametrosContext parametros;
		public RetornoContext retorno;
		public SentenciasContext sentencias;
		public TerminalNode IDENT() { return getToken(GrammarParser.IDENT, 0); }
		public ParametrosContext parametros() {
			return getRuleContext(ParametrosContext.class,0);
		}
		public RetornoContext retorno() {
			return getRuleContext(RetornoContext.class,0);
		}
		public SentenciasContext sentencias() {
			return getRuleContext(SentenciasContext.class,0);
		}
		public FuncionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcion; }
	}

	public final FuncionContext funcion() throws RecognitionException {
		FuncionContext _localctx = new FuncionContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_funcion);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(77);
			((FuncionContext)_localctx).IDENT = match(IDENT);
			setState(78);
			match(T__6);
			setState(79);
			((FuncionContext)_localctx).parametros = parametros();
			setState(80);
			match(T__7);
			setState(81);
			((FuncionContext)_localctx).retorno = retorno();
			setState(82);
			match(T__4);
			setState(83);
			((FuncionContext)_localctx).sentencias = sentencias();
			setState(84);
			match(T__5);
			 ((FuncionContext)_localctx).ast =  new Funcion(((FuncionContext)_localctx).IDENT, ((FuncionContext)_localctx).parametros.ast, ((FuncionContext)_localctx).retorno.ast, ((FuncionContext)_localctx).sentencias.ast); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RetornoContext extends ParserRuleContext {
		public List<Tipo> ast = new ArrayList<Tipo>();
		public TipoContext tipo;
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public RetornoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_retorno; }
	}

	public final RetornoContext retorno() throws RecognitionException {
		RetornoContext _localctx = new RetornoContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_retorno);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(91);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(87);
				match(T__1);
				setState(88);
				((RetornoContext)_localctx).tipo = tipo();
				 _localctx.ast.add(((RetornoContext)_localctx).tipo.ast); 
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ListaContext extends ParserRuleContext {
		public List<Entero> ast = new ArrayList<Entero>();
		public Token INT_CONSTANT;
		public List<TerminalNode> INT_CONSTANT() { return getTokens(GrammarParser.INT_CONSTANT); }
		public TerminalNode INT_CONSTANT(int i) {
			return getToken(GrammarParser.INT_CONSTANT, i);
		}
		public ListaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lista; }
	}

	public final ListaContext lista() throws RecognitionException {
		ListaContext _localctx = new ListaContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_lista);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(99);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__8) {
				{
				{
				setState(93);
				match(T__8);
				setState(94);
				((ListaContext)_localctx).INT_CONSTANT = match(INT_CONSTANT);
				setState(95);
				match(T__9);
				 _localctx.ast.add(new Entero(((ListaContext)_localctx).INT_CONSTANT)); 
				}
				}
				setState(101);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TipoContext extends ParserRuleContext {
		public Tipo ast;
		public Token IDENT;
		public TerminalNode IDENT() { return getToken(GrammarParser.IDENT, 0); }
		public TipoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipo; }
	}

	public final TipoContext tipo() throws RecognitionException {
		TipoContext _localctx = new TipoContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_tipo);
		try {
			setState(110);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__10:
				enterOuterAlt(_localctx, 1);
				{
				setState(102);
				match(T__10);
				 ((TipoContext)_localctx).ast =  new TipoInt(); 
				}
				break;
			case T__11:
				enterOuterAlt(_localctx, 2);
				{
				setState(104);
				match(T__11);
				 ((TipoContext)_localctx).ast =  new TipoFloat(); 
				}
				break;
			case T__12:
				enterOuterAlt(_localctx, 3);
				{
				setState(106);
				match(T__12);
				 ((TipoContext)_localctx).ast =  new TipoChar(); 
				}
				break;
			case IDENT:
				enterOuterAlt(_localctx, 4);
				{
				setState(108);
				((TipoContext)_localctx).IDENT = match(IDENT);
				 ((TipoContext)_localctx).ast =  new TipoVar(((TipoContext)_localctx).IDENT); 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DefinicionesContext extends ParserRuleContext {
		public List<Definicion> ast = new ArrayList<Definicion>();
		public DefinicionContext definicion;
		public List<DefinicionContext> definicion() {
			return getRuleContexts(DefinicionContext.class);
		}
		public DefinicionContext definicion(int i) {
			return getRuleContext(DefinicionContext.class,i);
		}
		public DefinicionesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_definiciones; }
	}

	public final DefinicionesContext definiciones() throws RecognitionException {
		DefinicionesContext _localctx = new DefinicionesContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_definiciones);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(117);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IDENT) {
				{
				{
				setState(112);
				((DefinicionesContext)_localctx).definicion = definicion();
				 _localctx.ast.add(((DefinicionesContext)_localctx).definicion.ast); 
				}
				}
				setState(119);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParametrosContext extends ParserRuleContext {
		public List<Parametro> ast = new ArrayList<Parametro>();
		public ParametroContext parametro;
		public List<ParametroContext> parametro() {
			return getRuleContexts(ParametroContext.class);
		}
		public ParametroContext parametro(int i) {
			return getRuleContext(ParametroContext.class,i);
		}
		public ParametrosContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parametros; }
	}

	public final ParametrosContext parametros() throws RecognitionException {
		ParametrosContext _localctx = new ParametrosContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_parametros);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(131);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENT) {
				{
				setState(120);
				((ParametrosContext)_localctx).parametro = parametro();
				 _localctx.ast.add(((ParametrosContext)_localctx).parametro.ast); 
				setState(128);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__13) {
					{
					{
					setState(122);
					match(T__13);
					setState(123);
					((ParametrosContext)_localctx).parametro = parametro();
					 _localctx.ast.add(((ParametrosContext)_localctx).parametro.ast); 
					}
					}
					setState(130);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParametroContext extends ParserRuleContext {
		public Parametro ast;
		public Token IDENT;
		public TipoContext tipo;
		public TerminalNode IDENT() { return getToken(GrammarParser.IDENT, 0); }
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public ParametroContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parametro; }
	}

	public final ParametroContext parametro() throws RecognitionException {
		ParametroContext _localctx = new ParametroContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_parametro);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(133);
			((ParametroContext)_localctx).IDENT = match(IDENT);
			setState(134);
			match(T__1);
			setState(135);
			((ParametroContext)_localctx).tipo = tipo();
			 ((ParametroContext)_localctx).ast =  new Parametro(((ParametroContext)_localctx).IDENT, ((ParametroContext)_localctx).tipo.ast); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SentenciasContext extends ParserRuleContext {
		public List<Sentencia> ast = new ArrayList<Sentencia>();
		public SentenciaContext sentencia;
		public List<SentenciaContext> sentencia() {
			return getRuleContexts(SentenciaContext.class);
		}
		public SentenciaContext sentencia(int i) {
			return getRuleContext(SentenciaContext.class,i);
		}
		public SentenciasContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sentencias; }
	}

	public final SentenciasContext sentencias() throws RecognitionException {
		SentenciasContext _localctx = new SentenciasContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_sentencias);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(143);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__14) {
				{
				{
				setState(138);
				((SentenciasContext)_localctx).sentencia = sentencia();
				 _localctx.ast.add(((SentenciasContext)_localctx).sentencia.ast); 
				}
				}
				setState(145);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SentenciaContext extends ParserRuleContext {
		public Sentencia ast;
		public SentenciaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sentencia; }
	}

	public final SentenciaContext sentencia() throws RecognitionException {
		SentenciaContext _localctx = new SentenciaContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_sentencia);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(146);
			match(T__14);
			 ((SentenciaContext)_localctx).ast =  new Sentencia("cuerpo"); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\30\u0098\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\3\2\3\2\3\2\3\3\3"+
		"\3\3\3\7\3\'\n\3\f\3\16\3*\13\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\5\4\67\n\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\t\3\t\3\t\3\t\5\t^\n\t\3\n\3\n\3\n\3\n\7\nd\n\n\f\n\16\n"+
		"g\13\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13q\n\13\3\f\3\f\3\f"+
		"\7\fv\n\f\f\f\16\fy\13\f\3\r\3\r\3\r\3\r\3\r\3\r\7\r\u0081\n\r\f\r\16"+
		"\r\u0084\13\r\5\r\u0086\n\r\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\7"+
		"\17\u0090\n\17\f\17\16\17\u0093\13\17\3\20\3\20\3\20\3\20\2\2\21\2\4\6"+
		"\b\n\f\16\20\22\24\26\30\32\34\36\2\2\2\u0094\2 \3\2\2\2\4(\3\2\2\2\6"+
		"\66\3\2\2\2\b8\3\2\2\2\n@\3\2\2\2\fG\3\2\2\2\16O\3\2\2\2\20]\3\2\2\2\22"+
		"e\3\2\2\2\24p\3\2\2\2\26w\3\2\2\2\30\u0085\3\2\2\2\32\u0087\3\2\2\2\34"+
		"\u0091\3\2\2\2\36\u0094\3\2\2\2 !\5\4\3\2!\"\b\2\1\2\"\3\3\2\2\2#$\5\6"+
		"\4\2$%\b\3\1\2%\'\3\2\2\2&#\3\2\2\2\'*\3\2\2\2(&\3\2\2\2()\3\2\2\2)+\3"+
		"\2\2\2*(\3\2\2\2+,\7\2\2\3,\5\3\2\2\2-.\5\b\5\2./\b\4\1\2/\67\3\2\2\2"+
		"\60\61\5\f\7\2\61\62\b\4\1\2\62\67\3\2\2\2\63\64\5\16\b\2\64\65\b\4\1"+
		"\2\65\67\3\2\2\2\66-\3\2\2\2\66\60\3\2\2\2\66\63\3\2\2\2\67\7\3\2\2\2"+
		"89\7\3\2\29:\7\25\2\2:;\7\4\2\2;<\5\22\n\2<=\5\24\13\2=>\7\5\2\2>?\b\5"+
		"\1\2?\t\3\2\2\2@A\7\25\2\2AB\7\4\2\2BC\5\22\n\2CD\5\24\13\2DE\7\5\2\2"+
		"EF\b\6\1\2F\13\3\2\2\2GH\7\6\2\2HI\7\25\2\2IJ\7\7\2\2JK\5\26\f\2KL\7\b"+
		"\2\2LM\7\5\2\2MN\b\7\1\2N\r\3\2\2\2OP\7\25\2\2PQ\7\t\2\2QR\5\30\r\2RS"+
		"\7\n\2\2ST\5\20\t\2TU\7\7\2\2UV\5\34\17\2VW\7\b\2\2WX\b\b\1\2X\17\3\2"+
		"\2\2YZ\7\4\2\2Z[\5\24\13\2[\\\b\t\1\2\\^\3\2\2\2]Y\3\2\2\2]^\3\2\2\2^"+
		"\21\3\2\2\2_`\7\13\2\2`a\7\22\2\2ab\7\f\2\2bd\b\n\1\2c_\3\2\2\2dg\3\2"+
		"\2\2ec\3\2\2\2ef\3\2\2\2f\23\3\2\2\2ge\3\2\2\2hi\7\r\2\2iq\b\13\1\2jk"+
		"\7\16\2\2kq\b\13\1\2lm\7\17\2\2mq\b\13\1\2no\7\25\2\2oq\b\13\1\2ph\3\2"+
		"\2\2pj\3\2\2\2pl\3\2\2\2pn\3\2\2\2q\25\3\2\2\2rs\5\n\6\2st\b\f\1\2tv\3"+
		"\2\2\2ur\3\2\2\2vy\3\2\2\2wu\3\2\2\2wx\3\2\2\2x\27\3\2\2\2yw\3\2\2\2z"+
		"{\5\32\16\2{\u0082\b\r\1\2|}\7\20\2\2}~\5\32\16\2~\177\b\r\1\2\177\u0081"+
		"\3\2\2\2\u0080|\3\2\2\2\u0081\u0084\3\2\2\2\u0082\u0080\3\2\2\2\u0082"+
		"\u0083\3\2\2\2\u0083\u0086\3\2\2\2\u0084\u0082\3\2\2\2\u0085z\3\2\2\2"+
		"\u0085\u0086\3\2\2\2\u0086\31\3\2\2\2\u0087\u0088\7\25\2\2\u0088\u0089"+
		"\7\4\2\2\u0089\u008a\5\24\13\2\u008a\u008b\b\16\1\2\u008b\33\3\2\2\2\u008c"+
		"\u008d\5\36\20\2\u008d\u008e\b\17\1\2\u008e\u0090\3\2\2\2\u008f\u008c"+
		"\3\2\2\2\u0090\u0093\3\2\2\2\u0091\u008f\3\2\2\2\u0091\u0092\3\2\2\2\u0092"+
		"\35\3\2\2\2\u0093\u0091\3\2\2\2\u0094\u0095\7\21\2\2\u0095\u0096\b\20"+
		"\1\2\u0096\37\3\2\2\2\13(\66]epw\u0082\u0085\u0091";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}