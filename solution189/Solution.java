package solution189;

public class Solution {
	
    public static int firstMissingPositive(int[] A) {
    	for (int i = 0; i < A.length; i++) {
            while (A[i] > 0 && A[i] <= A.length && A[i] != (i+1)) {
                int tmp = A[A[i]-1];
                if (tmp == A[i]) {
                    break;
                }
                A[A[i]-1] = A[i];
                A[i] = tmp;
            }
        }
    	for(int i=0;i<A.length;i++){
    		if(A[i]!=i+1){
    			return i+1;
    		}
    	}
    	return A.length+1;
    }
    public static void main(String[] args) {
    	int[] A={3,4,-1,1};
    	System.out.println(firstMissingPositive(A));
    }
}
