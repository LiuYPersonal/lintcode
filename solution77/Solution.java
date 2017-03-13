package solution77;


public class Solution {

	
    public static int longestCommonSubsequence(String A, String B) {
        // write your code here
    	if(A.length()==0 || B.length()==0){
    		return 0;
    	}
    	int[][] res=new int[A.length()+1][B.length()+1];
    	for(int i=0;i<A.length()+1;i++){
    		res[i][0]=0;
    	}
    	for(int i=0;i<B.length()+1;i++){
    		res[0][i]=0;
    	}
    	for(int i=1;i<A.length()+1;i++){
    		for(int j=1;j<B.length()+1;j++){
    			if(A.charAt(i-1)==B.charAt(j-1)){
    				res[i][j]=res[i-1][j-1]+1;
    			}
    			else{
    				res[i][j]=Math.max(res[i-1][j], res[i][j-1]);
    			}
    		}
    	}
    	return res[A.length()][B.length()];
    }
    public static void main(String[] args) {
		// TODO Auto-generated method stub
    	String A="bedaacbade";
    	String B="dccaeedbeb";
    	System.out.println(longestCommonSubsequence(A,B));
	}
}
