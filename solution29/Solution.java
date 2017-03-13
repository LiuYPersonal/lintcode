package solution29;

public class Solution {
	
	
    public static boolean isInterleave(String s1, String s2, String s3) {
        // write your code here
    	if(s1.length()+s2.length()!= s3.length()){
    		return false;
    	} 
        boolean[][] res = new boolean[s1.length()+1][s2.length()+1];  
        for(int i=1;i<s1.length()+1;i++)  
        {  
           res[i][0]=(s1.charAt(i-1)==s3.charAt(i-1));  
        }
        for(int i=1;i<s2.length()+1;i++)  
        {  
           res[0][i]=(s2.charAt(i-1)==s3.charAt(i-1));  
        } 
        for(int i=1;i<s1.length()+1;i++)  
        {  
            for(int j=1;j<s2.length()+1;j++)  
            {  
                res[i][j]=(res[i-1][j] && s1.charAt(i-1)==s3.charAt(i+j-1))||(res[i][j-1] && s2.charAt(j-1)==s3.charAt(i+j-1));  
            }  
        }  
        return res[s1.length()][s2.length()];  
    }
    
    public static void main(String[] args) {
    	String s1="aabcc";
    	String s2="dbbca";
    	String s3="aadbbcbcac";
    	System.out.println(isInterleave(s1,s2,s3));
    }
}
