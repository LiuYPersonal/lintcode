package solution4;

public class Solution {

    public static int nthUglyNumber(int n) {
        // Write your code here
    	int[] uglyNumber=new int[n];
    	uglyNumber[0]=1;
    	int by2=0,by3=0,by5=0;
    	int i=1;
    	int minnumber;
    	while(i<n){
    		minnumber=Math.min(Math.min(uglyNumber[by2]*2, uglyNumber[by3]*3),uglyNumber[by5]*5);
    		uglyNumber[i]=minnumber;
    		if(minnumber==uglyNumber[by2]*2){
    			by2++;
    		}
    		if(minnumber==uglyNumber[by3]*3){
    			by3++;
    		}
    		if(minnumber==uglyNumber[by5]*5){
    			by5++;
    		}
    		i++;
    	}
    	return uglyNumber[n-1];
    }
    public static void main(String[] args) {
    	System.out.println(nthUglyNumber(9));
    }
}
