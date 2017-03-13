package solution91;

import java.util.ArrayList;

public class Solution {

    public static int MinAdjustmentCost(ArrayList<Integer> A, int target) {
        // write your code here
    	if(A==null || A.size()<=0){
    		return 0;
    	}
    	int[][] res=new int[A.size()+1][100];
    	for(int i=0;i<100;i++){
    		res[0][i]=0;
    	}
    	for(int i=1;i<A.size()+1;i++){
    		for(int j=0;j<100;j++){
    			res[i][j] = Integer.MAX_VALUE;
    			int lowerRange=Math.max(0, j-target);
    			int upperRange=Math.min(99, j+target);
    			for(int p=lowerRange;p<=upperRange;p++){
    				res[i][j]=Math.min(res[i][j], res[i-1][p]+Math.abs(A.get(i-1)-j));
    			}
    		}
    	}
    	int cost=Integer.MAX_VALUE;
    	for(int j=0;j<100;j++){
    		if(res[A.size()][j]<cost){
    			cost=res[A.size()][j];
    		}
    	}
    	return cost;
    }
    public static void main(String[] args) {
		// TODO Auto-generated method stub
    	ArrayList<Integer> A=new ArrayList<Integer>();
    	A.add(1);
    	A.add(4);
    	A.add(2);
    	A.add(3);
    	System.out.println(MinAdjustmentCost(A,1));
	}
}
