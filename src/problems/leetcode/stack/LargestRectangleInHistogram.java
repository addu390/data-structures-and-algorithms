package problems.leetcode.stack;

import java.util.Stack;

public class LargestRectangleInHistogram {

    // Find previous smallest and next smallest and then (nextSmallIndex - previousSmallIndex) * currentHeight.
    public static int largestRectangleArea(int[] heights) {
        int result = 0;
        int[] previousSmallest = previousSmallestElement(heights);
        int[] nextSmallest = nextSmallestElement(heights);

        for (int i = 0; i < heights.length; i++) {
            int area = (nextSmallest[i] - previousSmallest[i] - 1) * heights[i];
            result = Math.max(result, area);
        }

        return result;
    }

    private static int[] previousSmallestElement(int[] array) {
        int[] result = new int[array.length];
        // Index:Height
        Stack<Integer[]> stack = new Stack<>();

        for (int i = 0; i < array.length; i++) {
            while (!stack.isEmpty() && stack.peek()[1] >= array[i]) {
                stack.pop();
            }

            result[i] = stack.isEmpty() ? -1 : stack.peek()[0];
            stack.push(new Integer[]{i, array[i]});
        }

        return result;
    }

    private static int[] nextSmallestElement(int[] array) {
        int[] result = new int[array.length];
        // Index:Height
        Stack<Integer[]> stack = new Stack<>();

        for (int i = array.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek()[1] >= array[i]) {
                stack.pop();
            }

            result[i] = stack.isEmpty() ? array.length : stack.peek()[0];
            stack.push(new Integer[]{i, array[i]});
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.print(largestRectangleArea(new int[]{2,1,5,6,2,3}));
        System.out.print(largestRectangleArea(new int[]{2,4}));
    }
}
