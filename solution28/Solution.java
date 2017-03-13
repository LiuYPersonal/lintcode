package solution28;

public class Solution {

    public static boolean searchMatrix(int[][] matrix, int target) {
        // write your code here
    	int row=matrix.length;
    	if(row==0){
    		return false;
    	}
    	int col=matrix[0].length;
    	if(col==0){
    		return false;
    	}
        int l=0,r=row;
        int mid;
    	while (l<r){
    		mid=(l+r)/2;
    		if(matrix[mid][0]<=target &&matrix[mid][col-1]>=target){
    			return binarySearch(matrix[mid], target);
    		}
    		else if(matrix[mid][0]>target){
    			r=mid;
    		}
    		else{
    			l=mid+1;
    		}
    	}
    	return false;
    }
    public static boolean binarySearch(int[] nums, int target){
    	int p=0,q=nums.length;
    	int mid;
    	while(p<q){
    		mid=(p+q)/2;
    		if(nums[mid]==target){
    			return true;
    		}
    		else if(nums[mid]<target){
    			p=mid+1;
    		}
    		else{
    			q=mid;
    		}
    	}
    	return false;
    }
    public static void main(String[] args) {
		// TODO Auto-generated method stub
    	int[][] nums={{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
    	System.out.println(searchMatrix(nums,7));
	}
}
