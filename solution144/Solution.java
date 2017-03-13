package solution144;

public class Solution {
	
    public static void rerange(int[] A) {
        // write your code here
    	int p=0;
    	int n=0;
    	int tmp;
        for(int i=0;i<A.length;i++){
        	if(i%2==1){
        		p=i;
            	while(A[p]<0 && p<A.length){
            		p++;
            	}        		
        		tmp=A[i];
        		A[i]=A[p];
        		A[p]=tmp;

        	}
        	else if(i%2==0){
        		n=i;
            	while(A[n]>=0 && n<A.length){
            		n++;
            	}
        		tmp=A[i];
        		A[i]=A[n];
        		A[n]=tmp;

        	}
        }
        return;
   }
    public static void main(String[] args) {
		// TODO Auto-generated method stub
    	int[] nums={-33,-19,30,26,21,-9};
    	rerange(nums);
	}
}
