package solution106;

public class Solution {
    public static TreeNode sortedListToBST(ListNode head) {  
        // write your code here
    	int len=0;
    	ListNode cur=head;
    	while(cur!=null){
    		cur=cur.next;
    		len++;
    	}
    	cur=head;
    	return sortedListToBST(cur,len);
    }
    public static TreeNode sortedListToBST(ListNode head, int q){
    	if(q<=0){
    		return null;
    	}
    	if(q==1){
    		return new TreeNode(head.val);
    	}
    	int mid=q/2;
    	ListNode cur=head;
    	for(int i=0;i<mid-1;i++){
    		cur=cur.next;
    	}
    	ListNode tmp=cur.next;
    	cur.next=null;
    	TreeNode root=new TreeNode(tmp.val);
    	root.left=sortedListToBST(head,mid);
    	root.right=sortedListToBST(tmp.next,q-mid-1);
    	return root;
    }
    public static void main(String[] args) {
		// TODO Auto-generated method stub
    	ListNode head =new ListNode(1);
    	head.next=new ListNode(2);
    	head.next.next=new ListNode(3);
    	head.next.next.next=new ListNode(4);
    	head.next.next.next.next=new ListNode(5);
    	head.next.next.next.next.next=new ListNode(6);
    	System.out.println(sortedListToBST(head));
	}
}
