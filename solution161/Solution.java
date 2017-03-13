package solution161;

public class Solution {

    public static void rotate(int[][] matrix) {
        // write your code here
    	int n=matrix.length-1;
    	int tmp1,tmp2;
    	for(int i=0;i<(n+1)/2;i++){
    		for(int j=i;j<n;j++){
    			tmp1=matrix[j][n-i];
    			matrix[j][n-i]=matrix[i][j];
    			tmp2=matrix[n-i][n-j];
    			matrix[n-i][n-j]=tmp1;
    			tmp1=matrix[n-j][i];
    			matrix[n-j][i]=tmp2;
    			matrix[i][j]=tmp1;
    			
    		}
    	}
    }
    public static void main(String[] args) {
		// TODO Auto-generated method stub
    	int[][] nums={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
    	rotate(nums);
	}
}
