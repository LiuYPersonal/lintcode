package solution3;

public class Solution {
	
	
    public static int digitCounts(int k, int n) {
        // write your code here
    	int base=1;
    	int count=0;
    	int cur=0;
    	int higher=0;
    	int lower=0;
    	while(n/base>0){
    		cur=n%(base*10)/base;
    		higher=n/(base*10);
    		lower=n%base;
    		if(cur<k){
    			count+=higher*base;
    		}
    		else if(cur==k){
    			count+=higher*base+lower+1;
    		}
    		else{
    			count+=(higher+1)*base;
    		}
    		base*=10;
    	}
    	if(k==0){
    		count-=base/10;
    	}
    	return count;
    }
    public static void main(String[] args) {
		// TODO Auto-generated method stub
    	System.out.println(digitCounts(0,19));
	}
}
