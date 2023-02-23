package problems.blindAll.dynamicProgramming;

import java.util.Arrays;

public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];

        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], 0);
        }

        for (int i = dp.length - 2; i >= 0; i--) {
            for (int j = dp[0].length - 2; j >= 0; j--) {
                if (s.charAt(i) == t.charAt(j)) {
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }

        if (dp[0][0] == s.length()) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
//        isSubsequence("ahbgdc", "abc");
    }
}
