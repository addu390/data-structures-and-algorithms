package problems.blindAll.dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordBreak {
    public static boolean wordBreak(String s, List<String> wordDict) {
        // + 1 is for the base case.
        // If we get to the last index, then return True.
        boolean[] dp = new boolean[s.length() + 1];
        Arrays.fill(dp, false);
        dp[s.length()] = true;

        for (int i = s.length() - 1; i >= 0; i--) {
            for (String word: wordDict) {
                if (((s.length() - i) >= word.length()) && word.equals(s.substring(i, i + word.length())))  {
                    dp[i] = dp[i + word.length()];
                }
                if (dp[i]) {
                    break;
                }
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        List<String> wordDict1 = new ArrayList<>();
        wordDict1.add("leet");
        wordDict1.add("code");
        System.out.println(wordBreak("leetcode", wordDict1));
    }
}
