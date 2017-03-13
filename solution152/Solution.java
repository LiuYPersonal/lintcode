package solution152;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	
    public static List<List<Integer>> combine(int n, int k) {
    	
    	List<List<Integer>> res=new ArrayList<List<Integer>>();
    	if(k>n){
    		return res;
    	}
		List<Integer> tmp;
    	if(k==1){

    		for(int i=1;i<=n;i++){
    			tmp=new ArrayList<Integer>();
    			tmp.add(i);
    			res.add(tmp);
    		}
    		return res;
    	}
    	else{
    		int count=0;
    		for(int j=n;j>=k;j--){
	    		res.addAll(combine(j-1,k-1));
	    		for(int i=count;i<res.size();i++){
	    			tmp=res.get(i);
	    			tmp.add(j);
	    		}
	    		count=res.size();
    		}
    	}
    	return res;
    }
    public static void main(String[] args) {
		// TODO Auto-generated method stub

    	System.out.println(combine(4,3));
	}
}
