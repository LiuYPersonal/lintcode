package solution20;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Solution {

    public static List<Map.Entry<Integer, Double>> dicesSum(int n) {
    	List<Map.Entry<Integer, Double>> res=new ArrayList<Map.Entry<Integer,Double>>();
    	double sum=0;
    	double base=1.0/6.0;
    	double[] dp=new double[n*6+1];
    	for(int i=0;i<=6;i++){
    		dp[i]=1.0/6.0;
    	}
    	for(int i=2;i<=n;i++){
    		for(int j=i*6;j>=(i*7+1)/2;j--){
    			sum=0;
    			for(int k=1;k<=6;k++){
    				if(j-k<=(i-1)*6 && j-k>=1){
    					sum+=base*dp[j-k];
    				}
    			}
    			dp[j]=sum;
    		}
    		for(int j=i;j<(i*7+1)/2;j++){
    			dp[j]=dp[i*7-j];
    		}
    	}
    	for(int i=n;i<=n*6;i++){
    		res.add(new AbstractMap.SimpleEntry<Integer, Double>(i, dp[i]));
    	}
    	return res;
    }
    public static void main(String[] args) {
    	System.out.println(dicesSum(3));
    }
}
