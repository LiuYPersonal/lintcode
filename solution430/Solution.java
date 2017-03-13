package solution430;

public class Solution {
	
    public static boolean isScramble(String s1, String s2) {
        // Write your code here
        if(s1.length()!=s2.length()){
        	return false;
        }
        if(s1.length()==1){
	        if(s1.equals(s2)){
	        	return true;
	        }
	        return false;
        }
        boolean[][][] dp=new boolean[s1.length()+1][s1.length()+1][s1.length()+1];
        for(int k=1;k<=s1.length();k++){
            for(int i=1;i<=s1.length()-k+1;i++){
        		for(int j=1;j<=s2.length()-k+1;j++){
        			String tmp1=s1.substring(i-1,i+k-1);
        			String tmp2=s2.substring(j-1,j+k-1);
        			if(tmp1.equals(tmp2)){
        				dp[i][j][k]=true;
        				break;
        			}
        			else{
        				for(int w=1;w<k;w++){
        					if(dp[i][j][w] && dp[i+w][j+w][k-w]){
        						dp[i][j][k]=true;
        						break;
        					}
        					if(dp[i][j+k-w][w] && dp[i+w][j][k-w]){
        						dp[i][j][k]=true;
        						break;
        					}
        				}        				
        			}
        		}
        	}
        }
        return dp[1][1][s1.length()];
        
    }
    public static void main(String[] args) {
		// TODO Auto-generated method stub
    	String s1="taerg";
    	String s2="great";
    	System.out.println(isScramble(s1,s2));
	}
}
