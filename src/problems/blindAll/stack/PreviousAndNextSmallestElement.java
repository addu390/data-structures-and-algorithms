package problems.blindAll.stack;

import java.util.Stack;

public class PreviousAndNextSmallestElement {
    public static int[] previousSmallestElement(int[] array) {
        int[] result = new int[array.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < array.length; i++) {
            while (!stack.isEmpty() && stack.peek() >= array[i]) {
                stack.pop();
            }

            result[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(array[i]);
        }

        return result;
    }

    public static int[] nextSmallestElement(int[] array) {
        int[] result = new int[array.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = array.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() >= array[i]) {
                stack.pop();
            }

            result[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(array[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        previousSmallestElement(new int[]{13, 15, 12, 14, 16});
        nextSmallestElement(new int[]{13, 15, 12, 14, 16});
    }
}
