package solution96;

public class Solution {

    public static ListNode partition(ListNode head, int x) {
        // write your code here
    	if(head==null){
    		return null;
    	}
    	ListNode dummy=new ListNode(-1);
    	dummy.next=head;
    	ListNode cur=dummy;
    	ListNode next_node;
    	ListNode tmp1,tmp2,tmp3;
    	while(cur.next!=null){
    		if(cur.next.val>=x){
    			next_node=cur.next;
    			while(next_node.next!=null){
    				if(next_node.next.val<x){
    					break;
    				}
    				next_node=next_node.next;
    			}
    			if(next_node.next==null){
    				return dummy.next;
    			}
    			else{
    				tmp1=cur.next;
    				tmp2=next_node.next;
    				cur.next=tmp2;
    				tmp3=tmp2.next;
    				tmp2.next=tmp1.next;
    				next_node.next=tmp1;
    				tmp1.next=tmp3;
    			}
    		}
    		cur=cur.next;
    	}
    	
    	return dummy.next;
    }
    
    public static void main(String[] args) {
		// TODO Auto-generated method stub
    	ListNode head =new ListNode(1);
    	head.next=new ListNode(4);
    	head.next.next=new ListNode(3);
    	head.next.next.next=new ListNode(2);
    	head.next.next.next.next=new ListNode(5);
    	head.next.next.next.next.next=new ListNode(2);
    	System.out.println(partition(head,6));
	}
}
