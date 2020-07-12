package dataStructures;

/**
 * 2 dimensional : m x n
 * 3 dimensional : m x n x p
 * Traverse : (number of dimensions) nested loops.
 * Multidimensional arrays is also a contiguous array.
 * Elements are stored row wise or column wise (Row major or Column major order).
 */
public class Matrix {

    public static void main(String[] args) {
        int arr[][] = {{1, 2, 3}, {4, 5, 6}};

        int irr[][] = {{1, 2, 3}, {4, 5, 6, 7, 8}};

        // 1 2 3 4 5 6
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.println(arr[i][j]);
            }
        }
    }
}
