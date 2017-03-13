package solution30;

import java.util.ArrayList;

class Interval {
	     int start, end;
	     Interval(int start, int end) {
	         this.start = start;
	         this.end = end;
	     }
}
public class Solution {
	public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
		ArrayList<Interval> result = new ArrayList<Interval>();
        // write your code here
		if(intervals.size()==0){
			intervals.add(newInterval);
			return intervals;
		}
		boolean isInserted=false;
        for(int i=0;i<intervals.size();i++){
        	Interval cur=intervals.get(i);
        	if(!isInserted){
	        	if(cur.end<newInterval.start){
	        		result.add(cur);
	        	}
	        	else if(newInterval.end<cur.start){
	        		result.add(newInterval);
	        		result.add(cur);
	        		isInserted=true;
	        	}
	        	else{
	        		newInterval.start=Math.min(cur.start,newInterval.start);
	        		newInterval.end=Math.max(cur.end,newInterval.end);
	        	}
        	}
        	else{
        		result.add(cur);
        	}
        }
        if(!isInserted){
        	result.add(newInterval);
        }
        return result;   
	}
}
