package pers.tavish.leetcode.easy;

/*

Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.

Example 1:

Input: 121
Output: true

Example 2:

Input: -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.

Example 3:

Input: 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.

Follow up:

    - Coud you solve it without converting the integer to a string?

for more information: https://leetcode.com/problems/palindrome-number/description/
 */

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class PalindromeNumber {

    public boolean isPalindrome(int x) {

        if (x < 0) {
            return false;
        } else if (x < 9) {
            return true;
        } else {
            List<Integer> list = new ArrayList<>();
            while (x > 0) {
                int m = x % 10;
                x = x/ 10;
                list.add(m);
            }
            for (int i = 0, j = list.size() - 1; i < j; i++, j--) {
                 if (!list.get(i).equals(list.get(j))) {
                     return false;
                 }
            }
            return true;
        }
    }


    // int ---> String
//    public boolean isPalindrome(int x) {
//        return x < 0 ? false : isPalindrome(String.valueOf(x));
//    }
//
//    private boolean isPalindrome(String str) {
//
//        if (str.length() == 1) {
//            return true;
//        }
//
//        for (int i = 0, j = str.length() - 1; i < j; i++, j--) {
//             if (str.charAt(i) != str.charAt(j)) {
//                 return false;
//             }
//        }
//        return true;
//    }

    @Test
    public void testCase() {
        Assert.assertTrue(isPalindrome(0));
        Assert.assertTrue(isPalindrome(101));
        Assert.assertTrue(isPalindrome(1110111));
        Assert.assertTrue(isPalindrome(1001));
        Assert.assertFalse(isPalindrome(10011));
    }
}
