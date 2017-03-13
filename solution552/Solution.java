package solution552;
import java.util.Stack;

public class Solution {
	
    public static int[] maxNumber(int[] nums1, int[] nums2, int k) {
        // Write your code here
    	int m=nums1.length;
    	int n=nums2.length;
    	if(k==0 || m+n<k){
    		return new int[0];
    	}
    	else if(m+n==k){
    		return merge(nums1,nums2);
    	}
    	int[] res=new int[k];
    	int[] tmp_res;
    	for(int i=0;i<=k;i++){
    		if(nums1.length>=i && nums2.length>=k-i){
	    		int[] tmp1=findCombinations(nums1,i);
	    		int[] tmp2=findCombinations(nums2,k-i);
	    		tmp_res=merge(tmp1,tmp2);
				if(isBigger(tmp_res,res)){
					res=tmp_res;
				}
    		}
    	}
    	return res;
    }
    public static int[] findCombinations(int[] nums, int k) {
		// TODO Auto-generated method stub
    	if(k==0 || nums.length==0){
    		return null;
    	}
    	int[] res=new int[k];
		Stack<Integer> stack=new Stack<Integer>();
		stack.push(nums[0]);
    	for(int i=1;i<nums.length;i++){
    		while(!stack.isEmpty()){
    			if(stack.peek()<nums[i] && nums.length-i-1+stack.size()>=k){
    				stack.pop();
    			}
    			else{
    				break;
    			}
    		}
    		if(stack.size()<k){
    			stack.push(nums[i]);
    		}
    	}
    	k--;
		while(!stack.isEmpty()){
			res[k]=stack.pop();
			k--;
		}
		return res;
	}
    
	public static int[] merge(int[] num1,int[] num2){
		if(num1==null || num1.length==0){
			return num2;
		}
		if(num2==null || num2.length==0){
			return num1;
		}
    	int[] res=new int[num1.length+num2.length];
    	int i=0,j=0,count=0;
    	while(i<num1.length && j<num2.length){
    		if(num1[i]>num2[j]){
    			res[count]=num1[i];
    			i++;
    		}
    		else if(num1[i]<num2[j]){
    			res[count]=num2[j];
    			j++;
    		}
    		else{
    			if(i==num1.length-1){
    				res[count]=num2[j];
    				j++;
    			}
    			else if(j==num2.length-1){
    				res[count]=num1[i];
    				i++;
    			}
    			else {
    				int w=i+1;
    				int u=j+1;
    				while(num1[w]==num2[u]){
    					w++;
    					u++;
    					if(w==num1.length || u==num2.length){
    						break;
    					}
    				}
    				if(num1[w]<num2[u]){
    					res[count]=num2[j];
    					j++;
    				}
    				else{
    					res[count]=num1[i];
    					i++;
    				}
    			}
    		}
    		count++;
    	}
    	while(i<num1.length){
			res[count]=num1[i];
			count++;
			i++;
    	}
    	while(j<num2.length){
			res[count]=num2[j];
			count++;
			j++;
    	}  
    	return res;
    }
    
    public static boolean isBigger(int[] num1, int[] num2){
    	for(int i=0;i<num1.length;i++){
    		if(num1[i]>num2[i]){
    			return true;
    		}
    		else if(num1[i]<num2[i]){
    			return false;
    		}
    	}
    	return false;
    }
    public static void main(String[] args) {
		// TODO Auto-generated method stub
    	int[] nums1={1,2,3,4};
    	int[] nums2={};
    	System.out.println(maxNumber(nums1,nums2,2));
	}
}
