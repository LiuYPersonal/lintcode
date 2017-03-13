package solution47;

import java.util.ArrayList;

public class Solution {

    public int majorityNumber(ArrayList<Integer> nums) {
        // write your code
        int m1 = 0, m2 = 0;
        int c1 = 0, c2 = 0;
        for (int n : nums) {
        	if (n == m1) {
        		c1++;
        	} else if (n == m2) {
        		c2++;
        	} else if (c1 == 0) {
        		m1 = n;
        		c1 = 1;
        	} else if (c2 == 0) {
        		m2 = n;
        		c2 = 1;
        	} else {
        		c1--;
        		c2--;
        	}
        }
        c1 = c2 = 0;
        for (int n : nums) {
        	if (m1 == n) {
        		c1++;
        	} else if (m2 == n) {
        		c2++;
        	}
        }
        return c1 > c2 ? m1 : m2;
    }
}
