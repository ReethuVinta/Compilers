# COOL Compiler #

# OVERALL STRUCTURE #

Lexer implemented here tokenizes in the following order:
 
1. **Operators**
2. **Keywords**
3. **Identifiers**
4. **Whitespaces**
5. **Strings**
6. **Unknown token**
7. **Comments**

# DESIGN RULES #

 **Operators**
    
    ';' , ':','(',')','{','}','+','-','*','/','~','<','<=','=','.',',' ,'<-','=>','@' ---> all these symbols are tokenised here.
    If it encounters any other symbols which are not present here error message is printed.

 **Keywords**

    All the keywords in COOL are case insensitive except for 'true' and 'false'. Rule for them is written as following:
        CASE : ('C'|'a')('A'|'a')('S'|'s')('E'|'e')

    For true and false first character is case sensitive and must be lower case, we use the following rule definition:
        true   :  ('t')('R'|'r')('U'|'u')('E'|'e')
        false  :   ('f')('A'|'a')('L'|'l')('S'|'s')('E'|'e')

 **Identifiers**

    Integer should contain minimum one digit so it is defined as follow :
        INT_CONST   : (DIGIT)+

    Bool can be either true or false so it is defined as follows :
        BOOL_CONST  : (TRUE|FALSE)

    Type Identifier always begins with capital letter so it is defined as follows :
        TYPEID      :  (CAPITAL)(_|CAPITAL|SMALL)*

    Object Identifier always begins with small letter so it is defined as follows :
        OBJECTID    :  (SMALL)(_|CAPITAL|SMALL)*

 **WhiteSpaces**

    If white spaces are encountered we just eat up all whitespaces.
    
 **Strings**

    There are four functions to process strings :

    1. processString() :
        a. If it is enclosed by '"' then it will enter this function.
        b. If length of string is greater than 1024 then "String too long is printed".
        c. If an escaped new line is present then '\n' is added to the string.
        d. If an unescaped new line is present in the string then
            * If number of chars before newline are greater than 1025 then "String constant too long".
            * Else "Unterminated string constant" is printed.
    2. EOF_string() :
        a. If there is EOF in string then it enters this function.
        b. If there is an NULL character in this string then
            * If number of chars before NULL char is greater than 1025 then "String constant too long" error is printed.
            * Else "String contains null character" is printed.
           Else 
            * If number of chars are greater than 1024 "String constant too long" error is printed.
            * Else "EOF in string constant" is printed.
    3. Unterminated_string() :
        a. If there is unterminated string then it enters this function.
        b. If there is an NULL character in this string then
            * If number of chars before NULL char is greater than 1025 then "String constant too long" error is printed.
            * Else "String contains null character" is printed.
           Else 
            * If number of chars are greater than 1024 "String constant too long" error is printed.
            * Else "Unterminated string constant" is printed.
    4. null_string() :
        a. If there is NULL enclosed between two '"' then it enters this function.
        b. If there is a new line in this string
            * If number of chars before newline are greater than 1025 then "String constant too long" error is printed.
            * Else "Unterminated string constant" is printed.
           Else
            * If number of chars before NULL char is greater than 1025 then "String constant too long" error is printed.
            * Else "String contains null character" is printed.
        c. If an escaped null character is present then "String contains escaped null character." error is printed.

 **UnknownTokens**
       If unknown token are found then we just print the same thing with ERROR message
       
 **Comments**

    1. If '--' is encountered it means it is a single line comment. Even if EOF is present in single line comment it is not considered as error.
    2. When '(\*' is encountered, we enter the INCOMMENT state. When EOF is encountered in comment state, error is             reported. After enetring INCOMMENT if we encounter '(*'again this means there are nested comments so we enter INCOM state. Pops of when corresponding '*)' is encountered. A comment ends when it encounters "*)".
    3. If the encounter '*)' with out encountering '(*' error is printed out.
    4. For nested comments we should EOF ,if we encounter EOF we report error.

**TESTING**

    I have conducted various tests on my code.
    Many rigorous tests are done for comments,strings to ensure that they are correct.
    Some test cases are provided.

