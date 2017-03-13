package solution426;

import java.util.ArrayList;

public class Solution {

    public static ArrayList<String> restoreIpAddresses(String s) {
        // Write your code here
    	return findAddrs(s,0);
    }
    public static ArrayList<String> findAddrs(String s, int count){
    	ArrayList<String> res=new ArrayList<String>();
    	int size=0;
    	if(s.length()==0){
    		return res;
    	}
    	if(count==3){
    		if(Integer.valueOf(s)>255 || (s.charAt(0)=='0' && s.length()>1)){
    			return res;
    		}
    		res.add(s);
    		return res;
    	}
    	count++;
		res.addAll(findAddrs(s.substring(1),count));
		size=res.size();
		String tmp;
    	for(int i=0;i<res.size();i++){
    		tmp=res.get(i);
    		tmp=s.substring(0, 1)+'.'+tmp;
    		res.set(i, tmp);
    	}
    	if(s.charAt(0)!='0' && s.length()>=2){
    		res.addAll(findAddrs(s.substring(2),count));
    		for(int i=size;i<res.size();i++){
        		tmp=res.get(i);
        		tmp=s.substring(0, 2)+'.'+tmp;
        		res.set(i, tmp);
        	}
    		size=res.size();
    	}
    	if(s.charAt(0)!='0' && s.length()>=3){
    		res.addAll(findAddrs(s.substring(3),count));
    		if(Integer.valueOf(s.substring(0, 3))<256){
	        	for(int i=size;i<res.size();i++){
	        		tmp=res.get(i);
	        		tmp=s.substring(0, 3)+'.'+tmp;
	        		res.set(i, tmp);
	        	}
    		}
    		else{
    			int size2=res.size();
	        	for(int i=size;i<size2;i++){
	        		res.remove(size);
	        	}
    		}
    	}
    	return res;
    }
    public static void main(String[] args) {
    	String s="172162541";
    	System.out.println(restoreIpAddresses(s));
    }
}
