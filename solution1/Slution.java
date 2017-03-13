package solution1;

public class Slution {

    public int aplusb(int a, int b) {
        // write your code here, try to do it without arithmetic operators.
        while(b!=0){
        	int _a=a^b;
        	int _b=(a&b)<<1;
        	a=_a;
        	b=_b;
        }
        return a;
    }
}
