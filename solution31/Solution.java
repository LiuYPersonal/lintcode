package solution31;

public class Solution {
	public int partitionArray(int[] nums, int k) {
	    //write your code here
	    if(nums.length==0) return 0;
	    int p=0,q=nums.length-1;
	    while(p<q){
	    	while(nums[p]<k){
	    		p++;
	    	}
	    	while(nums[q]>=k){
	    		q--;
	    	}
	    	if(p<=q){
	    		int tmp=nums[p];
	    		nums[p]=nums[q];
	    		nums[q]=tmp;
	    		p--;
	    		q++;
	    	}
	    }
	    return p;
	    
    }
}
