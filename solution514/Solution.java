package solution514;

public class Solution {
	
    public static int numWays(int n, int k) {
        // Write your code here
        if(n<=0 || k<=0){
            return 0;
        }
        int[] dp=new int[n+1];
        dp[0]=0;
        dp[1]=k;
        dp[2]=k*k;
        int dis1,dis2;
        for(int i=3;i<=n;i++){
            dis1=dp[i-3];
            dis2=dp[i-2];
            dp[i]=(dis2-dis1)*(k-1)+(dp[i-1]-(dis2-dis1))*k;
        }
        return dp[n];
    }
    public static void main(String[] args) {
    	System.out.println(numWays(4,3));
    }
}
