package solution45;

public class Solution {
	public static int maxDiffSubArrays(int[] nums) {
        // write your code here
    	if(nums.length==0) return 0;
    	int local_max=0;
    	int local_min=0;
    	int[] global_max_left=new int[nums.length+1];
    	int[] global_min_left=new int[nums.length+1];
    	int[] global_max_right=new int[nums.length+1];
    	int[] global_min_right=new int[nums.length+1];    	
    	global_max_left[0]=Integer.MIN_VALUE;
    	global_min_left[0]=Integer.MAX_VALUE;
    	global_max_right[nums.length]=Integer.MIN_VALUE;
    	global_min_right[nums.length]=Integer.MAX_VALUE;
    	for(int i=1;i<=nums.length;i++){
    		local_max=local_max+nums[i-1];
    		global_max_left[i]=Math.max(global_max_left[i-1], local_max);
    		if(local_max<0){
    			local_max=0;
    		}
    		local_min=local_min+nums[i-1];
    		global_min_left[i]=Math.min(global_min_left[i-1], local_min);
    		if(local_min>0){
    			local_min=0;
    		}
    	}
    	local_max=0;
    	local_min=0;
    	for(int i=nums.length;i>0;i--){
    		local_max=local_max+nums[i-1];
    		global_max_right[i-1]=Math.max(global_max_right[i], local_max);
    		if(local_max<0){
    			local_max=0;
    		}
    		local_min=local_min+nums[i-1];
    		global_min_right[i-1]=Math.min(global_min_right[i], local_min);
    		if(local_min>0){
    			local_min=0;
    		}
    	}
    	int max=0;
    	for(int i=1;i<nums.length-1;i++){
    		local_max=Math.max(Math.abs(global_max_left[i]-global_min_right[i]),Math.abs(global_min_left[i]-global_max_right[i]));
    		if(local_max>max){
    			max=local_max;
    		}
    	}	
    	return max;
    }
    public static void main(String[] args) {
		// TODO Auto-generated method stub
    	int[] nums={2,3,-3,1};
    	System.out.println(maxDiffSubArrays(nums));
	}
}
