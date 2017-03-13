package solution151;

public class Solution {
	
    public static int maxProfit(int[] prices) {
    	
  	  if (prices.length<2){
  		  return 0;
  	  }
  	  if(prices.length==2) {
  		  return Math.max(0, prices[1]-prices[0]);
  	  }
  	  int min_price=prices[0];
  	  int[] profit_left=new int[prices.length];
  	  for(int i=1;i<prices.length;i++){
  		  if(prices[i]>min_price){
  			  profit_left[i]=Math.max(profit_left[i-1],prices[i]-min_price);
  		  }
  		  else{
  			  min_price=prices[i];
  			  profit_left[i]=profit_left[i-1];
  		  }
  	  }
  	  int max_price=prices[prices.length-1];
  	  int[] profit_right=new int[prices.length];  	  
  	  for(int i=prices.length-2;i>0;i--){
  		  if(prices[i]<max_price){
  			  profit_right[i]=Math.max(profit_right[i+1],max_price-prices[i]);
  		  }
  		  else{
  			  max_price=prices[i];
  			  profit_right[i]=profit_right[i+1];
  		  }
  	  }
  	  int max_profit=0;
  	  for(int i=1;i<prices.length-1;i++){
  		  max_profit=Math.max(max_profit, profit_left[i]+profit_right[i]);
  	  }
  	  return max_profit;
  }
    public static void main(String[] args) {
		// TODO Auto-generated method stub
    	int[] nums={2,1,2,0,1};
    	System.out.println(maxProfit(nums));
	}
}
