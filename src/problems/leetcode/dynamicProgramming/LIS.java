package problems.leetcode.dynamicProgramming;

import java.util.Arrays;

// Longest Increasing Subsequence
// Start from the last and check for every element after "i" until nums.length
// Starting from the last, find the maximum subsequence for every position (i to end).
// Then, find the largest subsequence found so far.
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
