package problems.blindAll.graph;

public class MaxAreaOfIsland {
    public static int maxAreaOfIsland(int[][] grid) {
        int result = 0;

        int rows = grid.length;
        int columns = grid[0].length;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                if (grid[r][c] == 1) {
                    Integer[] area = new Integer[1];
                    area[0] = 0;
                    dfs(grid, r, c, area);
                    result = Math.max(result, area[0]);
                }
            }
        }

        return result;
    }

    private static void dfs(int[][] grid, int r, int c, Integer[] area) {
        int rows = grid.length;
        int columns = grid[0].length;

        if (r < 0 || c < 0 || r >= rows || c >= columns || grid[r][c] == 0) {
            return;
        }

        grid[r][c] = 0;
        area[0] = area[0] + 1;

        dfs(grid, r + 1, c, area);
        dfs(grid, r - 1, c, area);
        dfs(grid,  r, c + 1, area);
        dfs(grid,  r, c - 1, area);
    }
}
