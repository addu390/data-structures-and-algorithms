package Algorithms.Sort;

public class SelectionSort {

    /**
     * Theory : Similar to Bubble sort, array is partitioned into sorted and unsorted partitions.
     * Result : Sort in ascending order.
     * Initialisation : unsortedPartitionedIndex = array.length - 1 (Last index)
     *                  For loop starts from i = 1 (i = 0 is the largest element when we start).
     *                  largestElementIndex = 0 (starts with 0)
     *
     * Now in the first iteration, instead of swapping every time like in Bubble sort,
     * we update the largestElementIndex with the index of the largest element.
     * And then SWAP the "last element" with the largestElementIndex.
     *
     * Selection sort is an in-place algorithm
     * The time complexity is O(n^2)
     * Although we don't have to SWAP every time.
     */
    public static void main(String[] args) {
        int[] ints = new int[5];

        ints[0] = 24;
        ints[1] = 4;
        ints[2] = 67;
        ints[3] = -2;
        ints[4] = 23;


        int unsortedPartitionedIndex = ints.length - 1;
        while (unsortedPartitionedIndex > 0) {
            int largestElementIndex = 0;
            for (int i = 0; i <= unsortedPartitionedIndex; i++) {
                if (ints[i] > ints[largestElementIndex]) {
                    /** The difference form bubble sort is that we don't swap,
                     * instead largestElementIndex is updated with the index of the largest element.
                     */
                    largestElementIndex = i;
                }
            }
            int temp = ints[unsortedPartitionedIndex];
            ints[unsortedPartitionedIndex] = ints[largestElementIndex];
            ints[largestElementIndex] = temp;
            unsortedPartitionedIndex = unsortedPartitionedIndex - 1;
        }
        print(ints);
    }

    private static void print(int[] intArray) {
        for (int i = 0; i < intArray.length; i++) {
            System.out.println(intArray[i]);
        }
    }
}
