package solution156;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Interval {
	     int start, end;
	     Interval(int start, int end) {
	         this.start = start;
	         this.end = end;
	     }
}
public class Solution {
	
	public List<Interval> merge(List<Interval> intervals) {
        // write your code here
        ArrayList<Interval> result = new ArrayList<Interval>();
        if(intervals.size()==0) return result;
        Comparator<Interval> comp = new Comparator<Interval>()  
        {  
            @Override  
            public int compare(Interval i1, Interval i2)  
            {  
                if(i1.start==i2.start){  
                    return i1.end-i2.end;
                }
                return i1.start-i2.start;  
            }  
        };  
        Collections.sort(intervals,comp);  
        Interval cur=intervals.get(0);
    	for(int i=1;i<intervals.size();i++){
    		Interval newInterval=intervals.get(i);
    		if(newInterval.start>cur.end){
    			Interval tmp=new Interval(cur.start,cur.end);
    			result.add(tmp);
    			cur.start=newInterval.start;
    			cur.end=newInterval.end;
    		}
    		else{
    			cur.start=Math.min(cur.start, newInterval.start);
       			cur.end=Math.max(cur.end, newInterval.end);
    		}
    	}
    	result.add(cur);
    	return result;
    }
}
