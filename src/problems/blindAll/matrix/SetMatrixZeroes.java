package problems.blindAll.matrix;

public class SetMatrixZeroes {

    public void setZeroes(int[][] matrix) {
        boolean rowZero = false;
        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    if (i == 0) {
                        rowZero = true;
                    } else {
                        matrix[i][0] = 0;
                    }
                }
            }
        }

        // Apart from 1st row and column, set everything else to zero based on 1st row and column.
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // check if first column has to be zeroes
        if (matrix[0][0] == 0) {
            for (int i = 0; i < rows; i++) {
                matrix[i][0] = 0;
            }
        }

        // check if first row has to be zeroes
        if (rowZero) {
            for (int i = 0; i < cols; i++) {
                matrix[0][i] = 0;
            }
        }
    }
}
