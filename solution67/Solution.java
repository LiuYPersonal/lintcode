package solution67;

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
	
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        // write your code here
    	Stack<TreeNode> stack=new Stack<TreeNode>();
    	ArrayList<Integer> res =new ArrayList<Integer>();
    	if(root==null){
    		return res;
    	}
    	TreeNode cur=root;
    	while(cur!=null || !stack.isEmpty()){
    		while(cur!=null){
    			stack.push(cur);
    			cur=cur.left;
    		}
    		cur=stack.pop();
    		res.add(cur.val);
    		cur=cur.right;
    	}
    	return res;
    }

}
