package pers.tavish.leetcode.hard;

/*

Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

Example 1:

Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]

Example 2:

Input: n = 1
Output: ["()"]

Constraints:

- 1 <= n <= 8

for more information: https://leetcode.com/problems/generate-parentheses/
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        generateParenthesis(list, "", n, n);
        return list;
    }

    private void generateParenthesis(List<String> list, String curr, int left, int right) {
        if (left == 0 && right == 0) {
            list.add(curr);
        }

        if (left > 0) {
            generateParenthesis(list, curr + "(", left - 1, right);
        }

        if (left < right) {
            generateParenthesis(list, curr + ")", left, right - 1);
        }
    }

    @Test
    public void testCase() {
         List<String> list = generateParenthesis(2);
        System.out.println(list);
    }
}
