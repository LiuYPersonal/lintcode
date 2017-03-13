package solution178;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class Solution {
	
    public static boolean validTree(int n, int[][] edges) {
        // Write your code here
    	if(n==0){
    		return false;
    	}
    	if(edges.length!=n-1){
    		return false;
    	}
    	ArrayList<ArrayList<Integer>> tree=new ArrayList<ArrayList<Integer>>();
    	for(int i=0;i<n;i++){
    		tree.add(new ArrayList<Integer>());
    	}
    	// undirected graph
    	for(int i=0;i<edges.length;i++){
    		tree.get(edges[i][0]).add(edges[i][1]);
    		tree.get(edges[i][1]).add(edges[i][0]);
    		
    	}
    	return DFS(n,tree);
    }
    public static boolean DFS(int n,ArrayList<ArrayList<Integer>> tree){
    	Set<Integer> visited=new HashSet<Integer>(n);
    	Stack<Integer> stack =new Stack<Integer>();
    	stack.push(0);
    	visited.add(0);
    	ArrayList<Integer> neighbors;
    	while(!stack.isEmpty()){
    		int node=stack.pop();
    		neighbors=tree.get(node);
    		for(int i=0;i<neighbors.size();i++){
				int neighbor=neighbors.get(i);
				if(!visited.contains(neighbor)){
    				stack.push(neighbors.get(i));
    				visited.add(neighbors.get(i));
    				for(int j=0;j<tree.get(neighbor).size();j++){
    					if(tree.get(neighbor).get(j)==node){
    						tree.get(neighbor).remove(j);
    						break;
    					}
    				}
				}
				else{
					return false;
				}
    		}
    	}
    	return (visited.size()==n)?true:false;
    }

    public static void main(String[] args) {
    	int[][] edges={{0,1},{0,2},{0,3},{1,4},{2,4}};
    	System.out.println(validTree(5,edges));
    }
}
