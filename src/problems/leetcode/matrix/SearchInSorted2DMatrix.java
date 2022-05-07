package problems.leetcode.matrix;


public class SearchInSorted2DMatrix {

    public static boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            if (target >= matrix[i][0] && target <= matrix[i][cols - 1]) {
                int left = 0;
                int right = cols - 1;

                int[] row = matrix[i];

                while (left <= right) {
                    int mid = (left + right)/2;

                    if (target == row[mid]) {
                        return true;
                    }

                    if (target > row[mid]) {
                        left = mid + 1;

                    } else {
                        right = mid - 1;
                    }
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1}};
        System.out.print(searchMatrix(matrix, 1));
    }
}
