package solution155;

class TreeNode {
	     public int val;
	     public TreeNode left, right;
	     public TreeNode(int val) {
	         this.val = val;
	         this.left = this.right = null;
	     }
}

public class Solution {
    public int minDepth(TreeNode root) {
        // write your code here
    	int left=Integer.MAX_VALUE;
    	int right=Integer.MAX_VALUE;
    	if(root==null){
    		return 0;
    	}
    	if(root.left==null && root.right==null){
    		return 1;
    	}
    	if(root.left!=null){
    		left=minDepth(root.left);
    	}
    	if(root.right!=null){
    		right=minDepth(root.right);
    	}
    	return Math.min(left, right)+1;
    }
}
