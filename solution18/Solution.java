package solution18;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {

	public static ArrayList<ArrayList<Integer>> subsetsWithDup(int[] nums) {
        // write your code here
        ArrayList<ArrayList<Integer>> results = new ArrayList<>();
        if (nums == null) return results;
        
        if (nums.length == 0) {
            results.add(new ArrayList<Integer>());
            return results;
        }
        Arrays.sort(nums);
        ArrayList<Integer> subset=new ArrayList<Integer>();
        DFS(nums,0,subset, results);
        return results;
        
        
    }
    public static void DFS(int[] nums, int startIndex, ArrayList<Integer> subset, ArrayList<ArrayList<Integer>> results){
    	results.add(new ArrayList<Integer>(subset));
        for(int i=startIndex; i<nums.length; i++){
        	if(i!=startIndex && nums[i]==nums[i-1]){
        		continue;
        	}
            subset.add(nums[i]);
            DFS(nums,i+1,subset,results);
            subset.remove(subset.size()-1);
        }
    }
    public static void main(String[] args){
    	int[] nums={1,2,2,3,4};
    	System.out.println(subsetsWithDup(nums));
    }
}
