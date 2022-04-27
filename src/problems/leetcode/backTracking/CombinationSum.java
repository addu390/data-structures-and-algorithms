package problems.leetcode.backTracking;

import java.util.ArrayList;
import java.util.List;

// Refer to images/neetcode-39

// Pointer - whether to choose the element or not, to ensure a unique set of combinations (same elements can however repeat).
// Time complexity: 2^target
public class CombinationSum {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentCandidates = new ArrayList<>();

        backtrack(candidates, result, currentCandidates, 0, 0, target);

        return result;
    }

    // i is the index pointer
    public static void backtrack(int[] candidates,
                                 List<List<Integer>> result,
                                 List<Integer> currentCandidates,
                                 int i,
                                 int currentTotal,
                                 int target) {

        if (currentTotal == target) {
            // To ensure that it's not the reference (Array copy at this stage).
            result.add(new ArrayList<>(currentCandidates));
            return;
        }

        if (i > candidates.length - 1 || currentTotal > target) {
            return;
        }

        // Consider ith candidate
        currentCandidates.add(0, candidates[i]);
        backtrack(candidates, result, currentCandidates, i, currentTotal + candidates[i], target);

        // Do not consider ith candidate
        currentCandidates.remove(0);
        backtrack(candidates, result, currentCandidates, i + 1, currentTotal, target);

    }

    public static void main(String[] args) {
        System.out.println(combinationSum(new int[]{1, 2, 3, 4}, 7));
    }
}
