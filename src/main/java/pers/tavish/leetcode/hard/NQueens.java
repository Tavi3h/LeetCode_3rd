package pers.tavish.leetcode.hard;

/*

The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.

Given an integer n, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.

Example:

Input: 4
Output: [
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]
Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above.

for more information: https://leetcode.com/problems/n-queens/
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (char[] chars : board) {
            Arrays.fill(chars, '.');
        }
        List<List<String>> res = new ArrayList<>();
        solveNQueens(res, board, 0, n);
        return res;
    }

    private void solveNQueens(List<List<String>> res, char[][] board, int row, int n) {
        if (row == n) {
            List<String> list = new ArrayList<>();
            for (char[] queen : board) {
                list.add(new String(queen));
            }
            res.add(list);
        } else {
            for (int col = 0; col < n; col++) {
                if (board[row][col] == '.') {
                    board[row][col] = 'Q';
                    if (isValid(board, row, col)) {
                        solveNQueens(res, board, row + 1, n);
                    }
                    board[row][col] = '.';
                }
            }
        }
    }

    private boolean isValid(char[][] board, int row, int col) {
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    @Test
    public void testCase() {
        System.out.println(solveNQueens(4));
    }
}
