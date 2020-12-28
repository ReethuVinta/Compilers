#include<bits/stdc++.h>
using namespace std;
int main()
{
    int n = 1;
    if n>0  //Here we have forgot to close out expression by brackets()
    {
        cout<<"Number is postive"<<endl;
    }
    else
    {
        cout<<"Number is negative" // Here we didn't end the line with semicolon
    }
    /*As you can see there are errors at line 6,12. When yo run this files the
     console will show you these two errors at a same time*/
    return 0;
}