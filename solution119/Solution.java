package solution119;

public class Solution {

    public int minDistance(String word1, String word2) {
        // write your code here
    	int n=word1.length();
    	int m=word2.length();
    	int[][] path=new int[n+1][m+1];
    	for(int i=0;i<n+1;i++){
    		path[i][0]=i;
    	}	
    	for(int j=0;j<m+1;j++){
    		path[0][j]=j;
    	}
    	for(int i=1;i<n+1;i++){
    		for (int j=1;j<m+1;j++){
    			if(word1.charAt(i)==word2.charAt(j)){
    				path[i][j]=path[i-1][j-1];
    			}
    			else{
    				path[i][j]=Math.min(path[i-1][j],Math.min(path[i-1][j-1],path[i][j-1]))+1;
    			}
    		}
    	}
    	return path[n][m];
    }
}
