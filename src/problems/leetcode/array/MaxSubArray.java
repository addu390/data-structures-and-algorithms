package problems.leetcode.array;

public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int sum = nums[0];
        int result = nums[0];

        for (int i = 1; i < nums.length; i++) {
            sum = Math.max(sum + nums[i], nums[i]);
            result = Math.max(result, sum);
        }
        return result;
    }
}
