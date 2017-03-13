package solution83;

public class Solution {
	
	
    public static int singleNumberII(int[] A) {
        // write your code here
    	if(A==null || A.length==0){
    		return 0;
    	}
        int ones = 0, twos = 0, xthrees = 0;
        for(int i = 0; i < A.length; ++i) {
            twos |= (ones & A[i]);
            ones ^= A[i];
            xthrees = ~(ones & twos);
            ones &= xthrees;
            twos &= xthrees;
        }
    	
    	return ones;
    }
    
    public static void main(String[] args) {
		// TODO Auto-generated method stub
    	int[] matrix={1,1,2,3,3,3,2,2,4,1};
    	System.out.println(singleNumberII(matrix));
	}
}

