package problems.blindAll.array;

import java.util.Arrays;

/**
 * Because of negative and positive number, keep track of max and min element,
 * So that if num[i] is negative and minProduct is also negative -> choose nums[i] * minProduct.
 * As compared to num[i] is positive and maxProduct is also positive -> choose nums[i] * maxProduct
 */
public class MaxProductSubArray {

    public int maxProduct(int[] nums) {
        int maxProduct = 1;
        int minProduct = 1;
        int result = Arrays.stream(nums).max().getAsInt();

        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i] * maxProduct;
            maxProduct = Math.max(nums[i] * minProduct, Math.max((nums[i] * maxProduct), nums[i]));
            minProduct = Math.min(nums[i] * minProduct, Math.min(temp, nums[i]));
            result = Math.max(result, maxProduct);
        }
        return result;
    }
}
