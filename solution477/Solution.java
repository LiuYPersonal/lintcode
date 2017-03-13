package solution477;

import java.util.LinkedList;
import java.util.Queue;
class Pair{
	int x,y;
	Pair(int x,int y){
		this.x=x;
		this.y=y;
	}
}
public class Solution {	
    public static void surroundedRegions(char[][] board) {
        // Write your code here
    	if(board.length==0 || board[0].length==0){
    		return;
    	}
    	for(int i=0;i<board.length;i++){
    		if(board[i][0]=='O'){
    			board=BFS(board,i,0);
    		}
    		if(board[i][board[0].length-1]=='O'){
    			board=BFS(board,i,board[0].length-1);
    		}
    	}
    	for(int j=0;j<board[0].length;j++){
    		if(board[0][j]=='O'){
    			board=BFS(board,0,j);
    		}
    		if(board[board.length-1][j]=='O'){
    			board=BFS(board,board.length-1,j);
    		}
    	}
    	for(int i=0;i<board.length;i++){
    		for(int j=0;j<board[0].length;j++){
    			if(board[i][j]=='O'){
    				board[i][j]='X';
    			}
    			else if(board[i][j]=='#'){
    				board[i][j]='O';
    			}
    		}
    	}
    	return;
    }
    
    public static char[][] BFS(char[][] board, int i, int j){
    	Queue<Pair> queue=new LinkedList<Pair>();
    	queue.add(new Pair(i,j));
    	int x,y;
    	while(!queue.isEmpty()){
    		x=queue.peek().x;
    		y=queue.peek().y;
    		queue.poll();
    		board[x][y]='#';
			if(x+1<board.length && board[x+1][y]=='O'){
				queue.add(new Pair(x+1,y));
			}
			
			if(y+1<board[0].length && board[x][y+1]=='O'){
				queue.add(new Pair(x,y+1));
			}
			if((y-1)>=0 && board[x][y-1]=='O'){
				queue.add(new Pair(x,y-1));
			}
			if((x-1)>=0 && board[x-1][y]=='O'){
				queue.add(new Pair(x-1,y));
			}
    	}
    	return board;
    }
    public static void main(String[] args) {
		// TODO Auto-generated method stub
    	char[][] nums={"XOX".toCharArray()};
    	surroundedRegions(nums);
	}
}
