package solution43;

public class Solution {

	public int maxSubArray(int[] nums, int k) {
        // write your code here
        if(nums==null ||nums.length==0 || k>nums.length){
    		return 0;
    	}
    	int[][] res = new int[k+1][nums.length+1];
    	int local_max=0;
    	for(int i=1;i<=k;i++){
    		res[i][i]+=nums[i-1]+res[i-1][i-1];
    		local_max=res[i][i];
    		for(int j=i+1;j<=nums.length;j++){
    			//use this local max or start over local max=res[i-1][j-1]
    			local_max=Math.max(local_max+nums[j-1], res[i-1][j-1]+nums[j-1]);
    			res[i][j]=Math.max(res[i][j-1],local_max);
    		}
    	}
    	
    	return res[k][nums.length];
        
    }
    
    public static void main(String[] args) {
		// TODO Auto-generated method stub
    	int[] nums={-1,4,-2,3,-2,3};
    	System.out.println(maxSubArray(nums,2));
	}
}
