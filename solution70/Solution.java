package solution70;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
	     public int val;
	     public TreeNode left, right;
	     public TreeNode(int val) {
	         this.val = val;
	         this.left = this.right = null;
	     }
}
public class Solution {

    public static ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
    	ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
    	if(root==null){
    		return res;
    	}
        // write your code here
    	Queue<TreeNode> BFS=new LinkedList<TreeNode>();
    	Queue<Integer> Depth=new LinkedList<Integer>();
    	BFS.add(root);
    	Depth.offer(1);
    	int count=1;
    	int depth;
    	ArrayList<Integer> tmp_res=new ArrayList<Integer>();
    	while(!BFS.isEmpty()){
    		TreeNode tmp=BFS.poll();
    		depth=Depth.poll();
    		if(count!=depth){
    			ArrayList<Integer> tmp2=new ArrayList<Integer>(tmp_res);
    			res.add(0,tmp2);
    			tmp_res.clear();
    			count++;
    		}
			tmp_res.add(tmp.val);
			if(tmp.left!=null){
		    	BFS.add(tmp.left);
		    	Depth.offer(count+1);
			}
			if(tmp.right!=null){
		    	BFS.add(tmp.right);
		    	Depth.offer(count+1);
			}
    	}
    	res.add(0,tmp_res);
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
    	System.out.println(levelOrderBottom(root));
	}
}
