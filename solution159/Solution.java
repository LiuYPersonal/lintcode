package solution159;

public class Solution {
	
	
    public static int findMin(int[] nums) {
        // write your code here
    	if(nums==null || nums.length==0){
    		return 0;
    	}
    	if(nums[0]<=nums[nums.length-1]){
    		return nums[0];
    	}
    	int p=0;
    	int q=nums.length-1;
    	int center;
    	while(p+1<q){
    		center=p+(q-p)/2;
    		if(nums[center]>nums[p]){
    			p=center;
    		}
    		else if(nums[center]<nums[q]){
    			q=center;
    		}
    	}
    	return nums[q];
    }
    public static void main(String[] args) {
		// TODO Auto-generated method stub
    	int[] s={1, 2, 4, 5, 6, 7, 0};
    	System.out.println(findMin(s));
	}
}
