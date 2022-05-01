package problems.leetcode.heap;

import java.util.*;

// https://leetcode.com/problems/top-k-frequent-elements/
public class TopKFrequentElements {

    // Using a heap would result in a time complexity of O(k log n).
    // However, using a variation of Bucket Sort Count:List<Input> has O(n) time and space.
    public int[] topKFrequent(int[] nums, int k) {

        List<Integer> result = new ArrayList<>();

        // Number: Frequency
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            frequencyMap.merge(nums[i], 1, Integer::sum);
        }

        // PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>((e1, e2) -> e1.getValue() - e2.getValue());
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));

        for (Map.Entry<Integer, Integer> entry: frequencyMap.entrySet()) {
            minHeap.add(entry);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        while (!minHeap.isEmpty()) {
            result.add(minHeap.poll().getKey());
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
