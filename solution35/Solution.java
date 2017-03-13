package solution35;

public class Solution {

    public static ListNode reverse(ListNode head) {
    	
    	if(head==null){
    		return null;
    	}
    	ListNode dummy=new ListNode(0);
    	dummy.next=head;
    	ListNode cur=head;
    	while(cur.next!=null){
    		ListNode tmp=cur.next;
    		cur.next=tmp.next;
    		tmp.next=dummy.next;
    		dummy.next=tmp;
    		
    	}
    	return dummy.next;	
    }
    
    public static void main(String[] args) {
		// TODO Auto-generated method stub
    	ListNode head =new ListNode(1);
    	head.next=new ListNode(2);
    	head.next.next=new ListNode(3);
    	head.next.next.next=new ListNode(4);
    	head.next.next.next.next=new ListNode(5);
    	head.next.next.next.next.next=new ListNode(6);
    	System.out.println(reverse(head));
	}
}
