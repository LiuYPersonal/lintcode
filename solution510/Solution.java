package solution510;

import java.util.Stack;

public class Solution {
	
	public int maximalRectangle(boolean[][] matrix) {
        // Write your code here
    	//row length
    	if(matrix.length==0 ||matrix[0].length==0) return 0;
    	int largestSize=0;
    	int[] dp=new int[matrix[0].length];
    	for(int i=0;i<matrix.length;i++){
    		//for each row, build a histogram
    		for(int j=0;j<matrix[0].length;j++){
    			if(matrix[i][j]){
    				dp[j]+=1;
    			}
    			else{
    				dp[j]=0;
    			}
    		}
    		//get the largest size for each histogram
	    	int size=largestRectangleArea(dp);
	    	//update values
	    	if(size>largestSize){
	    		largestSize=size;
	    	}	
    	}
    	return largestSize;
    }
    public int largestRectangleArea(int[] height) {
        // write your code here
    	Stack<Integer> h= new Stack<Integer>();
    	Stack<Integer> indexes= new Stack<Integer>();
    	int largestSize=0;
    	for(int i=0;i<height.length;i++){
    		if(h.isEmpty() || height[i]>h.peek()){
    			h.push(height[i]);
    			indexes.push(i);
    			    			
    		}
    		else if(height[i]<h.peek()){
    			int lastIndex=0;
    			while(!h.isEmpty() && height[i]<h.peek()){
    				lastIndex=indexes.pop();
    				int tempAreaSize=h.pop()*(i-lastIndex);
    				if(tempAreaSize>largestSize){
    					largestSize=tempAreaSize;
    				}
    			}
    			h.push(height[i]);
    			indexes.push(lastIndex);		
    		}
    	}
    	while(!h.isEmpty()){
    		int tmpAreaSize=h.pop()*(height.length-indexes.pop());
    		if(tmpAreaSize>largestSize){
				largestSize=tmpAreaSize;    			
    		}
    	}
    	return largestSize;
    }
}
