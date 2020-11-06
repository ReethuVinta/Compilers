class Main inherits IO
{
    n : Int;
    result : Int;
    square : Int;
    sum_of_squares(n : Int) : Int  --Function to find sum of squares of first n numbers
    {
        square <- ((n*(n+1))*(2*n+1))/6  --formula to find the sum
    };
    main() : Object
    {
        {
            out_string("Sum of squares of first n numbers \n");
            out_string("Give n value :\n");
            n <- in_int();
            result <- sum_of_squares(n);
            out_string("Sum of squares of first ");
            out_int(n);
            out_string(" numbers is : ");
            out_int(result);
            out_string("\n");
        }
    };
};