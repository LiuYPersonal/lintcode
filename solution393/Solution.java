package solution393;

public class Solution {
	
    public static int maxProfit(int k, int[] prices) {
        // write your code here
    	if(k<1 || prices.length==0){
    		return 0;
    	}
    	if(k>=prices.length-1){
    		return unlimitedTrans(prices);
    	}
    	int[][] dp=new int[k+1][prices.length];
    	int local_max=0;
    	for(int i=1;i<=k;i++){
    		local_max=0;
    		for(int j=i;j<prices.length;j++){
    			local_max=Math.max(local_max+prices[j]-prices[j-1], dp[i-1][j-1]+Math.max(prices[j]-prices[j-1], 0));
    			dp[i][j]=Math.max(local_max, dp[i][j-1]);
    		}
    	}
    	return dp[k][prices.length-1];
    }
    public static int unlimitedTrans(int[] prices){
    	int res=0;
    	for(int i=1;i<prices.length;i++){
    		if(prices[i]-prices[i-1]>0){
    			res+=prices[i]-prices[i-1];
    		}
    	}
    	return res;
    }
    public static void main(String[] args) {
    	int[] nums={1,2,4,2,5,7,2,4,9,0};
    	System.out.println(maxProfit(4,nums));
    }
}
