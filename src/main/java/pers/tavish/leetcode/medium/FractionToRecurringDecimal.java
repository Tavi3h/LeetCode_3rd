package pers.tavish.leetcode.medium;

/*

Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.

If the fractional part is repeating, enclose the repeating part in parentheses.

If multiple answers are possible, return any of them.

It is guaranteed that the length of the answer string is less than 104 for all the given inputs.


Example 1:

Input: numerator = 1, denominator = 2
Output: "0.5"

Example 2:

Input: numerator = 2, denominator = 1
Output: "2"

Example 3:

Input: numerator = 2, denominator = 3
Output: "0.(6)"

Example 4:

Input: numerator = 4, denominator = 333
Output: "0.(012)"

Example 5:

Input: numerator = 1, denominator = 5
Output: "0.2"

Constraints:

- -2^31 <= numerator, denominator <= 2^31 - 1
- denominator != 0

for more information: https://leetcode.com/problems/fraction-to-recurring-decimal/
 */

import java.util.HashMap;
import java.util.Map;

public class FractionToRecurringDecimal {
    public String fractionToDecimal(int numerator, int denominator) {

        if (denominator == 0) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        Map<Long, Integer> map = new HashMap<>();
        if ((numerator > 0 && denominator < 0) || (numerator < 0 && denominator > 0)) {
            sb.append("-");
        }

        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);

        long n = num / den, m = num % den;
        sb.append(n);
        if (m == 0) {
            return sb.toString();
        } else {
            sb.append(".");
        }

        while (!map.containsKey(m)) {
            map.put(m, sb.length());
            n = m * 10 / den;
            m = m * 10 % den;
            if (m != 0 || !map.containsKey(m)) {
                sb.append(n);
            }
        }

        if (m != 0) {
            sb.insert(map.get(m), "(");
            sb.append(")");
        }
        return sb.toString();
    }
}
