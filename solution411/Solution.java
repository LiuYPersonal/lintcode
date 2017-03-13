package solution411;

import java.util.ArrayList;

public class Solution {
	public static ArrayList<Integer> grayCode(int n) {
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
            ArrayList<Integer> tmp_res=new ArrayList<Integer>(res);
            for(int w=0;w<tmp_res.size();w++){
            	tmp=tmp_res.get(w);
            	tmp=tmp+j;
            	for(int y=0;y<res.size();y++){
            	    int tmp2=tmp^res.get(y);
            	    int tmp3=1;
            	    boolean flag=false;
            	    while(tmp3<=j){
            	        if(tmp3==tmp2){
            	           res.add(y+1,tmp);
            	           flag=true;
            			   break;
            	        }
            	        tmp3=tmp3<<1;
            	    }
            	    if(flag){
            	    	break;
            	    }

            	}
            	
            }
        }
        return res;
    }
    public static void main(String[] args) {
    	System.out.println(grayCode(3));
    }
}
