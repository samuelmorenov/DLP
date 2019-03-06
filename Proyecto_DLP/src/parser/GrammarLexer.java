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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\30\u00a0\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\3\2\3\2\3\2\3"+
		"\2\3\3\3\3\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b"+
		"\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\16"+
		"\3\16\3\16\3\16\3\16\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\21\6\21e\n\21\r\21\16\21f\3\22\6\22j\n\22\r\22\16\22k\3\22\3\22\6\22"+
		"p\n\22\r\22\16\22q\3\23\3\23\3\23\3\23\3\24\3\24\7\24z\n\24\f\24\16\24"+
		"}\13\24\3\25\3\25\3\25\3\25\7\25\u0083\n\25\f\25\16\25\u0086\13\25\3\25"+
		"\3\25\3\25\3\25\3\26\3\26\3\26\3\26\7\26\u0090\n\26\f\26\16\26\u0093\13"+
		"\26\3\26\3\26\3\26\3\26\3\26\3\27\6\27\u009b\n\27\r\27\16\27\u009c\3\27"+
		"\3\27\4\u0084\u0091\2\30\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f"+
		"\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30\3\2\7\3\2\62"+
		";\4\2C\\c|\5\2C\\aac|\6\2\62;C\\aac|\5\2\13\f\17\17\"\"\2\u00a6\2\3\3"+
		"\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2"+
		"\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3"+
		"\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2"+
		"%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\3/\3\2\2\2\5\63"+
		"\3\2\2\2\7\65\3\2\2\2\t\67\3\2\2\2\13>\3\2\2\2\r@\3\2\2\2\17B\3\2\2\2"+
		"\21D\3\2\2\2\23F\3\2\2\2\25H\3\2\2\2\27J\3\2\2\2\31N\3\2\2\2\33T\3\2\2"+
		"\2\35Y\3\2\2\2\37[\3\2\2\2!d\3\2\2\2#i\3\2\2\2%s\3\2\2\2\'w\3\2\2\2)~"+
		"\3\2\2\2+\u008b\3\2\2\2-\u009a\3\2\2\2/\60\7x\2\2\60\61\7c\2\2\61\62\7"+
		"t\2\2\62\4\3\2\2\2\63\64\7<\2\2\64\6\3\2\2\2\65\66\7=\2\2\66\b\3\2\2\2"+
		"\678\7u\2\289\7v\2\29:\7t\2\2:;\7w\2\2;<\7e\2\2<=\7v\2\2=\n\3\2\2\2>?"+
		"\7}\2\2?\f\3\2\2\2@A\7\177\2\2A\16\3\2\2\2BC\7*\2\2C\20\3\2\2\2DE\7+\2"+
		"\2E\22\3\2\2\2FG\7]\2\2G\24\3\2\2\2HI\7_\2\2I\26\3\2\2\2JK\7k\2\2KL\7"+
		"p\2\2LM\7v\2\2M\30\3\2\2\2NO\7h\2\2OP\7n\2\2PQ\7q\2\2QR\7c\2\2RS\7v\2"+
		"\2S\32\3\2\2\2TU\7e\2\2UV\7j\2\2VW\7c\2\2WX\7t\2\2X\34\3\2\2\2YZ\7.\2"+
		"\2Z\36\3\2\2\2[\\\7e\2\2\\]\7w\2\2]^\7g\2\2^_\7t\2\2_`\7r\2\2`a\7q\2\2"+
		"ab\7=\2\2b \3\2\2\2ce\t\2\2\2dc\3\2\2\2ef\3\2\2\2fd\3\2\2\2fg\3\2\2\2"+
		"g\"\3\2\2\2hj\t\2\2\2ih\3\2\2\2jk\3\2\2\2ki\3\2\2\2kl\3\2\2\2lm\3\2\2"+
		"\2mo\7\60\2\2np\t\2\2\2on\3\2\2\2pq\3\2\2\2qo\3\2\2\2qr\3\2\2\2r$\3\2"+
		"\2\2st\7)\2\2tu\t\3\2\2uv\7)\2\2v&\3\2\2\2w{\t\4\2\2xz\t\5\2\2yx\3\2\2"+
		"\2z}\3\2\2\2{y\3\2\2\2{|\3\2\2\2|(\3\2\2\2}{\3\2\2\2~\177\7\61\2\2\177"+
		"\u0080\7\61\2\2\u0080\u0084\3\2\2\2\u0081\u0083\13\2\2\2\u0082\u0081\3"+
		"\2\2\2\u0083\u0086\3\2\2\2\u0084\u0085\3\2\2\2\u0084\u0082\3\2\2\2\u0085"+
		"\u0087\3\2\2\2\u0086\u0084\3\2\2\2\u0087\u0088\7\f\2\2\u0088\u0089\3\2"+
		"\2\2\u0089\u008a\b\25\2\2\u008a*\3\2\2\2\u008b\u008c\7\61\2\2\u008c\u008d"+
		"\7,\2\2\u008d\u0091\3\2\2\2\u008e\u0090\13\2\2\2\u008f\u008e\3\2\2\2\u0090"+
		"\u0093\3\2\2\2\u0091\u0092\3\2\2\2\u0091\u008f\3\2\2\2\u0092\u0094\3\2"+
		"\2\2\u0093\u0091\3\2\2\2\u0094\u0095\7,\2\2\u0095\u0096\7\61\2\2\u0096"+
		"\u0097\3\2\2\2\u0097\u0098\b\26\2\2\u0098,\3\2\2\2\u0099\u009b\t\6\2\2"+
		"\u009a\u0099\3\2\2\2\u009b\u009c\3\2\2\2\u009c\u009a\3\2\2\2\u009c\u009d"+
		"\3\2\2\2\u009d\u009e\3\2\2\2\u009e\u009f\b\27\2\2\u009f.\3\2\2\2\n\2f"+
		"kq{\u0084\u0091\u009c\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}