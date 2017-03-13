package solution173;

class ListNode {
	     int val;
	     ListNode next;
	     ListNode(int val) {
	         this.val = val;
	         this.next = null;
	     }
}
public class Solution {

    public static ListNode insertionSortList(ListNode head) {
        // write your code here
        if(head==null || head.next==null){
            return head;
        }
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode p=head;
        ListNode q=head.next;
        ListNode cur,tmp;
        while(q!=null){
        	if(q.val<p.val){
        		cur=dummy;
        		while(cur.next.val<q.val){
        			cur=cur.next;
        		}
        		//delete the node
        		p.next=p.next.next;
        		//insert the node to  cur.next
        		tmp=cur.next;
        		cur.next=q;
        		q.next=tmp;	
        		q=p.next;
        	}
	        else{
	        	p=p.next;
	        	if(p==null){
	        		break;
	        	}
	        	q=p.next;
	        }
        }
        return dummy.next;
    }
    
    public static void main(String[] args) {
		// TODO Auto-generated method stub
    	ListNode head=new ListNode(1);
    	ListNode node1=new ListNode(3);
    	ListNode node2=new ListNode(2);
    	ListNode node3=new ListNode(5);
    	ListNode node4=new ListNode(4);
    	ListNode node5=new ListNode(0);
    	head.next=node1;
    	node1.next=node2;
    	node2.next=node3;
    	node3.next=node4;
    	node4.next=node5;
    	
    	System.out.println(insertionSortList(head));
	}
}
