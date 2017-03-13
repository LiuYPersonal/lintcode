package solution107;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static boolean wordBreak(String s, Set<String> dict) {
        // write your code here   
    	if(s==null || s.length()==0){
    		return true;
    	}
    	if(dict.size()==0){
    		return false;
    	}
    	boolean[] dp=new boolean[s.length()+1];
    	dp[0]=true;
    	int len;
	    for(int i=1;i<=s.length();i++){
	    	if(!dp[i]){
	    		for(String word:dict){
	    			len=word.length();
	    			if(i-len>=0 && s.substring(i-len,i).equals(word)){
		    			dp[i]=dp[i-len];
		    			if(dp[i]){
		    				break;
		    			}
	    			}
	    		}
	    	}
    	}
    	return dp[s.length()];
    }
    public static void main(String[] args) {
    	String s="rabbit";
    	Set<String> dict=new HashSet<String>();
    	dict.add("rab");
    	dict.add("b");
    	dict.add("it");
    	System.out.println(wordBreak(s,dict));
    }
}
