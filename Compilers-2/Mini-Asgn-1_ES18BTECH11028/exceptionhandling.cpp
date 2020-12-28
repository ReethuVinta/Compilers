#include<bits/stdc++.h>
using namespace std;
int main()
{
    int a=2;
    int b=01;
    try
    {
        if(b==0) throw 0;
        cout<<a/b<<endl;
    }
    catch(int x)
    {
        cout<<"Denominator is zero. Please provide another number as denominator"<<endl;
    }
    /*As we can see if b=0 then immediatly it passes the comand to catch 
    block and the chunck of code present there is executed */

    return 0;
}