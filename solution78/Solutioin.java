package solution78;

public class Solutioin {

    public static String longestCommonPrefix(String[] strs) {
        // write your code here
    	if(strs==null){
    		return null;
    	}
    	if(strs.length==0){
    		return "";
    	}
    	int prefix_count=strs[0].length();
    	char[] s=strs[0].toCharArray();
    	for(int i=1;i<strs.length;i++){
    		char[] str=strs[i].toCharArray();
    		int count=0;
    		while (count<str.length && count<prefix_count){
    			if(str[count]!=s[count]){
    				break;
    			}
    			else{
    				count++;
    			}
    		}
    		prefix_count=count;
    	}
    	return strs[0].substring(0, prefix_count);
    }
    public static void main(String[] args) {
		// TODO Auto-generated method stub
    	String[] s={"ABCDEFG","ABCEFG","ABCEFA"};
    	System.out.println(longestCommonPrefix(s));
	}
}
