package solution197;

public class Solution {
	
    public static long permutationIndex(int[] A) {
        // Write your code here
    	if(A.length==0){
    		return (long) 0;
    	}
    	long res=0;
    	long factor=1;
    	for(int i=1;i<A.length;i++){
    		factor=factor*i;
    	}
    	int count;
    	for(int i=0;i<A.length-1;i++){
    		count=0;
    		for(int j=i+1;j<A.length;j++){
    			if(A[j]<A[i]){
    				count++;
    			}
    		}
			res+=count*factor;
			factor=factor/(A.length-1-i);
    	}
    	return res+1;
    }
    public static void main(String[] args) {
    	int[] nums={4,1,3,2};
    	System.out.println(permutationIndex(nums));
    }
}
