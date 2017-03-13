package solution34;

import java.util.ArrayList;

public class Solution {
    public int totalNQueens(int n) {
		ArrayList<ArrayList<Integer>> res2=new ArrayList<ArrayList<Integer>>();
	    // write your code here
		if(n<=0){
			return 0;
		}
		
		int[] position=new int[n];
		
		res2=searchPosition(0,position,n);
		return res2.size();
	}
	
	public static ArrayList<ArrayList<Integer>> searchPosition(int col, int[] position, int n){
		ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> tmp=new ArrayList<Integer>();
		int k=0;
		for(int i=0;i<n;i++){
			for(k=0;k<col;k++){
	    		if((position[k]!=i && Math.abs(i-position[k])!=Math.abs(col-k))){
	    			continue;
	    			}
				else{
					break;
					
				}
	    	}
	
			if(k==col){
	    		position[col]=i;	
	        	if(col==n-1){
	        		tmp.add(i);
	        		res.add(tmp);
	        	}
	        	else{
	        		ArrayList<ArrayList<Integer>> tmp2=searchPosition(col+1,position,n);
	        		int w=0;
	        		while(w<tmp2.size()){
	        			tmp=tmp2.get(w);
	        			tmp.add(i);
	        			res.add(tmp);
	        			w++;
	        		}
	        	}
			}
	
		}
		return res;
	}
}
