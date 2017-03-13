package solution66;

import java.util.ArrayList;

class TreeNode {
    public int val;
    public TreeNode left, right;
    public TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}

public class Solution {

    public ArrayList<Integer> preorderTraversal(TreeNode root) {
    	ArrayList<Integer> list=new ArrayList<Integer>();
    	if(root==null){
    		return list;
    	}
    	
    	list.add(root.val);
    	ArrayList<Integer> left=preorderTraversal(root.left);
    	ArrayList<Integer> right=preorderTraversal(root.right);

    	list.addAll(left);
    	list.addAll(right);
    	return list;
    }
}
