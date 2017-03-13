package solution128;

public class Solution {

    public static int hashCode(char[] key,int HASH_SIZE) {
        // write your code here
    	long sum=0;
    	long base=1;
    	int ch;
    	for(int i=key.length-1;i>=0;i--){
    		ch = (int) key[i];
    		sum+=(ch*base)%HASH_SIZE;
    		base=(base*33)%HASH_SIZE;
    	}
    	return (int)sum%HASH_SIZE;
    }
    public static void main(String[] args) {
		// TODO Auto-generated method stub
    	char[] nums={'a','b','c','d'};
    	System.out.println(hashCode(nums,100));
	}
}
