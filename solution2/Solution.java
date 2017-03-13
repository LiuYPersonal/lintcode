package solution2;

public class Solution {

    public long trailingZeros(long n) {
        // write your code here
    	long res=0;
    	long x=5;
    	while(n>x){
    		res+=n/x;
    		x=x*5;
    	}
    	return res;
    }
	
}
