/* Definitions */
%{ 
    #include<stdio.h>
    void yyerror(char *);
%}
%start Start   //Start symbol of the gramar
%union // To define the types that we will use in our code
{
    float FloatVal; // To store float value
    struct Bit      // To store the structure of bit
    {
        float FloatVal;
        int Length; // Length of bitstring
    }BitString;
} 
%token ZERO ONE DOT END ERROR  //Tokens defined in lexer

// Specifing the types of Non-terminals 
%type<FloatVal> N B R Start 
%type<BitString> L
/* Rules */
%% 
Start : N END  { // Start symbol 
    $$=$1;
    printf("%f", $$);
    return 0;
}
N : L DOT R    {
    $$ = $1.FloatVal + $3;
    
}
|   L          {
    $$ = $1.FloatVal;
    
}
L : B L        { // Handels integer part
    $$.FloatVal = $1 * (1 << $2.Length) + $2.FloatVal;
    $$.Length = $2.Length + 1;
}
|   B          {
    $$.FloatVal = $1;
    $$.Length = 1;
}
R : B R        { // Handels fractional part
    $$ = $1/(2.0) + $2/(2.0);
}
|   B          {
    $$ = $1/(2.0);
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