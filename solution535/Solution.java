package solution535;

import java.util.HashMap;
import java.util.Map;

class TreeNode {
	     public int val;
	     public TreeNode left, right;
	     public TreeNode(int x) { val = x; }
}
public class Solution {
	static Map<TreeNode,Integer> truemap=new HashMap<TreeNode, Integer>();
	static Map<TreeNode,Integer> falsemap=new HashMap<TreeNode, Integer>();
    public static int houseRobber3(TreeNode root) {
        // write your code here
    	return Math.max(findMax(root, true), findMax(root,false));
    }
    public static int findMax(TreeNode root, boolean taken){
    	if(root==null){
    		return 0;
    	}
    	if(root.left==null && root.right==null){
    		if(taken==false){
    			return Math.max(0, root.val);
    		}
    		else{
    			return 0;
    		}
    	}
    	int left1=0, left2=0, right1=0, right2=0;
    	if(taken){
    		if(root.left!=null){
    			if(falsemap.containsKey(root.left)){
    				left2=falsemap.get(root.left);
    			}
    			else{
    				left2=findMax(root.left,false);
    				falsemap.put(root.left, left2);
    			}
    			
    		}
        	if(root.right!=null){
    			if(falsemap.containsKey(root.right)){
    				right2=falsemap.get(root.right);
    			}
    			else{
    				right2=findMax(root.right,false);
    				falsemap.put(root.right, right2);
    			}
        	}
        	return left2+right2;
    	}
    	else{
    		if(root.left!=null){
    			if(truemap.containsKey(root.left)){
    				left1=truemap.get(root.left);
    			}
    			else{
    				left1=findMax(root.left,true);
    				truemap.put(root.left, left1);
    			}
    			if(falsemap.containsKey(root.left)){
    				left2=falsemap.get(root.left);
    			}
    			else{
    				left2=findMax(root.left,false);
    				falsemap.put(root.left, left2);
    			}
    		}
        	if(root.right!=null){
    			if(truemap.containsKey(root.right)){
    				right1=truemap.get(root.right);
    			}
    			else{
    				right1=findMax(root.right,true);
    				truemap.put(root.right, right1);
    			}
        		
    			if(falsemap.containsKey(root.right)){
    				right2=falsemap.get(root.right);
    			}
    			else{
    				right2=findMax(root.right,false);
    				falsemap.put(root.right, right2);
    			}  		
        	}
        	return Math.max(left1+right1+root.val, left2+right2);        	
    	}
    }
    public static void main(String[] args) {
    	TreeNode root=new TreeNode(3);
    	TreeNode node1=new TreeNode(2);
    	TreeNode node2=new TreeNode(3);
    	TreeNode node3=new TreeNode(3);
    	TreeNode node4=new TreeNode(1);
    	root.left=node1;
    	root.right=node2;
    	root.left.right=node3;
    	root.right.right=node4;
    	System.out.println(houseRobber3(root));
    }
}
