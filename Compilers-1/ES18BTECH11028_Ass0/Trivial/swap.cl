class Main inherits IO
{
    a : Int;
    b : Int;
    temp : Int;
    main() : Object
    {
        {
            out_string("Swapping two numbers a and b \n");
            out_string("Please give value of a : ");
            a <- in_int();
            out_string("Please give value of b : ");
            b <- in_int();
            out_string("\n");
            temp <- a; --Swapping of a and b value
            a <- b;
            b <- temp;
            out_string("After swapping \n");
            out_string("Value of a : ");
            out_int(a);
            out_string("\n");
            out_string("Value of b : ");
            out_int(b);
            out_string("\n");
        }
    };
};