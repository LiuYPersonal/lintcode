package solution513;

import java.util.Arrays;

public class Solution {

    public static int numSquares(int n) {
        // Write your code here
    	int[] dp=new int[n+1];
    	Arrays.fill(dp, Integer.MAX_VALUE);
    	for(int i=0;i*i<=n;i++){
    		dp[i*i]=1;
    	}
    	for(int a=1;a<=n;a++){
    		for(int b=0;a+b*b<=n;b++){
    			dp[a+b*b]=Math.min(dp[a]+1, dp[a+b*b]);
    		}
    	}
    	return dp[n];
    }
    public static void main(String[] args) {
    	System.out.println(numSquares(12));
    }
    
}
