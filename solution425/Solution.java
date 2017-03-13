package solution425;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Solution {
	
    public static ArrayList<String> letterCombinations(String digits) {
        // Write your code here
        Map<Character,String> map=new HashMap<Character,String>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        return build(digits, 0, map);
    }
    public static ArrayList<String> build(String digits, int index, Map<Character,String> map){
        ArrayList<String> res=new ArrayList<String>(); 
        if(digits.length()==0){
        	return res;
        }
        if(index==digits.length()-1){
        	char[] tmp=map.get(digits.charAt(index)).toCharArray();
            for(char c:tmp){
            		res.add(String.valueOf(c));
            	}      	
            return res;
        }
        char[] tmp=map.get(digits.charAt(index)).toCharArray();
        res.addAll(build(digits,index+1,map));
        int count=res.size();
        for(char c:tmp){
        	for(int j=0;j<count;j++){
        		String tmp2=res.get(j);
        		tmp2=c+tmp2;
        		res.add(tmp2);
        	}
        }
        for(int i=0;i<count;i++){
        	res.remove(0);
        }
        return res;
    }
    
    public static void main(String[] args) {
    	System.out.println(letterCombinations("234"));
    }

}
