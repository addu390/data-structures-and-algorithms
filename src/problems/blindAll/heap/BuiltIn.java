package problems.blindAll.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class BuiltIn {

    public static void main(String[] args) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        minHeap.add(1);
        minHeap.peek();
        minHeap.remove(1);

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
    }
}
