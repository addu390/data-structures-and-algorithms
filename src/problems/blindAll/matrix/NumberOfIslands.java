package problems.blindAll.matrix;

import java.util.Objects;

public class NumberOfIslands {
    public static void main(String[] args) {
        char[][] matrix = new char[4][5];
        matrix[0] = new char[]{'1', '1', '1', '1', '0'};
        matrix[1] = new char[]{'1', '1', '0', '1', '0'};
        matrix[2] = new char[]{'1', '1', '0', '0', '0'};
        matrix[3] = new char[]{'0', '0', '0', '1', '0'};

        System.out.print(numIslands(matrix));
    }

    public static int numIslands(char[][] grid) {
        if (Objects.isNull(grid) || grid.length == 0) {
            return 0;
        }

        int rows = grid.length;
        int columns = grid[0].length;

        int numOfIslands = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                if (grid[r][c] == '1') {
                    numOfIslands++;
                    // Mark all the connected 1s as 0
                    dfs(grid, r, c);
                }
            }
        }
        return numOfIslands;

    }

    private static void dfs(char[][] grid, int r, int c) {
        int rows = grid.length;
        int columns = grid[0].length;

        if (r < 0 || c < 0 || r >= rows || c >= columns || grid[r][c] == '0') {
            return;
        }

        grid[r][c] = '0';

        dfs(grid, r + 1, c);
        dfs(grid, r - 1, c);
        dfs(grid,  r, c + 1);
        dfs(grid,  r, c - 1);
    }
}
