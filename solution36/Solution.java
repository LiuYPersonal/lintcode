package solution36;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
public class Solution {
	
    public static ListNode reverseBetween(ListNode head, int m , int n) {
        // write your code
    	if(head==null){
    		return head;
    	}
    	ListNode dummy=new ListNode(0);
    	ListNode pre=dummy;
    	dummy.next=head;
    	for(int i=0;i<m-1;i++){
    		pre=pre.next;
    		head=head.next;
    	}
    	for(int i=m;i<n;i++){
    		ListNode tmp=head.next;
    		ListNode tmp2=pre.next;
    		head.next=tmp.next;
    		pre.next=tmp;
    		tmp.next=tmp2;
    		
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
    	head.next.next.next.next.next.next=new ListNode(7);
    	System.out.println(reverseBetween(head,1,7));
    }
}
