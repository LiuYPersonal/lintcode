package solution68;

import java.util.ArrayList;
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
	
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        // write your code here
        ArrayList<Integer> res=new ArrayList<Integer>();
        Stack<TreeNode> stack=new Stack<TreeNode>();
        if(root==null){
        	return res;
        }
        TreeNode cur=root;
        while(cur!=null || !stack.isEmpty()){
    		while(cur!=null){
    			if(cur.right!=null){
    				stack.push(cur.right);
    			}
    			stack.push(cur);
    			cur=cur.left;
    		}
    		cur=stack.pop();
    		if(cur.right!=null && stack.peek()==cur.right){
    			stack.pop();
    			stack.push(cur);
    			cur=cur.right;
    		}
    		else{
    			res.add(cur.val);
    			cur=null;
    		}
        }
        return res;
    }
}
