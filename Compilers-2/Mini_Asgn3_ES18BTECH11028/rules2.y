/* Definitions */
%{ 
    #include<stdio.h>
    void yyerror(char *);
%}
%start Start   //Start symbol of the grammar  
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
%type<FloatVal> N B Start
%type<BitString> L
/* Rules */
%%
Start : N END  { // Start symbol 
    $$=$1;
    printf("%f", $$);
    return 0;
} 
N : L DOT L    {
    $$ = $1.FloatVal + ($3.FloatVal)/(1 << $3.Length);
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
B : ZERO       {
    $$=0;
}
|  ONE         {
    $$=1;
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