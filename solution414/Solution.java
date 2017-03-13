package solution414;

public class Solution {
	
	
    public static int divide(int dividend, int divisor) {
        // Write your code here
        if(divisor==0){
            return Integer.MAX_VALUE;
        }
        boolean flag=false;
        long d1=dividend;
        long d2=divisor;
        if(dividend<0){
            flag=!flag;
            d1=-d1;
        }
        if(divisor<0){
            flag=!flag;
            d2=-d2;
        }
        int res = BinarySearch(d1, d2, 0, d1);
        if(flag){
            return 0-res;
        }
        return res;
    }
    public static int BinarySearch(long dividend, long divisor, long p, long q){
    	if(p+1==q){
    	    if(q*divisor==dividend){
    	        return (int)q;
    	    }
    		return (int)p;
    	}
    	int mid=(int)(p+q)/2;
    	long res=mid*divisor;
    	if(res<dividend){
    		return BinarySearch(dividend, divisor, mid, q);
    	}
    	else if(res==dividend){
    		return mid;
    	}
    	else{
    		return BinarySearch(dividend, divisor, p, mid);
    	}
    }
    public static void main(String[] args) {
		// TODO Auto-generated method stub
    	System.out.println(divide(-2147483648,-1));
	}
}
