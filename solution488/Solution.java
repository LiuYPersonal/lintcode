package solution488;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public static boolean isHappy(int n) {
        // Write your code here
       Set<Integer> map=new HashSet<Integer>();
       map.add(n);
       if(n==1){
    	   return true;
       }
       int sum=0;
       while(true){
    	   sum+=(n%10)*(n%10);
    	   n=n/10;
    	   if(n==0){
    		   if(sum==1){
    			   return true;
    		   }
        	   else if(map.contains(sum)){
    			   return false;
    		   }
        	   else{
        		   map.add(sum);
        		   n=sum;
        		   sum=0;
        	   }
    	   }
       }
    }
    public static void main(String[] args) {
		// TODO Auto-generated method stub
    	System.out.println(isHappy(19));
	}
}
