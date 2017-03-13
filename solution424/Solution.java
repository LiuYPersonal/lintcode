package solution424;

import java.util.Stack;

public class Solution {

    public int evalRPN(String[] tokens) {
        // Write your code here
    	if(tokens.length==0){
    		return 0;
    	}
    	
    	Stack<String> stack=new Stack<String>();
    	for(int i=0;i<tokens.length;i++){
    		if("+-*/".contains(tokens[i])){
    			int s1=Integer.valueOf(stack.pop());
    			int s2=Integer.valueOf(stack.pop());
    			if(tokens[i].equals("+")){
    				stack.push(String.valueOf(s1+s2));
    			}
    			else if(tokens[i].equals("-")){
    				stack.push(String.valueOf(s1-s2));
    			}
    			else if(tokens[i].equals("*")){
    				stack.push(String.valueOf(s1*s2));
    			}
    			else if(tokens[i].equals("/")){
    				stack.push(String.valueOf(s1/s2));
    			}
    		}
    		else{
    			stack.push(tokens[i]);
    		}
    	}
    	return Integer.valueOf(stack.peek());
    }
    
}
