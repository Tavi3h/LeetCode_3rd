package pers.tavish.leetcode.hard;

/*

Given a string s, partition s such that every substring of the partition is a palindrome.

Return the minimum cuts needed for a palindrome partitioning of s.



Example 1:

Input: s = "aab"
Output: 1
Explanation: The palindrome partitioning ["aa","b"] could be produced using 1 cut.

Example 2:

Input: s = "a"
Output: 0

Example 3:

Input: s = "ab"
Output: 1

for more information: https://leetcode.com/problems/palindrome-partitioning-ii/
 */

public class PalindromePartitioningII {
    public int minCut(String s) {
        int length = s.length();
        int[][] dp = new int[length][length];
        int[] cut = new int[length + 1];
        for (int i = length - 1; i >= 0; --i) {
            cut[i] = Integer.MAX_VALUE;
            for (int j = i; j < length; ++j) {
                if (s.charAt(i) == s.charAt(j) && (j - i <= 2 || dp[i + 1][j - 1] == 1)) {
                    dp[i][j] = 1;
                    cut[i] = Math.min(1 + cut[j + 1], cut[i]);
                }
            }
        }
        return cut[0] - 1;
    }
}