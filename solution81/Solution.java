package solution81;

import java.util.Collections;
import java.util.PriorityQueue;

public class Solution {
    public static int[] medianII(int[] nums) {
        // write your code here
    	if(nums==null || nums.length==0){
    		return nums;
    	}
    	PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
    	PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(1,Collections.reverseOrder());
    	
        int[] res=new int[nums.length];
        res[0] = nums[0];  
        maxHeap.add(nums[0]);  

        for(int i = 1; i < nums.length; i++) {  
            int x = maxHeap.peek();  
            if(nums[i] <= x) {  
                maxHeap.add(nums[i]);  
            } else {  
                minHeap.add(nums[i]);  
            }  
            if(maxHeap.size() > minHeap.size()+1 ) { 
                minHeap.add(maxHeap.poll());  
            } else if(maxHeap.size() < minHeap.size()) {  
                maxHeap.add(minHeap.poll());  
            }  
            res[i] = maxHeap.peek();  
        }  
        return res;
    	
    }
    
    public static void main(String[] args) {
    	int[] nums={1,2,3,4,5};
    	System.out.println(medianII(nums));
    }
}
