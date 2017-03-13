package solution143;

public class Solution {
	
    public static void sortColors2(int[] colors, int k) {
        // write your code here
    	if(k<=0 || colors.length==0)
    	{
    		return;
    	}
		int i=0,j=0,tmp;
    	for(int w=1;w<=k;w++){
    		while(j<colors.length){
    			if(colors[j]==w){
    				tmp=colors[i];
    				colors[i]=colors[j];
    				colors[j]=tmp;
    				i++;
    			}
    			j++;
    		}
    		j=i;
    	}
    	return;
    }
    public static void main(String[] args) {
    	int[] colors={3,2,2,1,4};
    	sortColors2(colors,4);
    }
}
