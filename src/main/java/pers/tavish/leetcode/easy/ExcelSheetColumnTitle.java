package pers.tavish.leetcode.easy;

/*

Given a positive integer, return its corresponding column title as appear in an Excel sheet.

For example:

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB
    ...
Example 1:

Input: 1
Output: "A"

Example 2:

Input: 28
Output: "AB"

Example 3:

Input: 701
Output: "ZY"

for more information: https://leetcode.com/problems/excel-sheet-column-title/
 */

public class ExcelSheetColumnTitle {
    public String convertToTitle(int n) {
        StringBuilder s = new StringBuilder();
        while (n != 0) {
            int temp = (n - 1) % 26;
            s.insert(0, (char) ('A' + temp));
            n = (n - 1) / 26;
        }
        return s.toString();
    }
}
