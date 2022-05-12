package problems.leetcode.heap;

import java.util.Arrays;

// https://leetcode.com/problems/task-scheduler/
// A set of repeated characters implying a task(s) and idle time between same tasks.
// Find the least time it takes to complete all the tasks.
public class TaskScheduler {

    public static int leastInterval(char[] tasks, int n) {
        if (n == 0) return tasks.length;

        int[] chars = new int[26];

        for (char c:tasks) {
            chars[c - 'A']++;
        }

        // Constant time and largest value (count) will be at the end.
        Arrays.sort(chars);

        // [A, A, A, B, B] and n = 2
        int idleLength = chars[25] - 1;
        // A, i, i, A, i, i, A (last task does not require idle time)
        // Now the plan is to fill the i with other values.
        int maxIdle = idleLength * n;

        for (int i = 24; i >= 0; i--) {
            // Min because, in the case when 2 or more tasks have same unit of work
            // [A, A, A, B, B, B], Consider Max instead of the count, as no idle time is required to place at the end.
            maxIdle = maxIdle - Math.min(chars[i], idleLength);
        }
        return maxIdle > 0 ? maxIdle + tasks.length : tasks.length;
    }

    public static void main(String[] args) {
        leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2);
    }
}
