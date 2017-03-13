package solution192;

public class Solution {

    public static boolean isMatch(String s, String p) {
        // write your code here
    	if(s.length()==0){
    		if(p.equals("*")){
    			return true;
    		}
    		return false;
    	}
    	if(p.length()==0){
    		return false;
    	}
    	boolean[][] dp=new boolean[s.length()+1][p.length()+1];
    	dp[0][0]=true;
    	for(int j=1;j<=p.length();j++){
    		for(int i=1;i<=s.length();i++){
    			if(p.charAt(j-1)=='?' || (p.charAt(j-1)==s.charAt(i-1))){
    				dp[i][j]=dp[i-1][j-1];
    			}
	    		else if(p.charAt(j-1)=='*'){
	    				dp[i][j]=dp[i-1][j-1] || dp[i-1][j];
	    		}
    		}
    	}
    	return dp[s.length()][p.length()];

     }
    public static void main(String[] args) {
    	String s="bbabacccbcbbcaaab";
    	String p="*d*b??b*b";
    	System.out.println(isMatch(s,p));
    }
}
