package solution436;

public class Solution {

	public int maxSquare(int[][] matrix) {
        // write your code here
		if(matrix==null || matrix.length==0 || matrix[0].length==0){
			return 0;
		}
    	
    	int[][] square=new int[matrix.length+1][matrix[0].length+1];
    	int max=0;
    	//DP
    	for(int i=1;i<=matrix.length;i++){
    		for(int j=1;j<=matrix[0].length;j++){
    			if(matrix[i-1][j-1]==1){
    				square[i][j]=Math.min(square[i-1][j-1], Math.min(square[i-1][j], square[i][j-1]))+1;
    			}
    			if(square[i][j]>max){
    				max=square[i][j];
    			}
    		}
    	}
    	return max*max;
    }
}
