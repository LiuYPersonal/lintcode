package solution131;

import java.util.ArrayList;

class Edge{
	int val;
	boolean start;
	boolean end;
	Edge(int val, boolean start, boolean end){
		this.val=val;
		this.start=start;
		this.end=end;
	}
}
public class Solution {

    public static ArrayList<ArrayList<Integer>> buildingOutline(int[][] buildings) {

    }
    public static void main(String[] args) {
		// TODO Auto-generated method stub
    	int[][] nums={{1,3,3},{2,4,4},{5,6,1}};
    	System.out.println(buildingOutline(nums));
	}
}
