package solution112;

public class Solutions {
	
    public static ListNode deleteDuplicates(ListNode head) { 
        // write your code here
    	ListNode dummy=new ListNode(0);
    	dummy.next=head;
    	ListNode pre=head;
    	head=head.next;
    	while(head!=null){
    		if(pre.val==head.val){
    			pre.next=pre.next.next;
    		}
    		else{
    			pre=pre.next;
    		}
    		head=head.next;
    	}
    	return dummy.next;
    } 
    public static void main(String[] args) {
		// TODO Auto-generated method stub
    	ListNode head =new ListNode(1);
    	head.next=new ListNode(1);
    	head.next.next=new ListNode(2);
    	head.next.next.next=new ListNode(3);
    	head.next.next.next.next=new ListNode(3);
    	System.out.println(deleteDuplicates(head));
	}
}
