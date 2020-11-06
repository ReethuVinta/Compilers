// Generated from CoolLexer.g4 by ANTLR 4.5
package cool;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CoolLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		ERROR=1, TYPEID=2, OBJECTID=3, BOOL_CONST=4, INT_CONST=5, STR_CONST=6, 
		LPAREN=7, RPAREN=8, COLON=9, ATSYM=10, SEMICOLON=11, COMMA=12, PLUS=13, 
		MINUS=14, STAR=15, SLASH=16, TILDE=17, LT=18, EQUALS=19, LBRACE=20, RBRACE=21, 
		DOT=22, DARROW=23, LE=24, ASSIGN=25, CLASS=26, ELSE=27, FI=28, IF=29, 
		IN=30, INHERITS=31, LET=32, LOOP=33, POOL=34, THEN=35, WHILE=36, CASE=37, 
		ESAC=38, OF=39, NEW=40, ISVOID=41, NOT=42, WHITESPACE=43, OTHER=44, SINGLE_LINE_COMMENT=45, 
		END_COMMENT=46, EOF_COMMENT=47, COMMENT=48, ERR1=49, OPENCOMMENT=50, CLOSECOMMENT=51, 
		TEXT1=52, ERR2=53, OPEN=54, ERR3=55, CLOSE=56, TEXT2=57;
	public static final int INCOMMENT = 1;
	public static final int INCOM = 2;
	public static String[] modeNames = {
		"DEFAULT_MODE", "INCOMMENT", "INCOM"
	};

	public static final String[] ruleNames = {
		"ERROR", "SEMICOLON", "COLON", "LPAREN", "RPAREN", "LBRACE", "RBRACE", 
		"PLUS", "MINUS", "STAR", "SLASH", "TILDE", "LT", "LE", "EQUALS", "DOT", 
		"COMMA", "ASSIGN", "DARROW", "ATSYM", "CASE", "ESAC", "WHILE", "LOOP", 
		"POOL", "IF", "FI", "THEN", "ELSE", "CLASS", "IN", "INHERITS", "NEW", 
		"ISVOID", "NOT", "OF", "LET", "DIGIT", "CAPITAL", "SMALL", "LETTER", "TRUE", 
		"FALSE", "INT_CONST", "BOOL_CONST", "TYPEID", "OBJECTID", "WHITESPACE", 
		"ESCAPE", "STR_CONST", "OTHER", "SINGLE_LINE_COMMENT", "END_COMMENT", 
		"EOF_COMMENT", "COMMENT", "ERR1", "OPENCOMMENT", "CLOSECOMMENT", "TEXT1", 
		"ERR2", "OPEN", "ERR3", "CLOSE", "TEXT2"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, null, null, null, null, "'('", "')'", "':'", "'@'", 
		"';'", "','", "'+'", "'-'", "'*'", "'/'", "'~'", "'<'", "'='", "'{'", 
		"'}'", "'.'", "'=>'", "'<='", "'<-'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "ERROR", "TYPEID", "OBJECTID", "BOOL_CONST", "INT_CONST", "STR_CONST", 
		"LPAREN", "RPAREN", "COLON", "ATSYM", "SEMICOLON", "COMMA", "PLUS", "MINUS", 
		"STAR", "SLASH", "TILDE", "LT", "EQUALS", "LBRACE", "RBRACE", "DOT", "DARROW", 
		"LE", "ASSIGN", "CLASS", "ELSE", "FI", "IF", "IN", "INHERITS", "LET", 
		"LOOP", "POOL", "THEN", "WHILE", "CASE", "ESAC", "OF", "NEW", "ISVOID", 
		"NOT", "WHITESPACE", "OTHER", "SINGLE_LINE_COMMENT", "END_COMMENT", "EOF_COMMENT", 
		"COMMENT", "ERR1", "OPENCOMMENT", "CLOSECOMMENT", "TEXT1", "ERR2", "OPEN", 
		"ERR3", "CLOSE", "TEXT2"
	};
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



		/*
			YOU CAN ADD YOUR MEMBER VARIABLES AND METHODS HERE
		*/

		/**
		* Function to report errors.
		* Use this function whenever your lexer encounters any erroneous input
		* DO NOT EDIT THIS FUNCTION
		*/
		public void reportError(String errorString)
		{
			setText(errorString);
			setType(ERROR);
		}

		public void processString() //processing string
		{
			Token t = _factory.create(_tokenFactorySourcePair, _type, _text, _channel, _tokenStartCharIndex, getCharIndex()-1, _tokenStartLine, _tokenStartCharPositionInLine);
			String text = t.getText();
			//write your code to test strings here
			if(text.length()==2)//if string length is 2
			{
				String output = ""; 
				setText(output);
				return;
			}
			if(text.length()==3)//if string length is 3
			{
				setText(text.substring(1,2));
				return;
			}

			String before_check = text.substring(1,text.length()-2);
			boolean before = before_check.length()>1024;//checking the intial length of string;
			boolean newline = false;
			boolean set = false;
			boolean back_slash = false;

			StringBuilder s = new StringBuilder(0);//creating a new string to store output string
			for(int i = 1; i < text.length()-1; ++i) 
			{
				if(text.charAt(i) == '\n') //if '\n' we set the booleanvalue of 'middle'
				{
					newline=true;
					if(s.length() > 1025)set=true; //if the number of chars that occur before newline are greater than 1025 we set the booleanvalueof 'set'
				}
				else if(text.charAt(i) == '\\') 
				{
					if(text.charAt(i+1) == 'n')
						s.append('\n');
					else if(text.charAt(i+1) == 'f')
						s.append('\f');
					else if(text.charAt(i+1) == 't')
						s.append('\t');
					else if(text.charAt(i+1) == 'b')
						s.append('\b');
					else if(text.charAt(i+1) == '\"')
					{
						if(i+1==text.length()-1)back_slash=true;
						else s.append('\"');
					}
					else if(text.charAt(i+1) == '\\')
						s.append('\\');
					else
						s.append(text.charAt(i+1));
						
					i++;
				}
				else //any other character found just add it
				{
					s.append(text.charAt(i));
				}
			}
			if(back_slash)
			{
				reportError("EOF in string constant");
				return;
			}
		
			String output = s.toString();
			boolean after = output.length()>1024; //taking the length after processing 

			if(!before && !after)//if both before and after the length of string is less than 1024 then
				{
					if(newline) //if we encounter new line then print accordingly
					{
						setText("Unterminated string constant");
						setType(ERROR);
						return;
					}
					else
					{
						setText(output);
						return;
					}
				}
			else if(before && !after)//if before the string is long but after wards if it is small then
				{
					if(newline)//if we enounter new line in between
					{
						setText("Unterminated string constant");
						setType(ERROR);
						return;
					}
					else
					{
						setText(output);
						return;
					}
				}
			else 
				{
					if(set && newline)//if the number of chars before the new line are greater than 1025
					{
						setText("String constant too long");
						setType(ERROR);
						return;
					}
					else if(!set && newline)//if the number of chars beforethe new line are less than 1025
					{
						setText("Unterminated string constant");
						setType(ERROR);
						return;
					}
					else //in any other case except the above
					{
						setText("String constant too long");
						setType(ERROR);
						return;
					}
				}
		}
		public void EOF_string() //checking the EOF string
		{
			Token t = _factory.create(_tokenFactorySourcePair, _type, _text, _channel, _tokenStartCharIndex, getCharIndex()-1, _tokenStartLine, _tokenStartCharPositionInLine);
			String text = t.getText();
			String output = text.substring(1,text.length());
			Boolean check=false;
			int length=0;
			
			for(int i=0;i<output.length();i++)
			{
				if(output.charAt(i) == '\u0000')//marking the position where we get the null character
				{
					check=true;
					length=i;
					break;
				}
			}
			if(output.length()> 1024) //if the string length is greaterthan 1024
			{	
				if(check)
				{
					if(length > 1025)//if the number of chars before NULL are greater than 1025 
					{
						reportError("String constant too long");
						return;
					}
					else //if the number of chars before NULL are less than 1025
					{
						reportError("String contains null character.");
						return;
					}
				}
				else
				{
					reportError("String constant too long");
					return;
				}
			}
			else
			{
				if(check)
				{
					reportError("String contains null character.");
					return;
				}
				else
				{
					reportError("EOF in string constant");
					return;
				}
			}
		}
		public void Unterminated_string() //Checking unterminated string
		{
			Token t = _factory.create(_tokenFactorySourcePair, _type, _text, _channel, _tokenStartCharIndex, getCharIndex()-1, _tokenStartLine, _tokenStartCharPositionInLine);
			String text = t.getText();
			String output = text.substring(1,text.length()-1);
			Boolean check=false;
			int length=0;
			
			for(int i=0;i<output.length();i++)
			{
				if(output.charAt(i) == '\u0000') //marking the NULL char position
				{
					check=true;
					length=i;
					break;
				}
			}
			if(output.length()>1024) //if the string length is greaterthan 1024
			{
				if(check)
				{
					if(length > 1025) //if the number of chars before NULL are greater than 1025 
					{
						reportError("String constant too long");
						return;
					}
					else //if the number of chars before NULL are less than 1025
					{
						reportError("String contains null character.");
						return;
					}
				}
				else
				{
					reportError("String constant too long");
					return;
				}
			}
			else
			{
				if(check)
				{
					reportError("String contains null character.");
					return;
				}
				else
				{
					reportError("Unterminated string constant");
					return;
				}
			}
		}
		public void null_string() //checking the null string
		{
			Token t = _factory.create(_tokenFactorySourcePair, _type, _text, _channel, _tokenStartCharIndex, getCharIndex()-1, _tokenStartLine, _tokenStartCharPositionInLine);
			String text = t.getText();

			String output = text.substring(1,text.length()-1);
			Boolean check_null=false;
			Boolean escape=false;
			int length_null=0;
			
			for(int i=0;i<output.length();i++)//marking the NULL char position
			{
				if(output.charAt(i) == '\u0000')
				{
					check_null=true;
					length_null=i;
					break;
				}
			}
			for(int i=0;i<output.length();i++)//checking escape NULL char if there any
			{
				if(output.charAt(i) == '\\')
				{
					if(output.charAt(i+1)=='\u0000')
					{
						escape=true;
					}
				}
			}
			if(escape)
			{
				reportError("String contains escaped null character.");
				return;
			}
			Boolean check_new=false;
			int length_new=0;
			for(int i=0;i<output.length();i++)//marking the new line position if there any
			{
				if(output.charAt(i) == '\n')
				{
					check_new=true;
					length_new=i;
					break;
				}
			}

			if(check_null)
			{
				if(check_new)//if there is a new line in string
				{
					if(length_new > 1025)//numberof chars before newline are greater than 1025
					{
						setText("String constant too long");
						setType(ERROR);
						return;
					}
					else //numberof chars before newline are less than 1025
					{
						setText("Unterminated string constant");
						setType(ERROR);
						return;
					}
				}
				else //if there is no new line in string
				{
					if(length_null > 1025)//numberof chars before NULL char are greater than 1025
					{
						setText("String constant too long");
						setType(ERROR);
						return;
					}
					else //numberof chars before NULL char are less than 1025
					{
						reportError("String contains null character.");
						return;
					}
				}
			}

		}
		public void UknownToken() //if unknown token is found
		{
			Token t = _factory.create(_tokenFactorySourcePair, _type, _text, _channel, _tokenStartCharIndex, getCharIndex()-1, _tokenStartLine, _tokenStartCharPositionInLine);
			String text = t.getText();
			reportError(text); //we just print the same string with ERROR
		}


	public CoolLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "CoolLexer.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 0:
			ERROR_action((RuleContext)_localctx, actionIndex);
			break;
		case 49:
			STR_CONST_action((RuleContext)_localctx, actionIndex);
			break;
		case 50:
			OTHER_action((RuleContext)_localctx, actionIndex);
			break;
		case 52:
			END_COMMENT_action((RuleContext)_localctx, actionIndex);
			break;
		case 53:
			EOF_COMMENT_action((RuleContext)_localctx, actionIndex);
			break;
		case 55:
			ERR1_action((RuleContext)_localctx, actionIndex);
			break;
		case 59:
			ERR2_action((RuleContext)_localctx, actionIndex);
			break;
		case 61:
			ERR3_action((RuleContext)_localctx, actionIndex);
			break;
		}
	}
	private void ERROR_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:
			null_string();
			break;
		case 1:
			 EOF_string();
			break;
		case 2:
			 Unterminated_string();
			break;
		}
	}
	private void STR_CONST_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 3:
			 processString();
			break;
		}
	}
	private void OTHER_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 4:
			UknownToken();
			break;
		}
	}
	private void END_COMMENT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 5:
			 reportError("Unmatched *)");
			break;
		}
	}
	private void EOF_COMMENT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 6:
			 reportError("Unmatched *)");
			break;
		}
	}
	private void ERR1_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 7:
			 reportError("EOF in comment");
			break;
		}
	}
	private void ERR2_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 8:
			 reportError("EOF in comment");
			break;
		}
	}
	private void ERR3_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 9:
			 reportError("EOF in comment");
			break;
		}
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2;\u01ba\b\1\b\1\b"+
		"\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n"+
		"\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21"+
		"\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30"+
		"\4\31\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37"+
		"\4 \t \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t"+
		"*\4+\t+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63"+
		"\4\64\t\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t"+
		"<\4=\t=\4>\t>\4?\t?\4@\t@\4A\tA\3\2\3\2\7\2\u0088\n\2\f\2\16\2\u008b\13"+
		"\2\3\2\3\2\7\2\u008f\n\2\f\2\16\2\u0092\13\2\3\2\3\2\3\2\3\2\7\2\u0098"+
		"\n\2\f\2\16\2\u009b\13\2\3\2\3\2\3\2\3\2\7\2\u00a1\n\2\f\2\16\2\u00a4"+
		"\13\2\3\2\3\2\5\2\u00a8\n\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3"+
		"\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3"+
		"\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\23\3\24\3\24\3\24\3\25\3"+
		"\25\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3"+
		"\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\33\3"+
		"\33\3\33\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3"+
		"\36\3\37\3\37\3\37\3\37\3\37\3\37\3 \3 \3 \3!\3!\3!\3!\3!\3!\3!\3!\3!"+
		"\3\"\3\"\3\"\3\"\3#\3#\3#\3#\3#\3#\3#\3$\3$\3$\3$\3%\3%\3%\3&\3&\3&\3"+
		"&\3\'\3\'\3(\3(\3)\3)\3*\3*\3+\3+\3+\3+\3+\3,\3,\3,\3,\3,\3,\3-\6-\u0139"+
		"\n-\r-\16-\u013a\3.\3.\5.\u013f\n.\3/\3/\3/\3/\7/\u0145\n/\f/\16/\u0148"+
		"\13/\3\60\3\60\3\60\3\60\7\60\u014e\n\60\f\60\16\60\u0151\13\60\3\61\6"+
		"\61\u0154\n\61\r\61\16\61\u0155\3\61\3\61\3\62\3\62\3\62\3\62\5\62\u015e"+
		"\n\62\3\63\3\63\3\63\7\63\u0163\n\63\f\63\16\63\u0166\13\63\3\63\3\63"+
		"\3\63\3\64\3\64\3\64\3\65\3\65\3\65\3\65\7\65\u0172\n\65\f\65\16\65\u0175"+
		"\13\65\3\65\5\65\u0178\n\65\3\65\3\65\3\66\3\66\3\66\3\66\3\66\3\67\3"+
		"\67\3\67\3\67\3\67\3\67\38\38\38\38\38\38\39\39\39\39\3:\3:\3:\3:\3:\3"+
		":\3;\3;\3;\3;\3;\3;\3<\3<\3<\3<\3=\3=\3=\3=\3>\3>\3>\3>\3>\3>\3?\3?\3"+
		"?\3?\3?\3?\3@\3@\3@\3@\3@\3@\3A\3A\3A\3A\5\u0090\u0164\u0173\2B\5\3\7"+
		"\r\t\13\13\t\r\n\17\26\21\27\23\17\25\20\27\21\31\22\33\23\35\24\37\32"+
		"!\25#\30%\16\'\33)\31+\f-\'/(\61&\63#\65$\67\379\36;%=\35?\34A C!E*G+"+
		"I,K)M\"O\2Q\2S\2U\2W\2Y\2[\7]\6_\4a\5c-e\2g\bi.k/m\60o\61q\62s\63u\64"+
		"w\65y\66{\67}8\1779\u0081:\u0083;\5\2\3\4\33\4\2\f\f$$\6\2\f\f$$GHQQ\4"+
		"\2EEee\4\2CCcc\4\2UUuu\4\2GGgg\4\2YYyy\4\2JJjj\4\2KKkk\4\2NNnn\4\2QQq"+
		"q\4\2RRrr\4\2HHhh\4\2VVvv\4\2PPpp\4\2TTtt\4\2XXxx\4\2FFff\3\2\62;\3\2"+
		"C\\\3\2c|\4\2C\\c|\4\2WWww\5\2\13\f\16\17\"\"\3\3\f\f\u01c3\2\5\3\2\2"+
		"\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21"+
		"\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2"+
		"\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3"+
		"\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3"+
		"\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3"+
		"\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2"+
		"\2\2M\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2"+
		"g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\3s\3"+
		"\2\2\2\3u\3\2\2\2\3w\3\2\2\2\3y\3\2\2\2\4{\3\2\2\2\4}\3\2\2\2\4\177\3"+
		"\2\2\2\4\u0081\3\2\2\2\4\u0083\3\2\2\2\5\u00a7\3\2\2\2\7\u00a9\3\2\2\2"+
		"\t\u00ab\3\2\2\2\13\u00ad\3\2\2\2\r\u00af\3\2\2\2\17\u00b1\3\2\2\2\21"+
		"\u00b3\3\2\2\2\23\u00b5\3\2\2\2\25\u00b7\3\2\2\2\27\u00b9\3\2\2\2\31\u00bb"+
		"\3\2\2\2\33\u00bd\3\2\2\2\35\u00bf\3\2\2\2\37\u00c1\3\2\2\2!\u00c4\3\2"+
		"\2\2#\u00c6\3\2\2\2%\u00c8\3\2\2\2\'\u00ca\3\2\2\2)\u00cd\3\2\2\2+\u00d0"+
		"\3\2\2\2-\u00d2\3\2\2\2/\u00d7\3\2\2\2\61\u00dc\3\2\2\2\63\u00e2\3\2\2"+
		"\2\65\u00e7\3\2\2\2\67\u00ec\3\2\2\29\u00ef\3\2\2\2;\u00f2\3\2\2\2=\u00f7"+
		"\3\2\2\2?\u00fc\3\2\2\2A\u0102\3\2\2\2C\u0105\3\2\2\2E\u010e\3\2\2\2G"+
		"\u0112\3\2\2\2I\u0119\3\2\2\2K\u011d\3\2\2\2M\u0120\3\2\2\2O\u0124\3\2"+
		"\2\2Q\u0126\3\2\2\2S\u0128\3\2\2\2U\u012a\3\2\2\2W\u012c\3\2\2\2Y\u0131"+
		"\3\2\2\2[\u0138\3\2\2\2]\u013e\3\2\2\2_\u0140\3\2\2\2a\u0149\3\2\2\2c"+
		"\u0153\3\2\2\2e\u015d\3\2\2\2g\u015f\3\2\2\2i\u016a\3\2\2\2k\u016d\3\2"+
		"\2\2m\u017b\3\2\2\2o\u0180\3\2\2\2q\u0186\3\2\2\2s\u018c\3\2\2\2u\u0190"+
		"\3\2\2\2w\u0196\3\2\2\2y\u019c\3\2\2\2{\u01a0\3\2\2\2}\u01a4\3\2\2\2\177"+
		"\u01aa\3\2\2\2\u0081\u01b0\3\2\2\2\u0083\u01b6\3\2\2\2\u0085\u0089\7$"+
		"\2\2\u0086\u0088\13\2\2\2\u0087\u0086\3\2\2\2\u0088\u008b\3\2\2\2\u0089"+
		"\u0087\3\2\2\2\u0089\u008a\3\2\2\2\u008a\u008c\3\2\2\2\u008b\u0089\3\2"+
		"\2\2\u008c\u0090\7\2\2\2\u008d\u008f\13\2\2\2\u008e\u008d\3\2\2\2\u008f"+
		"\u0092\3\2\2\2\u0090\u0091\3\2\2\2\u0090\u008e\3\2\2\2\u0091\u0093\3\2"+
		"\2\2\u0092\u0090\3\2\2\2\u0093\u0094\7$\2\2\u0094\u00a8\b\2\2\2\u0095"+
		"\u0099\7$\2\2\u0096\u0098\n\2\2\2\u0097\u0096\3\2\2\2\u0098\u009b\3\2"+
		"\2\2\u0099\u0097\3\2\2\2\u0099\u009a\3\2\2\2\u009a\u009c\3\2\2\2\u009b"+
		"\u0099\3\2\2\2\u009c\u009d\7\2\2\3\u009d\u00a8\b\2\3\2\u009e\u00a2\7$"+
		"\2\2\u009f\u00a1\n\3\2\2\u00a0\u009f\3\2\2\2\u00a1\u00a4\3\2\2\2\u00a2"+
		"\u00a0\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a3\u00a5\3\2\2\2\u00a4\u00a2\3\2"+
		"\2\2\u00a5\u00a6\7\f\2\2\u00a6\u00a8\b\2\4\2\u00a7\u0085\3\2\2\2\u00a7"+
		"\u0095\3\2\2\2\u00a7\u009e\3\2\2\2\u00a8\6\3\2\2\2\u00a9\u00aa\7=\2\2"+
		"\u00aa\b\3\2\2\2\u00ab\u00ac\7<\2\2\u00ac\n\3\2\2\2\u00ad\u00ae\7*\2\2"+
		"\u00ae\f\3\2\2\2\u00af\u00b0\7+\2\2\u00b0\16\3\2\2\2\u00b1\u00b2\7}\2"+
		"\2\u00b2\20\3\2\2\2\u00b3\u00b4\7\177\2\2\u00b4\22\3\2\2\2\u00b5\u00b6"+
		"\7-\2\2\u00b6\24\3\2\2\2\u00b7\u00b8\7/\2\2\u00b8\26\3\2\2\2\u00b9\u00ba"+
		"\7,\2\2\u00ba\30\3\2\2\2\u00bb\u00bc\7\61\2\2\u00bc\32\3\2\2\2\u00bd\u00be"+
		"\7\u0080\2\2\u00be\34\3\2\2\2\u00bf\u00c0\7>\2\2\u00c0\36\3\2\2\2\u00c1"+
		"\u00c2\7>\2\2\u00c2\u00c3\7?\2\2\u00c3 \3\2\2\2\u00c4\u00c5\7?\2\2\u00c5"+
		"\"\3\2\2\2\u00c6\u00c7\7\60\2\2\u00c7$\3\2\2\2\u00c8\u00c9\7.\2\2\u00c9"+
		"&\3\2\2\2\u00ca\u00cb\7>\2\2\u00cb\u00cc\7/\2\2\u00cc(\3\2\2\2\u00cd\u00ce"+
		"\7?\2\2\u00ce\u00cf\7@\2\2\u00cf*\3\2\2\2\u00d0\u00d1\7B\2\2\u00d1,\3"+
		"\2\2\2\u00d2\u00d3\t\4\2\2\u00d3\u00d4\t\5\2\2\u00d4\u00d5\t\6\2\2\u00d5"+
		"\u00d6\t\7\2\2\u00d6.\3\2\2\2\u00d7\u00d8\t\7\2\2\u00d8\u00d9\t\6\2\2"+
		"\u00d9\u00da\t\5\2\2\u00da\u00db\t\4\2\2\u00db\60\3\2\2\2\u00dc\u00dd"+
		"\t\b\2\2\u00dd\u00de\t\t\2\2\u00de\u00df\t\n\2\2\u00df\u00e0\t\13\2\2"+
		"\u00e0\u00e1\t\7\2\2\u00e1\62\3\2\2\2\u00e2\u00e3\t\13\2\2\u00e3\u00e4"+
		"\t\f\2\2\u00e4\u00e5\t\f\2\2\u00e5\u00e6\t\r\2\2\u00e6\64\3\2\2\2\u00e7"+
		"\u00e8\t\r\2\2\u00e8\u00e9\t\f\2\2\u00e9\u00ea\t\f\2\2\u00ea\u00eb\t\13"+
		"\2\2\u00eb\66\3\2\2\2\u00ec\u00ed\t\n\2\2\u00ed\u00ee\t\16\2\2\u00ee8"+
		"\3\2\2\2\u00ef\u00f0\t\16\2\2\u00f0\u00f1\t\n\2\2\u00f1:\3\2\2\2\u00f2"+
		"\u00f3\t\17\2\2\u00f3\u00f4\t\t\2\2\u00f4\u00f5\t\7\2\2\u00f5\u00f6\t"+
		"\20\2\2\u00f6<\3\2\2\2\u00f7\u00f8\t\7\2\2\u00f8\u00f9\t\13\2\2\u00f9"+
		"\u00fa\t\6\2\2\u00fa\u00fb\t\7\2\2\u00fb>\3\2\2\2\u00fc\u00fd\t\4\2\2"+
		"\u00fd\u00fe\t\13\2\2\u00fe\u00ff\t\5\2\2\u00ff\u0100\t\6\2\2\u0100\u0101"+
		"\t\6\2\2\u0101@\3\2\2\2\u0102\u0103\t\n\2\2\u0103\u0104\t\20\2\2\u0104"+
		"B\3\2\2\2\u0105\u0106\t\n\2\2\u0106\u0107\t\20\2\2\u0107\u0108\t\t\2\2"+
		"\u0108\u0109\t\7\2\2\u0109\u010a\t\21\2\2\u010a\u010b\t\n\2\2\u010b\u010c"+
		"\t\17\2\2\u010c\u010d\t\6\2\2\u010dD\3\2\2\2\u010e\u010f\t\20\2\2\u010f"+
		"\u0110\t\7\2\2\u0110\u0111\t\b\2\2\u0111F\3\2\2\2\u0112\u0113\t\n\2\2"+
		"\u0113\u0114\t\6\2\2\u0114\u0115\t\22\2\2\u0115\u0116\t\f\2\2\u0116\u0117"+
		"\t\n\2\2\u0117\u0118\t\23\2\2\u0118H\3\2\2\2\u0119\u011a\t\20\2\2\u011a"+
		"\u011b\t\f\2\2\u011b\u011c\t\17\2\2\u011cJ\3\2\2\2\u011d\u011e\t\f\2\2"+
		"\u011e\u011f\t\16\2\2\u011fL\3\2\2\2\u0120\u0121\t\13\2\2\u0121\u0122"+
		"\t\7\2\2\u0122\u0123\t\17\2\2\u0123N\3\2\2\2\u0124\u0125\t\24\2\2\u0125"+
		"P\3\2\2\2\u0126\u0127\t\25\2\2\u0127R\3\2\2\2\u0128\u0129\t\26\2\2\u0129"+
		"T\3\2\2\2\u012a\u012b\t\27\2\2\u012bV\3\2\2\2\u012c\u012d\7v\2\2\u012d"+
		"\u012e\t\21\2\2\u012e\u012f\t\30\2\2\u012f\u0130\t\7\2\2\u0130X\3\2\2"+
		"\2\u0131\u0132\7h\2\2\u0132\u0133\t\5\2\2\u0133\u0134\t\13\2\2\u0134\u0135"+
		"\t\6\2\2\u0135\u0136\t\7\2\2\u0136Z\3\2\2\2\u0137\u0139\5O\'\2\u0138\u0137"+
		"\3\2\2\2\u0139\u013a\3\2\2\2\u013a\u0138\3\2\2\2\u013a\u013b\3\2\2\2\u013b"+
		"\\\3\2\2\2\u013c\u013f\5W+\2\u013d\u013f\5Y,\2\u013e\u013c\3\2\2\2\u013e"+
		"\u013d\3\2\2\2\u013f^\3\2\2\2\u0140\u0146\5Q(\2\u0141\u0145\7a\2\2\u0142"+
		"\u0145\5U*\2\u0143\u0145\5O\'\2\u0144\u0141\3\2\2\2\u0144\u0142\3\2\2"+
		"\2\u0144\u0143\3\2\2\2\u0145\u0148\3\2\2\2\u0146\u0144\3\2\2\2\u0146\u0147"+
		"\3\2\2\2\u0147`\3\2\2\2\u0148\u0146\3\2\2\2\u0149\u014f\5S)\2\u014a\u014e"+
		"\7a\2\2\u014b\u014e\5U*\2\u014c\u014e\5O\'\2\u014d\u014a\3\2\2\2\u014d"+
		"\u014b\3\2\2\2\u014d\u014c\3\2\2\2\u014e\u0151\3\2\2\2\u014f\u014d\3\2"+
		"\2\2\u014f\u0150\3\2\2\2\u0150b\3\2\2\2\u0151\u014f\3\2\2\2\u0152\u0154"+
		"\t\31\2\2\u0153\u0152\3\2\2\2\u0154\u0155\3\2\2\2\u0155\u0153\3\2\2\2"+
		"\u0155\u0156\3\2\2\2\u0156\u0157\3\2\2\2\u0157\u0158\b\61\5\2\u0158d\3"+
		"\2\2\2\u0159\u015a\7^\2\2\u015a\u015e\7$\2\2\u015b\u015c\7^\2\2\u015c"+
		"\u015e\7^\2\2\u015d\u0159\3\2\2\2\u015d\u015b\3\2\2\2\u015ef\3\2\2\2\u015f"+
		"\u0164\7$\2\2\u0160\u0163\5e\62\2\u0161\u0163\13\2\2\2\u0162\u0160\3\2"+
		"\2\2\u0162\u0161\3\2\2\2\u0163\u0166\3\2\2\2\u0164\u0165\3\2\2\2\u0164"+
		"\u0162\3\2\2\2\u0165\u0167\3\2\2\2\u0166\u0164\3\2\2\2\u0167\u0168\7$"+
		"\2\2\u0168\u0169\b\63\6\2\u0169h\3\2\2\2\u016a\u016b\13\2\2\2\u016b\u016c"+
		"\b\64\7\2\u016cj\3\2\2\2\u016d\u016e\7/\2\2\u016e\u016f\7/\2\2\u016f\u0173"+
		"\3\2\2\2\u0170\u0172\13\2\2\2\u0171\u0170\3\2\2\2\u0172\u0175\3\2\2\2"+
		"\u0173\u0174\3\2\2\2\u0173\u0171\3\2\2\2\u0174\u0177\3\2\2\2\u0175\u0173"+
		"\3\2\2\2\u0176\u0178\t\32\2\2\u0177\u0176\3\2\2\2\u0178\u0179\3\2\2\2"+
		"\u0179\u017a\b\65\5\2\u017al\3\2\2\2\u017b\u017c\7,\2\2\u017c\u017d\7"+
		"+\2\2\u017d\u017e\3\2\2\2\u017e\u017f\b\66\b\2\u017fn\3\2\2\2\u0180\u0181"+
		"\7,\2\2\u0181\u0182\7+\2\2\u0182\u0183\3\2\2\2\u0183\u0184\7\2\2\3\u0184"+
		"\u0185\b\67\t\2\u0185p\3\2\2\2\u0186\u0187\7*\2\2\u0187\u0188\7,\2\2\u0188"+
		"\u0189\3\2\2\2\u0189\u018a\b8\n\2\u018a\u018b\b8\5\2\u018br\3\2\2\2\u018c"+
		"\u018d\13\2\2\2\u018d\u018e\7\2\2\3\u018e\u018f\b9\13\2\u018ft\3\2\2\2"+
		"\u0190\u0191\7*\2\2\u0191\u0192\7,\2\2\u0192\u0193\3\2\2\2\u0193\u0194"+
		"\b:\f\2\u0194\u0195\b:\5\2\u0195v\3\2\2\2\u0196\u0197\7,\2\2\u0197\u0198"+
		"\7+\2\2\u0198\u0199\3\2\2\2\u0199\u019a\b;\r\2\u019a\u019b\b;\5\2\u019b"+
		"x\3\2\2\2\u019c\u019d\13\2\2\2\u019d\u019e\3\2\2\2\u019e\u019f\b<\5\2"+
		"\u019fz\3\2\2\2\u01a0\u01a1\13\2\2\2\u01a1\u01a2\7\2\2\3\u01a2\u01a3\b"+
		"=\16\2\u01a3|\3\2\2\2\u01a4\u01a5\7*\2\2\u01a5\u01a6\7,\2\2\u01a6\u01a7"+
		"\3\2\2\2\u01a7\u01a8\b>\f\2\u01a8\u01a9\b>\5\2\u01a9~\3\2\2\2\u01aa\u01ab"+
		"\7,\2\2\u01ab\u01ac\7+\2\2\u01ac\u01ad\3\2\2\2\u01ad\u01ae\7\2\2\3\u01ae"+
		"\u01af\b?\17\2\u01af\u0080\3\2\2\2\u01b0\u01b1\7,\2\2\u01b1\u01b2\7+\2"+
		"\2\u01b2\u01b3\3\2\2\2\u01b3\u01b4\b@\r\2\u01b4\u01b5\b@\5\2\u01b5\u0082"+
		"\3\2\2\2\u01b6\u01b7\13\2\2\2\u01b7\u01b8\3\2\2\2\u01b8\u01b9\bA\5\2\u01b9"+
		"\u0084\3\2\2\2\26\2\3\4\u0089\u0090\u0099\u00a2\u00a7\u013a\u013e\u0144"+
		"\u0146\u014d\u014f\u0155\u015d\u0162\u0164\u0173\u0177\20\3\2\2\3\2\3"+
		"\3\2\4\b\2\2\3\63\5\3\64\6\3\66\7\3\67\b\7\3\2\39\t\7\4\2\6\2\2\3=\n\3"+
		"?\13";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}