package solution109;

public class Solution {
	
    public static int minimumTotal(int[][] triangle) {
        // write your code here
    	if(triangle==null ||triangle.length==0 || triangle[0].length==0){
    		return 0;
    	}
    	if(triangle.length==1){
    		return triangle[0][0];
    	}
    	int len=triangle.length;
    	int[] pre=new int[len];
    	pre[0]=triangle[0][0];
    	int old=0;
    	for (int i=1;i<len;i++){
    		for(int j=0;j<=i;j++){	
    			if(j==0){
    				old=pre[j];
    				pre[j]=triangle[i][j]+pre[j];
    			}
    			else if(j==i){
    				pre[j]=old+triangle[i][j];
    			}
    			else{
    				int old2=pre[j];
    				pre[j]=Math.min(old,pre[j])+triangle[i][j];
    				old=old2;
    				
    			}
    		}
    	}
    	int min_val=pre[0];
    	for(int i=0;i<len;i++){
    		if(pre[i]<min_val){
    			min_val=pre[i];
    		}
    	}
    	return min_val;
    }
    public static void main(String[] args) {
    	int[][] nums={{-10}};
    	System.out.println(minimumTotal(nums));
    }
}
