package pers.tavish.leetcode.easy;

/*

Given a 32-bit signed integer, reverse digits of an integer.

Example 1:

Input: 123
Output: 321

Example 2:

Input: -123
Output: -321

Example 3:

Input: 120
Output: 21

Note:

Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−2^31,  2^31 − 1]. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.

for more information: https://leetcode.com/problems/reverse-integer/description/
 */

import org.junit.Test;

public class ReverseInteger {
//    public int reverse(int x) {
//        try{
//            return x < 0 ? -Integer.parseInt(new StringBuilder(-x + "").reverse().toString()) : Integer.parseInt(new StringBuilder(x + "").reverse().toString());
//        } catch (Exception e) {
//            return 0;
//        }
//    }

    public int reverse(int x) {

        if (x == 0) {
            return 0;
        }

        boolean isPositive = x > 0;
        x = x > 0 ? x : -x;

        StringBuilder builder = new StringBuilder();

        while (x > 0) {
            int m = x % 10;
            x /= 10;
            builder.append(m);
        }

        try {
            int res = Integer.parseInt(builder.toString());
            return isPositive ? res : -res;
        } catch (Exception ex) {
            return 0;
        }
    }

    @Test
    public void testCase() {
        System.out.println(reverse(123));
    }
}
