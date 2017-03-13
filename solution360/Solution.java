package solution360;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class Solution {
	
    public static ArrayList<Integer> medianSlidingWindow(int[] nums, int k) {
        // write your code here
    	ArrayList<Integer> res=new ArrayList<Integer>();
    	PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
    	PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(1,Collections.reverseOrder());
    	for(int i=0;i<nums.length;i++){
    		if(maxHeap.isEmpty() || nums[i]<=maxHeap.peek()){
    			maxHeap.add(nums[i]);
    		}
    		else{
    			minHeap.add(nums[i]);
    		}
    		if(maxHeap.size() >minHeap.size() + 1){
    			minHeap.add(maxHeap.poll());
    		}
    		else if(maxHeap.size() <minHeap.size()){
    			maxHeap.add(minHeap.poll());
    		}
    		if(i>=k-1){
    			res.add(maxHeap.peek());
    			int toRemove=nums[i-k+1];
    			if(maxHeap.contains(toRemove)){
    				maxHeap.remove(toRemove);
    			}
    			else{
    				minHeap.remove(toRemove);
    			}
        		if(maxHeap.size() >minHeap.size() + 1){
        			minHeap.add(maxHeap.poll());
        		}
        		else if(maxHeap.size() <minHeap.size()){
        			maxHeap.add(minHeap.poll());
        		}
    		}
    	}
    	return res;
    }
    public static void main(String[] args) {
    	int[] A={1,2,7,8,5};
    	System.out.println(medianSlidingWindow(A,3));
    }
}
