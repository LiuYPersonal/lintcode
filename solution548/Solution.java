package solution548;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    public static int[] intersection(int[] nums1, int[] nums2) {
        // Write your code here
    	List<Integer> tmp_res=new ArrayList<Integer>();    
    	Map<Integer,Integer> map=new HashMap<Integer,Integer>();
    	
    	for (int i=0;i<nums1.length;i++){
    		if(map.containsKey(nums1[i])){
    			map.put(nums1[i], map.get(nums1[i])+1);
    		}
    		else{
    			map.put(nums1[i],1);
    		}
    	}
    	for(int i=0;i<nums2.length;i++){
    		if(map.containsKey(nums2[i]) && map.get(nums2[i])>0){
    			tmp_res.add(nums2[i]);
    			map.put(nums2[i],map.get(nums2[i])-1);
    		}
    	}
    	int[] res=new int[tmp_res.size()];
    	for(int i=0;i<res.length;i++){
    		res[i]=tmp_res.get(i);
    	}
    	return res;
    }
    public static void main(String[] args) {
		// TODO Auto-generated method stub
    	int[] nums1={4,7,9,7,6,7};
    	int[] nums2={5,0,0,6,1,6,2,2,4};
    	System.out.println(intersection(nums1,nums2));
	}
}
