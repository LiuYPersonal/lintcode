package solution108;

public class Solution {
    public static int minCut(String s) {
        // write your code here
    	if(s.length()==0){
    		return 0;
    	}
    	//check all the substrings to see if they are palindromes
    	boolean[][] dp=new boolean[s.length()][s.length()];
    	for(int i=0;i<s.length();i++){
    		for(int j=i;j<s.length();j++){
    			dp[i][j]=isPalindrome(s,i,j);
    		}
    	}
    	int[] count=new int[s.length()+1];
    	count[0]=0;
    	int min;
    	for(int i=1;i<=s.length();i++){
    		min=Integer.MAX_VALUE;
    		for(int j=0;j<i;j++){
    			if(dp[j][i-1]){
    				min=Math.min(min,count[j]+1);
    			}
    		}
    		count[i]=min;
    	}
    	return count[s.length()]-1;
    }
    public static boolean isPalindrome(String s, int p, int q){
    	while(p<q){
    		if(s.charAt(p)!=s.charAt(q)){
    			return false;
    		}
    		p++;
    		q--;
    	}
    	return true;
    }
    public static void main(String[] args) {
    	String s="aabcdcbef";
    	System.out.println(minCut(s));
    }
}
