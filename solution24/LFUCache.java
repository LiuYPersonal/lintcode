package solution24;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LFUCache {
	class Node{
		int value;
		int count;
		Node(int value,int count){
			this.value=value;
			this.count=count;
		}
	}
    // @param capacity, an integer
    private Map<Integer,Node> cacheMap;
    ArrayList<Integer> LRU;
    private int capacity;
    public LFUCache(int capacity) {
        // Write your code here
    	this.capacity=capacity;
    	cacheMap = new HashMap<Integer,Node>();
    	LRU = new ArrayList<Integer>();
    }

    // @param key, an integer
    // @param value, an integer
    // @return nothing
    public void set(int key, int value) {
        // Write your code here
        // if key exists, remove the key from LRU
    	if(cacheMap.containsKey(key)){
    		for(int i=0;i<LRU.size();i++){
    			if(LRU.get(i)==key){
    				LRU.remove(i);
    				break;
    			}
    		}
    	}
    	// if cache is full, remove an element from cache and LRU
    	else if(cacheMap.size()==capacity){
    		// find the least recent used with minimum count...
    		int min_count=1000;  
    		int index=0;
    		//
    		for(int i=LRU.size()-1;i>=0;i--){
    			if(cacheMap.get(LRU.get(i)).count<min_count){
    				min_count=cacheMap.get(LRU.get(i)).count;
    				index=i;
    			}
    		}
    		cacheMap.remove(LRU.get(index));
    		LRU.remove(index);
    	}
    	cacheMap.put(key, new Node(value,1));
    	LRU.add(0,key);
    	return;
    }

    public int get(int key) {
        // Write your code here
    	if(cacheMap.containsKey(key)){
    		// update the count
    		Node tmp=cacheMap.get(key);
    		tmp.count+=1;
    		cacheMap.put(key,tmp);
    		// update the LRU
    		for(int i=0;i<LRU.size();i++){
    			if(LRU.get(i)==key){
    				LRU.remove(i);
    				LRU.add(0,key);
    				break;
    			}
    		}
    		return tmp.value;
    	}
    	return -1;
    }
}

