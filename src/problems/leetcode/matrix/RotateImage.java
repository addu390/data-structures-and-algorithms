package problems.leetcode.matrix;

// Transpose (interchange rows and columns) and then reverse.
// Input: [[1,2,3],[4,5,6],[7,8,9]]
// Transpose: [[1,4,7],[2,5,8],[3,6,9]]
// Reverse: [[7,4,1],[8,5,2],[9,6,3]]
public class RotateImage {

    public void rotate(int[][] matrix) {
        int rows = matrix.length;

        // Transpose
        for (int i = 0; i < rows; i++) {
            for (int j = i + 1; j < rows; j++) {
                int temp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }

        // Reverse
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < rows /2 ; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][rows - 1 - j];
                matrix[i][rows - 1 - j] = temp;
            }
        }
    }
}
