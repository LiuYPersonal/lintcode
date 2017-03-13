package solution94;

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
    public static int maxPathSum(TreeNode root) {
        // write your code here
    	if(root==null){
    		return 0;
    	}
    	int max=Integer.MIN_VALUE;
    	Stack<TreeNode> stack=new Stack<TreeNode>();
    	stack.push(root);
    	int left,right;
    	while(!stack.isEmpty()){
    		root=stack.pop();
    		left=0;
    		right=0;
			if(root.left!=null){
				stack.push(root.left);
				left=findMax(root.left);
			}
			if(root.right!=null){
				stack.push(root.right);
				right=findMax(root.right);
			}
			int sum=root.val;
	    	if(left>0){
	    		sum+=left;
	    	}
	    	if(right>0){
	    		sum+=right;
	    	}
	    	if(sum>max){
	    		max=sum;
	    	}
    	}
    	return max;
    }
    public static int findMax(TreeNode root){
    	if(root.left==null && root.right==null){
    		return root.val;
    	}
    	int left=0,right=0;
    	if(root.left!=null){
    		left=findMax(root.left);
    	}
    	if(root.right!=null){
    		right=findMax(root.right);
    	}
    	int sum=(left>right)?left:right;
    	sum+=root.val;
    	return sum>0?sum:0;
    }
    public static void main(String[] args) {
    	TreeNode node1=new TreeNode(1);
    	TreeNode node2=new TreeNode(-2);
    	TreeNode node3=new TreeNode(3);
    	node2.left=node1;
    	node2.right=node3;
    	System.out.println(maxPathSum(node2));
    }
}
