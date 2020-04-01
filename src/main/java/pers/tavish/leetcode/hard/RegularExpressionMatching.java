package pers.tavish.leetcode.hard;

/*

Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.

'.' Matches any single character.
'*' Matches zero or more of the preceding element.
The matching should cover the entire input string (not partial).

Note:

    - s could be empty and contains only lowercase letters a-z.
    - p could be empty and contains only lowercase letters a-z, and characters like . or *.

Example 1:

Input:
s = "aa"
p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".

Example 2:

Input:
s = "aa"
p = "a*"
Output: true
Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".

Example 3:

Input:
s = "ab"
p = ".*"
Output: true
Explanation: ".*" means "zero or more (*) of any character (.)".

Example 4:

Input:
s = "aab"
p = "c*a*b"
Output: true
Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore, it matches "aab".

Example 5:

Input:
s = "mississippi"
p = "mis*is*p*."
Output: false

for more information: https://leetcode.com/problems/regular-expression-matching/
 */

public class RegularExpressionMatching {

    public boolean isMatch(String s, String p) {
        if (s == null && p == null) {
            return true;
        } else if (s == null || p == null) {
            return false;
        } else {
            char[] sa = s.toCharArray(), pa = p.toCharArray();
            boolean[][] matched = new boolean[pa.length + 1][sa.length + 1];
            matched[0][0] = true;
            for (int i = 1; i <= pa.length; i++) {
                matched[i][0] = pa[i - 1] == '*' && matched[i - 2][0];
                for (int j = 1; j <= sa.length; j++) {
                    if (pa[i - 1] == '.') {
                        matched[i][j] = matched[i - 1][j - 1];
                    } else if (pa[i - 1] == sa[j - 1]) {
                        matched[i][j] = matched[i - 1][j - 1];
                    } else if (pa[i - 1] == '*') {
                        if (pa[i - 2] != sa[j - 1] && pa[i - 2] != '.') {
                            matched[i][j] = matched[i - 2][j];
                        } else {
                            matched[i][j] = matched[i][j - 1] || matched[i - 1][j] || matched[i - 2][j];
                        }
                    }
                }
            }
            return matched[pa.length][sa.length];
        }
    }
}
