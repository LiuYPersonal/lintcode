package solution182;

import java.util.Stack;

public class Solution {

    public static String DeleteDigits(String A, int k) {
        // write your code here
    	if(k==0){
    		return A;
    	}
    	if(A==null || A.length()==0 ||A.length()==k){
    		return "";
    	}
    	Stack<Character> stack = new Stack<Character>();
    	int len=A.length()-k;
    	for(int i=0;i<A.length();i++){
    		char c=A.charAt(i);
    		while (!stack.isEmpty() && c<stack.peek() && A.length()-i-1>=len-stack.size()){
    			stack.pop();
    		}
    		if(stack.size()<len){
    			stack.push(c);
    		}
    	}
    	StringBuffer res=new StringBuffer();
    	while(!stack.isEmpty()){
    		res.insert(0, stack.pop());
    	}
    	while(res.length()>0 && res.charAt(0)=='0'){
    		res.deleteCharAt(0);
    	}
    	return res.toString();
    }
    
    public static void main(String[] args) {
		// TODO Auto-generated method stub
    	String A="91735142";
    	int t=4;
    	System.out.println(DeleteDigits(A,t));
	}
}
