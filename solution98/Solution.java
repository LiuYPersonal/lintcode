package solution98;

class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}
public class Solution {
	private static ListNode findMiddle(ListNode head){
		ListNode slow=head, fast=head.next;
		while(fast!=null && fast.next!=null){
			fast=fast.next.next;
			slow=slow.next;
		}
		return slow;
	}
	
	private static ListNode merge(ListNode left, ListNode right){
		ListNode dummy=new ListNode(0);
		ListNode tail=dummy;
		while(left!=null & right!=null){
			if(left.val<right.val){
				tail.next=left;
				left=left.next;
			}
			else{
				tail.next=right;
				right=right.next;
			}
			tail=tail.next;
		}
		if(left!=null){
			tail.next=left;
		}
		else{
			tail.next=right;
		}
		return dummy.next;
	}
	
    public static ListNode sortList(ListNode head) {  
        // write your code here
    	if(head==null || head.next==null){
    		return head;
    	}
    	ListNode mid=findMiddle(head);
    	ListNode right=sortList(mid.next);
    	mid.next=null;
    	ListNode left=sortList(head);
    	return merge(left,right);
    	
    }
    
    public static void main(String[] args) {
		// TODO Auto-generated method stub
    	ListNode head =new ListNode(2);
    	head.next=new ListNode(1);
    	head.next.next=new ListNode(3);
    	head.next.next.next=new ListNode(6);
    	head.next.next.next.next=new ListNode(4);
    	head.next.next.next.next.next=new ListNode(5);
    	head.next.next.next.next.next.next=new ListNode(7);
    	System.out.println(sortList(head));
	}
}
