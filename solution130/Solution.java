package solution130;

import java.util.Arrays;

public class Solution {

    public static void heapify(int[] A) {
        // write your code here
    	Arrays.sort(A);
    	if(A.length==0){
    		return;
    	}
    	int len=A.length;
    	for(int i=len/2-1;i>=0;i--){
    		A=MinHeapify(A,i);
    	}
    }
    public static int[] MinHeapify(int[] A, int i){
    	int len=A.length;
    	int tmp;
    	if(2*i+2<len){
    		if(A[2*i+1]<A[i] && A[2*i+1]<A[2*i+2]){
    			tmp=A[2*i+1];
    			A[2*i+1]=A[i];
    			A[i]=tmp;
    			A=MinHeapify(A,2*i+1);
    		}
    		else if(A[2*i+2]<A[i] && A[2*i+2]<A[2*i+1]){
    			tmp=A[2*i+2];
    			A[2*i+2]=A[i];
    			A[i]=tmp;
    			A=MinHeapify(A,2*i+2);
    		}
    	}
    	else if(2*i+1<len){
    		if(A[2*i+1]<A[i]){
    			tmp=A[2*i+1];
    			A[2*i+1]=A[i];
    			A[i]=tmp;
    			A=MinHeapify(A,2*i+1);
    		}
    	}
    	return A;
    }
    public static void main(String[] args) {
		// TODO Auto-generated method stub
    	int[] nums={84,83,17,10,13,19,6,22,9};
    	heapify(nums);
	}
}
