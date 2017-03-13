package solution73;

class TreeNode {
    public int val;
    public TreeNode left, right;
    public TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}

public class Solution {

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        // write your code here
    	if(preorder==null || inorder==null || preorder.length==0
    			|| inorder.length==0 ||preorder.length!=inorder.length){
    		return null;
    	}
    	int i=0;
    	int j=preorder.length;
    	int w=0;
    	return build(preorder, inorder, i, j, w);
    	
    }
    public static TreeNode build(int[]preorder , int[] inorder, int i, int j, int w){
    	if(i==j){
    		return null;
    	}
    	TreeNode res=new TreeNode(preorder[i]);
    	int k=0;
    	while(preorder[i]!=inorder[k+w]){
    		k++;
    	}
    	res.left=build(preorder,inorder, i+1,i+k+1,w);
    	res.right=build(preorder,inorder, i+k+1,j,w+k+1);
    	return res;
    }
    public static void main(String[] args) {
		// TODO Auto-generated method stub
    	int[] preorder={10,5,3,9,6,15,11,20};
    	int[] inorder={3,5,6,9,10,11,15,20};
    	System.out.println(buildTree(preorder,inorder));
	}
}
