package solution125;

public class Solution {
	
	
    public static int backPackII(int m, int[] A, int V[]) {
        // write your code here
        if(m<=0 || A.length==0 || V.length==0){
            return 0;
        }
        int max_value=0;
        boolean[] item=new boolean[m+1];
        item[0]=true;
        int[] value=new int[m+1];
        for(int i=0;i<A.length;i++){
            for(int j=m-A[i];j>=0;j--){
                if(item[j]){
                    item[A[i]+j]=true;
                    value[A[i]+j]=Math.max(value[A[i]+j], V[i]+value[j]);
                    if(value[A[i]+j]>max_value){
                    	max_value=value[A[i]+j];
                    }
                }
            }
        }
        return max_value;
    }
    public static void main(String[] args) {
    	int[] A={77,22,29,50,99};
    	int[] V={92,22,87,46,90};
    	System.out.println(backPackII(100,A,V));
    }
}
