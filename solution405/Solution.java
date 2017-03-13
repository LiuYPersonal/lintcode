package solution405;

public class Solution {

	
    public int[][] submatrixSum(int[][] matrix) {
        // Write your code here
    	int[][] res=new int[2][2];
    	if(matrix.length==0 || matrix[0].length==0){
    		return res;
    	}
    	int row=matrix.length;
    	int col=matrix[0].length;
    	int[][] dp=new int[row][col];
    	dp[0][0]=matrix[0][0];
    	for(int i=1;i<row;i++){
    		dp[i][0]=dp[i-1][0]+matrix[i][0];
    		if(dp[i][0]==0){

    		}
    	}
    	for(int j=1;j<col;j++){
    		dp[0][j]=dp[0][j-1]+matrix[0][j];
    	}
    	return res;
    }
    
}
