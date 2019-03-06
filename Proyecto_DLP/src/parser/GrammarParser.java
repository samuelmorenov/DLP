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
		RULE_start = 0, RULE_bloque = 1, RULE_definicion_var = 2, RULE_definicion = 3, 
		RULE_vector = 4, RULE_tipo = 5, RULE_struct = 6, RULE_definiciones = 7, 
		RULE_funcion = 8, RULE_parametros = 9, RULE_parametro = 10, RULE_sentencias = 11;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "bloque", "definicion_var", "definicion", "vector", "tipo", 
			"struct", "definiciones", "funcion", "parametros", "parametro", "sentencias"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'var'", "':'", "';'", "'['", "']'", "'int'", "'float'", "'char'", 
			"'struct'", "'{'", "'}'", "'('", "')'", "','", "'cuerpo'"
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
		public List<Bloque> ast = new ArrayList<Bloque>();
		public BloqueContext bloque;
		public TerminalNode EOF() { return getToken(GrammarParser.EOF, 0); }
		public List<BloqueContext> bloque() {
			return getRuleContexts(BloqueContext.class);
		}
		public BloqueContext bloque(int i) {
			return getRuleContext(BloqueContext.class,i);
		}
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(29);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__8) | (1L << IDENT))) != 0)) {
				{
				{
				setState(24);
				((StartContext)_localctx).bloque = bloque();
				 _localctx.ast.add(((StartContext)_localctx).bloque.ast); 
				}
				}
				setState(31);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(32);
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
		public Definicion_varContext definicion_var;
		public StructContext struct;
		public FuncionContext funcion;
		public Definicion_varContext definicion_var() {
			return getRuleContext(Definicion_varContext.class,0);
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
		enterRule(_localctx, 2, RULE_bloque);
		try {
			setState(43);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				enterOuterAlt(_localctx, 1);
				{
				setState(34);
				((BloqueContext)_localctx).definicion_var = definicion_var();
				 ((BloqueContext)_localctx).ast =  new Definicion(((BloqueContext)_localctx).definicion_var.ast); 
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 2);
				{
				setState(37);
				((BloqueContext)_localctx).struct = struct();
				 ((BloqueContext)_localctx).ast =  new Struct(((BloqueContext)_localctx).struct.ast); 
				}
				break;
			case IDENT:
				enterOuterAlt(_localctx, 3);
				{
				setState(40);
				((BloqueContext)_localctx).funcion = funcion();
				 ((BloqueContext)_localctx).ast =  new Funcion(((BloqueContext)_localctx).funcion.ast); 
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

	public static class Definicion_varContext extends ParserRuleContext {
		public Definicion_var ast;
		public DefinicionContext definicion;
		public DefinicionContext definicion() {
			return getRuleContext(DefinicionContext.class,0);
		}
		public Definicion_varContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_definicion_var; }
	}

	public final Definicion_varContext definicion_var() throws RecognitionException {
		Definicion_varContext _localctx = new Definicion_varContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_definicion_var);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(45);
			match(T__0);
			setState(46);
			((Definicion_varContext)_localctx).definicion = definicion();
			 ((Definicion_varContext)_localctx).ast =  new Definicion_var(((Definicion_varContext)_localctx).definicion.ast); 
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
		public VectorContext vector;
		public TipoContext tipo;
		public TerminalNode IDENT() { return getToken(GrammarParser.IDENT, 0); }
		public VectorContext vector() {
			return getRuleContext(VectorContext.class,0);
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
		enterRule(_localctx, 6, RULE_definicion);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(49);
			((DefinicionContext)_localctx).IDENT = match(IDENT);
			setState(50);
			match(T__1);
			setState(51);
			((DefinicionContext)_localctx).vector = vector();
			setState(52);
			((DefinicionContext)_localctx).tipo = tipo();
			setState(53);
			match(T__2);
			 ((DefinicionContext)_localctx).ast =  new definicion(((DefinicionContext)_localctx).IDENT, ((DefinicionContext)_localctx).vector.ast, ((DefinicionContext)_localctx).tipo.ast); 
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

	public static class VectorContext extends ParserRuleContext {
		public List<$INT_CONSTANT> ast = new ArrayList<$INT_CONSTANT>();
		public Token INT_CONSTANT;
		public List<TerminalNode> INT_CONSTANT() { return getTokens(GrammarParser.INT_CONSTANT); }
		public TerminalNode INT_CONSTANT(int i) {
			return getToken(GrammarParser.INT_CONSTANT, i);
		}
		public VectorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vector; }
	}

	public final VectorContext vector() throws RecognitionException {
		VectorContext _localctx = new VectorContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_vector);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(56);
				match(T__3);
				setState(57);
				((VectorContext)_localctx).INT_CONSTANT = match(INT_CONSTANT);
				setState(58);
				match(T__4);
				 _localctx.ast.add(((VectorContext)_localctx).INT_CONSTANT); 
				}
				}
				setState(64);
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
		enterRule(_localctx, 10, RULE_tipo);
		try {
			setState(73);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
				enterOuterAlt(_localctx, 1);
				{
				setState(65);
				match(T__5);
				 ((TipoContext)_localctx).ast =  new TipoInt(); 
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 2);
				{
				setState(67);
				match(T__6);
				 ((TipoContext)_localctx).ast =  new TipoFloat(); 
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 3);
				{
				setState(69);
				match(T__7);
				 ((TipoContext)_localctx).ast =  new TipoChar(); 
				}
				break;
			case IDENT:
				enterOuterAlt(_localctx, 4);
				{
				setState(71);
				((TipoContext)_localctx).IDENT = match(IDENT);
				 ((TipoContext)_localctx).ast =  ((TipoContext)_localctx).IDENT; 
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
		enterRule(_localctx, 12, RULE_struct);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(75);
			match(T__8);
			setState(76);
			((StructContext)_localctx).IDENT = match(IDENT);
			setState(77);
			match(T__9);
			setState(78);
			((StructContext)_localctx).definiciones = definiciones();
			setState(79);
			match(T__10);
			setState(80);
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
		enterRule(_localctx, 14, RULE_definiciones);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(88);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IDENT) {
				{
				{
				setState(83);
				((DefinicionesContext)_localctx).definicion = definicion();
				 _localctx.ast.add(((DefinicionesContext)_localctx).definicion.ast); 
				}
				}
				setState(90);
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

	public static class FuncionContext extends ParserRuleContext {
		public Funcion ast;
		public Token IDENT;
		public ParametrosContext parametros;
		public TipoContext tipo;
		public SentenciasContext sentencias;
		public TerminalNode IDENT() { return getToken(GrammarParser.IDENT, 0); }
		public ParametrosContext parametros() {
			return getRuleContext(ParametrosContext.class,0);
		}
		public SentenciasContext sentencias() {
			return getRuleContext(SentenciasContext.class,0);
		}
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public FuncionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcion; }
	}

	public final FuncionContext funcion() throws RecognitionException {
		FuncionContext _localctx = new FuncionContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_funcion);
		try {
			setState(112);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(91);
				((FuncionContext)_localctx).IDENT = match(IDENT);
				setState(92);
				match(T__11);
				setState(93);
				((FuncionContext)_localctx).parametros = parametros();
				setState(94);
				match(T__12);
				{
				setState(95);
				match(T__1);
				setState(96);
				((FuncionContext)_localctx).tipo = tipo();
				}
				setState(98);
				match(T__9);
				setState(99);
				((FuncionContext)_localctx).sentencias = sentencias();
				setState(100);
				match(T__10);
				 ((FuncionContext)_localctx).ast =  new Definicion(((FuncionContext)_localctx).IDENT, ((FuncionContext)_localctx).parametros.ast, ((FuncionContext)_localctx).tipo.ast, ((FuncionContext)_localctx).sentencias.ast); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(103);
				((FuncionContext)_localctx).IDENT = match(IDENT);
				setState(104);
				match(T__11);
				setState(105);
				((FuncionContext)_localctx).parametros = parametros();
				setState(106);
				match(T__12);
				setState(107);
				match(T__9);
				setState(108);
				((FuncionContext)_localctx).sentencias = sentencias();
				setState(109);
				match(T__10);
				 ((FuncionContext)_localctx).ast =  new Definicion(((FuncionContext)_localctx).IDENT, ((FuncionContext)_localctx).parametros.ast, ((FuncionContext)_localctx).sentencias.ast); 
				}
				break;
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
		public List<Parametro> ast = new ArrayList<Bloque>();
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
		enterRule(_localctx, 18, RULE_parametros);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(125);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENT) {
				{
				setState(114);
				((ParametrosContext)_localctx).parametro = parametro();
				 _localctx.ast.add(((ParametrosContext)_localctx).parametro.ast); 
				setState(122);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__13) {
					{
					{
					setState(116);
					match(T__13);
					setState(117);
					((ParametrosContext)_localctx).parametro = parametro();
					 _localctx.ast.add(((ParametrosContext)_localctx).parametro.ast); 
					}
					}
					setState(124);
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
		enterRule(_localctx, 20, RULE_parametro);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(127);
			((ParametroContext)_localctx).IDENT = match(IDENT);
			setState(128);
			match(T__1);
			setState(129);
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
		public Sentencias ast;
		public SentenciasContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sentencias; }
	}

	public final SentenciasContext sentencias() throws RecognitionException {
		SentenciasContext _localctx = new SentenciasContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_sentencias);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(132);
			match(T__14);
			 ((SentenciasContext)_localctx).ast =  new Cuerpo(); 
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\30\u008a\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\3\2\3\2\3\2\7\2\36\n\2\f\2\16\2!\13\2\3\2\3\2\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3.\n\3\3\4\3\4\3\4\3\4\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\7\6?\n\6\f\6\16\6B\13\6\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\5\7L\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t"+
		"\3\t\7\tY\n\t\f\t\16\t\\\13\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\ns\n\n\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\7\13{\n\13\f\13\16\13~\13\13\5\13\u0080\n\13\3\f\3\f\3\f"+
		"\3\f\3\f\3\r\3\r\3\r\3\r\2\2\16\2\4\6\b\n\f\16\20\22\24\26\30\2\2\2\u0088"+
		"\2\37\3\2\2\2\4-\3\2\2\2\6/\3\2\2\2\b\63\3\2\2\2\n@\3\2\2\2\fK\3\2\2\2"+
		"\16M\3\2\2\2\20Z\3\2\2\2\22r\3\2\2\2\24\177\3\2\2\2\26\u0081\3\2\2\2\30"+
		"\u0086\3\2\2\2\32\33\5\4\3\2\33\34\b\2\1\2\34\36\3\2\2\2\35\32\3\2\2\2"+
		"\36!\3\2\2\2\37\35\3\2\2\2\37 \3\2\2\2 \"\3\2\2\2!\37\3\2\2\2\"#\7\2\2"+
		"\3#\3\3\2\2\2$%\5\6\4\2%&\b\3\1\2&.\3\2\2\2\'(\5\16\b\2()\b\3\1\2).\3"+
		"\2\2\2*+\5\22\n\2+,\b\3\1\2,.\3\2\2\2-$\3\2\2\2-\'\3\2\2\2-*\3\2\2\2."+
		"\5\3\2\2\2/\60\7\3\2\2\60\61\5\b\5\2\61\62\b\4\1\2\62\7\3\2\2\2\63\64"+
		"\7\25\2\2\64\65\7\4\2\2\65\66\5\n\6\2\66\67\5\f\7\2\678\7\5\2\289\b\5"+
		"\1\29\t\3\2\2\2:;\7\6\2\2;<\7\22\2\2<=\7\7\2\2=?\b\6\1\2>:\3\2\2\2?B\3"+
		"\2\2\2@>\3\2\2\2@A\3\2\2\2A\13\3\2\2\2B@\3\2\2\2CD\7\b\2\2DL\b\7\1\2E"+
		"F\7\t\2\2FL\b\7\1\2GH\7\n\2\2HL\b\7\1\2IJ\7\25\2\2JL\b\7\1\2KC\3\2\2\2"+
		"KE\3\2\2\2KG\3\2\2\2KI\3\2\2\2L\r\3\2\2\2MN\7\13\2\2NO\7\25\2\2OP\7\f"+
		"\2\2PQ\5\20\t\2QR\7\r\2\2RS\7\5\2\2ST\b\b\1\2T\17\3\2\2\2UV\5\b\5\2VW"+
		"\b\t\1\2WY\3\2\2\2XU\3\2\2\2Y\\\3\2\2\2ZX\3\2\2\2Z[\3\2\2\2[\21\3\2\2"+
		"\2\\Z\3\2\2\2]^\7\25\2\2^_\7\16\2\2_`\5\24\13\2`a\7\17\2\2ab\7\4\2\2b"+
		"c\5\f\7\2cd\3\2\2\2de\7\f\2\2ef\5\30\r\2fg\7\r\2\2gh\b\n\1\2hs\3\2\2\2"+
		"ij\7\25\2\2jk\7\16\2\2kl\5\24\13\2lm\7\17\2\2mn\7\f\2\2no\5\30\r\2op\7"+
		"\r\2\2pq\b\n\1\2qs\3\2\2\2r]\3\2\2\2ri\3\2\2\2s\23\3\2\2\2tu\5\26\f\2"+
		"u|\b\13\1\2vw\7\20\2\2wx\5\26\f\2xy\b\13\1\2y{\3\2\2\2zv\3\2\2\2{~\3\2"+
		"\2\2|z\3\2\2\2|}\3\2\2\2}\u0080\3\2\2\2~|\3\2\2\2\177t\3\2\2\2\177\u0080"+
		"\3\2\2\2\u0080\25\3\2\2\2\u0081\u0082\7\25\2\2\u0082\u0083\7\4\2\2\u0083"+
		"\u0084\5\f\7\2\u0084\u0085\b\f\1\2\u0085\27\3\2\2\2\u0086\u0087\7\21\2"+
		"\2\u0087\u0088\b\r\1\2\u0088\31\3\2\2\2\n\37-@KZr|\177";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}