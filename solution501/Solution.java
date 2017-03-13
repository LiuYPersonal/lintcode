package solution501;

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
	
    public static List<TreeNode> generateTrees(int n) {
        // write your code here
    	return generate(1,n);
    }
    public static List<TreeNode> generate(int start, int end){
    	List<TreeNode> left=new ArrayList<TreeNode>();
    	List<TreeNode> right=new ArrayList<TreeNode>();
    	List<TreeNode> res=new ArrayList<TreeNode>();
    	if(start>end){
    		res.add(null);
    		return res;
    	}
    	if(start==end){
    		TreeNode root=new TreeNode(start);
    		res.add(root);
    		return res;
    	}
    	int count1=0,count2=0;
    	for(int i=start;i<=end;i++){	
    		left.addAll(generate(start,i-1));
    		right.addAll(generate(i+1,end));
    		for(int j=count1;j<left.size();j++){
    			for(int w=count2;w<right.size();w++){
    				TreeNode root= new TreeNode(i);
    				root.left=left.get(j);
    				root.right=right.get(w);
    				res.add(root);

    			}
    		}
			count1=left.size();
			count2=right.size();
    	}
    	return res;
    }
    public static void main(String[] args) {
    	System.out.println(generateTrees(3));
    }
}
