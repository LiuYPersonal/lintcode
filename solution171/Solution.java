package solution171;

import java.util.ArrayList;

public class Solution {
	
	public ArrayList<Integer> grayCode(int n) {
        // Write your code here
        ArrayList<Integer> res= new ArrayList<Integer>();
        if(n<=0){
            return res;
        }
        res.add(0);
        res.add(1);
        int j=1,tmp;
        for(int k=2;k<=n;k++){
            j=j<<1;
            for(int w=0;w<res.size();w++){
            	tmp=res.get(w);
            	tmp=tmp+j;
            	for(int y=0;y<res.size();y++){
            		if((tmp^res.get(y))==1){
            			res.add(y+1,tmp);
            		}
            	}
            	
            }
        }
        return res;
    }
}
