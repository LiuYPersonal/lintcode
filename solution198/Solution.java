package solution198;

import java.util.HashMap;
import java.util.Map;

public class Solution {
	public static long permutationIndexII(int[] A) {
        if (A == null || A.length == 0)
            return 0L;
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        long multi_factor=1;
        int index=1;
        int factor=1;
        for(int i=A.length-1;i>=0;i--){
        	if(!map.containsKey(A[i])){
        		map.put(A[i], 1);
        	}
        	else{
        		map.put(A[i], map.get(A[i])+1);
        	}
        	multi_factor*=map.get(A[i]);
        	int count=0;
        	for(int j=i+1;j<A.length;j++){
        		if(A[j]<A[i]){
        			count++;
        		}
        	}
        	index+=count*factor/multi_factor;
        	factor*=A.length-i;
        	
        }
        return index;
    }
    public static void main(String[] args) {
    	int[] nums={3,2,2,1,1};
    	System.out.println(permutationIndexII(nums));
    }
}
