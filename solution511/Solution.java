package solution511;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
public class Solution {

    public static ListNode swapNodes(ListNode head, int v1, int v2) {
        // Write your code here
    	ListNode dummy=new ListNode(-1);
    	dummy.next=head;
    	head=dummy;
    	ListNode L1=null,L2=null;
    	while(head.next!=null){
    		if(head.next.val==v1){
    			L1=head;
    		}
    		else if(head.next.val==v2){
    			L2=head;
    		}
    		head=head.next;
    	}
    	if(L1!=null && L2!=null){
    		if(L1.next==L2){
    			ListNode tmp=L2.next;
    			L2.next=L2.next.next;
    			L1.next=tmp;
    			tmp.next=L2;
    		}
    		else if(L2.next==L1){
    			ListNode tmp=L1.next;
    			L1.next=L1.next.next;
    			L2.next=tmp;
    			tmp.next=L1;
    		}
    		else{
    			ListNode tmp=L2.next;
	    		ListNode tmp2=L1.next;
	    		L2.next=L2.next.next;
	    		L1.next=L1.next.next;
	    		tmp.next=L1.next;
	    		L1.next=tmp;
	    		tmp2.next=L2.next;
	    		L2.next=tmp2;
    		}
    	}
    	return dummy.next;
    }
    public static void main(String[] args) {
    	ListNode node1=new ListNode(10);
    	ListNode node2=new ListNode(8);
    	ListNode node3=new ListNode(7);
    	ListNode node4=new ListNode(6);
    	ListNode node5=new ListNode(4);
    	ListNode node6=new ListNode(3);
    	node1.next=node2;
    	node2.next=node3;
    	node3.next=node4;
    	node4.next=node5;
    	node5.next=node6;
    	
    	System.out.println(swapNodes(node1,10,3));
    }
}
