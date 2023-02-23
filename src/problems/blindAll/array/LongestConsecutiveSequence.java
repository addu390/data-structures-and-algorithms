package problems.blindAll.array;

import java.util.HashSet;

// https://leetcode.com/problems/longest-consecutive-sequence/
public class LongestConsecutiveSequence {

    public static int longestConsecutive(int[] nums) {
        // Convert Array to set
        // For each element, check if there is a left element to it, if not - it's start of a sequence.

        int result = 0;

        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        for (int i = 0; i < nums.length; i++) {
            // Is start of the sequence
            if (set.contains(nums[i] - 1)) {
                continue;
            } else {
                int count = 1;
                int number = nums[i] + 1;
                while (set.contains(number)) {
                    count = count + 1;
                    number = number + 1;
                }
                result = Math.max(result, count);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.print(longestConsecutive(new int[]{100,4,200,1,3,2}));
    }
}
