package pers.tavish.leetcode.hard;

/*

Given two strings s and t, return the minimum window in s which will contain all the characters in t. If there is no such window in s that covers all characters in t, return the empty string "".

Note that If there is such a window, it is guaranteed that there will always be only one unique minimum window in s.

Example 1:

Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"

Example 2:

Input: s = "a", t = "a"
Output: "a"

Constraints:

- 1 <= s.length, t.length <= 105
- s and t consist of English letters.

for more information: https://leetcode.com/problems/minimum-window-substring/
 */

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        int[] map = new int[128];

        for (int i = 0; i < t.length(); i++) {
            map[t.charAt(i)]++;
        }
        int begin = 0, end = 0, head = 0, d = Integer.MAX_VALUE, counter = t.length();

        while (end < s.length()) {
            if (map[s.charAt(end++)]-- > 0) {
                counter--;
            }
            while (counter == 0) {
                if (d > end - begin) {
                    head = begin;
                    d = end - begin;
                }
                if (map[s.charAt(begin++)]++ == 0) {
                    counter++;
                }
            }
        }
        return d == Integer.MAX_VALUE ? "" : s.substring(head, head + d);
    }
}
