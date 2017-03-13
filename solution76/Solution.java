package solution76;

import java.util.Arrays;

public class Solution {
	
    public static int longestIncreasingSubsequence(int[] nums) {
        // write your code here
    	if(nums==null || nums.length==0){
    		return 0;
    	}
        int[] new_nums=nums.clone();
        Arrays.sort(new_nums);
        int[][] res=new int[nums.length+1][nums.length+1];
    	for(int i=0;i<nums.length+1;i++){
    		res[i][0]=0;
    		res[0][i]=0;
    		
    	}
    	
    	for(int i=1;i<nums.length+1;i++){
    		int last=Integer.MIN_VALUE;
    		for(int j=1;j<nums.length+1;j++){
    			if(nums[i-1]==new_nums[j-1] && nums[i-1]>last){
    				res[i][j]=res[i-1][j-1]+1;
    				last=nums[i-1];
    			}
    			else{
    				res[i][j]=Math.max(res[i-1][j], res[i][j-1]);
    			}
    		}
    	}
    	return res[nums.length][nums.length];
        
    }
    public static void main(String[] args) {
		// TODO Auto-generated method stub
    	int[] nums={4,2,4,5,3,7};
    	System.out.println(longestIncreasingSubsequence(nums));
	}
}
