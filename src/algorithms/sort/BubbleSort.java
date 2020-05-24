package algorithms.sort;

public class BubbleSort {

    /**
     * Bubble sort : Performance decreases as the number of elements grow.
     *
     * Theory : With progression, partitions the array into sorted and un-sorted (Logical partitioning).
     * Result : Sort in ascending order.
     * Initialisation : unsortedPartitionedIndex = array.length() - 1 (Last index)
     * Swap elements from Index A to Index B : SWAP(A, B)
     *
     * Start : from left of the array - Index 0
     * If (Index 0 > Index 1) : SWAP(0, 1), else : i = i + 1
     *
     * After the first iteration, the largest element in at the END.
     * Now iterate again without the last element, unsortedPartitionedIndex = array.length() - 1
     * Stop the Iteration when unsortedPartitionedIndex == 0
     *
     * Since the larger values are bubbling up to the right - It's called as BUBBLE SORT.
     * Time complexity : O(n^2)
     * In-place algorithm - The existing array can be mutated, so space complexity if O(1)
     */
    public static void main (String[] args) {

        int[] ints = new int[5];
        ints[0] = 24;
        ints[1] = 4;
        ints[2] = 67;
        ints[3] = -2;
        ints[4] = 23;

        // So unsortedPartitionedIndex starts with 4
        int unsortedPartitionedIndex = ints.length - 1;
        while (unsortedPartitionedIndex > 0) {
            for (int i = 0; i < unsortedPartitionedIndex; i++) {
                if (ints[i] > ints[i + 1]) {
                    int temp = ints[i];
                    ints[i] = ints[i + 1];
                    ints[i + 1] = temp;
                }
            }
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
