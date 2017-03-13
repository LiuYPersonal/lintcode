package solution97;


class TreeNode {
    public int val;
    public TreeNode left, right;
    public TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}

public class Solution {

    public static int maxDepth(TreeNode root) {
        // write your code here
    	if(root==null){
    		return 0;
    	}
    	int depth1=1+maxDepth(root.left);
    	int depth2=1+maxDepth(root.right);
    	return (depth1>depth2?depth1:depth2);
    }
    
    public static void main(String[] args) {
		// TODO Auto-generated method stub
    	TreeNode root = new TreeNode(1);
    	root.left= new TreeNode(2);
    	root.right=new TreeNode(3);
    	root.right.left=new TreeNode(4);
    	root.right.right=new TreeNode(5);
    	System.out.println(maxDepth(root));
	}
    
}
