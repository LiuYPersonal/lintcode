package solution13;

public class Solution {

    public static int strStr(String source, String target) {
        //write your code here
    	if (source==null || target==null){
    		return -1;
    	}
    	if (source.length()<target.length()){
    		return -1;
    	}
    	if (source.length()==0 || target.length()==0){
    		return 0;
    	}
    	char[] a=source.toCharArray();
    	char[] b=target.toCharArray();
    	for(int i=0;i<(a.length-b.length+1);i++){
            if (a[i]==b[0]){
            	int m=i;
            	int j=0;
            	while(a[m]==b[j]){
            		m++;
            		j++;
                	if (j==b.length){
                		return i;
                	}
            	}
            }  		
    	}
        return -1;
    }
    
    public static void main(String[] args) {
		// TODO Auto-generated method stub
    	String s="source";
    	String t="target";
    	System.out.println(strStr(s,t));
	}
    
}
