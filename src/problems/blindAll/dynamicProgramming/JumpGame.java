package problems.blindAll.dynamicProgramming;

/**
 * https://leetcode.com/problems/jump-game/
 */
public class JumpGame {

    // Move the position of the goal from last to first if the move is possible.
    // If the goal can be moved to 0th position, then the jump is possible.
    public boolean canJump(int[] nums) {
        int goal = nums.length - 1;

        for (int i = nums.length - 2; i >= 0; i--) {
            if (i + nums[i] >= goal) {
                goal = i;
            }
        }

        return goal == 0;
    }
}
