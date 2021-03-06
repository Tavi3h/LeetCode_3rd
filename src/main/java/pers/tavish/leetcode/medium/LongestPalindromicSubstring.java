package pers.tavish.leetcode.medium;

/*

Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example 1:

Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.

Example 2:

Input: "cbbd"
Output: "bb"

for more information: https://leetcode.com/problems/longest-palindromic-substring/
 */

import org.junit.Assert;
import org.junit.Test;

public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {

        if (s == null || s.isEmpty()) {
            return "";
        }

        String res = "";

        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);
                if (dp[i][j] && (j - i + 1 > res.length())) {
                    res = s.substring(i, j + 1);
                }
            }
        }
        return res;
    }

    @Test
    public void testCase() {
        Assert.assertEquals("abcba", longestPalindrome("abcba"));
        Assert.assertEquals("bcb", longestPalindrome("abcbe"));
        Assert.assertEquals("cdc", longestPalindrome("abcdc"));
        Assert.assertEquals("ccc", longestPalindrome("abccc"));
    }
}
