package problems.blindAll.array;

public class TrappingRainWater {

    public static int trap(int[] height) {
        int result = 0;

        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];

        leftMax[0] = height[0];
        for (int i = 1; i < leftMax.length; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        rightMax[height.length - 1] = height[height.length - 1];
        for (int i = rightMax.length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        for (int i = 0; i < height.length; i++) {
            result = result + (Math.min(leftMax[i], rightMax[i]) - height[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        trap(new int[]{1, 2, 3});
    }
}
