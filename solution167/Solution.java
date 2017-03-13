package solution167;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;      
    }
}
public class Solution {
	
    public static ListNode addLists(ListNode l1, ListNode l2) {
        // write your code here
    	int carry=0;
    	int sum=0;

    	ListNode res = new ListNode(0);
    	ListNode dummy=res;
    	while(l1!=null && l2!=null){
    		sum=l1.val+l2.val+carry;
    		carry=sum/10;
    		sum=sum%10;
    		res.next=new ListNode(sum);
    		res=res.next;
    		l1=l1.next;
    		l2=l2.next;
    	}
    	if(l1!=null){
    		while(l1!=null){
        		sum=l1.val+carry;
        		carry=sum/10;
        		sum=sum%10;
        		res.next=new ListNode(sum);
        		res=res.next;
        		l1=l1.next;
    		}
    	}
    	else if(l2!=null){
    		while(l2!=null){
        		sum=l2.val+carry;
        		carry=sum/10;
        		sum=sum%10;
        		res.next=new ListNode(sum);
        		res=res.next;
        		l2=l2.next;
    		}
    	}
    	if(carry!=0){
    		res.next=new ListNode(carry);
    	}
    	return dummy.next;
    }
    
    public static void main(String[] args) {
		// TODO Auto-generated method stub
    	ListNode head =new ListNode(7);
    	head.next=new ListNode(2);
    	head.next.next=new ListNode(7);
    	
    	ListNode head2=new ListNode(3);
    	head2.next=new ListNode(4);
    	head2.next.next=new ListNode(3);    	
    	head2.next.next.next=new ListNode(9);

    	System.out.println(addLists(head,head2));
	}
}
