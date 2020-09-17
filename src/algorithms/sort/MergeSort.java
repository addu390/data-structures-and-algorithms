package algorithms.sort;

/**
 * Divide and conquer.
 * Divide the array into two parts, recursively sort them and merge them.
 * Stable sorting algorithm.
 * Complexity : O(n log n).
 * Space complexity : O(n).
 * Quick sort for arrays works better than merge sort.
 */
public class MergeSort {

    public static void main(String[] args) {

        int[] a = new int[]{ 10, 20, 30 };
        int[] b = new int[]{ 20, 40 };
        mergeSortedArrays(a, b);

        int[] unsorted = new int[]{ 11, 10, 4, 30, 10 };
        mergeSort(unsorted, 0, unsorted.length - 1);

        intersection(a, b);

    }

    /**
     * Given two sorted arrays, merge them with O(n).
     * Example : [1, 1, 2] and [3] -> [1, 1, 2, 3]
     */
    public static void mergeSortedArrays(int[] a, int[] b) {
        int j = 0;
        int i = 0;

        while (i < a.length && j < b.length) {
            if (a[i] >= b[j]) {
                System.out.println("Adding : " + b[j]);
                j++;
            } else {
                System.out.println("Adding : " + a[i]);
                i++;
            }
        }

        // Add rest of the elements.
        while (i < a.length) {
            System.out.println("Adding : " + a[i]);
            i++;
        }

        while (j < b.length) {
            System.out.println("Adding : " + b[j]);
            j++;
        }
    }

    /**
     * l and r represents left and right index, to start with it will be 0 and int.length - 1.
     * The height of the recursion tree is log n and work done at each level is O(n).
     * Hence time complexity : O(n * log n).
     */
    public static void mergeSort(int[] ints, int l, int r) {
        if (r > l) {
            int m = l + ((r - l)/2);
            mergeSort(ints, l, m);
            mergeSort(ints, m + 1, r);

            // Merge two sorted arrays.
            merge(ints, l, m ,r);
        }
    }

    /**
     * Elements from l to m are sorted.
     * Elements from m + 1 to r are sorted.
     * Sort the entire array.
     */
    private static void merge(int[] ints, int l, int m, int r) {

        int n1 = m - l + 1;
        int n2 = r - m;
        int[] left = new int[n1];
        int[] right = new int[n2];

        for (int  i = 0; i < n1; i++) {
            left[i] = ints[l + i];
        }

        for (int  i = 0; i < n2; i++) {
            right[i] = ints[m + 1 + i];
        }

        int j = 0;
        int i = 0;
        int k = l;

        while (i < n1 && j < n2) {
            // Lesser than equal to - Stability.
            if (left[i] <= right[j]) {
                ints[k++] = left[i++];
            } else {
                ints[k++] = right[j++];
            }
        }

        while (i < n1) {
            ints[k++] = left[i++];
        }

        while (j < n2) {
            ints[k++] = right[j++];
        }
    }

    /**
     * Intersection of sorted arrays.
     * Find the repeated elements (distinct) in 2 sorted arrays.
     */
    public static void intersection(int[] a, int[] b) {
        // Very similar to the merge function of merge sort.

        int j = 0;
        int i = 0;

        while (i < a.length && j < b.length) {
            if (a[i] == b[j]) {
                // An extra if condition to check for equality.
                System.out.println(a[i]);
            }
            if (a[i] >= b[j]) {
                j++;
            } else {
                i++;
            }
        }

        while (i < a.length) {
            i++;
        }

        while (j < b.length) {
            j++;
        }

    }
}
