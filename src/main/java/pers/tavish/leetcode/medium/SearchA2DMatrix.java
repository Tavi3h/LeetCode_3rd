package pers.tavish.leetcode.medium;

/*

Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

- Integers in each row are sorted from left to right.
- The first integer of each row is greater than the last integer of the previous row.

Example 1:

Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,50]], target = 3
Output: true

Example 2:

Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,50]], target = 13
Output: false

Example 3:

Input: matrix = [], target = 0
Output: false

Constraints:

- m == matrix.length
- n == matrix[i].length
- 0 <= m, n <= 100
- -104 <= matrix[i][j], target <= 104

for more information: https://leetcode.com/problems/search-a-2d-matrix/
 */

import java.util.Arrays;

public class SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int m = matrix.length, n = matrix[0].length;

        int[] tails = new int[m];
        for (int i = 0; i < m; i++) {
            tails[i] = matrix[i][n - 1];
        }

        if (target > tails[m - 1]) {
            return false;
        }

        int result = Arrays.binarySearch(tails, target);

        return result >= 0 || Arrays.binarySearch(matrix[-result - 1], target) >= 0;
    }
}
