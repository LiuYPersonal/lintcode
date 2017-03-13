package solution6;

public class Solution {
	public int[] mergeSortedArray(int[] A, int[] B) {
		int m=A.length;
		int n=B.length;
        int[] result=new int[m+n];
        int index=m+n-1;
		int i=m-1,j=n-1;
		while(i>=0 && j>=0){
			if(A[i]>B[j]){
				A[index]=A[i];
				i--;
			}
			else{
				A[index]=B[j];
				j--;
			}
			index--;
		}
		while(i>=0){
			A[index]=A[i];
			index--;
			i--;
		}
		while(j>=0){
			A[index]=B[j];
			index--;
			j--;
		}
        return result;
    }
}
