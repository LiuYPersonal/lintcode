package solution365;

public class Solution {
	
    public static int countOnes(int num) {
        // write your code here
        int count=0;
        boolean flag=false;
        if(num<0){
            num=~num;
            flag=true;
        }
        while(num!=0){
            count+=num%2;
            num=num/2;
        }
        return flag?(32-count):count;
    }
    public static void main(String[] args) {
    	System.out.println(countOnes(-1));
    }
}
