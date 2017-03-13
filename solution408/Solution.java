package solution408;

public class Solution {
    public static String addBinary(String a, String b) {
        // Write your code here
     	if(a.equals("")){
     		return b;
     	}
     	if(b.equals("")){
     		return a;
     	}

     	while(true){
     		String carry="";
     		String rest="";
         	int len1=a.length()-1;
         	int len2=b.length()-1;
         	boolean flag=true;
         	while(len1>=0 && len2>=0){
         		if(a.charAt(len1)=='1' && b.charAt(len2)=='1'){
         			carry="1"+carry;
         			rest="0"+rest;
         			flag=false;
         		}
         		else{
         			if(a.charAt(len1)!=b.charAt(len2)){
         			rest='1'+rest;
         			}
         			else{
         				rest='0'+rest;
         			}
         			carry='0'+carry;
         		}
         		len1--;
         		len2--;
         	}
         	while(len1>=0){
         		rest=a.charAt(len1)+rest;
         		len1--;
         	}
         	while(len2>=0){
         		rest=b.charAt(len2)+rest;
         		len2--;
         	}
         	if(flag){
         		int k=0;
             	for(k=0;k<rest.length();k++){
             		if(rest.charAt(k)=='1'){
             			break;
             		}
             	}
         		return rest.substring(k);
         	}
         	carry+='0';
         	a=carry;
         	b=rest;
     	}

    }
    public static void main(String[] args) {
		// TODO Auto-generated method stub
    	String a="100110";
    	String b="111111";
    	System.out.println(addBinary(a, b));
	}
}
