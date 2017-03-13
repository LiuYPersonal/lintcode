package solution547;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Solution {
	
    public static int[] intersection(int[] nums1, int[] nums2) {
        // Write your code here
    	if(nums1== null || nums2==null){
    		return null;
    	} 
    	ArrayList<Integer> tmp_res=new ArrayList<Integer>();
    
    	Set<Integer> map=new HashSet<Integer>();
    	for (int i=0;i<nums1.length;i++){
    		if(!map.contains(nums1[i])){
    			map.add(nums1[i]);
    		}
    	}
    	for(int i=0;i<nums2.length;i++){
    		if(map.contains(nums2[i])){
    			tmp_res.add(nums2[i]);
    			map.remove(nums2[i]);
    		}
    	}
    	int size=tmp_res.size();
    	int[] res=new int[size];
    	if(res.length==0){
    		return res;
    	}
    	for(int i=0;i<res.length;i++){
    		res[i]=tmp_res.get(i);
    	}
    	return res;
    }
    
    public static void main(String[] args) {
		// TODO Auto-generated method stub
    	int[] nums1={1,2,2,1};
    	int[] nums2={2,2};
    	System.out.println(intersection(nums1,nums2));
	}

}
