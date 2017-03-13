package solution140;


public class Solution {

    public static int fastPower(int a, int b, int n) {
        // write your code here
    	if(n==0){
    		return 1%b;
    	}
    	if(n==1){
    		return a%b;
    	}
    	long half=fastPower(a,b,n/2);
    	long res=(half*half)%b;
    	if(n%2==1){
    		res=(res*a)%b;
    	}
    	return (int)res;
    }
    public static void main(String[] args) {
		// TODO Auto-generated method stub
    	int a=3;
    	int b=7;
    	int n=5;
    	System.out.println(fastPower(a,b,n));
	}
}
