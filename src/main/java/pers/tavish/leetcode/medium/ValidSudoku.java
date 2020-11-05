package pers.tavish.leetcode.medium;

/*

Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.

Note:

A Sudoku board (partially filled) could be valid but is not necessarily solvable.
Only the filled cells need to be validated according to the mentioned rules.

Example 1:

Input: board =
[["5","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]
Output: true

Example 2:

Input: board =
[["8","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]
Output: false

Explanation: Same as Example 1, except with the 5 in the top left corner being modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.

Constraints:

- board.length == 9
- board[i].length == 9
- board[i][j] is a digit or '.'.

for more information: https://leetcode.com/problems/valid-sudoku/
 */

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {

        if (!isValidRow(board) || !isValidColumn(board)) {
            return false;
        }

        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                if (!isValidSudoku(board, i, j)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValidRow(char[][] board) {
        Set<Character> set;
        for (int i = 0; i < 9; i++) {
            set = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                if (!set.contains(board[i][j])) {
                    set.add(board[i][j]);
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValidColumn(char[][] board) {
        Set<Character> set;
        for (int i = 0; i < 9; i++) {
            set = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (board[j][i] == '.') {
                    continue;
                }
                if (!set.contains(board[j][i])) {
                    set.add(board[j][i]);
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValidSudoku(char[][] board, int i, int j) {

        Set<Character> set = new HashSet<>();
        for (int k = i; k < i + 3; k++) {
            for (int l = j; l < j + 3; l++) {
                if (board[k][l] == '.') {
                    continue;
                }
                if (!set.contains(board[k][l])) {
                    set.add(board[k][l]);
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
