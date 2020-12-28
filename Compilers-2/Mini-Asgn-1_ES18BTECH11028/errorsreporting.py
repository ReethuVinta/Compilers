# Writting a program to show that python shows error line by line

n=1;
if (n > 0) #Here we removed ':' which is a syntax error
    print("Number is postive")
elif n==0  #Here alse we have removed ':' which is also a syntax error
    print("Number is 0")

# But the console will only print the error in line 4
# There will be no error message printed at line 6 as Interpreter
# scans the code one line at a time 
