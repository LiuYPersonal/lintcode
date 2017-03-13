package solution124;

import java.util.HashMap;
import java.util.Map;

public class Solution {
	
    public int longestConsecutive(int[] num) {
        // write you code here
    	if(num.length==0){
    		return 0;
    	}
    	Map<Integer,Integer> map=new HashMap<Integer,Integer>();
    	int max=0;
    	int left=0,right=0,sum;
    	for(int i=1;i<num.length;i++){
    		if(!map.containsKey(num[i])){
    			left=map.containsKey(num[i]-1)?map.get(num[i]-1):0;
    			right=map.containsKey(num[i]+1)?map.get(num[i]+1):0;
	    		sum=left+right+1;
	    		map.put(num[i], sum);
	    		if(left!=0){
	    			map.put(num[i]-left, sum);
	    		}
	    		if(right!=0){
	    			map.put(num[i]+right, sum);
	    		}
	    		max=Math.max(max, sum);
    		}
    	
    	}
    	return max;
    }
}
