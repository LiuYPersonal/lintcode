package solution105;

class RandomListNode {
    int label;
    RandomListNode next, random;
    RandomListNode(int x) { 
    	this.label = x; 
    	}
};
public class Solution {
    public static RandomListNode copyRandomList(RandomListNode head) {
        // write your code here
    	if(head==null){
    		return null;
    	}
    	RandomListNode dummy=new RandomListNode(-1);
    	dummy.next=head;
		RandomListNode newNode;
		RandomListNode tmp;
		//copy nodes
    	while(head!=null){
    		newNode=new RandomListNode(10+head.label);
    		tmp=head.next;
    		head.next=newNode;
    		newNode.next=tmp;
    		head=head.next.next;
    		
    	}
    	// copy random
    	head=dummy.next;
    	while(head!=null){
    		tmp=head.random;
    		newNode=head.next;
    		if(tmp!=null){
    		    newNode.random=tmp.next;
    		}
    		head=head.next.next;
    	}
    	// decouple
    	head=dummy.next;
    	dummy.random=new RandomListNode(-1);
    	newNode=dummy.random;
    	
    	while(head!=null){
    		newNode.next=head.next;
    		head=head.next.next;
    		newNode=newNode.next;
    	}
    	return dummy.random.next;
    }
    public static void main(String[] args) {
    	RandomListNode node1=new RandomListNode(1);
    	RandomListNode node2=new RandomListNode(2);
    	RandomListNode node3=new RandomListNode(3);
    	RandomListNode node4=new RandomListNode(4);
    	RandomListNode node5=new RandomListNode(5);
    	node1.next=node2;
    	node2.next=node3;
    	node3.next=node4;
    	node4.next=node5;
    	node1.random=node3;
    	node2.random=node5;
    	node3.random=node1;
    	node4.random=node4;
    	node5.random=node1;
    	System.out.println(copyRandomList(node1));
    }
}
