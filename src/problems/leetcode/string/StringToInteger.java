package problems.leetcode.string;

public class StringToInteger {

    public int myAtoi(String s) {
        char[] chars = s.toCharArray();
        int start = 0;
        int count = 0;
        long result = 0;

        // Convert the first group of digits to number
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ' || chars[i] == '+' || chars[i] == '-' || Character.isDigit(chars[i])) {
                if (Character.isDigit(chars[i])) {
                    result = result * 10 + (chars[i] - '0');
                    count = count + 1;
                    if (count == 1) {
                        start = i;
                    }
                }
            } else {
                if (count > 0) {
                    break;
                }
            }
        }

        if (start > 0 && chars[start - 1] == '-') {
            result = result * -1;
        }

        if (result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }

        if (result < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        return (int) result;
    }
}
