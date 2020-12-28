#include <bits/stdc++.h> 
using namespace std; 
int main() 
{ 
	time_t start, end; 
	time(&start); //Starting the clock
	
	int x=1; //Time taken for these statments execution is being noted
    int y=2;
    int z=x+y;
    cout<<z<<endl;

	time(&end); //ending the clock

	double time_taken = double(end - start); 
    //printing the timetaken to execute
	cout << "Time taken by program is : " << fixed << time_taken<< " sec " << endl; 
    /*If we print the time we can see that for the same program the amount 
      of time taken by python language is over 1s but int C++ language the 
      time taken is closse to 0 seconds*/
	return 0; 
} 
