package solution113;


class ListNode {
	     int val;
	     ListNode next;
	     ListNode(int x) {
	         val = x;
	         next = null;
	     }
}
public class Solution {

	
    public static ListNode deleteDuplicates(ListNode head) {
        // write your code here
    	if(head==null){
    		return head;
    	}
    	ListNode dummy=new ListNode(0);
    	dummy.next=head;
    	ListNode pre=dummy;
    	head=head.next;
    	while(head!=null){
    		if(head.val!=pre.next.val){
    			head=head.next;
    			pre=pre.next;
    		}
    		else{
    			while(head.val==pre.next.val){
    				head=head.next;
    				if(head==null){
    					pre.next=null;
    					return dummy.next;
    				}
    			}
    			pre.next=head;
    			head=head.next;
    		}
    	}
    	
    	return dummy.next;
    }
    public static void main(String[] args) {
    	ListNode head =new ListNode(1);
    	head.next=new ListNode(2);
    	head.next.next=new ListNode(3);
    	head.next.next.next=new ListNode(3);
    	head.next.next.next.next=new ListNode(4);
    	head.next.next.next.next.next=new ListNode(4);
    	head.next.next.next.next.next.next=new ListNode(4);
    	System.out.println(deleteDuplicates(head));
    }
}
