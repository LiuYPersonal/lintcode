package solution80;

public class Solution {
	public int median(int[] nums) {
        if (nums==null || nums.length==0) return 0;  
		int p=0,q=nums.length-1;
	    int k=(nums.length-1)/2;
	    int pivot,left,right;
	    while(p<q){
	    	left=p;
	    	right=q;
	    	pivot=nums[p];
	    	while(left<right){
	        	while(left<right && nums[right]>=pivot ){
	        		right--;
	        	}
	        	nums[left] = nums[right];
	        	while(left<right && nums[left]<=pivot ){
	        		left++;
	        	}
	        	nums[right] = nums[left];
	    	}
	    	nums[left] = pivot;
	    	if(left==k){
	    		return nums[left];
	    	}
	    	else if(left>k){
	    		q=left-1;
	    	}
	    	else{
	    		p=left+1;
	    	}
	    }
	    return nums[p];
	}
}
