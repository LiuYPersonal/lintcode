package solution387;

import java.util.Arrays;

public class Solution {
	
    public static int smallestDifference(int[] A, int[] B) {
        // write your code here
       	if(A.length==0 || B.length==0) return 0;
    	Arrays.sort(A);
    	Arrays.sort(B);
    	int min=Integer.MAX_VALUE;
    	int i=0,j=0,local_min=Integer.MAX_VALUE;
    	while(i<A.length && j<B.length){
    		if(Math.abs(A[i]-B[j])>local_min){
    			j--;
    			i++;
    			local_min=Integer.MAX_VALUE;
    			
    		}
    		else{
	    		local_min=Math.abs(A[i]-B[j]);
	    		if(local_min<min){
	    			min=local_min;
	    			if(min==0){
	    				return 0;
	    			}
	    		}
	    		j++;
    		}    		
    		
    	}
    	return min;
    }
    public static void main(String[] args){
    	int[] A={10,25,55,34};
    	int[] B={18,47,46,42};
    	System.out.println(smallestDifference(A,B));
    }
}
