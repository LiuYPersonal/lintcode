package solution181;

public class Solution {

    public static int bitSwapRequired(int a, int b) {
        // write your code here
    	int bit= a^b;
    	int count=0;
    	int number=32;
    	
    	while(number>0){
    		count+=bit &1;
    		bit=bit>>1;
    		number--;
    	}
    	
    	return count;
    	
    }
    
}
