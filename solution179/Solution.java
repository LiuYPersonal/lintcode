package solution179;

public class Solution {

    public int updateBits(int n, int m, int i, int j) {
        // write your code here
        int ones = ~0;
        int left = ones << (j + 1);
        int right = ((1 << i) - 1);
        int mask = left | right;

        return (n & mask) | (m << i);
    }
    
}
