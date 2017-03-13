package solution363;

public class Solution {
	public static int trapRainWater(int[] heights) {
		int[] right_max=new int[heights.length];
		right_max[heights.length-1]=heights[heights.length-1];
		for(int j=heights.length-2;j>0;j--){
			right_max[j]=Math.max(right_max[j+1], heights[j]);
		}
		int left_max=heights[0];
		int i=1;
		int water=0;
		while(i<heights.length-1){
			if(heights[i]<left_max && heights[i]<right_max[i+1]){
				int top=Math.min(left_max, right_max[i+1]);
				water+=top-heights[i];				
			}
			else if(heights[i]>=left_max){
				left_max=heights[i];
			}
			i++;
		}
		return water;
		
	}
    public static void main(String[] args) {
		// TODO Auto-generated method stub
    	int[] nums={0,1,0,2,1,0,1,3,2,1,2,3};
    	System.out.println(trapRainWater(nums));
	}

}
