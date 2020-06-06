package algorithms.sort;

public class InsertionSort {

    public static void main(String[] args) {

    }

    /**
     * Stability of sorting algorithms.
     * For repeated items or objects sorted based on a criteria which might be same for others,
     * has to be sorted such that, the one appearing first is also appears first in the sorted list.
     * One liner : if two items are same, then they should appear in the same order of the original array.
     * Stability may not matter for primitive data types, for example Integers, but would matter for Objects such as :
     * Class with name and marks sorted by marks.
     * Stable : Bubble, insertion, merge sort...
     * Un-stable : Selection, quick, heap sort... (Selection sort : Finds the max element and swaps with the last element).
     */

    /**
     * Insertion sort :
     * Complexity : O(n^2).
     * In-place and stable algorithm.
     * O(n) - Best case time complexity.
     * Auxiliary space : O(1).
     *
     * Steps :
     * Start with 2nd element.
     * Maintain 0 to (i - 1) elements sorted.
     *
     * O(n) - if the array is already sorted.
     * O(n^2) - When array is reverse sorted.
     */
    public static int[] insertionSort(int[] ints) {

        for (int i = 1; i < ints.length - 1; i++) {
            int key = ints[i];
            int j = i - 1;

            while ((j >= 0) && (ints[j] > key)) {
                ints[j + 1] = ints[j];
                j--;
            }
            ints[j + 1] = key;
        }
        return ints;
    }
}
