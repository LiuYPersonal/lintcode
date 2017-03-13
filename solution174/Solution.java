package solution174;

public class Solution {
	
    static ListNode removeNthFromEnd(ListNode head, int n) {
        // write your code here
    	if(n<=0){
    		return null;
    	}
    	ListNode pre=new ListNode(0);
    	pre.next=head;
    	ListNode cur=pre;
    	for(int i=0;i<n;i++){
    		if(head==null){
    			return null;
    		}
    		head=head.next;
    	}
    	while(head!=null){
    		head=head.next;
    		pre=pre.next;
    	}
    	pre.next=pre.next.next;
    	return cur.next;
    }
    
    public static void main(String[] args) {
		// TODO Auto-generated method stub
    	ListNode head =new ListNode(1);
    	System.out.println(removeNthFromEnd(head,1));
	}

}
