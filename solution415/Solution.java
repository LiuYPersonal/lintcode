package solution415;

public class Solution {

    public static boolean isPalindrome(String s) {
        // Write your code here
    	char[] string=s.toCharArray();
        if(s.length()==0){
            return true;
        }
        int i=0,j=s.length()-1;
        while(i<j){
            if(string[i]>='A' && string[i]<='Z'){
            	string[i]+=32;
            }
            if(string[j]>='A' && string[j]<='Z'){
            	string[j]+=32;
            }
            if(string[i]>='a' && string[i]<='z' && string[j]>='a' && string[j]<='z'){
            	if(string[j]==string[i]){
	            	i++;
	            	j--;
            	}
            	else{
            		return false;
            	}
            }
            else if(string[i]>='0' && string[i]<='9' && string[j]>='0' && string[j]<='9'){
            	if(string[j]==string[i]){
	            	i++;
	            	j--;
            	}
            	else{
            		return false;
            	}
            }
            else{
            	if(string[i]<'0' || (string[i]>'9' && string[i]<'a') || string[i]>'z'){
            		i++;
            	}
            	if(string[j]<'0' || (string[j]>'9' && string[j]<'a') || string[j]>'z'){
            		j--;
            	}
            }
        }
        return true;
    }
    public static void main(String[] args) {
    	System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }
}
