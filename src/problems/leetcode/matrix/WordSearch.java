package problems.leetcode.matrix;

// https://leetcode.com/problems/word-search/
// Given an m x n grid of characters board and a string word, return true if word exists in the grid.
public class WordSearch {

    public static boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (dfs(i, j, rows, cols, 0, board, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean dfs(int row, int col, int rowLength, int colLength, int currentIndex, char[][] board, String word) {
        if (word.length() == currentIndex) {
            return true;
        }

        if (row >= rowLength || col >= colLength || row < 0 || col < 0 ||
                board[row][col] == '#' || board[row][col] != word.charAt(currentIndex)) {
            return false;
        }

        char currentChar = board[row][col];
        // instead of setting '#', optionally use a pair set <row, col> and remove it in the later step before result.
        board[row][col] = '#'; // to prevent going back to the same node (visited node).

        boolean result = dfs(row + 1, col, rowLength, colLength, currentIndex + 1, board, word) ||
                dfs(row, col + 1, rowLength, colLength, currentIndex + 1, board, word) ||
                dfs(row - 1, col, rowLength, colLength, currentIndex + 1, board, word) ||
                dfs(row, col - 1, rowLength, colLength, currentIndex + 1, board, word);

        board[row][col] = currentChar; // setting it back for use by other paths.
        return result;
    }

    public static void main(String[] args) {

    }
}
