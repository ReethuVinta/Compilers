import time
start_time = time.time()#Starting the clock

x=1 #Time taken for these statments execution is being noted
y=2
z=x+y
print(z)
#Ending the clock

print("Time taken by program is : %s" % (time.time() - start_time))
#If we print the time we can see that for the same program the amount 
#of time taken by python language is over 1s but int C++ language the 
#time taken is closse to 0 seconds