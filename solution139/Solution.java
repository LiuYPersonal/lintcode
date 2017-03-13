package solution139;

import java.util.Arrays;
import java.util.HashMap;

public class Solution {
	
    public static int[] subarraySumClosest(int[] nums) {
        // write your code here
    	if (nums==null || nums.length==0){
    		return null;
    	}
    	int[] result_index=new int[2];
    	if(nums.length==1){
    		result_index[0]=0;
    		result_index[1]=0; 
    		return result_index;
    	}
    	
    	HashMap<Integer,Integer>map=new HashMap<Integer,Integer>();
    	int[] sum=new int[nums.length];
    	sum[0]=nums[0];
    	map.put(0, -1);
    	map.put(sum[0], 0);
    	for(int i=1;i<nums.length;i++){
    		sum[i]=sum[i-1]+nums[i];
    		if(map.containsKey(sum[i])){
    			result_index[0]=map.get(sum[i])+1;
    			result_index[1]=i;
    			return result_index;
    		}
    		else{
    			map.put(sum[i], i);
    		}
    	}    	
     	int min_gap=Integer.MAX_VALUE;
     	Arrays.sort(sum);
     	for(int i=1;i<nums.length;i++){
     		if(Math.abs(sum[i]-sum[i-1])<min_gap){
     			min_gap=Math.abs(sum[i]-sum[i-1]);
     			int tmp1=map.get(sum[i]);
     			int tmp2=map.get(sum[i-1]);
     			if(tmp1>tmp2){
     				int tmp=tmp1;
     				tmp1=tmp2;
     				tmp2=tmp;
     			}
     			result_index[0]=tmp1+1;
     			result_index[1]=tmp2;
     		}
     	}
    	return result_index;
    }
    
    public static void main(String[] args) {
		// TODO Auto-generated method stub
    	int[] nums={-3,1,1,-3,5};
    	System.out.println(Arrays.toString(subarraySumClosest(nums)));
	}

}
