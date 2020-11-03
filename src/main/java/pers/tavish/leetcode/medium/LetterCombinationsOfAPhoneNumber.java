package pers.tavish.leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**

 Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

 A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

 Example 1:

 Input: digits = "23"
 Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]

 Example 2:

 Input: digits = ""
 Output: []

 Example 3:

 Input: digits = "2"
 Output: ["a","b","c"]

 Constraints:

 - 0 <= digits.length <= 4
 - digits[i] is a digit in the range ['2', '9'].

 for more information: https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 */

public class LetterCombinationsOfAPhoneNumber {

    private static final String[] TABLE = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.isEmpty()) {
            return Collections.emptyList();
        }
        List<String> res = new ArrayList<>();
        letterCombinations(digits, res, "", 0);
        return res;
    }

    private void letterCombinations(String digits, List<String> res, String s, int idx) {
        if (idx == digits.length()) {
            res.add(s);
        } else {
            String letters = TABLE[digits.charAt(idx) - '0'];
            for (int i = 0; i < letters.length(); i++) {
                letterCombinations(digits, res, s + letters.charAt(i), idx + 1);
            }
        }
    }
}
