package solution33;

import java.util.ArrayList;

public class Solution {

    public static ArrayList<ArrayList<String>> solveNQueens(int n) {
    	
    	ArrayList<ArrayList<String>> res=new ArrayList<ArrayList<String>>();
    	ArrayList<ArrayList<Integer>> res2=new ArrayList<ArrayList<Integer>>();
        // write your code here
    	if(n<=0){
    		return res;
    	}
    	if(n==1){
    		ArrayList<String> tmp=new ArrayList<String>();
    		tmp.add("Q");
    		res.add(tmp);
    		return res;
    	}
    	int[] position=new int[n+1];
    	res2=searchPosition(n,position,1);  	
    	ArrayList<Integer> tmp2;
    	ArrayList<String> tmp;
    	String tmp3;
    	for(int i=0;i<res2.size();i++){
    		tmp2=res2.get(i);
    		tmp=new ArrayList<String>();
    		for(int j=0;j<tmp2.size();j++){
    			tmp3="";
    			for(int k=0;k<n;k++){
    				tmp3+=(tmp2.get(j)==k?"Q":".");
    			}
    			tmp.add(tmp3);
    		}
    		res.add(tmp);
    		
    	}
    	return res;
    }
    
    public static ArrayList<ArrayList<Integer>> searchPosition(int n, int[] position, int row){
    	ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
    	//check availability
    	int count=0;
    	ArrayList<Integer> tmp;
    	for(int i=0;i<n;i++){
    		int k;
    		for(k=1;k<row;k++){
    			if(position[k]==i || Math.abs(position[k]-i)==Math.abs(k-row)){
    				break;
    			}
    		}
    		if(k==row){
    			if(row==n){
    				tmp=new ArrayList<Integer>();
    				tmp.add(i);
    				res.add(tmp);
    				return res;
    			}
    			else{
    				position[row]=i;
    				res.addAll(searchPosition(n,position,row+1));
    				for(int w=count;w<res.size();w++){
    					tmp=res.get(w);
    					tmp.add(0,i);
    				}
    				count=res.size();
    			}
    		}
    	}

    	return res;
    }
    public static void main(String[] args) {
		// TODO Auto-generated method stub

    	System.out.println(solveNQueens(5));
	}
}
