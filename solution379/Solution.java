package solution379;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Solution {

	public static String minNumber(int[] nums) {
        // Write your code here
        String res="";
        if(nums.length<=0){
    		return res;
    	}
    	Integer[] ints=new Integer[nums.length];
    	for(int i=0;i<nums.length;i++){
    		ints[i]=nums[i];
    	}
    	Arrays.sort(ints, new Comparator<Integer>(){
    		public int compare(Integer n1,Integer n2){
    			String str1=String.valueOf(n1);
    			String str2=String.valueOf(n2);
    			return (str1+str2).compareTo(str2+str1);
    		}
    	});
    	for(int i=0;i<ints.length;i++){
    	    res+=String.valueOf(ints[i]);
    	}
    	int i=0;
    	while(i<res.length() && res.charAt(i)=='0'){
    	    i++;
    	}
    	if(i==res.length()){
    	    return "0";
    	}
    	res=res.substring(i);
    	return res;
    }
    
    public static void main(String[] args) {
		// TODO Auto-generated method stub
    	int[] nums={3,32,321};
    	System.out.println(minNumber(nums));
	}
    
}
