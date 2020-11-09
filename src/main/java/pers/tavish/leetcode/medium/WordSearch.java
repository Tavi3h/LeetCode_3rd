package pers.tavish.leetcode.medium;

/*

Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cells, where "adjacent" cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.

Example 1:

Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
Output: true

Example 2:

Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
Output: true

Example 3:

Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
Output: false

Constraints:

board and word consists only of lowercase and uppercase English letters.

- 1 <= board.length <= 200
- 1 <= board[i].length <= 200
- 1 <= word.length <= 10^3

for more information: https://leetcode.com/problems/word-search/
 */

public class WordSearch {
    public boolean exist(char[][] board, String word) {

        if (board.length == 0 || board[0].length == 0) {
            return false;
        }

        int m = board.length, n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (search(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean search(char[][] board, String word, int i, int j, int idx) {

        if (idx == word.length()) {
            return true;
        }
        int m = board.length, n = board[0].length;
        if (i < 0 || j < 0 || i >= m || j >= n || board[i][j] != word.charAt(idx)) {
            return false;
        }
        char c = board[i][j];
        board[i][j] = '#';
        boolean res = search(board, word, i - 1, j, idx + 1)
                || search(board, word, i + 1, j, idx + 1)
                || search(board, word, i, j - 1, idx + 1)
                || search(board, word, i, j + 1, idx + 1);
        board[i][j] = c;
        return res;
    }
}
