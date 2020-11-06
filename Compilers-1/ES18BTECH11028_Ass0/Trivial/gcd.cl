class Main inherits IO
{
    a : Int;
    b : Int;
    result : Int;
    mod(x : Int, y: Int) : Int--Function to find x%y value
    {
        x-y*(x/y)
    };
    gcd(x : Int, y : Int) : Int  --Function to find GCD of two numbers
    {
        if x=0 then y
        else
            gcd(mod(y,x),x)
        fi
    };
    main() : Object
    {
        {
            out_string("GCD of two numbers \n");
            out_string("Give two numbers : \n");
            a <- in_int();
            b <- in_int();
            result <- gcd(a,b);
            out_string("GCD of ");
            out_int(a);
            out_string(" and ");
            out_int(b);
            out_string(" is ");
            out_int(result);
            out_string("\n");
        }
    };
};