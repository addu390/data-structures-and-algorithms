package problems.blindAll;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CodeSignal {

    public static int[] solution1(int n, int[] a) {
        int[] b = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            int term1 = 0;
            int term3 = 0;
            if (i > 0) {
                term1 = a[i - 1];
            }
            if (i < a.length - 1) {
                term3 = a[i + 1];
            }
            b[i] = term1 + a[i] + term3;
        }

        return b;
    }

    public static int solution2(int[] a, int[] b, int k) {
        int result = 0;

        for (int i = 0; i < a.length; i++) {
            if (Integer.parseInt(a[i] + "" + b[a.length - 1 - i]) < k) {
                result = result + 1;
            }
        }
        return result;
    }

    public static boolean solution3(int[] arr, int[][] pieces) {
        Map<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < pieces.length; i++) {
            map.put(pieces[i][0], pieces[i]);
        }

        int i = 0;
        while (i < arr.length) {
            if (map.containsKey(arr[i])) {
                int[] piece = map.get(arr[i]);
                if (!Arrays.equals(Arrays.copyOfRange(arr, i, i + piece.length), piece)) {
                    return false;
                }
                i = i + piece.length;
            } else {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        solution3(new int[]{1, 2, 5, 3}, new int[][]{{5}, {1, 3}, {2}});
    }
}
