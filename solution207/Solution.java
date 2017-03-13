package solution207;

class SegmentTreeNode {
    public int start, end;
    public Long sum;
    public SegmentTreeNode left, right;
    public SegmentTreeNode(int start, int end, long sum) {
        this.start = start;
        this.end = end;
        this.sum = sum;
        this.left = this.right = null;
    }
}

public class Solution {
   /* you may need to use some attributes here */
	SegmentTreeNode root=null;
	public Solution(int[] A) {
	       // write your code here
	       if(A.length!=0){
	           root=buildTree(A,0,A.length-1);
	           for(int i=0;i<A.length;i++){
	        	   modify(i,A[i]);
	           }
	       }
	       return;
	   }
	   public SegmentTreeNode buildTree(int[] A, int p, int q){
	       SegmentTreeNode root1=new SegmentTreeNode(p,q,0);
	       if(p==q){
	           return root1;
	       }
	       else{
	           root1.left=buildTree(A,p,(p+q)/2);
	           root1.right=buildTree(A,(p+q)/2+1,q);
	       }
	       return root1;
	   }
	       /**
	    * @param start, end: Indices
	    * @return: The sum from start to end
	    */
	   public long query(int start, int end) {
	       // write your code here
	       return queryRoot(root,start,end);
	   }
	   public long queryRoot(SegmentTreeNode root, int start, int end) {
	       // write your code here
	       if(root==null || start>end || start<root.start || end>root.end){
	           return 0;
	       }
	       if(start<root.start){
	           start=root.start;
	       }
	       if(end>root.end){
	           end=root.end;
	       }
	       if(root.start==start && root.end==end){
	           return root.sum;
	       }
	       else if(start>(root.start+root.end)/2 && end<=root.end){
	           return queryRoot(root.right,start,end);
	       }
	       else if(end<=(root.start+root.end)/2 && start>=root.start){
	           return queryRoot(root.left,start,end);
	       }
	       else{
	           Long sum1=queryRoot(root.left,start,(root.start+root.end)/2);
	           Long sum2=queryRoot(root.right,(root.start+root.end)/2+1,end);
	           return (sum1+sum2);
	       }
	   }
	   /**
	    * @param index, value: modify A[index] to value.
	    */
	   public void modify(int index, int value) {
	       root=modifyRoot(root,index,value);
	       return;
	   }
	   public SegmentTreeNode modifyRoot(SegmentTreeNode root, int index, int value) { 
	       // write your code here
	       if(root==null){
	           return root;
	       }
	       if(root.start==root.end && root.start==index){
	           root.sum=(long) value;
	       }
	       else if(root.start<=index && root.end>=index){
	           if(index<=(root.start+root.end)/2){
	               root.left=modifyRoot(root.left,index,value);
	           }
	           else{
	               root.right=modifyRoot(root.right,index,value);
	           }
	           root.sum=root.left.sum+root.right.sum;
	       }
	       return root;
	   }
}
