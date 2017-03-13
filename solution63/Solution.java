package solution63;

public class Solution {
	
	public static boolean search(int[] A, int target) {
        // with duplicates
    	if(A==null || A.length==0){
    	    return false;
    	}
    	int p=0,q=A.length;
    	int mid;
    	while(p<q){
    		mid=(p+q)/2;
    		if(A[mid]==target){
    			return true;
    		}
    		if(A[mid]<A[p]){ //left is rotated
    			if(target<A[mid] || target>=A[p]){
    				q=mid;
    			}
    			else{
    				p=mid+1;
    			}
    		}
    		else if(A[mid]>A[p]){ //right is rotated
    			if(target<A[mid] && target>=A[p]){
    				q=mid;
    			}
    			else{
    				p=mid+1;
    			}    			
    			
    		}
    		else{
    			p++;
    		}
    	}
    	return false;
    }
    public static void main(String[] args) {
		// TODO Auto-generated method stub
    	int[] nums={9,5,6,7,8,9,9,9,9,9,9};
    	System.out.println(search(nums,8));
	}
}
