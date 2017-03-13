package solution127;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

class DirectedGraphNode {
	     int label;
	     ArrayList<DirectedGraphNode> neighbors;
	     DirectedGraphNode(int x) { 
	    	 label = x; neighbors = new ArrayList<DirectedGraphNode>(); 
	    	 }
}

public class Solution {
	static Set<DirectedGraphNode> visited = new HashSet<DirectedGraphNode>();
	static Stack<DirectedGraphNode> sortedNode =new Stack<DirectedGraphNode>();
    public static ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        // write your code here
    	if(graph==null){
    		return graph;
    	}
    	int i=0;
    	while(i<graph.size()){
    		if(!visited.contains(graph.get(i))){
    			visited.add(graph.get(i));
    			sortall(graph.get(i));
    		}
    		i++;
    	}
    	ArrayList<DirectedGraphNode> res=new ArrayList<DirectedGraphNode>();
    	while(!sortedNode.isEmpty()){
    		DirectedGraphNode tmp=sortedNode.pop();
    		res.add(tmp);
    		
    	}
    	return res;
    }
    public static void sortall(DirectedGraphNode graphNode){
    	if(graphNode.neighbors.size()==0){
    		sortedNode.push(graphNode);
    		return;
    	}
		for(int j=0;j<graphNode.neighbors.size();j++){
			if(!visited.contains(graphNode.neighbors.get(j))){
				visited.add(graphNode.neighbors.get(j));
				sortall(graphNode.neighbors.get(j));
			}
		}
    	sortedNode.push(graphNode);
		return;
    }
    public static void main(String[] args) {
		
    	ArrayList<DirectedGraphNode> graph=new ArrayList<DirectedGraphNode>();
    	DirectedGraphNode node1=new DirectedGraphNode(0);
    	DirectedGraphNode node2=new DirectedGraphNode(1);
    	DirectedGraphNode node3=new DirectedGraphNode(2);
    	DirectedGraphNode node4=new DirectedGraphNode(3);
    	DirectedGraphNode node5=new DirectedGraphNode(4);
    	DirectedGraphNode node6=new DirectedGraphNode(5);
    	DirectedGraphNode node7=new DirectedGraphNode(6);
    	DirectedGraphNode node8=new DirectedGraphNode(7);
    	node1.neighbors.add(node4);
    	
    	node2.neighbors.add(node4);
    	node2.neighbors.add(node6);
    	
    	node3.neighbors.add(node6);
    	node3.neighbors.add(node7);
    	
    	node4.neighbors.add(node6);
    	
    	node5.neighbors.add(node7);
    	node5.neighbors.add(node8);

    	graph.add(node1);
    	graph.add(node2);
    	graph.add(node3);
    	graph.add(node4);
    	graph.add(node5);
    	graph.add(node6);
    	graph.add(node7);
    	graph.add(node8);
    	System.out.println(topSort(graph));
	}
}
