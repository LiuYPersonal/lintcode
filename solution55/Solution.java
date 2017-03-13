package solution55;

import java.util.Arrays;

public class Solution {
    public static boolean compareStrings(String A, String B) {
        // write your code here
    	if (A.length()==0 && B.length()!=0){
    		return false;
    	}
    	if (B.length()==0){
    		return true;
    	}
        char[] a=A.toCharArray();
        char[] b=B.toCharArray();
        Arrays.sort(a);
        Arrays.sort(b); 
        int i=0;
        for (char x:b){
            if(i==A.length()){
    			return false;
    		}
        	while(a[i]!=x){
        		i++;
        		if(i==A.length()){
        			return false;
        		}
        	}
        	i++;
        }
        return true;
    }
    
    public static void main(String[] args) {
		// TODO Auto-generated method stub
    	String s="AAAAAAAAAABBBAAAAAAAAA";
    	String t="BBBBAAAAAAAAA";
    	System.out.println(compareStrings(s,t));
	}
}
