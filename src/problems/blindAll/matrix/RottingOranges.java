package problems.blindAll.matrix;


import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {

    public int orangesRotting(int[][] grid) {

        Queue<Integer[]> queue = new LinkedList<>();
        int freshOranges = 0;
        int minutes = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new Integer[]{i, j});
                }

                if (grid[i][j] == 1) {
                    freshOranges = freshOranges + 1;
                }
            }
        }

        int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

        while (!queue.isEmpty() && freshOranges > 0) {

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer[] rotten = queue.poll();

                for (int j = 0; j < directions.length; j++) {
                    int row = rotten[0] + directions[j][0];
                    int col = rotten[1] + directions[j][1];

                    if (row < 0 || row > grid.length || col < 0 || col > grid[0].length || grid[row][col] == 0 || grid[row][col] == 2) {
                        continue;
                    }

                    grid[row][col] = 2;
                    queue.add(new Integer[]{row, col});
                    freshOranges = freshOranges - 1;
                }
            }
            minutes = minutes + 1;
        }

        return freshOranges == 0 ? minutes : -1;
    }
}
