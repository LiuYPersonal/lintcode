package solution138;

import java.util.ArrayList;
import java.util.HashMap;

public class Solution {
	
    public static ArrayList<Integer> subarraySum(int[] nums) {
        // write your code here
    	if (nums==null || nums.length==0){
    		return null;
    	}
    	ArrayList<Integer> result_index=new ArrayList<Integer>();
    	HashMap<Integer,Integer>map=new HashMap<Integer,Integer>();
    	int sum=0;
    	map.put(0, -1);
    	for(int i=0;i<nums.length;i++){
    		sum+=nums[i];
    		if(map.containsKey(sum)){
    			result_index.add(map.get(sum)+1);
    			result_index.add(i);
    	    	return result_index;
    		}
    		else{
    			map.put(sum, i);
    		}
    	}
    	return result_index;
    }
    
    public static void main(String[] args) {
		// TODO Auto-generated method stub
    	int[] nums={-3, 1, 2, -3, 4};
    	System.out.println(subarraySum(nums));
	}
}
