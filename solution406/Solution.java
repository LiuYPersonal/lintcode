package solution406;

public class Solution {
	
	public static int minimumSize(int[] nums, int s) {
        // write your code here
    	if(nums==null || nums.length==0){
    	    return -1;
    	}
    	int i=0;
    	int sum=0;
    	int min=Integer.MAX_VALUE;
    	int last=0;
    	while(i<nums.length){
    		if(sum<s){
    			sum+=nums[i];
    			i++;
    		}		
    		while(sum>=s){
    			min=Math.min(min, i-last);
    			sum-=nums[last];
    			last++;
    		}   	    
    	}

    	return min;
    }
    
    public static void main(String[] args) {
    	int[] nums={2,3,1,2,4,3};
    	System.out.println(minimumSize(nums,7));
    }
    

}
