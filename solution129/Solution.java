package solution129;

class ListNode {
	     int val;
	     ListNode next;
	     ListNode(int x) {
	         val = x;
	         next = null;
	     }
}
public class Solution {

    public static ListNode[] rehashing(ListNode[] hashTable) {
        // write your code here
    	if(hashTable.length==0){
    		return hashTable;
    	}
    	int capacity=2*hashTable.length;
    	ListNode[] res=new ListNode[capacity];
    	ListNode node;
    	ListNode dummy=new ListNode(0);
    	int position=0;
    	for(int i=0;i<hashTable.length;i++){
    		node=hashTable[i];
    		while(node!=null){
    			position=(node.val%capacity+capacity)%capacity;
    			ListNode tmp=new ListNode(node.val);
    			if(res[position]==null){
    				res[position]=tmp;
    			}
    			else{
    				dummy.next=res[position];
    				while(res[position].next!=null){
    					res[position]=res[position].next;
    				}
    				res[position].next=tmp;
    				res[position]=dummy.next;
    			}
    			node=node.next;
    		}
    	}
    	return res;
    }
    public static void main(String[] args) {
		// TODO Auto-generated method stub
    	ListNode[] nums=new ListNode[4];
    	ListNode node1=new ListNode(8);
    	ListNode node2=new ListNode(16);
    	ListNode node3=new ListNode(14);
    	node2.next=node1;
    	nums[0]=node2;
    	nums[1]=null;
    	nums[2]=node3;
    	nums[3]=null;
    	System.out.println(rehashing(nums));
	}
}
