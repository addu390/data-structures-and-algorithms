package problems.leetcode.heap;

import java.util.*;

public class KClosestPointsToOrigin {

    public static int[][] kClosest(int[][] points, int k) {
        int[][] result = new int[k][2];
        PriorityQueue<Integer[]> maxHeap = new PriorityQueue<>((e1, e2) -> e2[0] - e1[0]);
        for (int i = 0; i < points.length; i++) {
            int distance = (points[i][0] * points[i][0]) + (points[i][1] * points[i][1]);

            maxHeap.add(new Integer[]{distance, i});
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        int index = 0;
        while (!maxHeap.isEmpty()) {
            result[index] = points[maxHeap.poll()[1]];
            index = index + 1;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.print(Arrays.deepToString(kClosest(new int[][]{{3, 3}, {5, -1}, {-2, 4}}, 2)));
    }
}
