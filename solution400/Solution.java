package solution400;

import java.util.HashSet;
import java.util.Set;

public class Solution {
	
    public static int maximumGap(int[] nums) {
        // write your code here
    	
    	// keep track of buckets that are not empty...
    	if(nums.length<2){
    		return 0;
    	}
    	int min=Integer.MAX_VALUE,max=Integer.MIN_VALUE;
    	int n=nums.length;
    	for(int i:nums){
    		min=Math.min(min, i);
    		max=Math.max(max, i);
    	}
    	if(min==max){
    		return 0;
    	}
    	int size=(max-min)/n+1;
    	int buckets_size=(max-min)/size+1;
    	int[] local_min=new int[buckets_size];
    	int[] local_max=new int[buckets_size];
    	boolean[] NotEmpty=new boolean[buckets_size];
    	for(int i=0;i<buckets_size;i++){
    		local_min[i]=Integer.MAX_VALUE;
    		local_max[i]=Integer.MIN_VALUE;
    	}
    	int t;
    	for(int i:nums){
    		t=(i-min)/size;
    		NotEmpty[i]=true;
    		local_min[t]=Math.min(local_min[t], i);
    		local_max[t]=Math.max(local_max[t], i);
    	}
    	int gap=-1,pre=0;
    	for(int i=1;i<buckets_size;i++){
    		if(NotEmpty[i]){
    			gap=Math.max(gap, local_min[i]-local_max[pre]);
    			pre=i;
    		}
    	}
    	return gap;
    }
    public static void main(String[] args) {
    	int[] nums={2147483647,0};
    	System.out.println(maximumGap(nums));
    }
}
