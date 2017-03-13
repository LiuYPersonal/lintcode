package solution89;

import java.util.Arrays;

public class Solution {

	
    public static int kSum(int A[], int k, int target) {
        // write your code here
    	if(A.length==0 || k<=0 || target<=0){
    		return 0;
    	}
    	int[][][] dp=new int[A.length+1][k+1][target+1];
    	Arrays.sort(A);
    	for(int i=0;i<=A.length;i++){
        	dp[i][0][0]=1;
    	}

    	for(int m=1;m<=A.length;m++){
	    	for(int i=1;i<=Math.min(k,m);i++){
	    		for(int j=1;j<=target;j++){
	    			if(j>=A[m-1]){
	    				dp[m][i][j]=dp[m-1][i][j]+dp[m-1][i-1][j-A[m-1]];
	    			}
	    			else{
	    				dp[m][i][j]=dp[m-1][i][j];
	    			}
	    		}
	    	}
    	}
    	return dp[A.length][k][target];
    }
    public static void main(String[] args) {
		// TODO Auto-generated method stub
    	int[] A={1,2,3,4};
    	System.out.println(kSum(A,2,5));
	}
}
