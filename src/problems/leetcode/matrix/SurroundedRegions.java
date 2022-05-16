package problems.leetcode.matrix;

// https://leetcode.com/problems/surrounded-regions/
// Given an m x n matrix board containing 'X' and 'O', capture all regions that are 4-directionally surrounded by 'X'.
// A region is captured by flipping all 'O's into 'X's in that surrounded region.

import java.util.Arrays;

// Reverse thinking.
// Instead of capturing surrounded regions,
// Capture everything except surrounded regions - Opposite of that is the answer.
public class SurroundedRegions {

    public static void solve(char[][] board) {
        for (int i = 0; i < board[0].length; i++) {
            // First Row
            if (board[0][i] == 'O') {
                // DFS to mark that entire region as 'T' - new variable.
                dfs(board, 0, i);
            }

            // Last Row
            if (board[board.length - 1][i] == 'O') {
                // DFS to mark that entire region as 'T' - new variable.
                dfs(board, board.length - 1, i);
            }
        }

        for (int i = 0; i < board.length; i++) {
            // First Column
            if (board[i][0] == 'O') {
                dfs(board, i, 0);
            }

            // Last Column
            if (board[i][board[0].length - 1] == 'O') {
                dfs(board, i, board[0].length - 1);
            }
        }

        // Mark all 'O' as 'X' - Capture.
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }

                if (board[i][j] == 'T') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private static void dfs(char[][] grid, int r, int c) {
        int rows = grid.length;
        int columns = grid[0].length;

        if (r < 0 || c < 0 || r >= rows || c >= columns || grid[r][c] == 'X' || grid[r][c] == 'T') {
            return;
        }

        grid[r][c] = 'T';

        dfs(grid, r + 1, c);
        dfs(grid, r - 1, c);
        dfs(grid,  r, c + 1);
        dfs(grid,  r, c - 1);
    }

    public static void main(String[] args) {
        char[][] grid = new char[][]{
                {'X','X','X','X',},
                {'X','O','O','X',},
                {'X','X','O','X',},
                {'X','O','X','X',}};
        char[][] grid2 = new char[][]{{'O', 'O'}, {'O', 'O'}};
        solve(grid2);
        System.out.print(Arrays.deepToString(grid2));

    }
}
