package solution51;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
	
    public static ArrayList<Integer> previousPermuation(ArrayList<Integer> nums) {
		// write your code
    	if(nums.size()==0){
    		return nums;
    	}
    	int max=Integer.MIN_VALUE,index=-1;
    	for(int i=nums.size()-2;i>=0;i--){
    		if(nums.get(i)>nums.get(i+1)){
    			for(int j=i+1;j<nums.size();j++){
    				if(nums.get(j)<nums.get(i) && nums.get(j)>max){
    					max=nums.get(j);
    					index=j;
    				}
    			}
    			if(index!=-1){
	    			int tmp=nums.get(i);
	    			nums.set(i, nums.get(index));
	    			nums.set(index, tmp);
    			}
    			List<Integer> substring=nums.subList(i+1,nums.size());
    			Collections.sort(substring, Collections.reverseOrder());
    			return nums;
    		}
    	}
    	Collections.sort(nums,Collections.reverseOrder());
    	return nums;
    }
    public static void main(String[] args) {
    	ArrayList<Integer> nums=new ArrayList<Integer>();
    	nums.add(1);
    	nums.add(4);
    	nums.add(3);
    	nums.add(2);
    	System.out.println(previousPermuation(nums));
    }
}
