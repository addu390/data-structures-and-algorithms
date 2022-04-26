package problems.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    /**
     * Sort the array to prevent duplicate triplet combination(s).
     * After choosing the first sum, find 2 sum using left-right pointer without hashmap (Array is already sorted).
     * Space: O(1) and Time: O(n^2)
     */
    // Target 0
    public List<List<Integer>> threeSum(int[] nums) {
        nums = Arrays.stream(nums).sorted().toArray();
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {

            // Prevent duplicates (consider the first one)
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int current = nums[i];

            int left  = i + 1;
            int right = nums.length - 1;

            // Two Sum
            int target = -current;
            int sum = nums[left] + nums[right];
            while (left < right) {
                if (sum > target) {
                    right = right - 1;
                } else if (sum < target) {
                    left = left + 1;
                } else {
                    result.add(Arrays.asList(current, nums[left], nums[right]));
                    left = left + 1;

                    // Prevent duplicates (don't choose the same nums[left] again).
                    while (nums[left] == nums[left - 1] && left < right) {
                        left = left + 1;
                    }
                }
            }
        }
        return result;
    }
}
