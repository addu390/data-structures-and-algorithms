package problems.blindAll.dynamicProgramming;

// Refer to images/neetcode-LCS

// Longest Common Subsequence between two strings.
// Match: 1 + diagonally down, else: Max(right, down).

import java.util.Arrays;

// When matched, move diagonally because that character matches and a sub-string after that character has to be compared
// for both the strings.
public class LCS {

    public static int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];

        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], 0);
        }

        for (int i = dp.length - 2; i >= 0; i--) {
            for (int j = dp[0].length - 2; j >= 0; j--) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j + 1], dp[i + 1][j]);
                }
            }

        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("abc", "def"));
    }
}
