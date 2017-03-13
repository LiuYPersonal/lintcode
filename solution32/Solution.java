package solution32;

import java.util.HashMap;

public class Solution {

	public static String minWindow(String source, String target) {
        // write your code
    	if(source=="" || target=="" || target.length()>source.length()){
    		return "";
    	}
		//Use hash map to record every char in target
		HashMap<Character,Integer> map=new HashMap<Character,Integer>();
		for(int i=0;i<target.length();i++){
			if(map.containsKey(target.charAt(i))){
				map.put(target.charAt(i), map.get(target.charAt(i))+1);
			}
			else{
				map.put(target.charAt(i), 1);
			}
		}
		int l=0;
		int count=0;
		int minLen=source.length()+1;
		int minStart=l;
		for(int r=0;r<source.length();r++){
			//find a substring containing target
			if(map.containsKey(source.charAt(r))){
				map.put(source.charAt(r), map.get(source.charAt(r))-1);
				if(map.get(source.charAt(r))>=0){
					count++;
				}
			}
			// decrease the length
			while(count==target.length()){
				if(r-l+1<minLen){
					minLen=r-l+1;
					minStart=l;
				}
				if(map.containsKey(source.charAt(l))){
					map.put(source.charAt(l), map.get(source.charAt(l))+1);
					if(map.get(source.charAt(l))>0){
						count--;
					}
				}
				l++;
			}
		}
		if(minLen==source.length()+1){
			return "";
		}
		else{
			return source.substring(minStart, minStart+minLen);
		}
    }
    public static void main(String[] args) {
    	String  source="aaaaaaaaaaaaaaaaaaabbbbbbbbbdfadsfjalsdjfalsdjfsadfadf";
    	String target="aaaaaabbbbbbbbbdfjaldjf";
    	System.out.println(minWindow(source, target));
    }
}
