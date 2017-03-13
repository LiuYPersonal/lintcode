package solution166;

class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}
public class Solution {

    ListNode nthToLast(ListNode head, int n) {
        // write your code here
    	if(n<=0){
    		return null;
    	}
    	ListNode pre=head;
    	ListNode cur=head;
    	for(int i=0;i<n;i++){
    		pre=pre.next;
    	}
    	while(pre!=null){
    		pre=pre.next;
    		cur=cur.next;
    	}
    	return cur;
    }
}
