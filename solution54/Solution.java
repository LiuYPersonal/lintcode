package solution54;

public class Solution {

    public static int atoi(String str) {
    	if(str==null || str.length()==0){
    		return 0;
    	}
    	boolean isNegative=false;
    	long res=0;
        //remove white spaces
    	int i=0;
    	while(str.charAt(i)==' '){
    		i++;
    	}
    	//negative or positive
    	if(str.charAt(i)=='-'){
    		isNegative=true;
    		i++;
    	}
    	else if(str.charAt(i)=='+'){
    		i++;
    	}
    	for(int j=i;j<str.length();j++){
    		if(str.charAt(j)>='0' && str.charAt(j)<='9'){
    			res=res*10+str.charAt(j)-'0';
    		}
    		else{
    			break;
    		}
    	}
    	if(res>Integer.MAX_VALUE){
    		return 0;
    	}
    	if(isNegative){
    		res=0-res;
    	}
    	return (int)res;
    }
    
    public static void main(String[] args) {
		// TODO Auto-generated method stub
    	String s="10ea";
    	System.out.println(atoi(s));
	}
}
