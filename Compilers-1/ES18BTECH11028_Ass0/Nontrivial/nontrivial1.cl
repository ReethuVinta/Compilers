class Main inherits IO
{
    n : Int;
    result : Int;
    rem : Int;
    sum : Int;
    mod(x : Int, y: Int) : Int --Function to find x%y value
    {
        x-y*(x/y)
    };
    notequal(x : Int) : Bool  --Function to find whether x=0 or not
    {
        if x=0 then false
        else true
        fi
    };
    check(x : Int) : Int --In this function we r checking whether sum of cubes of digits in number is equal to number or not
    {
        if x=0 then 0
        else
        {
            while notequal(x) loop
            {
                rem <- mod(x,10);
                sum <- sum + ((rem*rem)*rem);
                x <- x / 10;
            }
            pool;
            sum;
        }
        fi
    };
    main() : Object
    {
        {
            --A number is called armstring number if the sum of cubes of individual digits of number is equal to the number
            out_string("Checking whether given number is armstrong or not \n");
            out_string("Give n value \n");
            n <- in_int();
            result <- check(n);
            if result = n then
                out_string("Given number is armstrong number \n")
            else
                out_string("Given number is not an armstrong number \n")
            fi;
        }
    };
};