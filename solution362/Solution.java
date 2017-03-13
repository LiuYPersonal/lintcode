package solution362;

import java.util.ArrayList;
import java.util.LinkedList;

public class Solution {

	
    public static ArrayList<Integer> maxSlidingWindow(int[] nums, int k) {
        // write your code here
    	//assert nums.length>k;
    	ArrayList<Integer> res=new ArrayList<Integer>();
    	LinkedList<Integer> queue=new LinkedList<Integer>();
    	if(nums.length==0){
    		return res;
    	}  
        for(int i=0;i<nums.length;i++){
        	if(!queue.isEmpty() && queue.peek()<=i-k){
        		queue.poll();
        	}
    		while(!queue.isEmpty() && nums[i]>nums[queue.peekLast()]){
    			queue.removeLast();
    		}
    		queue.addLast(i);
        	if(i>=k-1){
        	   res.add(nums[queue.peek()]);
        	}
        }
        return res;
    }
    public static void main(String[] args) {
    	int[] A={1,2,7,7,8};
    	System.out.println(maxSlidingWindow(A,3));
    }
}
