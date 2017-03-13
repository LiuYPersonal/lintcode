package solution38;

public class Solution {

    public static int searchMatrix(int[][] matrix, int target) {
        // write your code here
    	if(matrix==null || matrix.length==0 ||matrix[0].length==0){
    		return 0;
    	}
    	int count=0;
    	int i=0;
    	int j=matrix[0].length-1;
    	while(i<matrix.length){
    		while(j>=0){
    			if(matrix[i][j]==target){
    				count++;
    				j--;
    			}
    			else if(matrix[i][j]<target){
    				break;
    			}
    			else{
    				j--;
    			}
    		}
    		i++;
    		j=matrix[0].length-1;
    	}
    	return count;
    }
    
    public static void main(String[] args) {
		// TODO Auto-generated method stub
    	int[][] matrix={{1,2,3,4},{2,4,4,5},{3,4,5,6},{4,6,6,7}};
    	System.out.println(searchMatrix(matrix,2));
	}
}
