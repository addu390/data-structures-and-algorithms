package algorithms.search;

/**
 * For an unsorted array, to find the element, complexity is O(n)
 * But we can do better if the array is sorted.
 * Binary search is for sorted array, complexity O(log n)
 * Start with the middle element.
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] sorted = new int[]{ 1, 3, 3, 3, 7, 9 };
        System.out.println("Is present : " + binarySearch(sorted, 0, sorted.length - 1, 3));
        System.out.println("Left index : " + occurrenceLeftIndex(sorted, 0, sorted.length - 1, 3));
        System.out.println("Right index : " + occurrenceRightIndex(sorted, 0, sorted.length - 1, 3));
        System.out.println("Number of occurrences : " + occurrenceLogN(sorted, 3));
        System.out.println("Is present (Index) in infinite array : " + binarySearchInfinite(sorted, 3));

        int[] pivot = new int[]{ 10, 20, 40, 50, 6, 7, 8 };
        System.out.println("Pivot index is : " + binarySearchPivot(pivot, 0,  pivot.length - 1));
        System.out.println("Floor square root is : " + squareRoot(17));
    }

    /**
     * Finding the mind point
     * Don't use (l + h)/2, instead use l + (h - l)/2
     * Complexity : O(log n)
     */
    public static int binarySearch(int[] ints, int start, int end, int k) {
        // Base case.
        if (start > end) {
            return -1;
        }

        int midIndex = start + ((end - start)/2);
        if (ints[midIndex] == k) {
            return midIndex;
        }

        if (k > ints[midIndex]) {
            return binarySearch(ints, start, midIndex - 1, k);
        }
        else {
            return binarySearch(ints, midIndex + 1, end, k);
        }
    }

    /**
     * Find left most occurrence of an element
     * Example : [2, 3, 3, 3]
     * Output : 1 -> Index
     */
    public static int occurrenceLeftIndex(int[] ints, int start, int end, int k) {
        if (start > end) {
            return -1;
        }

        int midIndex = start + ((end - start)/2);
        if ((ints[midIndex] == k) && ((midIndex == 0) || (ints[midIndex - 1] != k))) {
            return midIndex;
        }

        if (k <= ints[midIndex]) {
            return occurrenceLeftIndex(ints, start, midIndex - 1, k);
        }
        else {
            return occurrenceLeftIndex(ints, midIndex + 1, end, k);
        }
    }

    /**
     * Similar to occurrenceLeftIndex, find right most index.
     */
    public static int occurrenceRightIndex(int[] ints, int start, int end, int k) {
        if (start > end) {
            return -1;
        }

        int midIndex = start + ((end - start)/2);
        if ((ints[midIndex] == k) && ((midIndex == ints.length - 1) || (ints[midIndex + 1] != k))) {
            return midIndex;
        }

        if (k >= ints[midIndex]) {
            return occurrenceRightIndex(ints, midIndex + 1, end, k);
        }
        else {
            return occurrenceRightIndex(ints, start, midIndex - 1, k);
        }
    }

    /**
     * Find the number of occurrences of a given term.
     * Example : [2, 3, 3, 3, 3], X = 3
     * Output : 4
     * Complexity O(k + log n), where k is the number of occurrences.
     * This complexity is easy to achieve,
     * find the lowest occurrence index and use a loop to find the number of occurrences.
     * But to solve this with O(log n) : Find the left most index and right most index of the element.
     */
    public static int occurrenceLogN(int[] ints, int k) {
        int leftIndex = occurrenceLeftIndex(ints, 0, ints.length - 1, k);
        int rightIndex = occurrenceRightIndex(ints, 0, ints.length - 1, k);
        return rightIndex - leftIndex + 1;

        /**
         * In case of a Sorted Binary array,
         * int leftIndex = occurrenceLeftIndex(ints, 0, ints.length - 1, 1);
         * return ints.length - leftIndex;
         */
    }

    /**
     * Given an infinite SORTED array, find the element.
     * Complexity is O(counter)
     * Auxiliary space : O(1)
     */
    public static int binarySearchInfinite(int[] ints, int k) {
        if (ints[0] == k) {
            return 0;
        }
        int counter = 1;
        while (ints[counter] <= k) {
            counter = counter * 2;
        }
        return binarySearch(ints, 0, counter, k);
    }

    /**
     * You are given a sorted and rotated array (You don't know how many times the array is rotated).
     * Find if the given x is present in the array or now.
     * Example : [10, 20, 40, 5, 6, 7, 8] -> 4 rotations (5, 6, 7, 8 were rotated).
     * Pattern : It's like there are two sorted arrays in this sorted rotated array.
     * Find the element with O(log n), O(n) is simple.
     * Going by the pattern, the max element is the pivot element, after that I get two sorted arrays.
     * This question could've been finding the max element in a sorted rotated array as well.
     *
     * Similar problem : Find peak element, for a un-sorted rotated array.
     * Peak element : An element which is greater than the left element and right element (40 in our case).
     * This problem is however, slightly different, check for an element left and right, go in the direction of which ever is greater.
     * ie, if left element is greater, peak would be present in left half, likewise for right half.
     */
    public static int binarySearchPivot(int[] ints, int l, int h) {
        int mid = l + ((h - l)/2);
        if ((ints[mid] > ints[mid + 1]) && (ints[mid] > ints[mid - 1])) {
            return mid;
        }

        if (ints[mid] < ints[0]) {
            return binarySearchPivot(ints, l, mid - 1);
        } else {
            return binarySearchPivot(ints, mid + 1, h);
        }
    }

    /**
     * Given an integer, print the Square root of the number.
     * If it is not a prefect square, print the floor of square root.
     */
    public static int squareRoot(int x) {
        if (x == 0 || x == 1) {
            return x;
        }

        // Increase the start or decrease the end.
        int start = 1, end = x, ans = 0;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (mid * mid == x)
                return mid;

            if (mid * mid < x)
            {
                start = mid + 1;
                ans = mid;
            }
            else {
                end = mid - 1;
            }
        }
        return ans;
    }

}
