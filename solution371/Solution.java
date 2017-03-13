package solution371;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	public static List<Integer> numbersByRecursion(int n) {
        // write your code here
    	
    	List<Integer> res= new ArrayList<Integer>();
    	if(n<=0){
    		return res;
    	}
    	if(n==1){
    		for(int i=1;i<10;i++){
    			res.add(i);
    		}
    		return res;
    	}
    	else{
    		res=numbersByRecursion(n-1);
    		int base=1;
    		for(int i=1;i<n;i++){
    			base=base*10;
    		}
    		res.add(base);
    		int size=res.size();
    		int tmp;
    		for(int i=base/10;i<size-1;i++){
	    		for(int j=1;j<10;j++){
	    		    tmp=res.get(i)+j*base;
	    			res.add(tmp);
	    		}
    		}
    	}
    	res.remove(res.size()-1);
    	return res;
    }
    public static void main(String[] args) {
    	System.out.println(numbersByRecursion(3));
    }
}
