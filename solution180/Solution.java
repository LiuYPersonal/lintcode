package solution180;

import java.util.HashSet;
import java.util.Set;

public class Solution {
	
	
    public static String binaryRepresentation(String n) {
        // write your code here
    	if(n.equals("") || n.equals("0")){
    		return n;
    	}
    	int i=0;
    	for(i=0;i<n.length();i++){
    		if(n.charAt(i)=='.'){
    			break;
    		}
    	}
    	Set<Double> set=new HashSet<Double>();
    	String first_tmp=n.substring(0,i);
    	String second_tmp=n.substring(i+1);
    	String res="";
    	if(first_tmp.equals("") || first_tmp.equals("0")){
    		res="0";
    	}
    	else{
    		int first=Integer.parseInt(first_tmp);
    		while(first>0){
    			res=String.valueOf(first%2)+res;
    			first=first/2;
    		}
    	}
    	if(second_tmp.equals("") || second_tmp.equals("0")){
    		return res;
    	}
    	else{
    		res+='.';
    		int len=res.length();
    		second_tmp="0."+second_tmp;
    		double second=Double.parseDouble(second_tmp);
    		while(second>0){
    			if(set.contains(second) || res.length()-len>32){
    				return "ERROR";
    			}
    			set.add(second);
    			second=second*2;
    			if(second>=1){
    				res+="1";
    				second-=1;
    			}
    			else {
    				res+="0";
    			}
    			
    		}
    	}
    	return res;
    }
	
	public static void main(String[] args) {
    	System.out.println(binaryRepresentation("17817287.6418609619140625"));
	}
}
