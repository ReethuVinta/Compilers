class Main inherits IO
{
    n : Int;
    root : Int;
    low : Int <- 1;
    high : Int;
    mid : Int;
    i : Int <- 3;
    flag : Bool <- true;
    result : Bool;
    mod(x : Int, y: Int) : Int --Function to find x%y value
    {
        x-y*(x/y)
    };
    sqrt(x : Int) : Int --Function to find square root of n using binary search
    {
        if x=0 then x
        else if x=1 then x
        else
        {
            while  low <= high loop
            {
                mid <- (low+high)/2;
                if mid*mid = x then --if mid*mid = x we return mid
                {
                    low <- high+1;
                    root <- mid;
                }  
                else if mid*mid < x then --if mid*mid < x we go to right half of mid and check
                {
                    low<-mid+1;
                    root<-mid;
                }
                else  --if mid*mid > x we go to left half of mid and check
                {
                    high<-mid-1;
                }
                fi
                fi;              
            }
            pool;
            root;
        }
        fi
        fi
    };
    factors(x : Int) : Bool --Function that finds out the prime factor of n
    {
        if x=0 then false
        else if x=1 then false
        else
        {
            while mod(x,2)=0 loop --Finding the number of times the number is divisible by 2
            {
                out_int(2);
                out_string("  ");
                x <- x/2;
            }
            pool;
            while i<=sqrt(x) loop
            {
                while mod(x,i)=0 loop --if x%i=0 run the loop and print i
                {
                    out_int(i);
                    out_string("  ");
                    x <- x/i;
                }
                pool;
                i <- i+2; --Incrementing by 2
            }
            pool;
            if x < 2 then out_string(" ")
            else 
                out_int(x) --If x>2 then the number itself is prime number
            fi;
            out_string("\n");
            flag;
        }
        fi
        fi
    };
    main() : Object
    {
        {
            out_string("Finding prime factors of given number \n");
            out_string("Give n value \n");
            n <- in_int();
            high <- n;
            root <- sqrt(n);--Calling function that finds the square root of n
            out_string("Square root of ");
            out_int(n);
            out_string(" is : ");
            out_int(root);
            out_string("\n");
            out_string("Prime factors are : ");
            result <- factors(n);--Calling function to find the prime factors of n
            if result=false then out_int(n)
            else
                out_string(" ")
            fi;
            out_string("\n");
        }
    };
};