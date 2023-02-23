package problems.blindAll.array;

import java.util.Arrays;

public class ProductExceptSelf {
    public static int[] productExceptSelf(int[] nums) {
        int[] prefix = new int[nums.length];
        int[] suffix = new int[nums.length];

        int[] result = new int[nums.length];

        int prefixProduct = nums[0];
        prefix[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefixProduct = prefixProduct * nums[i];
            prefix[i] = prefixProduct;
        }

        int suffixProduct = nums[nums.length - 1];
        suffix[nums.length - 1] = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            suffixProduct = suffixProduct * nums[i];
            suffix[i] = suffixProduct;
        }

        result[0] = suffix[1];
        result[nums.length - 1] = prefix[nums.length - 2];
        for (int i = 1; i < nums.length - 1; i++) {
            result[i] = prefix[i - 1] * suffix[i + 1];
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelf(new int[]{1, 2, 3, 4})));
    }
}
