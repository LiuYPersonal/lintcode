package solution95;
class TreeNode {
    public int val;
    public TreeNode left, right;
    public TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}
public class Solution {
	
    public boolean isValidBST(TreeNode root) {
        // write your code here
    	if(root==null){
    		return true;
    	}
    	boolean left=isValidBST(root.left);
    	boolean right=isValidBST(root.right);
    	boolean res=true;
    	if(root.left!=null){
    		res=res && (root.val>root.left.val);
    	}
    	if (root.right!=null){
    		res=res && (root.val<root.right.val);
    	}
    	return (res && left && right);
    }

}
