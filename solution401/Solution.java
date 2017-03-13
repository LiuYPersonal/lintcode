package solution401;

import java.util.Comparator;
import java.util.PriorityQueue;

class Point{
	public int val, x, y;
	public Point(int val,int x,int y){
		this.x=x;
		this.y=y;
		this.val=val;
	}
}
class PointComparator implements Comparator<Point>{
	public int compare(Point x,Point y){
		return x.val-y.val;
	}
}
public class Solution {
	
    public static int kthSmallest(int[][] matrix, int k) {
        // write your code here
    	int row=matrix.length;
    	int col=matrix[0].length;
    	if(row==0 || col==0){
    		return 0;
    	}
    	PriorityQueue<Point> minHeap=new PriorityQueue<Point>(new PointComparator());
    	Point tmp=new Point(matrix[0][0],0,0);
    	int x,y;
    	minHeap.add(tmp);
    	int i=1;
    	while(i<k){
    		tmp=minHeap.poll();
    		x=tmp.x;
    		y=tmp.y;
    		if(y+1<col){
	    		tmp=new Point(matrix[x][y+1],x,y+1);
	    		minHeap.add(tmp);
    		}
    		
    		if(y==0 && x+1<row){
    			tmp=new Point(matrix[x+1][y],x+1,y);
    			minHeap.add(tmp);
    		}

    		i++;
    	}
    	return minHeap.peek().val;
    }
    public static void main(String[] args) {
		// TODO Auto-generated method stub
    	int[][] nums={{1,5,7},{3,7,8},{4,8,9}};
    	System.out.println(kthSmallest(nums,4));
	}
}
