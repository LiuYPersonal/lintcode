package solution148;

public class Solution {
	public static void sortColors(int[] nums) {
        // write your code here
    	if(nums.length==0) return;
    	int i=0,j=nums.length-1;
    	int tmp,k=0;
    	while(k<j){
    		while(nums[i]==0){
    			i++;
    		}
    		while(nums[j]==2){
    			j--;
    		}
    		k=i;
    	    if(nums[k]==0){
    	        tmp=nums[i];
    	        nums[i] = nums[k];
    	        nums[k]=tmp;
    	        i++;
    	    }
    	    if(nums[k]==2){
    	        tmp=nums[j];
    	        nums[j]=nums[k];
    	        nums[k]=tmp;
    	        j--;
    	    }
    	    if(nums[k]==1){
    	        k++;
    	    }
    	}
        return;
    }
    public static void main(String[] args) {
    	int[] nums={2,0,0,1,2,0,2};
    	sortColors(nums);
    }
}
