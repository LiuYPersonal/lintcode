package solution102;
class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}
public class Solution {

    public boolean hasCycle(ListNode head) {  
        // write your code here
    	if(head==null ||head.next==null){
    		return false;
    	}
    	ListNode fast=head;
    	ListNode slow=head;
    	while(fast.next!=null && slow.next.next!=null){
    		fast=fast.next;
    		slow=slow.next.next;
    		if(slow==fast){
    			return true;
    		}
    	}
    	return false;
    	
    }
}
