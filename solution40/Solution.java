package solution40;

import java.util.Stack;

public class Solution {
    private static Stack<Integer> stack1;
    private static Stack<Integer> stack2;

    public static void Queue() {
       // do initialization if necessary
    	stack1=new Stack<Integer>();
    	stack2=new Stack<Integer>();
    }
    
    public static void push(int element) {
        // write your code here
    	stack1.push(element);
    }

    public static int pop() {
        // write your code here
    	if(stack2.isEmpty()){
    		while(!stack1.isEmpty()){
    			stack2.push(stack1.pop());
    		}
    	}
    	return stack2.pop();
    	
    }

    public static int top() {
        // write your code here
    	if(stack2.isEmpty()){
    		while(!stack1.isEmpty()){
    			stack2.push(stack1.pop());
    		}
    	}
    	return stack2.peek();
    }
    
    public static void main(String[] args) {
    	Queue();
    	push(1);
    	System.out.println(pop());
    	push(2);
    	push(3);
    	System.out.println(top());
    	System.out.println(pop());
    	
    	
    	
    }
}
