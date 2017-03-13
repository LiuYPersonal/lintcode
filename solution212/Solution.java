package solution212;

public class Solution {

    public static int replaceBlank(char[] string, int length) {
        // Write your code here
    	
    	int count=0;
    	for(int i=0;i<length;i++){
    		if(string[i]==' '){
    			count++;
    		}
    	}
    	int newlen=length+count*2;
    	string[newlen] = 0;
    	
    	int j=1;
    	for(int i=length-1;i>=0;i--){
    		if(string[i]!=' '){
    			string[newlen-j]=string[i];
    			j++;
    		}
    		else{
    			string[newlen-j]='0';
    			j++;
    			string[newlen-j]='2';
    			j++;
    			string[newlen-j]='%';
    			j++;
    		}
    	}
    	return string.length;
    }
    
    public static void main(String[] args) {
    	char[] string="Hello world".toCharArray();
    	System.out.println(replaceBlank(string,11));
    }
}
