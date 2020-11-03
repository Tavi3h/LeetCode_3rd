package pers.tavish.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**

Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
For example, 2 is written as II in Roman numeral, just two one's added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

I can be placed before V (5) and X (10) to make 4 and 9.
X can be placed before L (50) and C (100) to make 40 and 90.
C can be placed before D (500) and M (1000) to make 400 and 900.
Given a roman numeral, convert it to an integer.



Example 1:

Input: s = "III"
Output: 3

 Example 2:

Input: s = "IV"
Output: 4

 Example 3:

Input: s = "IX"
Output: 9

 Example 4:

Input: s = "LVIII"
Output: 58
Explanation: L = 50, V= 5, III = 3.

Example 5:

Input: s = "MCMXCIV"
Output: 1994
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.


Constraints:

- 1 <= s.length <= 15
- bs contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M').
- It is guaranteed that s is a valid roman numeral in the range [1, 3999].

 for more information: https://leetcode.com/problems/roman-to-integer/
 */

public class Roman2Integer {

    private static final Map<Character, Integer> MAP;

    static {
        MAP = new HashMap<>();
        MAP.put('I', 1);
        MAP.put('V', 5);
        MAP.put('X', 10);
        MAP.put('L', 50);
        MAP.put('C', 100);
        MAP.put('D', 500);
        MAP.put('M', 1000);
    }

    public int romanToInt(String s) {
        int len = s.length() - 1;
        int sum = MAP.get(s.charAt(len--));
        while (len >= 0) {
            char cur = s.charAt(len);
            char next = s.charAt(len + 1);
            if (cur == 'I' && (next == 'V' || next == 'X')) {
                sum -= MAP.get(cur);
            } else if (cur == 'X' && (next == 'L' || next == 'C')) {
                sum -= MAP.get(cur);
            } else if (cur == 'C' && (next == 'D' || next == 'M')) {
                sum -= MAP.get(cur);
            } else {
                sum += MAP.get(cur);
            }
            len--;
        }
        return sum;
    }
}
