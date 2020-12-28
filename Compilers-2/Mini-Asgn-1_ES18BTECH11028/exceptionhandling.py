#Code to show exception handling in Python
a=2
b=0

try:
    print(a/b)
except Exception as e:
    print("Denominator is zero. Please provide another number as denominator")
#As we can see when we pass 0 as denominartor it goes inside 
#the except block and executes the code there.