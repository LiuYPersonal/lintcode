package solution57;

import java.util.Arrays;

public class Solution {
	public static int threeSumClosest(int[] numbers, int target) {
		int res=0;
   	    if(numbers.length<3){
   	    	for(int i=0;i<numbers.length;i++){
   	    		res+=numbers[i];
   	    	}
   	    	return res;
   	    }
    	Arrays.sort(numbers);
    	int min_gap=Integer.MAX_VALUE;
    	for(int i=0;i<numbers.length;i++){
    		for(int j=i+1;j<numbers.length-1;j++){
    			int tmp=binarySearch(numbers, j+1, numbers.length, target-numbers[i]-numbers[j]);
    			int gap=Math.abs(tmp+numbers[i]+numbers[j]-target);
    			if(gap<min_gap){
    				min_gap=gap;
    				res=tmp+numbers[i]+numbers[j];
    			}
    		}
    	}
    	return res;
    }
	public static int binarySearch(int[] numbers, int start, int end, int target) {
		// TODO Auto-generated method stub
		if(numbers.length==0){
			return 0;
		}
		if(start==end){
			return numbers[start];
		}
		int p=start,q=end;
		while(p<q){
			int mid=(p+q)/2;
			if(numbers[mid]==target){
				return target;
				
			}
			else if(numbers[mid]>target){
				q=mid;
			}
			else{
				p=mid+1;
			}
		}
		if(q==numbers.length){
			return numbers[q-1];
		}
		else if(p==0){
			return numbers[0];
		}
		else if(p==start){
			return numbers[p];
		}
		else {
			return (Math.abs(target-numbers[p])<Math.abs(target-numbers[p-1])? numbers[p]:numbers[p-1]);
		}
	}
    public static void main(String[] args) {
		// TODO Auto-generated method stub
    	int[] nums={2,7,11,15};
    	System.out.println(threeSumClosest(nums,3));
	}
}
