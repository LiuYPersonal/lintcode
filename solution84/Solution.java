package solution84;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	
    public static List<Integer> singleNumberIII(int[] A) {
        // write your code here
    	List<Integer> res=new ArrayList<Integer>();
    	
        int xor=0;
        for(int i=0;i<A.length;i++){
            xor=xor^A[i];
        }
        int lastBit= xor &(-xor);
        int group0=0;
        int group1=0;
        for(int i=0;i<A.length;i++){
        	if((lastBit & A[i])==0){
        		group0^=A[i];
        	}
        	else{
        		group1^=A[i];
        	}
        }
        res.add(group0);
        res.add(group1);
        return res;
    }
    public static void main(String[] args) {
		// TODO Auto-generated method stub
    	int[] matrix={1,2,2,3,4,4,5,3};
    	System.out.println(singleNumberIII(matrix));
	}
}
