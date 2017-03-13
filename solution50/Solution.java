package solution50;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {

    public static ArrayList<Long> productExcludeItself(ArrayList<Integer> A) {
        // write your code
    	if(A==null){
    		return null;
    	}
    	ArrayList<Long> result=new ArrayList<Long>();
    	if(A.isEmpty()){
    		return result;
    	}
    	if(A.size()==1){
    		result.add((long)0);
    		return result;
    	}
    	long[] left=new long[A.size()];
    	long[] right=new long[A.size()];
    	left[0]=A.get(0);
    	right[0]=A.get(A.size()-1);
    	for(int i=1;i<A.size();i++){
    		left[i]=left[i-1]*A.get(i);
    		right[i]=right[i-1]*A.get(A.size()-1-i);
    	}
    	result.add(right[A.size()-2]);
    	for(int i=1;i<A.size()-1;i++){
    		result.add(left[i-1]*right[A.size()-2-i]);
    	}
    	result.add(left[A.size()-2]);
        return result;
    }

    public static void main(String[] args) {
		// TODO Auto-generated method stub
    	ArrayList<Integer> nums=new ArrayList<Integer>(Arrays.asList(1));
    	System.out.println(productExcludeItself(nums));
	}
}
