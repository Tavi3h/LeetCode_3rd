package pers.tavish.leetcode.medium;

/*

Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.

Note: You must not use any built-in BigInteger library or convert the inputs to integer directly.



Example 1:

Input: num1 = "2", num2 = "3"
Output: "6"
Example 2:

Input: num1 = "123", num2 = "456"
Output: "56088"


Constraints:

1 <= num1.length, num2.length <= 200
num1 and num2 consist of digits only.
Both num1 and num2 do not contain any leading zero, except the number 0 itself.

for more information: https://leetcode.com/problems/multiply-strings/
 */

public class MultiplyStrings {
    public String multiply(String num1, String num2) {

        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        int[] ans = new int[num1.length() + num2.length()];
        int len = num1.length() + num2.length() - 2;
        for (int i = num1.length() - 1; i >= 0; i--) {
            int m = num1.charAt(i) - '0';
            for (int j = num2.length() - 1; j >= 0; j--) {
                int n = num2.charAt(j) - '0';
                ans[len - i - j] += m * n;
            }
        }

        for (int i = 0; i < ans.length - 1; i++) {
            ans[i + 1] += ans[i] / 10;
            ans[i] %= 10;
        }

        StringBuilder sb = new StringBuilder();
        int i = ans[ans.length - 1] == 0 ? ans.length - 2 : ans.length - 1;
        for (; i >= 0; i--) {
            sb.append(ans[i]);
        }

        return sb.toString();
    }
}
