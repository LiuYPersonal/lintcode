package solution389;

public class Solution {

    public static boolean isValidSudoku(String[] nums) {
    char[][] board=new char[9][9];
    for(int i=0;i<9;i++){
    	for(int j=0;j<9;j++){
    		board[i][j]=nums[i].charAt(j);
    	}
    }
    //check each row and col
    	int tmp=0;
	    for(int i=0;i<9;i++){
	    	boolean[] check_row=new boolean[9];
	    	boolean[] check_col=new boolean[9];
	    	for(int j=0;j<9;j++){
	    		if(board[i][j]!='.'){
	    			tmp=board[i][j]-'1';
	    			if(check_row[tmp]){
	    				return false;
	    			}
	    		}
	    		if(board[j][i]!='.'){
	    			tmp=board[j][i]-'1';
	    			if(check_col[tmp]){
	    				return false;
	    			}
	    		}
	    	}
	    }
	    //check each cell
	    for(int i=0;i<3;i++){
	    	for(int j=0;j<3;j++){
	    		boolean[] check=new boolean[9];
	    		for(int k=0;k<3;k++){
	    			for(int w=0;w<3;w++){
	    	    		if(board[3*i+k][3*j+w]!='.'){
	    	    			tmp=board[3*i+k][3*j+w]-'1';
	    	    			if(check[tmp]){
	    	    				return false;
	    	    			}
	    	    			else{
	    	    				check[tmp]=true;
	    	    			}
	    	    		}
	    			}
	    		}
	    		
	    	}
	    }
	    return true;
    
    }
    public static void main(String[] args) {
		// TODO Auto-generated method stub
    	String[] nums={"....5..1.",".4.3.....",".....3..1","8......2.","..2.7....",".15......",".....2...",".2.9.....","..4......"};
    	System.out.println(isValidSudoku(nums));
	}
}
