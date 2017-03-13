package solution451;


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
public class Solution {

    public static ListNode swapPairs(ListNode head) {
        // Write your code here
    	if(head==null || head.next==null){
    		return head;
    	} 
    	ListNode dummy=new ListNode(-1);
    	dummy.next=head;
    	ListNode p=head;
    	ListNode q=head.next;
    	ListNode pre=dummy;
    	while(q!=null){
    		p.next=p.next.next;
    		q.next=p;
    		pre.next=q;
    		pre=p;
    		p=p.next;
    		if(p==null){
    			break;
    		}
    		q=p.next;
    	}
    	return dummy.next;
    }
    
    public static void main(String[] args) {
    	ListNode head =new ListNode(1);
    	head.next=new ListNode(2);
    	head.next.next=new ListNode(3);
    	head.next.next.next=new ListNode(4);
    	head.next.next.next.next=new ListNode(5);
    	head.next.next.next.next.next=new ListNode(6);
    	System.out.println(swapPairs(head));
    }
}
