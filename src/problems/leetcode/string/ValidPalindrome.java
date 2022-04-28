package problems.leetcode.string;

public class ValidPalindrome {

    // String manipulation with O(n) space.
    public boolean isPalindrome(String s) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetterOrDigit(s.charAt(i))) {
                stringBuilder.append(s.charAt(i));
            }
        }

        stringBuilder = new StringBuilder(stringBuilder.toString().replace(" ", "").toLowerCase());

        String sanitizedString = stringBuilder.toString();

        if (sanitizedString.equals(stringBuilder.reverse().toString())) {
            return true;
        }

        return false;
    }

    // Two pointer without extra space.
    public boolean isPalindrome2(String s) {
        int left = 0;
        int right = s.length() - 1;

        while(left < right) {
            if (Character.isLetterOrDigit(s.charAt(right)) &&
                    Character.isLetterOrDigit(s.charAt(left))) {

                if (Character.toString(s.charAt(left)).toLowerCase().equals(Character.toString(s.charAt(right)).toLowerCase())) {
                    left = left + 1;
                    right = right - 1;
                } else {
                    return false;
                }

            }

            if (!Character.isLetterOrDigit(s.charAt(left))) {
                left = left + 1;
            }
            if (!Character.isLetterOrDigit(s.charAt(right))) {
                right = right - 1;
            }
        }

        return true;
    }
}