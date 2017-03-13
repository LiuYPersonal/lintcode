package solution373;

public class Solution {
	public void partitionArray(int[] nums) {
        if(nums.length==0) return;
        int p=0,q=nums.length;
        while(p<=q){
        	while(p<=q && nums[p]%2==1){
        		p++;
        	}
        	while(p<=q && nums[q]%2==0){
        		q--;
        	}
        	if(p<=q){
        		int tmp=nums[p];
        		nums[p]=nums[q];
        		nums[q]=tmp;
        		p++;
        		q--;
        	}
        }
        return;
    }
}
