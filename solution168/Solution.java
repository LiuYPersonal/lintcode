package solution168;

public class Solution {
    public static int maxCoins(int[] nums) {
        // Write your code here
    	if(nums==null || nums.length==0){
    		return 0;
    	}
    	int[][] dp=new int[nums.length+2][nums.length+2];
    	int[] new_nums=new int[nums.length+2];
    	new_nums[0]=1;
    	new_nums[nums.length+1]=1;
    	for(int i=1;i<=nums.length;i++){
    		new_nums[i]=nums[i-1];
    	}
		for(int k=0;k<nums.length;k++){
			for(int i=1;i<=nums.length-k;i++){
				int j=i+k;
				for(int w=i;w<=j;w++){
					dp[i][j]=Math.max(dp[i][j], dp[i][w-1]+dp[w+1][j]+new_nums[i-1]*new_nums[w]*new_nums[j+1]);
				}
    		}
    	}
    	return dp[1][nums.length];
    }
    public static void main(String[] args) {
		// TODO Auto-generated method stub
    	int[] nums={4,1,5,10};
    	System.out.println(maxCoins(nums));
	}
}
