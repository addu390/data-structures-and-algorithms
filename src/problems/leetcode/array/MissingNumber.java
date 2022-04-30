package problems.leetcode.array;

// Sum of n natural numbers: n * (n+1)/2
public class MissingNumber {

    public static int missingNumber(int[] nums) {
        int n = nums.length;
        int currentTotal = 0;
        for (int i = 0; i < n; i++) {
            currentTotal = currentTotal + nums[i];
        }

        double expectedTotal = n * ((n+1)/2.0);
        return (int) expectedTotal - currentTotal;
    }

    public static void main(String[] args) {
        System.out.println(missingNumber(new int[]{0, 1}));
    }
}
