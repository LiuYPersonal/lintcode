package solution72;

import java.util.Arrays;

class TreeNode {
	     public int val;
	     public TreeNode left, right;
	     public TreeNode(int val) {
	         this.val = val;
	         this.left = this.right = null;
	     }
}
public class Solution {

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        // write your code here
    	if(inorder==null || postorder==null){
    		return null;
    	}
    	if(inorder.length!=postorder.length){
    		return null;
    	}
    	if(inorder.length==0){
    		return null;
    	}
    	int len=postorder.length;
    	int i;
    	TreeNode root=new TreeNode(postorder[len-1]);
    	if(inorder.length==1){
    		return root;
    	}
    	for(i=0;i<len;i++){
    		if(inorder[i]==postorder[len-1]){
    			break;
    		}
    	}
    	int[] left_inorder=Arrays.copyOfRange(inorder, 0, i);
    	int[] left_postorder=Arrays.copyOfRange(postorder, 0, i);
    	int[] right_inorder=Arrays.copyOfRange(inorder, i+1, len);
    	int[] right_postorder=Arrays.copyOfRange(postorder, i, len-1); 
    	root.left=buildTree(left_inorder,left_postorder);
    	  	
    	root.right=buildTree(right_inorder,right_postorder);
    	return root;
    }
    
    public static void main(String[] args) {
    	int[] inorder={1,2,3,4,5,6,7,8,9};
    	int[] postorder={1,2,4,3,6,7,9,8,5};
    	System.out.println(buildTree(inorder,postorder));
    }
}
