package solution162;

public class Solution {
	
    public static void setZeroes(int[][] matrix) {
        // write your code here
    	int row=matrix.length;
    	int col=matrix[0].length;
    	boolean clear_row=false,clear_col=false;
    	for(int i=0;i<row;i++){
    		if(matrix[i][0]==0){
    			clear_row=true;
    			break;
    		}
    	}
    	for(int j=0;j<col;j++){
    		if(matrix[0][j]==0){
    			clear_col=true;
    			break;
    		}
    	}
    	for(int i=1;i<row;i++){
    		for(int j=1;j<col;j++){
    			if(matrix[i][j]==0){
    				matrix[0][j]=0;
    				matrix[i][0]=0;
    			}
    		}
    	}
    	for(int i=0;i<row;i++){
    		if(matrix[i][0]==0){
    	    	for(int j=0;j<col;j++){
    	    		matrix[i][j]=0;
    	    	}  
    		}
    	}
    	for(int j=0;j<col;j++){
    		if(matrix[0][j]==0){
            	for(int i=0;i<row;i++){
            		matrix[i][j]=0;
            	}    			
    		}
    	}  
    	if(clear_row){
        	for(int i=0;i<row;i++){
        		matrix[i][0]=0;
        	}
    	}
	    if(clear_col){
	    	for(int j=0;j<col;j++){
	    		matrix[0][j]=0;
	    	}    	
	    }
    }
    public static void main(String[] args) {
		// TODO Auto-generated method stub
    	int[][] nums={{0,2}};
    	setZeroes(nums);
	}
}
