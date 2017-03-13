package solution79;

public class Solution {

	
    public static int longestCommonSubstring(String A, String B) {
    	int max=0;
        // write your code here
    	if(A==null || B==null){
    		return 0;
    	}
    	if(A.length()==0 || B.length()==0){
    		return 0;
    	}
    	int[][] result=new int[A.length()+1][B.length()+1];
    	for (int i=0;i<A.length();i++){
    		result[i][0]=0;
    	}
    	for (int j=0;j<B.length();j++){
    		result[0][j]=0;
    	}
    	char[] a=A.toCharArray();
    	char[] b=B.toCharArray();
    	for(int i=0;i<A.length();i++){
    		for(int j=0;j<B.length();j++){
    			if(a[i]==b[j]){
    				result[i+1][j+1]=result[i][j]+1;
    				if(result[i+1][j+1]>max){
    					max=result[i+1][j+1];
    				}
    			}
    			else{
    				result[i+1][j+1]=0;
    			}
    		}
    	}
    	return max;
    }
    
    public static void main(String[] args) {
		// TODO Auto-generated method stub
    	String s="ABCD";
    	String t="CBCE";
    	System.out.println(longestCommonSubstring(s,t));
	}
}
