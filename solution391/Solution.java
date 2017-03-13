package solution391;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Interval {
     int start, end;
     Interval(int start, int end) {
         this.start = start;
         this.end = end;
     }
}
public class Solution {
	
    public static int countOfAirplanes(List<Interval> airplanes) { 
        // write your code here
    	ArrayList<Integer> flying=new ArrayList<Integer>();
    	ArrayList<Integer> landing=new ArrayList<Integer>();
    	for(int i=0;i<airplanes.size();i++){
    		Interval tmp=airplanes.get(i);
    		flying.add(tmp.start);
    		landing.add(tmp.end);
    		
    	}
    	
    	Collections.sort(flying);
    	Collections.sort(landing);
    	int i=0;
    	int j=0;
    	int count=0;
    	int max_count=0;
    	while(i<airplanes.size()){
    		if(flying.get(i)<landing.get(j)){
    			count++;
    			if(count>max_count){
    				max_count=count;
    			}
    			i++;
    		}
    		else{
    			count--;
    			j++;
    		}
    	}
    	return max_count;
    	
    }
    public static void main(String[] args) {
		// TODO Auto-generated method stub
    	Interval node1=new Interval(1,10);
    	Interval node2=new Interval(2,3);
    	Interval node3=new Interval(5,8);
    	Interval node4=new Interval(4,7);
    	List<Interval> nums=new ArrayList<Interval>();
    	nums.add(node1);
    	nums.add(node2);
    	nums.add(node3);
    	nums.add(node4);
    	System.out.println(countOfAirplanes(nums));
	}
    
}
