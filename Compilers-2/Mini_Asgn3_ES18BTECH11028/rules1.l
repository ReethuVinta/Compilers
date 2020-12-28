/* Definitions */
%{ 
    #include <stdio.h> 
    #include"y.tab.h" /*Get tokens from yacc file*/
    #define YYSTYPE
%} 
/* Rules */
%% 
0       {return ZERO;} 
1       {return ONE;} 
[.]     {return DOT;}
[ \t]   {;} 
\n      {return END;}
.       {return ERROR;}
%% 
/* Sub Routines */	
int yywrap() 
{ 
    int yylex(); /* Invokes yylex function */
    return 1; 
} 