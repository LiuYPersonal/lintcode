package solution160;

public class Solution {

    public static int findMin(int[] num) {
        // write your code here
    	if(num==null || num.length==0){
    		return 0;
    	}
    	if(num[0]<num[num.length-1]){
    		return num[0];
    	}
    	int p=0;
    	int q=num.length-1;
    	int center;
    	while(p+1<q){
    		center=p+(q-p)/2;
    		if(num[center]>num[p]){
    			p=center;
    		}
    		else if(num[center]==num[p]){
    			p=p+1;
    		}
    		else if(num[center]<num[q]){
    			q=center;
    		}
    		else if(num[center]==num[q]){
    			q=q-1;
    		}
    	}
    	return num[q];
    }
    public static void main(String[] args) {
		// TODO Auto-generated method stub
    	int[] s={1,2,2,2,2};
    	System.out.println(findMin(s));
	}
}
