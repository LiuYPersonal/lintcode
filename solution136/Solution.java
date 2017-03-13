package solution136;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	
    public static List<List<String>> partition(String s) {
        // write your code here
    	List<List<String>> res= new ArrayList<List<String>>();
    	List<String> tmp;
        if(s.length()==0){
        	return res;
        }
        if(s.length()==1){
        	tmp=new ArrayList<String>();
        	tmp.add(s);
        	res.add(tmp);
        	return res;
        }
        int count=0;
        for(int i=0;i<s.length();i++){
        	if(isPalidrome(s,0,i)){
        		res.addAll(partition(s.substring(i+1)));
        		for(int j=count;j<res.size();j++){
        			tmp=res.get(j);
        			tmp.add(0, s.substring(0, i+1));
        		}
        		count=res.size();
        	}
        }
        return res;
    }
    public static boolean isPalidrome(String s, int p, int q){
    	while(p<q){
    		if(s.charAt(p)!=s.charAt(q)){
    			return false;
    		}
    		p++;
    		q--;
    	}
    	return true;
    }
    public static void main(String[] args) {
    	String s="aabcdcbef";
    	System.out.println(partition(s));
    }
}
