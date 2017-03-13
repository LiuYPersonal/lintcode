package solution5;

public class Solution {
	
    public static int kthLargestElement(int k, int[] nums) {
        // write your code here
        if(nums.length<k){
            return 0;
        }
        int p=0,q=nums.length-1;
        k=nums.length-k+1;
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
        	if(left+1==k){
        		return nums[left];
        	}
        	else if(left+1>k){
        		q=left-1;
        	}
        	else{
        		p=left+1;
        	}
        }
        return nums[p];
    }
    public static void main(String[] args) {
		// TODO Auto-generated method stub
    	int[] nums={9,3,2,4,8};
    	System.out.println(kthLargestElement(3, nums));
	}
}
