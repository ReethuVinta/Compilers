class Main inherits IO
{
    number : Int <- 100; -- object identifiers begin with a lower case letter
    --(Here it begins with capital letter so we enconter error)
    x : Bool <- 0;
    y : Bool <- 0;
    main() : Object
    {
        {
            out_int(number);
            out_string("\n");
            number <- x?0:1;
            out_int(number);
        }
    };
};