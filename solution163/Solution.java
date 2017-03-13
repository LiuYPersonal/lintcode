package solution163;

public class Solution {

    public int numTrees(int n) {
        // write your code here
    	if (n<0){
    		return 0;
    	}
    	int[] bts=new int[n+1];
    	bts[0]=1;
    	for(int i=1;i<=n;i++){
    		for(int j=0;j<i;j++){
    			bts[i]+=bts[i-1-j]*bts[j];
    		}
    	}
    	return bts[n];
    }
    
    
}
