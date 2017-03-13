package solution205;

import java.util.ArrayList;

class Interval {
	     int start, end;
	     Interval(int start, int end) {
	         this.start = start;
	         this.end = end;
	 }
}
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
   /**
    *@param A, queries: Given an integer array and an query list
    *@return: The result list
    */
   public static ArrayList<Long> intervalSum(int[] A, 
                                               ArrayList<Interval> queries) {
       // write your code here
       ArrayList<Long> res=new ArrayList<Long>();
       if(queries.size()==0){
           return res;
       }
       if(A.length==0){
           for(int i=0;i<queries.size();i++){
               res.add((long)0);
           }
       }
       else{
           SegmentTreeNode root=buildTree(A,0,A.length-1);
           for(int i=0;i<A.length;i++){
        	   modify(root,A[i], i);
           }
           for(int i=0;i<queries.size();i++){   
               res.add(query(root,queries.get(i).start,queries.get(i).end));
           }
       }
       return res;
       
   }
   public static SegmentTreeNode buildTree(int[] A, int p, int q){
	   
       SegmentTreeNode root=new SegmentTreeNode(p,q,0);       
       if(p==q){
           return root;
       }
       else{
           root.left=buildTree(A,p,(p+q)/2);
           root.right=buildTree(A,(p+q)/2+1,q);
       }
       return root;
   }
   public static void modify(SegmentTreeNode root, int val, int index){
	   if(root.start==root.end && index==root.start){
		   root.sum+=val;
		   return;
	   }
	   if(index>=root.start && index<=root.end){
		   root.sum+=val;
	   }
	   if(index<=(root.start+root.end)/2){
		   modify(root.left,val,index);
	   }
	   else{
		   modify(root.right,val,index);
	   }
	   return;
   }
   public static long query(SegmentTreeNode root, int start, int end) {
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
           return query(root.right,start,end);
       }
       else if(end<=(root.start+root.end)/2 && start>=root.start){
           return query(root.left,start,end);
       }
       else{
           long min1=query(root.left,start,(root.start+root.end)/2);
           long min2=query(root.right,(root.start+root.end)/2+1,end);
           return min1+min2;
       }
   }

   public static void main(String[] args) {
	   int[] nums={7,8,1,5,2,6,3,1};
	   Interval node1=new Interval(0,1);
	   Interval node2=new Interval(0,4);
	   Interval node3=new Interval(2,4);
	   ArrayList<Interval> queries=new ArrayList<Interval>();
	   queries.add(node1);
	   queries.add(node2);
	   queries.add(node3);
   	   System.out.println(intervalMinNumber(nums,queries));
   }
}
