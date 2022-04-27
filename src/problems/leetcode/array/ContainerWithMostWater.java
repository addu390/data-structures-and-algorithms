package problems.leetcode.array;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int result = 0;

        while (left <= right) {
            int area = Math.min(height[left], height[right]) * (right - left);
            result = Math.max(area, result);

            if (height[left] > height[right]) {
                right = right - 1;
            } else {
                left = left + 1;
            }
        }
        return result;
    }
}
