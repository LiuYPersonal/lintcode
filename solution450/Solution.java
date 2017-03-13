package solution450;


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
public class Solution {

    public static ListNode reverseKGroup(ListNode head, int k) {
        // Write your code here
    	ListNode dummy=new ListNode(-1);
    	dummy.next=head;
    	ListNode p=dummy;
    	ListNode q=dummy;
    	int count=0;
    	while(q.next!=null){
    		if(count<k){
    			q=q.next;
    			count++;
    		}
    		if(count==k){
    			count=0;
    			ListNode tmp=q.next;
    			q.next=null;
    			p.next=reverseList(p.next);
    			while(p.next!=null){
    				p=p.next;
    			}
    			p.next=tmp;
    			q=p;
    		}
    	}
    	return dummy.next;
    	
    }
    
    public static ListNode reverseList(ListNode head){
    	ListNode dummy=new ListNode(-1);
    	dummy.next=head;
    	ListNode tmp;
    	while(head.next!=null){
    		tmp=head.next;
    		head.next=head.next.next;
    		tmp.next=dummy.next;
    		dummy.next=tmp;
    	}
    	return dummy.next;
    }
    public static void main(String[] args) {
    	ListNode node1=new ListNode(1);
    	ListNode node2=new ListNode(2);
    	ListNode node3=new ListNode(3);
    	ListNode node4=new ListNode(4);
    	ListNode node5=new ListNode(5);
    	ListNode node6=new ListNode(6);
    	ListNode node7=new ListNode(7);
    	node1.next=node2;
    	node2.next=node3;
    	node3.next=node4;
    	node4.next=node5;
    	node5.next=node6;
    	node6.next=node7;
    	System.out.println(reverseKGroup(node1,6));
    }
}
