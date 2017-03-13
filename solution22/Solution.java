package solution22;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public interface NestedInteger {
	 
	      // @return true if this NestedInteger holds a single integer,
	      // rather than a nested list.
	      public boolean isInteger();
	 
	      // @return the single integer that this NestedInteger holds,
	      // if it holds a single integer
	      // Return null if this NestedInteger holds a nested list
	      public Integer getInteger();
	 
	      // @return the nested list that this NestedInteger holds,
	      // if it holds a nested list
	      // Return null if this NestedInteger holds a single integer
	      public List<NestedInteger> getList();
}
public class Solution {
	
    public List<Integer> flatten(List<NestedInteger> nestedList) {
        // Write your code here
        List<Integer> res=new ArrayList<Integer>();
        Stack<NestedInteger> stack = new Stack<NestedInteger>();
        for(int i=0;i<nestedList.size();i++){
        	stack.push(nestedList.get(i));
        }
        NestedInteger tmp;
        List<NestedInteger> tmp2;
        while(!stack.isEmpty()){
        	tmp=stack.pop();
        	if(tmp.isInteger()){
        		res.add(0,tmp.getInteger());
        	}
        	else{
        		tmp2=tmp.getList();
        		for(int i=0;i<tmp2.size();i++){
        			stack.push(tmp2.get(i));
        		}
        	}
        }
        return res;
    }
}
