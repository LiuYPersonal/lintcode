package solution99;

class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}
public class Solution {

    public static void reorderList(ListNode head) {  
        // write your code here
    	if(head==null || head.next==null){
    		return;
    	}
    	ListNode dummy=new ListNode(0);
    	dummy.next=head;
    	ListNode cur=head;
    	int len=getLength(cur);
    	int mid=len/2;
//    	cur=head;
    	for(int i=0;i<mid;i++){
    		cur=cur.next;
    	}
    	ListNode right=cur.next;
    	cur.next=null;
    	right=reverse(right);
    	while(right!=null){
    		ListNode tmp1=head.next;
    		ListNode tmp2=right.next;
    		head.next=right;
    		right.next=tmp1;
    		right=tmp2;
    		head=head.next.next;
    	}
    	head=dummy.next;
    }
    
    public static int getLength(ListNode head){
    	int count=0;
    	while(head!=null){
    		count++;
    		head=head.next;
    	}
    	return count;
    }
    
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
    	head.next.next.next.next.next.next=new ListNode(7);
    	reorderList(head);
	}
}
