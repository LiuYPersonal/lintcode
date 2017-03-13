package solution384;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static int lengthOfLongestSubstring(String s) {
        // write your code here
        if(s.equals("")){
            return 0;
        }
        Map<Character, Integer> map=new HashMap<Character,Integer>();
        int max=1;
        int count=1;
        map.put(s.charAt(0),0);
        for(int i=1;i<s.length();i++){
        	if(!map.containsKey(s.charAt(i))){
        		map.put(s.charAt(i),i);
        		count++;
            	if(count>max){
            		max=count;
            	}
        	}
        	else{
        		count=i-map.get(s.charAt(i));
        		int w=map.get(s.charAt(i));
        		int j=w;
        		while(j>=0 && !map.isEmpty()){
        			if(map.containsKey(s.charAt(j)) && map.get(s.charAt(j))<w){
        				map.remove(s.charAt(j));
        			}
        		    j--;
        		}
        		map.put(s.charAt(i), i);
        	}

        }
        return max;
    }
    public static void main(String[] args) {
		// TODO Auto-generated method stub
    	String nums1="ejtdfngsdnnkgpkvtigsq";
    	System.out.println(lengthOfLongestSubstring(nums1));
	}
}
