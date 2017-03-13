package solution82;

public class Solution {

	
    public static int singleNumber(int[] A) {
        // Write your code here
        if(A==null || A.length==0){
            return 0;
        }
        int res=0;
        for(int i=0;i<A.length;i++){
            res=res^A[i];
        }
        
        return res;
    }
    public static void main(String[] args) {
		// TODO Auto-generated method stub
    	int[] matrix={1,2,2,3,4,4,5,3};
    	System.out.println(singleNumber(matrix));
	}
}
