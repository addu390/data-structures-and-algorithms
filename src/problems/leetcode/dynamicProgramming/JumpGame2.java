package problems.leetcode.dynamicProgramming;

import java.util.stream.IntStream;

// Minimum number of jumps
// Greedy O(n), DP: O(n^2)
// Sort of a 1D BFS.
public class JumpGame2 {

    public static int jump(int[] nums) {

        int result = 0;

        // Represents the window
        int left = 0;
        int right = 0;

        while (right < nums.length - 1) {
            // Who can jump the farthest to set the left and right point.
            int farthestJump = 0;
            for (int i = left; i < right + 1; i++) {
                farthestJump = Math.max(farthestJump, i + nums[i]);
            }

            left = right + 1;
            right = farthestJump;

            result = result + 1;
        }

        return result;
    }

    public static void main(String[] args) {
        jump(new int[]{2,3,1,1,4});
    }
}
