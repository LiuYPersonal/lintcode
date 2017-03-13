package solution176;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

class DirectedGraphNode {
    int label;
    ArrayList<DirectedGraphNode> neighbors;
    DirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<DirectedGraphNode>();
    }
}
public class Solution {

    public boolean hasRoute(ArrayList<DirectedGraphNode> graph, DirectedGraphNode s, DirectedGraphNode t) {
    	// write your code here
    	if(s==null || t==null || graph.size()==0){
    		return false;
    	}
    	int i=0;
    	for(i=0;i<graph.size();i++){
    		if(graph.get(i).label==s.label){
    			break;
    		}
    	}
    	Stack<DirectedGraphNode> stack = new Stack<DirectedGraphNode>();
    	Set<Integer> visited=new HashSet<Integer>();
    	stack.push(graph.get(i));
    	visited.add(s.label);
    	DirectedGraphNode root;
    	while(!stack.isEmpty()){
    		root=stack.pop();
    		if(root.label==t.label){
    			return true;
    		}
    		for(i=0;i<root.neighbors.size();i++){
    			if(!visited.contains(root.neighbors.get(i).label)){
    				stack.push(root.neighbors.get(i));
    				visited.add(root.neighbors.get(i).label);
    			}
    		}
    	}
    	return false;
    }
}
