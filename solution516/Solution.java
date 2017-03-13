package solution516;

public class Solution {
	
    public static int minCostII(int[][] costs) {
        // Write your code here
    	if(costs==null || costs.length==0 || costs[0].length==0){
    		return 0;
    	}
    	int[][] dp=new int[costs.length+1][costs[0].length];
    	int min21=0,min22=0;
    	int index21=-1;
    	for(int i=1;i<=costs.length;i++){
    		for(int j=0;j<costs[0].length;j++){
    			if(j==index21){
    				dp[i][j]=min22+costs[i-1][j];
    			}
    			else{
    				dp[i][j]=min21+costs[i-1][j];
    			}
    		}
			min21=Integer.MAX_VALUE;
			min22=Integer.MAX_VALUE;
    		for(int j=0;j<costs[0].length;j++){
	    		if(dp[i][j]<min21){
	    			min22=min21;
	    			min21=dp[i][j];
	    			index21=j;
	    		}
	    		else if(dp[i][j]<min22){
	    			min22=dp[i][j];
	    		}
    		}
    	}
    	return min21;
    }
    public static void main(String[] args) {
		// TODO Auto-generated method stub
    	int[][] nums={{14,2,11},{11,14,5},{14,3,10}};
    	System.out.println(minCostII(nums));
	}
}
