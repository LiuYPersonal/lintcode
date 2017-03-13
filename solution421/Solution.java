package solution421;

import java.util.Stack;

public class Solution {

    public static String simplifyPath(String path) {
        // Write your code here
    	String res="";
    	String tmp="";
    	Stack<String> stack = new Stack<String>();
    	for(int i=0;i<path.length();i++){
    		if(path.charAt(i)=='/' && !tmp.equals("")){
    			if(tmp.equals("..")){
					if(!stack.isEmpty()){
						stack.pop();
					}
    			}
    			else if(!tmp.equals(".")){
    				stack.push(tmp);
    			}
    			tmp="";
    		}
	    	else if(path.charAt(i)!='/'){
	    			tmp=tmp+path.charAt(i);
	    	}
    	}
    	if(!tmp.equals("")){
    		stack.push(tmp);
    	}
    	if(stack.isEmpty()){
    		return "/";
    	}
    	int size=stack.size();
    	for(int i=0;i<size;i++){
    		res="/"+stack.pop()+res;
    	}
    	return res;
    }
    
    public static void main(String[] args) {
		// TODO Auto-generated method stub
    	String nums="/home//foo/";
    	System.out.println(simplifyPath(nums));
	}
}
