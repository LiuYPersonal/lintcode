package solution380;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
public class Solution {

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // Write your code here
    	if(headA==null || headB==null){
    		return null;
    	}
        ListNode dummy1=new ListNode(-1);
        dummy1.next=headA;
        ListNode dummy2=new ListNode(-1);
        dummy2.next=headB;
        int len1=0,len2=0;
        while(headA!=null){
        	len1++;
        	headA=headA.next;
        }
        while(headB!=null){
        	len2++;
        	headB=headB.next;
        }
        headA=dummy1.next;
        headB=dummy2.next;
        if(len1>len2){
        	while(len1>len2){
        		headA=headA.next;
        		len1--;
        	}
        }
        else{
        	while(len2>len1){
        		headB=headB.next;
        		len2--;
        	}
        }
        while(headA!=null){
        	if(headA==headB){
        		return headA;
        	}
        	else{
        		headA=headA.next;
        		headB=headB.next;
        	}
        }
        return null;
        
    }
    
    public static void main(String[] args) {
    	ListNode headA=new ListNode(6);
    	ListNode headB=new ListNode(4);
    	ListNode node1=new ListNode(1);
    	ListNode node2=new ListNode(2);
    	ListNode node3=new ListNode(3);
    	ListNode node5=new ListNode(5);
    	headB.next=node5;
    	headA.next=node1;
    	node5.next=node1;
    	node1.next=node2;
    	node2.next=node3;
    	System.out.println(getIntersectionNode(headA,headB));
    }
}
