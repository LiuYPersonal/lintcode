package solution423;

import java.util.Stack;

public class Solution {
	
    public boolean isValidParentheses(String s) {
        // Write your code here
    	Stack<Character> stack= new Stack<Character>();
    	for(int i=0;i<s.length();i++){
    		if(!stack.isEmpty() && is_valid(s.charAt(i),stack.peek())){
    			stack.pop();
    		}
    		else{
    			stack.push(s.charAt(i));
    		}
    	}
    	if(stack.isEmpty()){
    		return true;
    	}
    	return false;
    }
    
    public boolean is_valid(char c1, char c2){
    	return ((c1==')' && c2=='(') || 
    			(c1==']' && c2=='[') || (c1=='{' && c2=='}'));
    }

}
