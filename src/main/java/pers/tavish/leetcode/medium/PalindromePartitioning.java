package pers.tavish.leetcode.medium;

/*

Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

Example:

Input: "aab"
Output:
[
  ["aa","b"],
  ["a","a","b"]
]

for more information: https://leetcode.com/problems/palindrome-partitioning/
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if (Objects.isNull(s) || s.isEmpty()) {
            return Collections.emptyList();
        }
        partition(res, new ArrayList<>(), s,  0);
        return res;
    }

    private void partition(List<List<String>> res, List<String> list, String s, int start) {
        if (start == s.length()) {
            res.add(new ArrayList<>(list));
        } else {
            for (int i = start; i < s.length(); i++) {
                String sub = s.substring(start, i + 1);
                if (isPalindrome(sub)) {
                    list.add(sub);
                    partition(res, list, s, i + 1);
                    list.remove(list.size() - 1);
                }
            }
        }
    }

    private boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }
}
