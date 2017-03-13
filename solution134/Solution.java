package solution134;

import java.util.HashMap;
import java.util.Map;

public class Solution {
	
	private class ListNode {
	    int val;
	    ListNode next;
	    ListNode(int x) {
	        val = x;
	        next = null;
	    }
	}
	private static Map<Integer,Integer> map=new HashMap<Integer,Integer>();
	
	ListNode dummy;
	int capacity;
	
    // @param capacity, an integer
    public Solution(int capacity) {
        // write your code here
    	this.capacity=capacity;
    	dummy=new ListNode(-1);
    }

    // @return an integer
    public int get(int key) {
        // write your code here
    	if(map.containsKey(key)){
    		ListNode head=dummy;
    		while(head.next.val!=key){
    			head=head.next;
    		}
    		head.next=head.next.next;
    		ListNode tmp=head.next;
    		tmp.next=null;
        	while(head.next!=null){
        		head=head.next;
        	}
        	head.next=tmp;
    		return map.get(key);
    	}
    	else{
    		return -1;
    	}
    	
    }

    // @param key, an integer
    // @param value, an integer
    // @return nothing
    public void set(int key, int value) {
        // write your code here
    	if(map.size()==capacity){
    		int old_key=dummy.next.val;
    		map.remove(old_key);
    		dummy.next=dummy.next.next;
    	}
    	
    	map.put(key, value);
    	ListNode head=dummy;
    	while(head.next!=null){
    		head=head.next;
    	}
    	head.next=new ListNode(key);
    	return;
    }
    public void main(String[] args) {
    	set(2,1);
    	set(1,1);
    	get(2);
    	set(4,1);
    	get(1);
    	get(2);
    	
    }
}
