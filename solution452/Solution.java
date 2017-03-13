package solution452;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
public class Solution {
	
    public static ListNode removeElements(ListNode head, int val) {
        // Write your code here
    	if(head==null){
    		return null;
    	}
    	ListNode dummy=new ListNode(0);
    	ListNode pre=dummy;
    	dummy.next=head;
    	while(head!=null){
    		if(head.val==val){
    			pre.next=head.next;
    			head=head.next;
    		}
    		else{
    			pre=pre.next;
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
    	head.next.next.next.next.next.next=new ListNode(3);
    	System.out.println(removeElements(head,3));
    }
}
