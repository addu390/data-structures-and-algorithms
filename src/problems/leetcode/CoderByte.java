package problems.leetcode;

public class CoderByte {

    public static boolean isArithmetic(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
            return true;
        }

        int diff = nums[1] - nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] != diff) {
                return false;
            }
        }

        return true;
    }

    public static boolean isGeometric(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
            return true;
        }

        int diff = nums[1] / nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] / nums[i - 1] != diff) {
                return false;
            }
        }

        return true;
    }

    public static String arithGeo(int[] nums) {
        return isArithmetic(nums) ? "arithmetic" : "geometric";
    }

    // Insert dash ('-') between each two odd numbers and insert asterisk ('*') between each two even numbers.
    public static String dashInsert(String input) {
        if (input.isEmpty() || input.length() == 1) {
            return input;
        }
        char[] chars = input.toCharArray();
        StringBuilder builder = new StringBuilder();

        for (int i = 1; i < chars.length; i++) {
            int left = Character.getNumericValue(chars[i - 1]);
            int right = Character.getNumericValue(chars[i]);
            builder.append(left);

            if (left == 0 && right == 0) {
                continue;
            }

            if (left % 2 == 0 && right % 2 == 0) {
                builder.append('*');
            } else if (left % 2 != 0 && right % 2 != 0) {
                builder.append('-');
            }
        }

        builder.append(chars[chars.length - 1]);

        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.print(dashInsert("45467930022"));
        System.out.print(arithGeo(new int[]{2, 6, 18, 54}));
    }
}
