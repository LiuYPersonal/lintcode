package solution370;

import java.util.ArrayList;
import java.util.Stack;


public class Solution {

	
	public static ArrayList<String> convertToRPN(String[] expression) {
        // write your code here
    	
    	return buildTree(expression,0,expression.length-1);
    }
	
    public static ArrayList<String> buildTree(String[] expression,int p, int q){	
    	ArrayList<String> res=new ArrayList<String>();
    	if(p==q){
    		res.add(expression[p]);
    		return res;
    	}
    	if(p+2==q && expression[p].equals("(") && expression[q].equals(")")){
    		res.add(expression[p+1]);
    		return res;
    	}
    	Stack<ArrayList<String>> stack=new Stack<ArrayList<String>>();
    	int count=0;
    	int min_count=Integer.MAX_VALUE;
    	int last=0;
    	int last1=-1; // for +-
    	int last2=-1; // for */
    	for(int i=p;i<=q;i++){
    		if(expression[i].equals("(")){
    			count++;
    		}
    		else if(expression[i].equals(")")){
    			count--;
    		}
    		else if("+-".contains(expression[i])){
    			// if the current layer is smaller than or equal to the minimum layer
    			if(count<=min_count){
    				last1=i;
    				last2=-1;
    				min_count=count;
    			}
    		}
    		else if("*/".contains(expression[i])){
    			if(count<=min_count){
    				if(count<min_count){
    					last1=-1;
    					min_count=count;
    				}
    				last2=i;
    				
    			}
    		}
    	}
    	if(last1==-1){
    	    last=last2;
    	}
    	else{
    		last=last1;
    	}
		res.add(expression[last]);
		//left
		stack.push(buildTree(expression, p+min_count, last-1));
		//right
		stack.push(buildTree(expression, last+1, q-min_count));


		while(!stack.isEmpty()){
			res.addAll(0,stack.pop());
		}
    	return res;
    }
    public static void main(String[] args) {
		// TODO Auto-generated method stub
    	String[] nums={"(","(","1","+","(","2",")",")","*","3","+","(","4","/","2",")","-","5",")"};
    	System.out.println(convertToRPN(nums));
	}
}
