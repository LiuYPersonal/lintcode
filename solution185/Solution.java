package solution185;

public class Solution {
    public static int[] printZMatrix(int[][] matrix) {
        // write your code here
    	if(matrix==null || matrix.length==0 || matrix[0].length==0){
    		return null;
    	}
    	int row=matrix.length;
    	int col=matrix[0].length;
    	int[] res=new int[row*col];
    	int count=0;
    	int i=0,j=0;
    	boolean inv=false;
    	while(count<row*col){
			res[count]=matrix[i][j];
			count++;
			if(inv){
				if(i==row-1){
					j++;
					inv=!inv;
				}
				else if(j==0){
					i++;
					inv=!inv;
				}
				else{
					i++;
					j--;
				}
			}
			else{
				if(j==col-1){
					i++;
					inv=!inv;
				}
				else if(i==0){
					j++;
					inv=!inv;
				}
				else{
					i--;
					j++;
				}
			}
    	}
    	return res;
    }
    
    public static void main(String[] args) {
		// TODO Auto-generated method stub
    	int[][] nums={{1,2,3,4},{5,6,7,8},{9,10,11,12}};
    	System.out.println(printZMatrix(nums));
	}
}
