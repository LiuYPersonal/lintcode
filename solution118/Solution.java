package solution118;

public class Solution {

    public int numDistinct(String S, String T) {
        // write your code here
    	int n=S.length();
    	int m=T.length();
    	int[][] path=new int[n+1][m+1];
    	for(int i=0;i<n+1;i++){
    		path[i][0]=1;
    	}	
    	for(int i=1;i<n+1;i++){
    		for (int j=1;j<m+1;j++){
    			path[i][j]=path[i-1][j];
    			if(S.charAt(i-1)==T.charAt(j-1)){
    				path[i][j]=path[i-1][j-1];
    			}
    		}
    	}
    	return path[n][m];
    }
}
