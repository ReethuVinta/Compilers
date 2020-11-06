class Main inherits IO
{
    x : Bool <- True;
    --the first letter of true and false must be lowercase;     
    --the trailing letters may be upper or lower case 
    main() : Object
    {
        {
            if x=true then
                out_string("TRUE \n")
            else
                out_string("FALSE \n")
            fi;
        }
    };
};