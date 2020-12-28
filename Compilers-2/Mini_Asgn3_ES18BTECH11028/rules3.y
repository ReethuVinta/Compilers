/* Definitions */
%{ 
    #include<stdio.h>
    void yyerror(char *);
    #define YYSTYPE double // Defining the type of all non terminals as float
%}
%start Start   //Start symbol of the grammar    

%token ZERO ONE DOT END ERROR  //Tokens defined in lexer 
 
/* Rules */
%%
Start : N END  { // Start symbol 
    $$=$1;
    printf("%f", $$);
    return 0;
} 
N : L DOT R    {
    $$ = $1 + $3;
}
|   L          {
    $$ = $1;
}
L : L B        { // Handels integer part
    $$ = $1 * 2 + $2;
}
|   B          {
    $$ = $1;
}
R : B R        { // Handels fractional part
    $$ = $1/2.0 + $2/2.0;
}
|   B          {
    $$ = ($1)/2.0;
}
B : ZERO       {
    $$ = 0;
}
|  ONE         {
    $$ = 1;
}
%%
/* Sub Routines */
int main()
{
    yyparse(); // Invokes yyparse
}
void yyerror(char *Err_string)/*Function which gets invoked when error is seen*/
{
    printf("Invalid Bit string");
}