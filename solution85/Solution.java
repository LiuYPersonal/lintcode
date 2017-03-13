package solution85;

class TreeNode {
    public int val;
    public TreeNode left, right;
    public TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}

public class Solution {

	
    public TreeNode insertNode(TreeNode root, TreeNode node) {
        // write your code here
    	if(root==null){
    		root=node;
    		return root;
    	}
    	TreeNode dummy=new TreeNode(-1);
    	dummy.right=root;
    	while(root!=null){
    		
	    	if(node.val<root.val){
	    		if(root.left==null){
	    			root.left=node;
	    		}
	    		else{
	    			root=root.left;
	    			break;
	    		}
	    	}
	    	else{
	    		if(root.right==null){
	    			root.right=node;
	    		}
	    		else{
	    			root=root.right;
	    			break;
	    		}
	    	}
    	}
    	return dummy.right;
    }
}
