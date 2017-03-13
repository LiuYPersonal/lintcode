package solution388;

public class Solution {
	
    public static String getPermutation(int n, int k) {
        int[] factor =new int[n];
        String res="";
        boolean[] used=new boolean[n];
        k=k-1;
        factor[0]=1;
        for(int i=1;i<n;i++){
        	factor[i]=factor[i-1]*(i);
        }
        int count=0;        
        for(int i=n-1;i>=0;i--){	
        	count=k/factor[i];
        	k=k%factor[i];
        	int tmp_count=0;
        	int j=0;
        	while(j<n){
        		if(tmp_count==count && !used[j]){
        			res=res+Integer.toString(j+1);
        			used[j]=true;
        			break;
        		}
        		if(!used[j]){
        			tmp_count++;
        		}
        		j++;

        	}
        	
        }
        return res;
    }
    public static void main(String[] args) {
		// TODO Auto-generated method stub
    	System.out.println(getPermutation(3,4));
	}
}
