package solution14;

public class Solution {
	public static int binarySearch(int[] nums, int target) {
		
        if(nums.length==0 || target<nums[0] || target>nums[nums.length-1]){
            return -1;
        }
        else return Search(nums, 0, nums.length,target);
    }
    private static int Search(int[] nums, int p, int q, int target) {
        while(p<q){
            int mid=(p+q)/2;
	        if (nums[mid]==target){
	            while(mid>0 && nums[mid]==target){
	                mid--;
	            }
	            return mid+1;
	        } 
	       
	        else if (nums[mid]>target){
	            q=mid;
	        }
	        else{
	            p=mid+1;
	        }
        }
        return -1;
	}
    public static void main(String[] args) {
    	int[] A={1, 2, 3, 3, 4, 5, 10};
    	System.out.println(binarySearch(A,10));
    }
}
