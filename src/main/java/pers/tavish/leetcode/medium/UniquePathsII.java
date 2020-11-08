package pers.tavish.leetcode.medium;

/*

A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

Now consider if some obstacles are added to the grids. How many unique paths would there be?

An obstacle and space is marked as 1 and 0 respectively in the grid.

Example 1:

Input: obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
Output: 2
Explanation: There is one obstacle in the middle of the 3x3 grid above.
There are two ways to reach the bottom-right corner:
1. Right -> Right -> Down -> Down
2. Down -> Down -> Right -> Right

Example 2:

Input: obstacleGrid = [[0,1],[0,0]]
Output: 1

Constraints:

- m == obstacleGrid.length
- n == obstacleGrid[i].length
- 1 <= m, n <= 100
- obstacleGrid[i][j] is 0 or 1.

for more information: https://leetcode.com/problems/unique-paths-ii/
 */

public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        if (obstacleGrid[0][0] == 1) {
            return 0;
        }

        int m = obstacleGrid[0].length, n = obstacleGrid.length;

        if (m == 1 && n == 1) {
            return 1;
        }

        for (int i = 1; i < m; i++) {
            if (obstacleGrid[0][i] != 1) {
                obstacleGrid[0][i] = 1;
            } else {
                if (n == 1) {
                    return 0;
                }
                for (int j = i; j < m; j++) {
                    obstacleGrid[0][j] = 0;
                }
                break;
            }
        }

        for (int i = 1; i < n; i++) {
            if (obstacleGrid[i][0] != 1) {
                obstacleGrid[i][0] = 1;
            } else {
                if (m == 1) {
                    return 0;
                }
                for (int j = i; j < n; j++) {
                    obstacleGrid[j][0] = 0;
                }
                break;
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                obstacleGrid[i][j] = obstacleGrid[i][j] == 1 ? 0 : obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
            }
        }

        return obstacleGrid[n - 1][m - 1];
    }
}
