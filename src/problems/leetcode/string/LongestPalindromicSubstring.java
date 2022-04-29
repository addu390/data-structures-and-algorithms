package problems.leetcode.string;

public class LongestPalindromicSubstring {

    public static String longestPalindrome(String s) {
        int resultLength = 0;
        String resultString = "";

        for (int i = 0; i < s.length(); i++) {
            // Odd
            int left = i;
            int right = i;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                if ((right - left + 1) > resultLength) {
                    resultLength = (right - left + 1);
                    resultString = s.substring(left, right + 1);
                }
                left = left - 1;
                right = right + 1;
            }

            left = i;
            right = i + 1;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                if ((right - left + 1) > resultLength) {
                    resultLength = (right - left + 1);
                    resultString = s.substring(left, right + 1);
                }
                left = left - 1;
                right = right + 1;
            }
        }

        return resultString;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
    }
}
