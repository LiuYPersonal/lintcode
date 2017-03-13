package solution175;

import java.util.Stack;

class TreeNode {
	     public int val;
	     public TreeNode left, right;
	     public TreeNode(int val) {
	         this.val = val;
	         this.left = this.right = null;
	     }
}
public class Solution {
	public void invertBinaryTree(TreeNode root) {
        // write your code here
        if(root==null){
            return;
        }
        Stack<TreeNode> stack= new Stack<TreeNode>();
        stack.push(root);
        while(!stack.isEmpty()){
            root=stack.pop();
            TreeNode dummy=root.left;
            root.left=root.right;
            root.right=dummy;
            if(root.left!=null){
                stack.push(root.left);
            }
            if(root.right!=null){
                stack.push(root.right);
            }
        }
        return;
    }
}
