package problems.leetcode.dynamicProgramming;


public class HouseRobber {
    public static int rob(int[] nums) {
        int rob1 = 0;
        int rob2 = 0;

        //  num[i] is current, consider nums[i] + rob1 (not adjacent) ot just rob2.
        // Rob1 and Rob2 represent the max money that can be robbed.
        for (int i = 0; i < nums.length; i++) {
            int temp = Math.max(nums[i] + rob1, rob2);
            rob1 = rob2;
            rob2 = temp;
        }
        return rob2;
    }

    public static void main(String[] args) {
        System.out.println(rob(new int[]{2,7,9,3,1}));
    }
}
