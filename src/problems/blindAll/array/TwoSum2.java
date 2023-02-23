package problems.blindAll.array;

import java.util.Arrays;

public class TwoSum2 {

    public static int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        int[] result = new int[2];

        while (left < right) {
            int number = numbers[left] + numbers[right];
            if (number == target) {
                result[0] = left + 1;
                result[1] = right + 1;
                return result;
            }
            if (number > target) {
                right = right - 1;
            }

            if (number < target) {
                left = left + 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.print(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
    }
}
