//package solution528;
//
//import java.util.Iterator;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Stack;
//
//interface NestedInteger {
//	 
//	      // @return true if this NestedInteger holds a single integer,
//	      // rather than a nested list.
//	     public boolean isInteger();
//	 
//	      // @return the single integer that this NestedInteger holds,
//	      // if it holds a single integer
//	      // Return null if this NestedInteger holds a nested list
//	      public Integer getInteger();
//	 
//	      // @return the nested list that this NestedInteger holds,
//	      // if it holds a nested list
//	      // Return null if this NestedInteger holds a single integer
//	      public List<NestedInteger> getList();
//	 }
//public class NestedIterator implements Iterator<Integer> {
//
//	Stack<NestedInteger> stack=new Stack<NestedInteger>();
//	
//    public NestedIterator(List<NestedInteger> nestedList) {
//        // Initialize your data structure here.
//        if(nestedList.size()==0){
//            return;
//        }
//    	for(int i=nestedList.size()-1;i>=0;i--){
//    		stack.push(nestedList.get(i));
//    	}
//    	return;
//    }
//
//    // @return {int} the next element in the iteration
//    @Override
//    public Integer next() {
//        // Write your code here
//        return stack.pop().getInteger();
//    }
//
//    // @return {boolean} true if the iteration has more element or false
//    @Override
//    public boolean hasNext() {
//        // Write your code here
//        if(!stack.isEmpty()){
//            if(stack.peek().isInteger()){
//        		return true;
//        	}
//        	List<NestedInteger> nestedList=stack.peek().getList();
//        	stack.pop();
//        	for(int i=nestedList.size()-1;i>=0;i--){
//        		stack.push(nestedList.get(i));
//        	}
//        }
//    	return false;
//    }
//    
//}