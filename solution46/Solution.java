package solution46;


public class Solution {
	
    public static int majorityNumber(int[] nums) {
    	int votes=0;
    	int voted=0;
    	for(int i=0;i<nums.length;i++){
    		if(votes==0){
    			voted=nums[i];
    			votes=1;
    		}
    		else if(nums[i]==voted){
    			votes++;
    		}
    		else{
    			votes--;
    		}

    	}
    	return voted;
    }
    public static void main(String[] args) {
		// TODO Auto-generated method stub
    	int[] nums={1, 2, 1, 2, 1, 3, 3};
    	System.out.println(majorityNumber(nums));
	}
}
