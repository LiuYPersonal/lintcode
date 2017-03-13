package solution137;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

class UndirectedGraphNode {
	     int label;
	     ArrayList<UndirectedGraphNode> neighbors;
	     UndirectedGraphNode(int x) {
	    	 label = x; neighbors = new ArrayList<UndirectedGraphNode>(); 
	     }
};
public class Solution {
	
    public static UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        // write your code here
    	// BFS
    	if(node==null){
    		return null;
    	}
    	Queue<UndirectedGraphNode> nodes=new LinkedList<UndirectedGraphNode>();
    	Map<UndirectedGraphNode,UndirectedGraphNode> visited=new HashMap<UndirectedGraphNode,UndirectedGraphNode>();
    	UndirectedGraphNode res=new UndirectedGraphNode(node.label);
		visited.put(node, res);
    	nodes.add(node);
		while(!nodes.isEmpty()){
			UndirectedGraphNode tmp=nodes.poll();
			res=visited.get(tmp);
	    	for(int i=0;i<tmp.neighbors.size();i++){
	    		if(visited.containsKey(tmp.neighbors.get(i))){
	    			res.neighbors.add(visited.get(tmp.neighbors.get(i)));
	    		}
	    		else{
	    			UndirectedGraphNode tmp_copy2=new UndirectedGraphNode(tmp.neighbors.get(i).label);
	    			res.neighbors.add(tmp_copy2);
	    			nodes.add(tmp.neighbors.get(i));
	    			visited.put(tmp.neighbors.get(i), tmp_copy2);
	    		}	
			}
		}
    	return visited.get(node);
    }
    public static void main(String[] args) {
    	UndirectedGraphNode node0=new UndirectedGraphNode(0);
    	UndirectedGraphNode node1=new UndirectedGraphNode(1);
    	UndirectedGraphNode node2=new UndirectedGraphNode(2);
    	UndirectedGraphNode node3=new UndirectedGraphNode(3);
    	UndirectedGraphNode node4=new UndirectedGraphNode(4);
    	UndirectedGraphNode node5=new UndirectedGraphNode(5);
    	node0.neighbors.add(node1);
    	node0.neighbors.add(node5);
    	
    	node1.neighbors.add(node2);    	
    	node1.neighbors.add(node5);
    	
    	node2.neighbors.add(node3);
    	
    	node3.neighbors.add(node4);
    	node3.neighbors.add(node4);
    	
    	node4.neighbors.add(node5);
    	node4.neighbors.add(node5);
    	
    	System.out.println(cloneGraph(node0));
    }
}
