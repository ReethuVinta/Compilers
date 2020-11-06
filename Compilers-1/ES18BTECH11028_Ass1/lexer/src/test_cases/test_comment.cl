class Main inherits IO
{
    input : String <-"This is my world";
    (* hello

    random comment to test *)

    *)
    main() : Object
    {
        --Example for single line comment
        out_string(input)
    };
    --Error message is given for the below as it crosses file boundaries
    (*This commment crosses file boundaries--EOF error is printed
};