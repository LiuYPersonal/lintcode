package solution480;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
	     public int val;
	     public TreeNode left, right;
	     public TreeNode(int val) {
	         this.val = val;
	         this.left = this.right = null;
	     }
}
public class Solution {
	
    public List<String> binaryTreePaths(TreeNode root) {
        // Write your code here
    	List<String> res=new ArrayList<String>();
    	if(root==null) return res;
    	DFS("",root,res);
    	return res;
    }
    public void DFS(String path,TreeNode root, List<String> res){
    	if(root==null){
    		return;
    	}
    	else if(root.left==null && root.right==null){
    		res.add(path+String.valueOf(root.val));
    	}
    	else{
    		if(root.left!=null){
    			DFS(path+"->"+String.valueOf(root.val),root.left,res);
    		}
    		if(root.right!=null){
    			DFS(path+"->"+String.valueOf(root.val),root.right,res);
    		}
    	}
    	return;
    }

}
