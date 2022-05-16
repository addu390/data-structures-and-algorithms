package problems.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        backtrack(result, path, nums, new boolean[nums.length]);
        return result;
    }

    private static void backtrack(List<List<Integer>> result, List<Integer> path, int[] nums, boolean[] visited) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }

            path.add(nums[i]);
            visited[i] = true;
            backtrack(result, path, nums, visited);

            path.remove(path.size() - 1);
            backtrack(result, path, nums, visited);
            visited[i] = false;
        }
    }
}
