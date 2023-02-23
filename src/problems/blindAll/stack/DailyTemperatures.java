package problems.blindAll.stack;

import java.util.Stack;

/**
 * https://leetcode.com/problems/daily-temperatures/
 * Given an array of integers temperatures represents the daily temperatures,
 * return an array answer such that answer[i] is the number of days you have to wait after the ith day
 * to get a warmer temperature. If there is no future day for which this is possible, keep answer[i] == 0 instead.
 */
public class DailyTemperatures {

    // O(n^2) brute force.
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        // <Temperature:Index>
        Stack<Integer[]> stack = new Stack<>();

        for (int i = 0; i < temperatures.length; i++) {
            // When true, the stack.peek has found a greater temperature.
            while (!stack.isEmpty() && stack.peek()[0] < temperatures[i]) {
                Integer[] temp = stack.pop();
                result[temp[1]] = i - temp[1];
            }
            stack.push(new Integer[]{temperatures[i], i});
        }
        return result;
    }
}
