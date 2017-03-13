package solution170;

public class Solution {

    public static ListNode rotateRight(ListNode head, int k) {
        // write your code here
    	if(head==null || head.next==null){
    		return head;
    	}
    	if(k<=0){
    		return head;
    	}
    	ListNode cur=head;
    	ListNode pre=cur;
    	ListNode dummy=new ListNode(0);
    	dummy.next=head;
    	for(int i=0;i<k;i++){
    		if(cur.next==null){
    			cur=dummy.next;
    		}
    		else{
    			cur=cur.next;
    		}
    	}
    	while(cur.next!=null){
    		cur=cur.next;
    		pre=pre.next;
    	}
    	ListNode tmp=pre.next;
    	if(tmp==null){
    		return dummy.next;
    	}
    	pre.next=null;
    	cur.next=dummy.next;
    	return tmp;
    	
    }
    
    public static void main(String[] args) {
		// TODO Auto-generated method stub
    	ListNode head =new ListNode(1);
    	head.next=new ListNode(2);
    	head.next.next=new ListNode(3);
    	head.next.next.next=new ListNode(4);
    	head.next.next.next.next=new ListNode(5);
    	head.next.next.next.next.next=new ListNode(6);
    	System.out.println(rotateRight(head,8));
	}
}
