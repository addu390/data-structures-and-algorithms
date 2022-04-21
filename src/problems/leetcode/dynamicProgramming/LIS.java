package problems.leetcode.dynamicProgramming;

import java.util.Arrays;

// Start from the last and check for every element after "i" until nums.length
public class LIS {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        for (int i = nums.length - 1; i >= 0; i--) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > nums[i]) {
                    dp[i] = Math.max(1, 1 + dp[j]);
                }
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }
}
