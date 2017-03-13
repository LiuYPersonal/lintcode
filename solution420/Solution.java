package solution420;

public class Solution {
	
	public static String countAndSay(int n) {
        // Write your code here
    	if(n<=0) return "0";
    	if(n==1) return "1";
    	String num="1";
    	int i,j;
    	String newNum="";
    	for(int k=1;k<n;k++){
    		i=0;  		
    		while(i<num.length()){
    			j=i;
    			while(num.charAt(j)==num.charAt(i)){
    				j++;
    				if(j==num.length()){
    					break;
    				}
    			}
    			newNum=newNum+String.valueOf(j-i)+num.charAt(i);
    			i=j;
    		}
    		num=newNum;
    		newNum="";
    	}
    	return num;
    }
    public static void main(String[] args) {
    	System.out.println(countAndSay(5));
    }
}
