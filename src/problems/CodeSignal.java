package problems;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;

public class CodeSignal {
    public static void main(String[] args) {

        int arr[][] = { { 1, 2, 3},
                { 4, 5, 6},
                { 7, 8, 9 }};
        rotateImage(arr);

    }

    public static int firstDuplicate(int[] a) {
        HashSet<Integer> map = new HashSet<>();

        for (int i= 0; i < a.length; i++) {
            if (map.contains(a[i])) {
                return a[i];
            } else {
                map.add(a[i]);
            }
        }
        return -1;
    }

    public static String firstNotRepeatingCharacter(String s) {
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();

        String[] strings = s.split("");

        for (int i = 0; i < strings.length; i++) {
            if (map.containsKey(strings[i])) {
                int value = map.get(strings[i]);
                map.replace(strings[i], value + 1);
            } else {
                map.put(strings[i], 1);
            }
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return "_";
    }

    public static int[][] rotateImage(int[][] a) {

        int[][] res = new int[a.length][a.length];

        int count = 0;
        for (int i = 0; i < a.length; i++) {
            res[count][a.length - 1 - i] = a[i][count];
            count = count + 1;
            if (count == a.length - 1) {
                count = 1;
            }
        }
        return res;
    }

}
