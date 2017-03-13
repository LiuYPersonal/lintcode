package solution512;

public class Solution {
	 public static int numDecodings(String s) {
	        // Write your code here
	        if(s==null || s.equals("")){
	            return 0;
	        }
	        int[] dp=new int[s.length()+1];
	        dp[0]=1;
	        dp[1]=s.charAt(0)=='0'?0:1;
	        for(int i=2;i<=s.length();i++){
	        	if(s.charAt(i)!='0'){
	        		dp[i]=dp[i-1];
	        	}
	        	int twoDigits=(s.charAt(i-2)-'0')*10+(s.charAt(i-1)-'0');
	        	if(twoDigits>=10 && twoDigits<=26){
	        		dp[i]+=dp[i-2];
	        	}
	        	
	        }
	        return dp[s.length()];
	    }
	    public static void main(String[] args) {
	    	String nums="2789011203";
	    	System.out.println(numDecodings(nums));
	    }
}
