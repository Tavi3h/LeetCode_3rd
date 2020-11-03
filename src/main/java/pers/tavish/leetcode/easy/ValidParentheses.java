package pers.tavish.leetcode.easy;

import java.util.LinkedList;

/**

 Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

 An input string is valid if:

 Open brackets must be closed by the same type of brackets.
 Open brackets must be closed in the correct order.

 Example 1:

 Input: s = "()"
 Output: true

 Example 2:

 Input: s = "()[]{}"
 Output: true

 Example 3:

 Input: s = "(]"
 Output: false

 Example 4:

 Input: s = "([)]"
 Output: false

 Example 5:

 Input: s = "{[]}"
 Output: true

 Constraints:

 - 1 <= s.length <= 104
 - s consists of parentheses only '()[]{}'.

 for more information: https://leetcode.com/problems/valid-parentheses/
 */

public class ValidParentheses {
    public boolean isValid(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (c == '{' || c == '(' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    char t = stack.pop();
                    if ((c == '}' && t != '{') || (c == ')' && t != '(') || (c == ']' && t != '[')) {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }
}
