package solution564;

public class Solution {
    public static int backPackVI(int[] nums, int target) {
        // Write your code here
        if(target<0 || nums==null || nums.length==0 ){
    		return 0;
    	}
    	int[] fill=new int[target+1];
    	fill[0]=1;
    	for(int j=0;j<=target;j++){
    	    for(int i=0;i<nums.length;i++){
    	        if(j+nums[i]<=target){
    			    fill[j+nums[i]]+=fill[j];
    	        }
    		}
    	}
    	return fill[target];
    }
    public static void main(String[] args) {
    	int[] nums={1,2,4};
    	System.out.println(backPackVI(nums,4));
    }
}
