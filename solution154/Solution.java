package solution154;

public class Solution {

	public static boolean isMatch(String s, String p) {
        // write your code here
    	if(p.length()==0 || p.charAt(0)=='*'){
    		return false;
    	}

    	int i=0;
    	while(p.charAt(i)=='*'){
    		i++;
    		if(i==p.length()){
    			return false;
    		}
    	}
    	p=p.substring(i);
    	boolean[][] dp=new boolean[s.length()+1][p.length()+1];
    	dp[0][0]=true;
    	for(int j=1;j<=p.length();j++){
    		if(p.charAt(j-1)=='*'){
    			dp[0][j]=dp[0][j-2] || dp[0][j-1];
    			for(i=1;i<=s.length();i++){
    				dp[i][j] = dp[i][j-1] || dp[i][j-2] || dp[i-1][j];
    			}
    		}
    		else{
    			for(i=1;i<=s.length();i++){
    				if(p.charAt(j-1)=='.' || p.charAt(j-1)==s.charAt(i-1)){
    					dp[i][j]=dp[i-1][j-1];
    				}
    			}
    		}
    	}
    	return dp[s.length()][p.length()];
    }
    public static void main(String[] args) {
    	String s="aasdfasdfasdfasdfas";
    	String p="aasdf.*asdf.*asdf.*asdf.*s";
    	System.out.println(isMatch(s,p));
    }
}
