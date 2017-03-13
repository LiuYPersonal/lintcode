package solution507;

public class Solution {
	public static void wiggleSort(int[] nums) {
        // Write your code here
    	if(nums==null || nums.length==0){
    	     return;
    	}
    	int k=nums.length/2;
    	int mid=partition(k,nums);
    	int[] res=new int[nums.length];
    	for(int i=0;i<nums.length;i++){
    		res[i]=mid;
    	}
		int l=0,r=nums.length-1;
		for(int i=0;i<nums.length;i++){
			if(nums[i]<mid){
				res[l]=nums[i];
				l++;
			}
			else if(nums[i]>mid){
				res[r]=nums[i];
				r--;
			}
		}
		if(nums.length%2==0){
			l=k-1;
		}
		else{
			l=k;
		}
		r=nums.length-1;
    	for(int i=0;i<nums.length;i++){
    		if(i%2==0){
    			nums[i]=res[l];
    			l--;
    		}
    		else{
    			nums[i]=res[r];
    			r--;
    		}
    	}
    	return;
	}
    	
    public static int partition(int k, int[] nums) {
        // write your code here
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
    	int[] nums={4,5,5,6};
    	wiggleSort(nums);
    }
}
