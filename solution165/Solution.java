package solution165;
class ListNode {
	     int val;
	     ListNode next;
	     ListNode(int val) {
	         this.val = val;
	         this.next = null;
	     }
}
public class Solution {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // write your code here
    	ListNode dummy=new ListNode(-1);
    	dummy.next=l1;
    	ListNode cur=dummy;
    	ListNode tmp1,tmp2;
    	while(cur.next!=null && l2!=null){
    		if(cur.next.val>l2.val){
    			tmp1=cur.next;
    			tmp2=l2.next;
    			cur.next=l2;
    			l2.next=tmp1;
    			l2=tmp2;
    		}
    		else{
    			cur=cur.next;
    		}
    	}
    	if(l2!= null){
    		cur.next=l2;
    	}
    	return dummy.next;
    }
}
