package solution103;

import java.util.HashSet;
import java.util.Set;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
public class Solution {
	
    public ListNode detectCycle(ListNode head) {  
        // write your code here
    	if(head==null || head.next==null){
    		return null;
    	}
    	ListNode fast,slow;
    	fast=head;
    	slow=head;
    	while(fast!=slow){
    		if(fast==null || fast.next==null){
    			return null;
    		}
    		fast=fast.next.next;
    		slow=slow.next;
    	}
    	while(head!=slow){
    		head=head.next;
    		slow=slow.next;
    	}
    	return head;
    }

}
