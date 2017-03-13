package solution427;

import java.util.ArrayList;

public class Solution {
	
    public static ArrayList<String> generateParenthesis(int n) {
        // Write your code here
    	ArrayList<String> res=new ArrayList<String>();
    	if(n<=0){
    		return res;
    	}
    	res=generator(n,n);
    	return res;
    }
    public static ArrayList<String> generator(int p,int q){
    	ArrayList<String> res= new ArrayList<String>();
    	int count=0;
    	String tmp;
    	if(p==0 && q==1){
    		tmp=")";
    		res.add(tmp);
    		return res;
    	}
    	else{
    		if(p>0){
	    		res.addAll(generator(p-1,q));
	        	for(int i=0;i<res.size();i++){
	        		tmp=res.get(0);
	        		tmp="("+tmp;
	        		res.add(tmp);
	        		res.remove(0);
	        	}
	        	count=res.size();
	    	}
	    	if(q>p){
				res.addAll(generator(p,q-1));
	        	for(int i=count;i<res.size();i++){
	        		tmp=res.get(count);
	        		tmp=")"+tmp;
	        		res.add(tmp);
	        		res.remove(count);
	        	}
	            
	    	}
    	}
    	return res;
    }
    
    public static void main(String[] args) {
    	System.out.println(generateParenthesis(3));
    }
}
