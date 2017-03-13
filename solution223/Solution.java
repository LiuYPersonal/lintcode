package solution223;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution {

    public static boolean isPalindrome(ListNode head) {
        // Write your code here
        if(head==null || head.next==null){
        	return true;
        }
        ListNode dummy =new ListNode(-1);
        dummy.next=head;
        ListNode slow=head;
        ListNode fast=head.next;
        while(fast.next!=null && fast.next.next!=null){
        	slow=slow.next;
        	fast=fast.next.next;
        }
        ListNode list1=slow;
        if(list1.val==list1.next.val){
        	list1=list1.next;
        }
        else{
        	list1=list1.next.next;
        }
        slow.next=null;
        ListNode list2=reverseList(dummy.next);
        while(list1!=null && list2!=null){
        	if(list1.val!=list2.val){
        		return false;
        	}
        	list1=list1.next;
        	list2=list2.next;
        }
        if(list1==list2){
        	return true;
        }
        return false;
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
    	ListNode node3=new ListNode(1);
    	ListNode node4=new ListNode(1);
 //   	ListNode node5=new ListNode(1);
    	node1.next=node2;
    	node2.next=node3;
//    	node3.next=node4;
//    	node4.next=node5;
    	System.out.println(isPalindrome(node1));
    }
}
