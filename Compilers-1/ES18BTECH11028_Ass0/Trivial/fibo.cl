class Main inherits IO
{
    n : Int;
    i : Int <- 0;
    first : Int <- 0; --First element of fibonacci sequence 
    second : Int <- 1; --Second element of fibonacci sequence
    result : Int <- 0;
    temp : Int <- 0;
    fibo(n : Int):Int --function to find nth fibonacci number
    {
        if n=1 then first --if given value is 1 we return 0
        else if n=2 then second --if given value is 2 we return 1
        else
        {
            while i < n-2 loop
            {
                temp <- first+second;
                first <- second;
                second <- temp;
                i <- i+1;
            }
            pool;
            second;  -- returning the nth symbol
        }
        fi
        fi
        
    };
    main() : Object
    {
        {
            out_string("Finding nth Fibonacci number \n");
            out_string("Please give value of n \n");
            n <- in_int();
            result <- fibo(n);
            out_string("Value of nth fibonacci number is ");
            out_int(result);
            out_string("\n");
        }
    };
};