package solution183;

public class Solution {

    public static int woodCut(int[] L, int k) {
        // write your code here
    	if(L==null || L.length==0){
    		return 0;
    	}

    	int max=L[0];
    	int min=0;
    	for(int i=1;i<L.length;i++){
    		if(L[i]>max){
    			max=L[i];
    		}
    	}
    	min=1;
    	if(max==min){
    		return max;
    	}
    	int center=min+(max-min)/2;
    	int count;
    	while(min+1<max){
    		count=0;
    		center=min+(max-min)/2;
    		for(int i=0;i<L.length;i++){
    			count+=(int)L[i]/center;
    		}
    		if(count<k){
    			max=center;
    		}
    		else{
    			min=center;
    		}
    	}
    	int max_count=0;
		for(int i=0;i<L.length;i++){
			max_count+=(int)L[i]/max;
		}
    	if(max_count>=k){
    		return max;
    	}  
    	int min_count=0;
		for(int i=0;i<L.length;i++){
			min_count+=(int)L[i]/min;
		}
    	if(min_count>=k){
    		return min;
    	}
    	return 0;
    	
    }
    
    public static void main(String[] args) {
		// TODO Auto-generated method stub
    	int[] s={2147483644,2147483645,2147483646,2147483647};
    	System.out.println(woodCut(s,4));
	}
    
}
