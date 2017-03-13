package solution200;

public class Solution {
	
    public static String longestPalindrome(String s) {
        // Write your code here
    	if(s.equals("")){
    		return s;
    	}
    	String new_s="";
    	for(int i=s.length()-1;i>=0;i--){
    		new_s+=s.charAt(i);
    	}
    	int[][] dp=new int[s.length()+1][s.length()+1];
    	int max=0;
    	int targeti=0;
    	for(int i=1;i<=s.length();i++){
    		for(int j=1;j<=s.length();j++){
    			if(new_s.charAt(j-1)==s.charAt(i-1)){
    				dp[i][j]=dp[i-1][j-1]+1;
    				if(dp[i][j]>max){
    					max=dp[i][j];
    					targeti=i;
    				}
    			}
    		}
    	}
    	String res="";
    	for(int i=targeti-1;i>=targeti-max;i--){
    		res+=s.charAt(i);
    	}
    	return res;
    }
	public static void main(String[] args) {
		String s="abcdzdczb";
    	System.out.println(longestPalindrome(s));
	}
}
