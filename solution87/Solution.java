package solution87;

class TreeNode {
     public int val;
     public TreeNode left, right;
     public TreeNode(int val) {
         this.val = val;
         this.left = this.right = null;
     }
}
public class Solution {
	
    public static TreeNode removeNode(TreeNode root, int value) {
        // write your code here
    	if(root==null){
    		return null;
    	}
    	TreeNode dummy=new TreeNode(Integer.MIN_VALUE);
    	dummy.right=root;
    	TreeNode cur=dummy;
    	while(cur!=null){
    		//find the node
	    	if(cur.left!=null && cur.left.val==value){
               helper(cur,false);
               break;
	    	}
	    	else if(cur.right!=null && cur.right.val==value){
	    		helper(cur,true);
	    		break;
	    	}
	    	else if(cur.val<value){
	    		cur=cur.right;
	    	}
	    	else{
	    		cur=cur.left;
	    	}
    	}
    	return dummy.right;
    }
    public static void helper(TreeNode cur, boolean isRight){
    	TreeNode child;
    	if(isRight){
    		child=cur.right;
    	}
    	else{
    		child=cur.left;
    	}
		//if leaf node
		if(child.left==null && child.right==null){
			if(isRight){
				cur.right=null;
			}
			else{
				cur.left=null;
			}
		}
		//if has two child nodes
		else if(child.left!=null && child.right!=null){
			int tmp=child.val;
			child.val=child.left.val;
			child.left.val=tmp;
			removeNode(child, tmp);
		}
		// other wise, only one node
		else if(child.left!=null){
			if(isRight){
				cur.right=child.left;
			}
			else{
				cur.left=child.left;
			}
		}
		else{
			if(isRight){
				cur.right=child.right;
			}
			else{
				cur.left=child.right;
			}
		}
    }

    public static void main(String[] args) {
		// TODO Auto-generated method stub
    	TreeNode root = new TreeNode(10);
    	root.left= new TreeNode(5);
    	root.left.left= new TreeNode(3);
    	root.left.right=new TreeNode(9);
    	root.left.right.left=new TreeNode(6);
    	root.right=new TreeNode(15);
    	root.right.left=new TreeNode(11);
    	root.right.right=new TreeNode(20);
    	System.out.println(removeNode(root,1));
	}
}
