// Generated from src\parser\Grammar.g4 by ANTLR 4.7.2
package parser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GrammarLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, INT_CONSTANT=16, 
		REAL_CONSTANT=17, CHAR_CONSTANT=18, IDENT=19, LINE_COMMENT=20, MULTILINE_COMMENT=21, 
		WHITESPACE=22;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "INT_CONSTANT", 
			"REAL_CONSTANT", "CHAR_CONSTANT", "IDENT", "LINE_COMMENT", "MULTILINE_COMMENT", 
			"WHITESPACE"
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


	public GrammarLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Grammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\30\u009f\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\3\2\3\2\3\2\3"+
		"\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\f\3\f"+
		"\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\21\6"+
		"\21d\n\21\r\21\16\21e\3\22\6\22i\n\22\r\22\16\22j\3\22\3\22\6\22o\n\22"+
		"\r\22\16\22p\3\23\3\23\3\23\3\23\3\24\3\24\7\24y\n\24\f\24\16\24|\13\24"+
		"\3\25\3\25\3\25\3\25\7\25\u0082\n\25\f\25\16\25\u0085\13\25\3\25\3\25"+
		"\3\25\3\25\3\26\3\26\3\26\3\26\7\26\u008f\n\26\f\26\16\26\u0092\13\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\27\6\27\u009a\n\27\r\27\16\27\u009b\3\27\3"+
		"\27\4\u0083\u0090\2\30\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27"+
		"\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30\3\2\7\3\2\62;"+
		"\4\2C\\c|\5\2C\\aac|\6\2\62;C\\aac|\5\2\13\f\17\17\"\"\2\u00a5\2\3\3\2"+
		"\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17"+
		"\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2"+
		"\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3"+
		"\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\3/\3\2\2\2\5\63\3"+
		"\2\2\2\7\65\3\2\2\2\t\67\3\2\2\2\139\3\2\2\2\r;\3\2\2\2\17?\3\2\2\2\21"+
		"E\3\2\2\2\23J\3\2\2\2\25Q\3\2\2\2\27S\3\2\2\2\31U\3\2\2\2\33W\3\2\2\2"+
		"\35Y\3\2\2\2\37[\3\2\2\2!c\3\2\2\2#h\3\2\2\2%r\3\2\2\2\'v\3\2\2\2)}\3"+
		"\2\2\2+\u008a\3\2\2\2-\u0099\3\2\2\2/\60\7x\2\2\60\61\7c\2\2\61\62\7t"+
		"\2\2\62\4\3\2\2\2\63\64\7<\2\2\64\6\3\2\2\2\65\66\7=\2\2\66\b\3\2\2\2"+
		"\678\7]\2\28\n\3\2\2\29:\7_\2\2:\f\3\2\2\2;<\7k\2\2<=\7p\2\2=>\7v\2\2"+
		">\16\3\2\2\2?@\7h\2\2@A\7n\2\2AB\7q\2\2BC\7c\2\2CD\7v\2\2D\20\3\2\2\2"+
		"EF\7e\2\2FG\7j\2\2GH\7c\2\2HI\7t\2\2I\22\3\2\2\2JK\7u\2\2KL\7v\2\2LM\7"+
		"t\2\2MN\7w\2\2NO\7e\2\2OP\7v\2\2P\24\3\2\2\2QR\7}\2\2R\26\3\2\2\2ST\7"+
		"\177\2\2T\30\3\2\2\2UV\7*\2\2V\32\3\2\2\2WX\7+\2\2X\34\3\2\2\2YZ\7.\2"+
		"\2Z\36\3\2\2\2[\\\7e\2\2\\]\7w\2\2]^\7g\2\2^_\7t\2\2_`\7r\2\2`a\7q\2\2"+
		"a \3\2\2\2bd\t\2\2\2cb\3\2\2\2de\3\2\2\2ec\3\2\2\2ef\3\2\2\2f\"\3\2\2"+
		"\2gi\t\2\2\2hg\3\2\2\2ij\3\2\2\2jh\3\2\2\2jk\3\2\2\2kl\3\2\2\2ln\7\60"+
		"\2\2mo\t\2\2\2nm\3\2\2\2op\3\2\2\2pn\3\2\2\2pq\3\2\2\2q$\3\2\2\2rs\7)"+
		"\2\2st\t\3\2\2tu\7)\2\2u&\3\2\2\2vz\t\4\2\2wy\t\5\2\2xw\3\2\2\2y|\3\2"+
		"\2\2zx\3\2\2\2z{\3\2\2\2{(\3\2\2\2|z\3\2\2\2}~\7\61\2\2~\177\7\61\2\2"+
		"\177\u0083\3\2\2\2\u0080\u0082\13\2\2\2\u0081\u0080\3\2\2\2\u0082\u0085"+
		"\3\2\2\2\u0083\u0084\3\2\2\2\u0083\u0081\3\2\2\2\u0084\u0086\3\2\2\2\u0085"+
		"\u0083\3\2\2\2\u0086\u0087\7\f\2\2\u0087\u0088\3\2\2\2\u0088\u0089\b\25"+
		"\2\2\u0089*\3\2\2\2\u008a\u008b\7\61\2\2\u008b\u008c\7,\2\2\u008c\u0090"+
		"\3\2\2\2\u008d\u008f\13\2\2\2\u008e\u008d\3\2\2\2\u008f\u0092\3\2\2\2"+
		"\u0090\u0091\3\2\2\2\u0090\u008e\3\2\2\2\u0091\u0093\3\2\2\2\u0092\u0090"+
		"\3\2\2\2\u0093\u0094\7,\2\2\u0094\u0095\7\61\2\2\u0095\u0096\3\2\2\2\u0096"+
		"\u0097\b\26\2\2\u0097,\3\2\2\2\u0098\u009a\t\6\2\2\u0099\u0098\3\2\2\2"+
		"\u009a\u009b\3\2\2\2\u009b\u0099\3\2\2\2\u009b\u009c\3\2\2\2\u009c\u009d"+
		"\3\2\2\2\u009d\u009e\b\27\2\2\u009e.\3\2\2\2\n\2ejpz\u0083\u0090\u009b"+
		"\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}