package solution413;

public class Solution {
	
    public int reverseInteger(int n) {
        // Write your code here
    	long res=0;
    	boolean flag=false;
    	if(n<0){
    		flag=true;
    		n=-n;
    	}
    	while(n>0){
    		res=10*res+n%10;
    		n=n/10;
    	}
    	if(flag){
    		res=-res;
    	}
    	if(res>Integer.MAX_VALUE){
    		return 0;
    	}
    	return (int) res;
    }
}
