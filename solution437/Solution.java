package solution437;

public class Solution {
	
    public static int copyBooks(int[] pages, int k) {
        // write your code here
    	if(pages.length==0 || k==0){
    		return 0;
    	}
    	int[][] dp=new int[k+1][pages.length+1];
    	int[] sum=new int[pages.length+1];
    	sum[0]=0;
    	for(int i=1;i<=pages.length;i++){
    		sum[i]=sum[i-1]+pages[i-1];
    		dp[1][i]=sum[i];
    	}
    	for(int i=2;i<=k;i++){
    		for(int j=pages.length;j>=k;j--){
    			for(int w=i;w<j;w++){
    				dp[i][j]=Math.min(dp[i][j],Math.max(dp[i-1][j-1], sum[pages.length]-sum[j-1]));
    			}
    		}
    	}
    	return dp[k][pages.length];
    }
    public static void main(String[] args) {
		// TODO Auto-generated method stub
    	int[] pages={3,2,4,5,1,5,2,6,7,1};
    	System.out.println(copyBooks(pages,3));
	}
}
