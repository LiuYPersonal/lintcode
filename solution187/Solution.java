package solution187;

public class Solution {
	
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        // write your code here
    	if(gas==null || cost==null){
    		return -1;
    	}
    	if(gas.length!=cost.length){
    		return -1;
    	}
    	int sum_gas=0;
    	int sum_cost=0;
    	for (int i=0;i<gas.length;i++){
    		sum_gas+=gas[i];
    		sum_cost+=cost[i];
    	}
    	if(sum_gas<sum_cost){
    		return -1;
    	}
    	int diff=0;
    	int station_index=0;
    	for (int i=0;i<gas.length;i++){
    		if(gas[i]+diff<cost[i]){
    			station_index=i+1;
    			diff=0;
    		}
    		else{
    			diff+=gas[i]-cost[i];
    		}
    	}
    	return station_index;
    	
    }
    public static void main(String[] args) {
		// TODO Auto-generated method stub
    	int[] gas={5};
    	int[] cost={4};
    	
    	System.out.println(canCompleteCircuit(gas,cost));
    }
}
