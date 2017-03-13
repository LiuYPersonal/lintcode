package solution141;

public class Solution {

    public static int sqrt(int x) {
        // write your code here
    	if(x<=0){
    		return 0;
    	}
    	if(x==1){
    		return 1;
    	}
    	int p=1;
    	int q=x;
    	int a=(int)x/2;
    	while (true){
    		int tmp=x/a;
    		if (tmp<a+1 && tmp>=a){
    			return a;
    		}
    		else if(a==p || a==q){
    			if((x-p*p)>(x-q*q)){
    				return q;
    			}
    			return p;
    		}
    		else if(tmp<a){
    			q=a-1;
    			a=(int)(p+q)/2;
    		}
    		else if(tmp>=a+1){
    			p=a+1;
    			a=(int)(p+q)/2;
    		}
    	}
    }
    public static void main(String[] args) {
		// TODO Auto-generated method stub
    	int nums=999999999;
    	System.out.println(sqrt(nums));
	}
}
