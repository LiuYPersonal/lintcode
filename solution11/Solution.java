package solution11;

import java.util.ArrayList;

class TreeNode {
    public int val;
    public TreeNode left, right;
    public TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}
public class Solution {

    public static ArrayList<Integer> searchRange(TreeNode root, int k1, int k2) {
        // write your code here
    	ArrayList<Integer> res=new ArrayList<Integer>();
    	if(root==null){
    		return res;
    	}
    	if(root.val>k2){
    		res.addAll(searchRange(root.left, k1,k2));
    	}
    	else if(root.val<k1){
    		res.addAll(searchRange(root.right,k1,k2));
    	}
    	else{
    		res.addAll(searchRange(root.left, k1,k2));
    		res.add(root.val);
    		res.addAll(searchRange(root.right,k1,k2));
    	}
    	return res;
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
    	System.out.println(searchRange(root,6,15));
	}
}
