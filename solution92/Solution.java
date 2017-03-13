package solution92;

public class Solution {

    public static int backPack(int m, int[] A) {
        // write your code here
    	
    	if(m<-0 || A==null || A.length==0 ){
    		return 0;
    	}
    	boolean[] fill=new boolean[m];
    	
    	for(int i=0;i<A.length;i++){
    		for(int j=m-1;j>=A[i]-1;j--){
    			if(j==A[i]-1 || fill[j-A[i]]==true){
    				fill[j]=true;
    			}
    		}
    	}
    	for(int i=m-1;i>=0;i--){
    		if(fill[i]){
    			return i+1;
    		}
    	}
    	return 0;
    }
    public static void main(String[] args) {
    	int m=12;
    	int[] A={2,3,5,7};
    	System.out.println(backPack(m,A));
    }
}
