package problems.blindAll.backtracking;

import java.util.ArrayList;
import java.util.List;

// Backtracking Brute Force: O(n * 2^n)
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        backtrack(result, current, nums, 0);
        return result;
    }

    private static void backtrack(List<List<Integer>> result, List<Integer> current, int[] nums, int index) {
        if (index >= nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        current.add(nums[index]);
        backtrack(result, current, nums, index + 1);

        // Remove by index - When you do not include.
        current.remove(current.size() - 1);
        backtrack(result, current, nums, index + 1);
    }
}
