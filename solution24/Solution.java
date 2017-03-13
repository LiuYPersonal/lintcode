package solution24;

public class Solution {
	
    public int romanToInt(String s) {
        // Write your code here
        int res=0;
        if(s.equals("")){
        	return res;
        }
        int i=0;
        while(i<s.length()-1){
            if(s.charAt(i)=='I'){
                if(s.charAt(i+1)=='V'){
                	res+=4;
                	i+=2;
                }
                else if( s.charAt(i+1)=='X'){
                	res+=9;
                	i+=2;
                }
                else{
                	res++;
                	i++;
                }
            }
            else if(s.charAt(i)=='X'){
            	if(s.charAt(i+1)=='L'){
            		res+=40;
            		i+=2;
            	}
            	else if(s.charAt(i+1)=='C'){
            		res+=90;
            		i+=2;
            	}
            	else{
            		res+=10;
            		i++;
            	}
            }
            else if(s.charAt(i)=='V'){
            	res+=5;
            	i++;
            }
            else if(s.charAt(i)=='C'){
            	if(s.charAt(i+1)=='D'){
            		res+=400;
            		i+=2;
            	}
            	else if(s.charAt(i+1)=='M'){
            		res+=900;
            		i+=2;
            	}
            	else {
            		res+=100;
            		i++;
            	}
            }
            else if(s.charAt(i)=='M'){
            	res+=1000;
            	i++;
            }
        }
        if(i==s.length()){
        	return res;
        }
        else{
        	if(s.charAt(i)=='I'){
        		res+=1;
        	}
            else if(s.charAt(i)=='V'){
            	res+=5;
            }
            else if(s.charAt(i)=='X'){
            	res+=10;
            }
            else if(s.charAt(i)=='C'){
        		res+=100;
            }
            else if(s.charAt(i)=='M'){
            	res+=1000;
            }
        	
        }
        return res;
    }
}
