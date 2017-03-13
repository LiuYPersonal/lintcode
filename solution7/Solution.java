package solution7;

import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
	     public int val;
	     public TreeNode left, right;
	     public TreeNode(int val) {
	         this.val = val;
	         this.left = this.right = null;
	     }
	 }

public class Solution {

    public static String serialize(TreeNode root) {
        // write your code here
    	if(root==null){
    		return "";
    	}
    	String res="";
    	Queue<TreeNode> treeQueue=new LinkedList<TreeNode>();
    	treeQueue.add(root);
    	TreeNode tmpNode;
    	while(!treeQueue.isEmpty()){
    		int size=treeQueue.size();
    		for(int i=0;i<size;i++){
    			
    			tmpNode=treeQueue.poll();
    			
    			if (tmpNode==null){
    				res+="#,";
    			}
    			else{
    				res+=String.valueOf(tmpNode.val)+",";		
        			treeQueue.add(tmpNode.left);
        			treeQueue.add(tmpNode.right);
    			}
    		}
    	}
    	return res;
    	
    }
    
    public static TreeNode deserialize(String data) {
        // write your code here
    	if (data==null || data.length()==0)
    		return null; 
    	Queue<TreeNode> queue=new LinkedList<TreeNode>();
    	TreeNode res;
    	TreeNode cur;
    	int i=0,j=0,treeVal;
    	while(data.charAt(j)!=','){
			j++;
		}
    	if(data.substring(i,j).equals("#")){
    		return null;
    	}
    	else{
    		treeVal=Integer.valueOf(data.substring(i,j));
    		res=new TreeNode(treeVal);
    		queue.add(res);
    	}
    	i=j+1;
    	while(!queue.isEmpty()){
    		cur=queue.poll();
    		j=i;
        	while(data.charAt(j)!=','){
    			j++;
    		}
        	if(!data.substring(i,j).equals("#")){
        		treeVal=Integer.valueOf(data.substring(i,j));
        		cur.left=new TreeNode(treeVal);
        		queue.add(cur.left);
        	}
        	i=j+1;
        	j=i;
        	while(data.charAt(j)!=','){
    			j++;
    		}
        	if(!data.substring(i,j).equals("#")){
        		treeVal=Integer.valueOf(data.substring(i,j));
        		cur.right=new TreeNode(treeVal);
        		queue.add(cur.right);
        	}
        	i=j+1;
    	}
    	return res;
    }
    
    public static void main(String[] args) {
		// TODO Auto-generated method stub
    	TreeNode root = new TreeNode(1);
    	root.right=new TreeNode(2);
    	String data=serialize(root);
    	System.out.println(data);
    	System.out.println(deserialize(data));
	}
}
