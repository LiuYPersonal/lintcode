package solution49;

public class Solution {
	
    public void sortLetters(char[] chars) {
        //write your code here
    	if(chars.length<=1){
    		return;
    	}
    	int i=0,j=chars.length-1;
    	while(i<j){
    		while(chars[i]>='a' && chars[i]<='z'){
    			i++;
    		}
    		while(chars[j]>='A' && chars[j]<='Z'){
    			j--;
    		}
    		if(i<j){
    			char tmp=chars[i];
    			chars[i]=chars[j];
    			chars[j]=tmp;
    			i++;
    			j--;
    		}
    	}
    	return;
    }
}
