package pers.tavish.leetcode.easy;

/*

Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word (last word means the last appearing word if we loop from left to right) in the string.

If the last word does not exist, return 0.

Note: A word is defined as a maximal substring consisting of non-space characters only.

Example:

Input: "Hello World"
Output: 5

for more information: https://leetcode.com/problems/length-of-last-word/
 */

import java.util.Objects;

public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        if (Objects.isNull(s) || s.isEmpty() || s.trim().isEmpty()) {
            return 0;
        }
        String[] subs = s.split(" ");
        return subs[subs.length - 1].length();
    }
}
