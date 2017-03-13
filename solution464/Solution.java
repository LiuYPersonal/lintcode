package solution464;

public class Solution {
	
    public static void sortIntegers2(int[] A) {
        // Write your code here
        qSort(A, 0, A.length-1);
        return;
    }
    public static void qSort(int[] A, int p, int q){
    	if(p>=q){
    		return; 
    	}
    	int left=p,right=q;
    	int pivot=A[(left+right)/2];
    	while(left<=right){
    		while(left<right && A[left]<pivot){
    			left++;
    		}
    		while(left< right && A[right]>pivot){
    			right--;
    		}
    		if(left<=right){
    			int tmp=A[left];
    			A[left]=A[right];
    			A[right]=tmp;
    		}
    	}
    	qSort(A,p,right);
    	qSort(A,left,q);
    }
    public static void main(String[] args) {
		// TODO Auto-generated method stub
    	int[] nums={3, 2, 1, 4, 6, 5, 3, 7};
    	sortIntegers2(nums);
	}
}
