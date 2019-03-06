// Generated from src\parser\Grammar.g4 by ANTLR 4.7.2
package parser;
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
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, INT_CONSTANT=38, 
		REAL_CONSTANT=39, CHAR_CONSTANT=40, IDENT=41, LINE_COMMENT=42, MULTILINE_COMMENT=43, 
		WHITESPACE=44;
	public static final int
		RULE_start = 0, RULE_bloque = 1, RULE_definicion = 2, RULE_tipo = 3, RULE_struct = 4, 
		RULE_funcion = 5, RULE_llamada_funcion = 6, RULE_parametros = 7, RULE_parametro = 8, 
		RULE_retorno = 9, RULE_sentencia = 10, RULE_sentencia_asignacion = 11, 
		RULE_sentencia_print = 12, RULE_sentencia_read = 13, RULE_sentencia_if = 14, 
		RULE_sentencia_while = 15, RULE_sentencia_return = 16, RULE_expr = 17, 
		RULE_token = 18, RULE_operador = 19;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "bloque", "definicion", "tipo", "struct", "funcion", "llamada_funcion", 
			"parametros", "parametro", "retorno", "sentencia", "sentencia_asignacion", 
			"sentencia_print", "sentencia_read", "sentencia_if", "sentencia_while", 
			"sentencia_return", "expr", "token", "operador"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'var'", "':'", "'['", "']'", "';'", "'int'", "'float'", "'char'", 
			"'struct'", "'{'", "'}'", "'('", "')'", "','", "'='", "'print'", "'printsp'", 
			"'println'", "'read'", "'if'", "'else'", "'while'", "'return'", "'.'", 
			"'cast'", "'<'", "'>'", "'*'", "'/'", "'+'", "'-'", "'=='", "'!='", "'>='", 
			"'<='", "'&&'", "'||'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, "INT_CONSTANT", "REAL_CONSTANT", "CHAR_CONSTANT", "IDENT", 
			"LINE_COMMENT", "MULTILINE_COMMENT", "WHITESPACE"
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
			setState(43);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__8) | (1L << IDENT))) != 0)) {
				{
				{
				setState(40);
				bloque();
				}
				}
				setState(45);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(46);
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
		public DefinicionContext definicion() {
			return getRuleContext(DefinicionContext.class,0);
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
			setState(52);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				enterOuterAlt(_localctx, 1);
				{
				setState(48);
				match(T__0);
				setState(49);
				definicion();
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 2);
				{
				setState(50);
				struct();
				}
				break;
			case IDENT:
				enterOuterAlt(_localctx, 3);
				{
				setState(51);
				funcion();
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

	public static class DefinicionContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(GrammarParser.IDENT, 0); }
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public List<TerminalNode> INT_CONSTANT() { return getTokens(GrammarParser.INT_CONSTANT); }
		public TerminalNode INT_CONSTANT(int i) {
			return getToken(GrammarParser.INT_CONSTANT, i);
		}
		public DefinicionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_definicion; }
	}

	public final DefinicionContext definicion() throws RecognitionException {
		DefinicionContext _localctx = new DefinicionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_definicion);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(54);
			match(IDENT);
			setState(55);
			match(T__1);
			setState(61);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(56);
				match(T__2);
				setState(57);
				match(INT_CONSTANT);
				setState(58);
				match(T__3);
				}
				}
				setState(63);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(64);
			tipo();
			setState(65);
			match(T__4);
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
		public TerminalNode IDENT() { return getToken(GrammarParser.IDENT, 0); }
		public TipoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipo; }
	}

	public final TipoContext tipo() throws RecognitionException {
		TipoContext _localctx = new TipoContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_tipo);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(67);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << IDENT))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static class StructContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(GrammarParser.IDENT, 0); }
		public List<DefinicionContext> definicion() {
			return getRuleContexts(DefinicionContext.class);
		}
		public DefinicionContext definicion(int i) {
			return getRuleContext(DefinicionContext.class,i);
		}
		public StructContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_struct; }
	}

	public final StructContext struct() throws RecognitionException {
		StructContext _localctx = new StructContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_struct);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(69);
			match(T__8);
			setState(70);
			match(IDENT);
			setState(71);
			match(T__9);
			setState(75);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IDENT) {
				{
				{
				setState(72);
				definicion();
				}
				}
				setState(77);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(78);
			match(T__10);
			setState(79);
			match(T__4);
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
		public TerminalNode IDENT() { return getToken(GrammarParser.IDENT, 0); }
		public ParametrosContext parametros() {
			return getRuleContext(ParametrosContext.class,0);
		}
		public RetornoContext retorno() {
			return getRuleContext(RetornoContext.class,0);
		}
		public List<SentenciaContext> sentencia() {
			return getRuleContexts(SentenciaContext.class);
		}
		public SentenciaContext sentencia(int i) {
			return getRuleContext(SentenciaContext.class,i);
		}
		public FuncionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcion; }
	}

	public final FuncionContext funcion() throws RecognitionException {
		FuncionContext _localctx = new FuncionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_funcion);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(81);
			match(IDENT);
			setState(82);
			match(T__11);
			setState(83);
			parametros();
			setState(84);
			match(T__12);
			setState(85);
			retorno();
			setState(86);
			match(T__9);
			setState(90);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__11) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__21) | (1L << T__22) | (1L << T__24) | (1L << INT_CONSTANT) | (1L << REAL_CONSTANT) | (1L << CHAR_CONSTANT) | (1L << IDENT))) != 0)) {
				{
				{
				setState(87);
				sentencia();
				}
				}
				setState(92);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(93);
			match(T__10);
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

	public static class Llamada_funcionContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(GrammarParser.IDENT, 0); }
		public ParametrosContext parametros() {
			return getRuleContext(ParametrosContext.class,0);
		}
		public Llamada_funcionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_llamada_funcion; }
	}

	public final Llamada_funcionContext llamada_funcion() throws RecognitionException {
		Llamada_funcionContext _localctx = new Llamada_funcionContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_llamada_funcion);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(95);
			match(IDENT);
			setState(96);
			match(T__11);
			setState(97);
			parametros();
			setState(98);
			match(T__12);
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
		enterRule(_localctx, 14, RULE_parametros);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(108);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENT) {
				{
				setState(100);
				parametro();
				setState(105);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__13) {
					{
					{
					setState(101);
					match(T__13);
					setState(102);
					parametro();
					}
					}
					setState(107);
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
		enterRule(_localctx, 16, RULE_parametro);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(110);
			match(IDENT);
			setState(111);
			match(T__1);
			setState(112);
			tipo();
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
		enterRule(_localctx, 18, RULE_retorno);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(116);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(114);
				match(T__1);
				setState(115);
				tipo();
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

	public static class SentenciaContext extends ParserRuleContext {
		public DefinicionContext definicion() {
			return getRuleContext(DefinicionContext.class,0);
		}
		public Sentencia_asignacionContext sentencia_asignacion() {
			return getRuleContext(Sentencia_asignacionContext.class,0);
		}
		public Sentencia_printContext sentencia_print() {
			return getRuleContext(Sentencia_printContext.class,0);
		}
		public Sentencia_readContext sentencia_read() {
			return getRuleContext(Sentencia_readContext.class,0);
		}
		public Sentencia_ifContext sentencia_if() {
			return getRuleContext(Sentencia_ifContext.class,0);
		}
		public Sentencia_whileContext sentencia_while() {
			return getRuleContext(Sentencia_whileContext.class,0);
		}
		public Sentencia_returnContext sentencia_return() {
			return getRuleContext(Sentencia_returnContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public SentenciaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sentencia; }
	}

	public final SentenciaContext sentencia() throws RecognitionException {
		SentenciaContext _localctx = new SentenciaContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_sentencia);
		try {
			setState(129);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(118);
				match(T__0);
				setState(119);
				definicion();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(120);
				sentencia_asignacion();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(121);
				sentencia_print();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(122);
				sentencia_read();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(123);
				sentencia_if();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(124);
				sentencia_while();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(125);
				sentencia_return();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(126);
				expr(0);
				setState(127);
				match(T__4);
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

	public static class Sentencia_asignacionContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public Sentencia_asignacionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sentencia_asignacion; }
	}

	public final Sentencia_asignacionContext sentencia_asignacion() throws RecognitionException {
		Sentencia_asignacionContext _localctx = new Sentencia_asignacionContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_sentencia_asignacion);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(131);
			expr(0);
			setState(132);
			match(T__14);
			setState(133);
			expr(0);
			setState(134);
			match(T__4);
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

	public static class Sentencia_printContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Sentencia_printContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sentencia_print; }
	}

	public final Sentencia_printContext sentencia_print() throws RecognitionException {
		Sentencia_printContext _localctx = new Sentencia_printContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_sentencia_print);
		int _la;
		try {
			setState(149);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__15:
				enterOuterAlt(_localctx, 1);
				{
				setState(136);
				match(T__15);
				setState(137);
				expr(0);
				setState(138);
				match(T__4);
				}
				break;
			case T__16:
				enterOuterAlt(_localctx, 2);
				{
				setState(140);
				match(T__16);
				setState(141);
				expr(0);
				setState(142);
				match(T__4);
				}
				break;
			case T__17:
				enterOuterAlt(_localctx, 3);
				{
				setState(144);
				match(T__17);
				setState(146);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__11) | (1L << T__24) | (1L << INT_CONSTANT) | (1L << REAL_CONSTANT) | (1L << CHAR_CONSTANT) | (1L << IDENT))) != 0)) {
					{
					setState(145);
					expr(0);
					}
				}

				setState(148);
				match(T__4);
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

	public static class Sentencia_readContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Sentencia_readContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sentencia_read; }
	}

	public final Sentencia_readContext sentencia_read() throws RecognitionException {
		Sentencia_readContext _localctx = new Sentencia_readContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_sentencia_read);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(151);
			match(T__18);
			setState(152);
			expr(0);
			setState(153);
			match(T__4);
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

	public static class Sentencia_ifContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<SentenciaContext> sentencia() {
			return getRuleContexts(SentenciaContext.class);
		}
		public SentenciaContext sentencia(int i) {
			return getRuleContext(SentenciaContext.class,i);
		}
		public Sentencia_ifContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sentencia_if; }
	}

	public final Sentencia_ifContext sentencia_if() throws RecognitionException {
		Sentencia_ifContext _localctx = new Sentencia_ifContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_sentencia_if);
		int _la;
		try {
			setState(187);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(155);
				match(T__19);
				setState(156);
				match(T__11);
				setState(157);
				expr(0);
				setState(158);
				match(T__12);
				setState(159);
				match(T__9);
				setState(161); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(160);
					sentencia();
					}
					}
					setState(163); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__11) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__21) | (1L << T__22) | (1L << T__24) | (1L << INT_CONSTANT) | (1L << REAL_CONSTANT) | (1L << CHAR_CONSTANT) | (1L << IDENT))) != 0) );
				setState(165);
				match(T__10);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(167);
				match(T__19);
				setState(168);
				match(T__11);
				setState(169);
				expr(0);
				setState(170);
				match(T__12);
				setState(171);
				match(T__9);
				setState(173); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(172);
					sentencia();
					}
					}
					setState(175); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__11) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__21) | (1L << T__22) | (1L << T__24) | (1L << INT_CONSTANT) | (1L << REAL_CONSTANT) | (1L << CHAR_CONSTANT) | (1L << IDENT))) != 0) );
				setState(177);
				match(T__10);
				setState(178);
				match(T__20);
				setState(179);
				match(T__9);
				setState(181); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(180);
					sentencia();
					}
					}
					setState(183); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__11) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__21) | (1L << T__22) | (1L << T__24) | (1L << INT_CONSTANT) | (1L << REAL_CONSTANT) | (1L << CHAR_CONSTANT) | (1L << IDENT))) != 0) );
				setState(185);
				match(T__10);
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

	public static class Sentencia_whileContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<SentenciaContext> sentencia() {
			return getRuleContexts(SentenciaContext.class);
		}
		public SentenciaContext sentencia(int i) {
			return getRuleContext(SentenciaContext.class,i);
		}
		public Sentencia_whileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sentencia_while; }
	}

	public final Sentencia_whileContext sentencia_while() throws RecognitionException {
		Sentencia_whileContext _localctx = new Sentencia_whileContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_sentencia_while);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(189);
			match(T__21);
			setState(190);
			match(T__11);
			setState(191);
			expr(0);
			setState(192);
			match(T__12);
			setState(193);
			match(T__9);
			setState(195); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(194);
				sentencia();
				}
				}
				setState(197); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__11) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__21) | (1L << T__22) | (1L << T__24) | (1L << INT_CONSTANT) | (1L << REAL_CONSTANT) | (1L << CHAR_CONSTANT) | (1L << IDENT))) != 0) );
			setState(199);
			match(T__10);
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

	public static class Sentencia_returnContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Sentencia_returnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sentencia_return; }
	}

	public final Sentencia_returnContext sentencia_return() throws RecognitionException {
		Sentencia_returnContext _localctx = new Sentencia_returnContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_sentencia_return);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(201);
			match(T__22);
			setState(203);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__11) | (1L << T__24) | (1L << INT_CONSTANT) | (1L << REAL_CONSTANT) | (1L << CHAR_CONSTANT) | (1L << IDENT))) != 0)) {
				{
				setState(202);
				expr(0);
				}
			}

			setState(205);
			match(T__4);
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

	public static class ExprContext extends ParserRuleContext {
		public TokenContext token() {
			return getRuleContext(TokenContext.class,0);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public TerminalNode IDENT() { return getToken(GrammarParser.IDENT, 0); }
		public OperadorContext operador() {
			return getRuleContext(OperadorContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 34;
		enterRecursionRule(_localctx, 34, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(234);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				{
				setState(208);
				token();
				}
				break;
			case 2:
				{
				setState(209);
				match(T__11);
				setState(210);
				expr(0);
				setState(211);
				match(T__12);
				}
				break;
			case 3:
				{
				setState(213);
				match(T__24);
				setState(214);
				match(T__25);
				setState(215);
				tipo();
				setState(216);
				match(T__26);
				setState(217);
				match(T__11);
				setState(218);
				expr(0);
				setState(219);
				match(T__12);
				}
				break;
			case 4:
				{
				setState(221);
				match(IDENT);
				setState(222);
				match(T__11);
				setState(231);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__11) | (1L << T__24) | (1L << INT_CONSTANT) | (1L << REAL_CONSTANT) | (1L << CHAR_CONSTANT) | (1L << IDENT))) != 0)) {
					{
					setState(223);
					expr(0);
					setState(228);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__13) {
						{
						{
						setState(224);
						match(T__13);
						setState(225);
						expr(0);
						}
						}
						setState(230);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(233);
				match(T__12);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(254);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(252);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(236);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(237);
						operador();
						setState(238);
						expr(7);
						}
						break;
					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(240);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(241);
						match(T__23);
						setState(242);
						expr(5);
						}
						break;
					case 3:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(243);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(248); 
						_errHandler.sync(this);
						_alt = 1;
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(244);
								match(T__2);
								setState(245);
								expr(0);
								setState(246);
								match(T__3);
								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(250); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
						} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
						}
						break;
					}
					} 
				}
				setState(256);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class TokenContext extends ParserRuleContext {
		public TerminalNode INT_CONSTANT() { return getToken(GrammarParser.INT_CONSTANT, 0); }
		public TerminalNode REAL_CONSTANT() { return getToken(GrammarParser.REAL_CONSTANT, 0); }
		public TerminalNode IDENT() { return getToken(GrammarParser.IDENT, 0); }
		public TerminalNode CHAR_CONSTANT() { return getToken(GrammarParser.CHAR_CONSTANT, 0); }
		public TokenContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_token; }
	}

	public final TokenContext token() throws RecognitionException {
		TokenContext _localctx = new TokenContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_token);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(257);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT_CONSTANT) | (1L << REAL_CONSTANT) | (1L << CHAR_CONSTANT) | (1L << IDENT))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static class OperadorContext extends ParserRuleContext {
		public OperadorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operador; }
	}

	public final OperadorContext operador() throws RecognitionException {
		OperadorContext _localctx = new OperadorContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_operador);
		int _la;
		try {
			setState(265);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__27:
			case T__28:
				enterOuterAlt(_localctx, 1);
				{
				setState(259);
				_la = _input.LA(1);
				if ( !(_la==T__27 || _la==T__28) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case T__29:
			case T__30:
				enterOuterAlt(_localctx, 2);
				{
				setState(260);
				_la = _input.LA(1);
				if ( !(_la==T__29 || _la==T__30) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case T__31:
			case T__32:
				enterOuterAlt(_localctx, 3);
				{
				setState(261);
				_la = _input.LA(1);
				if ( !(_la==T__31 || _la==T__32) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case T__25:
			case T__26:
			case T__33:
			case T__34:
				enterOuterAlt(_localctx, 4);
				{
				setState(262);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__25) | (1L << T__26) | (1L << T__33) | (1L << T__34))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case T__35:
				enterOuterAlt(_localctx, 5);
				{
				setState(263);
				match(T__35);
				}
				break;
			case T__36:
				enterOuterAlt(_localctx, 6);
				{
				setState(264);
				match(T__36);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 17:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 6);
		case 1:
			return precpred(_ctx, 4);
		case 2:
			return precpred(_ctx, 5);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3.\u010e\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\3\2\7\2,\n\2\f\2\16\2/\13\2\3\2\3\2\3\3"+
		"\3\3\3\3\3\3\5\3\67\n\3\3\4\3\4\3\4\3\4\3\4\7\4>\n\4\f\4\16\4A\13\4\3"+
		"\4\3\4\3\4\3\5\3\5\3\6\3\6\3\6\3\6\7\6L\n\6\f\6\16\6O\13\6\3\6\3\6\3\6"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\7\7[\n\7\f\7\16\7^\13\7\3\7\3\7\3\b\3\b\3"+
		"\b\3\b\3\b\3\t\3\t\3\t\7\tj\n\t\f\t\16\tm\13\t\5\to\n\t\3\n\3\n\3\n\3"+
		"\n\3\13\3\13\5\13w\n\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5"+
		"\f\u0084\n\f\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\3\16\3\16\5\16\u0095\n\16\3\16\5\16\u0098\n\16\3\17\3\17\3\17\3\17"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\6\20\u00a4\n\20\r\20\16\20\u00a5\3\20\3"+
		"\20\3\20\3\20\3\20\3\20\3\20\3\20\6\20\u00b0\n\20\r\20\16\20\u00b1\3\20"+
		"\3\20\3\20\3\20\6\20\u00b8\n\20\r\20\16\20\u00b9\3\20\3\20\5\20\u00be"+
		"\n\20\3\21\3\21\3\21\3\21\3\21\3\21\6\21\u00c6\n\21\r\21\16\21\u00c7\3"+
		"\21\3\21\3\22\3\22\5\22\u00ce\n\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\7\23\u00e5\n\23\f\23\16\23\u00e8\13\23\5\23\u00ea\n\23\3\23\5\23\u00ed"+
		"\n\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\6\23"+
		"\u00fb\n\23\r\23\16\23\u00fc\7\23\u00ff\n\23\f\23\16\23\u0102\13\23\3"+
		"\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\5\25\u010c\n\25\3\25\2\3$\26\2"+
		"\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(\2\b\4\2\b\n++\3\2(+\3\2\36"+
		"\37\3\2 !\3\2\"#\4\2\34\35$%\2\u0120\2-\3\2\2\2\4\66\3\2\2\2\68\3\2\2"+
		"\2\bE\3\2\2\2\nG\3\2\2\2\fS\3\2\2\2\16a\3\2\2\2\20n\3\2\2\2\22p\3\2\2"+
		"\2\24v\3\2\2\2\26\u0083\3\2\2\2\30\u0085\3\2\2\2\32\u0097\3\2\2\2\34\u0099"+
		"\3\2\2\2\36\u00bd\3\2\2\2 \u00bf\3\2\2\2\"\u00cb\3\2\2\2$\u00ec\3\2\2"+
		"\2&\u0103\3\2\2\2(\u010b\3\2\2\2*,\5\4\3\2+*\3\2\2\2,/\3\2\2\2-+\3\2\2"+
		"\2-.\3\2\2\2.\60\3\2\2\2/-\3\2\2\2\60\61\7\2\2\3\61\3\3\2\2\2\62\63\7"+
		"\3\2\2\63\67\5\6\4\2\64\67\5\n\6\2\65\67\5\f\7\2\66\62\3\2\2\2\66\64\3"+
		"\2\2\2\66\65\3\2\2\2\67\5\3\2\2\289\7+\2\29?\7\4\2\2:;\7\5\2\2;<\7(\2"+
		"\2<>\7\6\2\2=:\3\2\2\2>A\3\2\2\2?=\3\2\2\2?@\3\2\2\2@B\3\2\2\2A?\3\2\2"+
		"\2BC\5\b\5\2CD\7\7\2\2D\7\3\2\2\2EF\t\2\2\2F\t\3\2\2\2GH\7\13\2\2HI\7"+
		"+\2\2IM\7\f\2\2JL\5\6\4\2KJ\3\2\2\2LO\3\2\2\2MK\3\2\2\2MN\3\2\2\2NP\3"+
		"\2\2\2OM\3\2\2\2PQ\7\r\2\2QR\7\7\2\2R\13\3\2\2\2ST\7+\2\2TU\7\16\2\2U"+
		"V\5\20\t\2VW\7\17\2\2WX\5\24\13\2X\\\7\f\2\2Y[\5\26\f\2ZY\3\2\2\2[^\3"+
		"\2\2\2\\Z\3\2\2\2\\]\3\2\2\2]_\3\2\2\2^\\\3\2\2\2_`\7\r\2\2`\r\3\2\2\2"+
		"ab\7+\2\2bc\7\16\2\2cd\5\20\t\2de\7\17\2\2e\17\3\2\2\2fk\5\22\n\2gh\7"+
		"\20\2\2hj\5\22\n\2ig\3\2\2\2jm\3\2\2\2ki\3\2\2\2kl\3\2\2\2lo\3\2\2\2m"+
		"k\3\2\2\2nf\3\2\2\2no\3\2\2\2o\21\3\2\2\2pq\7+\2\2qr\7\4\2\2rs\5\b\5\2"+
		"s\23\3\2\2\2tu\7\4\2\2uw\5\b\5\2vt\3\2\2\2vw\3\2\2\2w\25\3\2\2\2xy\7\3"+
		"\2\2y\u0084\5\6\4\2z\u0084\5\30\r\2{\u0084\5\32\16\2|\u0084\5\34\17\2"+
		"}\u0084\5\36\20\2~\u0084\5 \21\2\177\u0084\5\"\22\2\u0080\u0081\5$\23"+
		"\2\u0081\u0082\7\7\2\2\u0082\u0084\3\2\2\2\u0083x\3\2\2\2\u0083z\3\2\2"+
		"\2\u0083{\3\2\2\2\u0083|\3\2\2\2\u0083}\3\2\2\2\u0083~\3\2\2\2\u0083\177"+
		"\3\2\2\2\u0083\u0080\3\2\2\2\u0084\27\3\2\2\2\u0085\u0086\5$\23\2\u0086"+
		"\u0087\7\21\2\2\u0087\u0088\5$\23\2\u0088\u0089\7\7\2\2\u0089\31\3\2\2"+
		"\2\u008a\u008b\7\22\2\2\u008b\u008c\5$\23\2\u008c\u008d\7\7\2\2\u008d"+
		"\u0098\3\2\2\2\u008e\u008f\7\23\2\2\u008f\u0090\5$\23\2\u0090\u0091\7"+
		"\7\2\2\u0091\u0098\3\2\2\2\u0092\u0094\7\24\2\2\u0093\u0095\5$\23\2\u0094"+
		"\u0093\3\2\2\2\u0094\u0095\3\2\2\2\u0095\u0096\3\2\2\2\u0096\u0098\7\7"+
		"\2\2\u0097\u008a\3\2\2\2\u0097\u008e\3\2\2\2\u0097\u0092\3\2\2\2\u0098"+
		"\33\3\2\2\2\u0099\u009a\7\25\2\2\u009a\u009b\5$\23\2\u009b\u009c\7\7\2"+
		"\2\u009c\35\3\2\2\2\u009d\u009e\7\26\2\2\u009e\u009f\7\16\2\2\u009f\u00a0"+
		"\5$\23\2\u00a0\u00a1\7\17\2\2\u00a1\u00a3\7\f\2\2\u00a2\u00a4\5\26\f\2"+
		"\u00a3\u00a2\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5\u00a3\3\2\2\2\u00a5\u00a6"+
		"\3\2\2\2\u00a6\u00a7\3\2\2\2\u00a7\u00a8\7\r\2\2\u00a8\u00be\3\2\2\2\u00a9"+
		"\u00aa\7\26\2\2\u00aa\u00ab\7\16\2\2\u00ab\u00ac\5$\23\2\u00ac\u00ad\7"+
		"\17\2\2\u00ad\u00af\7\f\2\2\u00ae\u00b0\5\26\f\2\u00af\u00ae\3\2\2\2\u00b0"+
		"\u00b1\3\2\2\2\u00b1\u00af\3\2\2\2\u00b1\u00b2\3\2\2\2\u00b2\u00b3\3\2"+
		"\2\2\u00b3\u00b4\7\r\2\2\u00b4\u00b5\7\27\2\2\u00b5\u00b7\7\f\2\2\u00b6"+
		"\u00b8\5\26\f\2\u00b7\u00b6\3\2\2\2\u00b8\u00b9\3\2\2\2\u00b9\u00b7\3"+
		"\2\2\2\u00b9\u00ba\3\2\2\2\u00ba\u00bb\3\2\2\2\u00bb\u00bc\7\r\2\2\u00bc"+
		"\u00be\3\2\2\2\u00bd\u009d\3\2\2\2\u00bd\u00a9\3\2\2\2\u00be\37\3\2\2"+
		"\2\u00bf\u00c0\7\30\2\2\u00c0\u00c1\7\16\2\2\u00c1\u00c2\5$\23\2\u00c2"+
		"\u00c3\7\17\2\2\u00c3\u00c5\7\f\2\2\u00c4\u00c6\5\26\f\2\u00c5\u00c4\3"+
		"\2\2\2\u00c6\u00c7\3\2\2\2\u00c7\u00c5\3\2\2\2\u00c7\u00c8\3\2\2\2\u00c8"+
		"\u00c9\3\2\2\2\u00c9\u00ca\7\r\2\2\u00ca!\3\2\2\2\u00cb\u00cd\7\31\2\2"+
		"\u00cc\u00ce\5$\23\2\u00cd\u00cc\3\2\2\2\u00cd\u00ce\3\2\2\2\u00ce\u00cf"+
		"\3\2\2\2\u00cf\u00d0\7\7\2\2\u00d0#\3\2\2\2\u00d1\u00d2\b\23\1\2\u00d2"+
		"\u00ed\5&\24\2\u00d3\u00d4\7\16\2\2\u00d4\u00d5\5$\23\2\u00d5\u00d6\7"+
		"\17\2\2\u00d6\u00ed\3\2\2\2\u00d7\u00d8\7\33\2\2\u00d8\u00d9\7\34\2\2"+
		"\u00d9\u00da\5\b\5\2\u00da\u00db\7\35\2\2\u00db\u00dc\7\16\2\2\u00dc\u00dd"+
		"\5$\23\2\u00dd\u00de\7\17\2\2\u00de\u00ed\3\2\2\2\u00df\u00e0\7+\2\2\u00e0"+
		"\u00e9\7\16\2\2\u00e1\u00e6\5$\23\2\u00e2\u00e3\7\20\2\2\u00e3\u00e5\5"+
		"$\23\2\u00e4\u00e2\3\2\2\2\u00e5\u00e8\3\2\2\2\u00e6\u00e4\3\2\2\2\u00e6"+
		"\u00e7\3\2\2\2\u00e7\u00ea\3\2\2\2\u00e8\u00e6\3\2\2\2\u00e9\u00e1\3\2"+
		"\2\2\u00e9\u00ea\3\2\2\2\u00ea\u00eb\3\2\2\2\u00eb\u00ed\7\17\2\2\u00ec"+
		"\u00d1\3\2\2\2\u00ec\u00d3\3\2\2\2\u00ec\u00d7\3\2\2\2\u00ec\u00df\3\2"+
		"\2\2\u00ed\u0100\3\2\2\2\u00ee\u00ef\f\b\2\2\u00ef\u00f0\5(\25\2\u00f0"+
		"\u00f1\5$\23\t\u00f1\u00ff\3\2\2\2\u00f2\u00f3\f\6\2\2\u00f3\u00f4\7\32"+
		"\2\2\u00f4\u00ff\5$\23\7\u00f5\u00fa\f\7\2\2\u00f6\u00f7\7\5\2\2\u00f7"+
		"\u00f8\5$\23\2\u00f8\u00f9\7\6\2\2\u00f9\u00fb\3\2\2\2\u00fa\u00f6\3\2"+
		"\2\2\u00fb\u00fc\3\2\2\2\u00fc\u00fa\3\2\2\2\u00fc\u00fd\3\2\2\2\u00fd"+
		"\u00ff\3\2\2\2\u00fe\u00ee\3\2\2\2\u00fe\u00f2\3\2\2\2\u00fe\u00f5\3\2"+
		"\2\2\u00ff\u0102\3\2\2\2\u0100\u00fe\3\2\2\2\u0100\u0101\3\2\2\2\u0101"+
		"%\3\2\2\2\u0102\u0100\3\2\2\2\u0103\u0104\t\3\2\2\u0104\'\3\2\2\2\u0105"+
		"\u010c\t\4\2\2\u0106\u010c\t\5\2\2\u0107\u010c\t\6\2\2\u0108\u010c\t\7"+
		"\2\2\u0109\u010c\7&\2\2\u010a\u010c\7\'\2\2\u010b\u0105\3\2\2\2\u010b"+
		"\u0106\3\2\2\2\u010b\u0107\3\2\2\2\u010b\u0108\3\2\2\2\u010b\u0109\3\2"+
		"\2\2\u010b\u010a\3\2\2\2\u010c)\3\2\2\2\32-\66?M\\knv\u0083\u0094\u0097"+
		"\u00a5\u00b1\u00b9\u00bd\u00c7\u00cd\u00e6\u00e9\u00ec\u00fc\u00fe\u0100"+
		"\u010b";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}