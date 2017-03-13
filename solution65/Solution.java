package solution65;

import java.util.ArrayList;

public class Solution {
	
	public double findMedianSortedArrays(int[] A, int[] B) {
        // write your code here
    	for(int i=0;i<A.length;i++){
    		AB.add(A[i]);
    	}
    	for(int i=0;i<B.length;i++){
    		AB.add(B[i]);
    	}
    	Collections.sort(AB);
    	if((A.length+B.length)%2==0){
    		return (double)(AB.get((A.length+B.length)/2)+AB.get((A.length+B.length)/2-1))/2;
    	}
    	else{
    		return AB.get((A.length+B.length)/2);
    	}
    }
}
