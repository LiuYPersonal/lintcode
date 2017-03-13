package solution158;

import java.util.Arrays;

public class solution {
    /**
     * @param s: The first string
     * @param b: The second string
     * @return true or false
     */
    public static boolean anagram(String s, String t) {
        // write your code here
        if (s.length()!=t.length()){
        	return false;
        }
        	
        if (s.length()==0){
        	return true;
        }	
        char[] a=s.toCharArray();
        char[] b=t.toCharArray();
        Arrays.sort(a);
        Arrays.sort(b);      	
        return Arrays.equals(a, b);
    }

    public static void main(String[] args) {
		// TODO Auto-generated method stub
    	String s="abcs";
    	String t="sacb";
    	System.out.println(anagram(s,t));
	}
};