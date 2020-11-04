package pers.tavish.leetcode.medium;

/*

Given two integers dividend and divisor, divide two integers without using multiplication, division, and mod operator.

Return the quotient after dividing dividend by divisor.

The integer division should truncate toward zero, which means losing its fractional part. For example, truncate(8.345) = 8 and truncate(-2.7335) = -2.

Note:

Assume we are dealing with an environment that could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. For this problem, assume that your function returns 231 − 1 when the division result overflows.

Example 1:

Input: dividend = 10, divisor = 3
Output: 3
Explanation: 10/3 = truncate(3.33333..) = 3.

Example 2:

Input: dividend = 7, divisor = -3
Output: -2
Explanation: 7/-3 = truncate(-2.33333..) = -2.

Example 3:

Input: dividend = 0, divisor = 1
Output: 0

Example 4:

Input: dividend = 1, divisor = 1
Output: 1

Constraints:

-2^31 <= dividend, divisor <= 2^31 - 1
divisor != 0

for more information: https://leetcode.com/problems/divide-two-integers/
 */

public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {

        if (dividend == -2147483648 && divisor == -1) {
            return 2147483647;
        }

        if (dividend == 0) {
            return 0;
        }

        long a = Math.abs((long) dividend), b = Math.abs((long) divisor);

        if (b > a) {
            return 0;
        }

        long sum = 0;
        int result = 0;

        while (a >= b) {
            int tmp = 1;
            sum = b;
            while (sum + sum <= a) {
                sum += sum;
                tmp += tmp;
            }
            a -= sum;
            result += tmp;
        }
        return (dividend ^ divisor) >>> 31 == 1 ? -result : result;
    }
}
