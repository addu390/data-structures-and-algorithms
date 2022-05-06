package problems.leetcode.string;

public class ZigzagConversion {

    // Similar to the Zig Zag operation, until numRows, increase by 1, then decrease by 1 until 0;
    public static String convert(String s, int numRows) {
        if (numRows <= 1) {
            return s;
        }
        // For each row.
        StringBuilder[] result = new StringBuilder[numRows];

        for (int i = 0; i < numRows; i++) {
            result[i] = new StringBuilder();
        }

        int index = 0, increase = 1;
        for (char c: s.toCharArray()) {
            result[index].append(c);

            if (index == numRows - 1) {
                increase = -1;
            }

            if (index == 0) {
                increase = 1;
            }

            index = index + increase;
        }
        return String.join("", result);
    }

    public static void main(String[] args) {
        System.out.print(convert("PAYPALISHIRING", 3));
    }
}
