package solution149;

public class Solution {

    public int maxProfit(int[] prices) {
        if(prices.length<2) return 0;
        int min_price=prices[0];
        int profit=0;
        for(int i=1;i<prices.length;i++){
        	if(prices[i]<min_price){
        		min_price=prices[i];
        	}
        	else if(prices[i]>min_price){
        		profit=prices[i]-prices[i-1];
        	}
        }
        return profit;
    }
}
