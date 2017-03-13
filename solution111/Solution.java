package solution111;

public class Solution {

    public static int climbStairs(int n) {
    	if(n<=0){
    		return 0;
    	}
    	int[] res=new int[n+1];
        // write your code here

    	if(n==1){
    		return 1;
    	}
    	else if(n==2){
    		return 2;
    	}
    	res[0]=0;
    	res[1]=1;
    	res[2]=2;
    	for(int i=3;i<=n;i++){
    		res[i]=res[i-1]+res[i-2];
    	}
    	return res[n];
    }
    public static void main(String[] args) {
    	System.out.println(climbStairs(44));
    }
}
