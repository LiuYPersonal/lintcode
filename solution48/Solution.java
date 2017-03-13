package solution48;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    public static int majorityNumber(ArrayList<Integer> nums, int k) {
        // write your code
    	HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
    	//维护k－1个candidates
    	for(int i=0;i<nums.size();i++){
    		//如果当前是某一个element
    		if(map.containsKey(nums.get(i))){
    			map.put(nums.get(i), map.get(nums.get(i))+1);
    		}
    		//否则增加一个candidate
    		else{
    			map.put(nums.get(i),1);			
    		}
    		//如果candidates数量大于k－1，将candidates互相抵消，将count＝0的去掉
    		if(map.size()>=k){
    			removeElement(map);
    		}
    	}
    	if(map.size()==0){
    		return 0;
    	}
    	Set<Integer> keySet=map.keySet();
    	for(int key:keySet){
    		map.put(key, 0);
    	}
    	for(int i=0;i<nums.size();i++){
    		map.put(nums.get(i), map.get(nums.get(i))+1);
    	}
    	int max=0,index=0;
    	for(int key:keySet){
    		if(map.get(key)>max){
    			max=map.get(key);
    			index=key;
    		}
    	}    	
    	return index;
    }
    public static void removeElement(HashMap<Integer,Integer> map){
    	Set<Integer> keySet=map.keySet();
    	Set<Integer> removeSet=new HashSet<Integer>();   	
    	for(int key:keySet){
    		map.put(key, map.get(key)-1);
    		if(map.get(key)==0){
    			removeSet.add(key);
    		}
    	}
    	map.remove(removeSet);
    	return;
    }
    public static void main(String[] args) {
		// TODO Auto-generated method stub
    	ArrayList<Integer> num=new ArrayList<Integer>();
    	num.add(3);
    	num.add(1);
    	num.add(2);
    	num.add(3);
    	num.add(2);
    	num.add(3);
    	num.add(3);
    	num.add(4);
    	num.add(4);
    	num.add(4);
    	System.out.println(majorityNumber(num,3));
	}
}
