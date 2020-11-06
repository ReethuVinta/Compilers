class Main inherits IO
{
    n : Int;
    result : Bool;
    mod(x : Int, y: Int) : Int --Function to find x%y
    {
        x-y*(x/y)
    };
    check(n : Int) : Bool  --Function to find whether n%2=0 or not
    {
        if mod(n,2)=0 then true
        else false
        fi
    };
    main() : Object
    {
        {
            out_string("Check whether given number is even or not \n");
            out_string("Give value of n :");
            n <- in_int();
            out_string("\n");
            if check(n) then --calling function here
                out_string("Given number is an even number \n")
            else
                out_string("Given number is not an even number \n")
            fi;
        }
    };
};