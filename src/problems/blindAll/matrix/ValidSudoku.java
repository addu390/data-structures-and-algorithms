package problems.blindAll.matrix;

import java.util.HashSet;

public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;

        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                char value = board[i][j];
                if (value == '.') {
                    continue;
                }
                String row = "R" + i + value;
                String col = "C" + j + value;
                String box = i/3 + "B" + j/3 + value;
                if (set.contains(row) || set.contains(col) || set.contains(box)) {
                    return false;
                } else {
                    set.add(row);
                    set.add(col);
                    set.add(box);
                }
            }
        }
        return true;
    }
}
