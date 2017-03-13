package solution104;

import java.util.List;

class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}
public class Solution {
	public ListNode mergeKLists(List<ListNode> lists) {  
        // write your code here
        if(lists==null || lists.size()==0)  
            return null;  
        return helper(lists,0,lists.size()-1);   	
    }
	
	private ListNode helper(List<ListNode> lists, int p, int q){
		if(p==q){
			return lists.get(p);
		}
		else{
			ListNode left=helper(lists, p, (p+q)/2);
			ListNode right=helper(lists, (p+q)/2+1,q);
			return merge(left, right);
		}
	}
	private ListNode merge(ListNode l1, ListNode l2){
		ListNode dummy=new ListNode(0);
	    dummy.next = l1;  
	    ListNode cur = dummy;  
	    while(l1!=null && l2!=null){  
	        if(l1.val<l2.val)  
	        {  
	            l1 = l1.next;  
	        }  
	        else  
	        {  
	            ListNode next = l2.next;  
	            cur.next = l2;  
	            l2.next = l1;  
	            l2 = next;  
	        }  
	        cur = cur.next;  
	    }  
	    if(l2!=null){  
	        cur.next = l2;
	    }
	    return dummy.next;  
    }
}
