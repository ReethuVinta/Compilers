lexer grammar CoolLexer;

tokens{
	ERROR,
	TYPEID,
	OBJECTID,
	BOOL_CONST,
	INT_CONST,
	STR_CONST,
	LPAREN,
	RPAREN,
	COLON,
	ATSYM,
	SEMICOLON,
	COMMA,
	PLUS,
	MINUS,
	STAR,
	SLASH,
	TILDE,
	LT,
	EQUALS,
	LBRACE,
	RBRACE,
	DOT,
	DARROW,
	LE,
	ASSIGN,
	CLASS,
	ELSE,
	FI,
	IF,
	IN,
	INHERITS,
	LET,
	LOOP,
	POOL,
	THEN,
	WHILE,
	CASE,
	ESAC,
	OF,
	NEW,
	ISVOID,
	NOT
}

/*
  DO NOT EDIT CODE ABOVE THIS LINE
*/

@members{

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
}

/*
	WRITE ALL LEXER RULES BELOW
*/

ERROR				:'"' (.)*('\u0000')(.)*?'"' {null_string();}|
					 '"' ~[\n"]*(EOF) 	  { EOF_string();}|
			 		 '"' ~["\nEOF]*('\n') { Unterminated_string();};
//Detecting errors in string


SEMICOLON        	: ';';   //Operators
COLON            	: ':';
LPAREN           	: '(';
RPAREN           	: ')';
LBRACE           	: '{';
RBRACE           	: '}';
PLUS             	: '+';
MINUS            	: '-';
STAR			 	: '*';
SLASH            	: '/';
TILDE            	: '~';
LT         		 	: '<';
LE      		 	: '<=';
EQUALS   		 	: '=';
DOT              	: '.';
COMMA            	: ',';
ASSIGN			 	: '<-';
DARROW           	: '=>';
ATSYM     		 	: '@';

//Keywords (In COOL keywords are case insensitive except true and false)
CASE			 	: ('C'|'c')('A'|'a')('S'|'s')('E'|'e');
ESAC			 	: ('E'|'e')('S'|'s')('A'|'a')('C'|'c');
WHILE			 	: ('W'|'w')('H'|'h')('I'|'i')('L'|'l')('E'|'e');
LOOP			 	: ('L'|'l')('O'|'o')('O'|'o')('P'|'p');
POOL		     	: ('P'|'p')('O'|'o')('O'|'o')('L'|'l');
IF				 	: ('I'|'i')('F'|'f');
FI 				 	: ('F'|'f')('I'|'i');
THEN			 	: ('T'|'t')('H'|'h')('E'|'e')('N'|'n');
ELSE 			 	: ('E'|'e')('L'|'l')('S'|'s')('E'|'e');
CLASS			 	: ('C'|'c')('L'|'l')('A'|'a')('S'|'s')('S'|'s');
IN 				 	: ('I'|'i')('N'|'n');
INHERITS         	: ('I'|'i')('N'|'n')('H'|'h')('E'|'e')('R'|'r')('I'|'i')('T'|'t')('S'|'s');
NEW              	: ('N'|'n')('E'|'e')('W'|'w');
ISVOID		     	: ('I'|'i')('S'|'s')('V'|'v')('O'|'o')('I'|'i')('D'|'d');
NOT 			 	: ('N'|'n')('O'|'o')('T'|'t');
OF 				 	: ('O'|'o')('F'|'f');
LET 			 	: ('L'|'l')('E'|'e')('T'|'t');

//Identifiers
fragment DIGIT 		: [0-9];
fragment CAPITAL    : [A-Z];
fragment SMALL      : [a-z];
fragment LETTER     : [a-zA-Z];
fragment TRUE       : ('t')('R'|'r')('U'|'u')('E'|'e');//In COOL true,false keywords should always start with small letter
fragment FALSE      : ('f')('A'|'a')('L'|'l')('S'|'s')('E'|'e');//remaining letters in true and false are case insensitive
INT_CONST           : DIGIT+;
BOOL_CONST			: (TRUE|FALSE);
TYPEID  			: CAPITAL('_'|LETTER|DIGIT)*;//TypeID begins with capital letter
OBJECTID			: SMALL('_'|LETTER|DIGIT)*;//ObjectID begins with small letter


//White Spaces
WHITESPACE          : [ \t\r\n\f]+     ->skip; //skip the whitespaces if they occur

//String
fragment ESCAPE		: '\\"'|'\\\\';
STR_CONST			: '"'(ESCAPE|.)*?'"' { processString();};//detects strings

//if unknown token is found
OTHER				: . {UknownToken();};

//Comments
SINGLE_LINE_COMMENT : '--' .*? ('\n'|(EOF)) -> skip;//single line comments
END_COMMENT			: '*)'    		{ reportError("Unmatched *)");};//error when only '*)' is present
EOF_COMMENT			: '*)'EOF 		{ reportError("Unmatched *)");};//error when only '*)EOF' is present
//Multi line comment
//comment opening
COMMENT				: '(*'    		-> pushMode(INCOMMENT), skip;
//handling nested comments if there any
mode INCOMMENT;
ERR1       			: .(EOF)  		{ reportError("EOF in comment");};//When EOF is found in comment
OPENCOMMENT	     	: '(*'    		-> pushMode(INCOM),skip;
CLOSECOMMENT		: '*)'    		-> popMode,skip;
TEXT1   			: .		  		-> skip;//eating up all the characters in comments

mode INCOM;
ERR2		     	: .(EOF) 		{ reportError("EOF in comment");};//When EOF is found in comment
OPEN		   		: '(*' 			-> pushMode(INCOM),skip;
ERR3	  			: '*)' EOF 		{ reportError("EOF in comment");};//When EOF is found in comment
CLOSE			    : '*)' 			-> popMode,skip;
TEXT2  				: . 			-> skip;//eating up all the characters in comments