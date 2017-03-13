package solution90;

import java.util.ArrayList;

public class Solution {
	
    public static ArrayList<ArrayList<Integer>> kSumII(int[] A, int k, int target) {
        // write your code here
    	return findKSum(A,k,target,0);
    }
    public static ArrayList<ArrayList<Integer>> findKSum(int[] A, int k, int target,int start){
    	ArrayList<ArrayList<Integer>> res= new ArrayList<ArrayList<Integer>>();
    	if(A.length==0){
    		return res;
    	}
    	if(k==1){
    		for(int i=start;i<A.length;i++){
    			if(A[i]==target){
		    		ArrayList<Integer> tmp=new ArrayList<Integer>();
		    		tmp.add(A[i]);
		    		res.add(tmp);
		    		break;
    			}
    		}
	    	return res;
    	}
    	int count=0;
    	ArrayList<Integer> tmpRes=new ArrayList<Integer>();
    	for(int i=start;i<A.length-1;i++){
    		if(A[i]<target){
    			res.addAll(findKSum(A,k-1,target-A[i],i+1));
        		for(int j=count;j<res.size();j++){
        			tmpRes=res.get(j);
        			tmpRes.add(A[i]);
        		}
        		count=res.size();
    		}
    	}
        return res;	
    }
    public static void main(String[] args) {
		// TODO Auto-generated method stub
    	int[] A={1,2,3,4};
    	System.out.println(kSumII(A,3,6));
	}
}
