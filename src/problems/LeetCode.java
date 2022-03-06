package problems;

import java.util.Arrays;

public class LeetCode {

    public static void main(String[] args) {

    }

    /**
     * Question: https://leetcode.com/problems/climbing-stairs/
     * Answer: https://youtu.be/Y0lT9Fck7qI
     *
     * Question: You are climbing a staircase. It takes n steps to reach the top.
     * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
     */
    public static int climbStairs(int n) {
        int one = 1;
        int two = 1;

        for (int i = 0; i < n - 1; i++) {
            int temp = one;
            one = one + two;
            two = temp;
        }
        return one;
    }

    /**
     * Question: https://leetcode.com/problems/coin-change/
     * Answer: https://youtu.be/H9bfqozjoqs
     *
     * Question: You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
     * Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
     * You may assume that you have an infinite number of each kind of coin.
     *
     * Answer: If n = 7, compute DP[0] to DP[7], DP[i] is the number of coins required to get i.
     * Now, for the given n, calculate the 1 + DP[n - Coin Change]
     */
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1]; // 0 to Amount
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int i = 1; i < amount + 1; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);
                }
            }
        }

        return dp[amount] != amount + 1 ? dp[amount] : -1;
    }

    /**
     * Question: https://leetcode.com/problems/longest-increasing-subsequence/
     * Answer: https://youtu.be/cjWnW0hdF1Y
     *
     * Question: Given an integer array nums, return the length of the longest strictly increasing subsequence.
     * A subsequence is a sequence that can be derived from an array by deleting some or no elements without changing the order of the remaining elements. For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].
     */
    public int lengthOfLIS(int[] nums) {
        return 0;
    }
}
