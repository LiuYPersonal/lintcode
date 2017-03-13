package solution93;


class TreeNode {
    public int val;
    public TreeNode left, right;
    public TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}


public class Solution {

    public boolean isBalanced(TreeNode root) {
        // write your code here
    	return (maxDepth(root)!=-1);
    }
    
    public static int maxDepth(TreeNode root) {
        // write your code here
    	if(root==null){
    		return 0;
    	}
    	int depth1=maxDepth(root.left);
    	int depth2=maxDepth(root.right);
    	if(depth1==-1 || depth2==-1 || Math.abs(depth1-depth2)>1){
    		return -1;
    	}
    	return Math.max(depth1, depth2)+1;
    }
}
