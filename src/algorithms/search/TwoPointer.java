package algorithms.search;

public class TwoPointer {

    public static void main(String[] args) {

        int[] sorted = new int[]{ 2, 4, 8, 9, 11, 12, 20, 30 };
        System.out.println("Is sum present PAIR : " + isSumPresentPair(sorted, 23, 0, sorted.length - 1));
        System.out.println("Is sum present TRIPLET : " + isSumPresentTriplet(sorted, 22));

    }

    /**
     * Given a un-sorted array and a SUM (SUM pair), find if the SUM is present
     * Example : [2, 5, 3, 9], SUM = 14
     * Output : True.
     * Naive approach : O(n^2)
     * But solve this with O(n).
     * 1. Using hashing (For un-sorted array).
     * 2. Two pointer (For sorted array).
     *
     * Two pointer approach :
     * Start two pointers from 2 corners.
     * Example : [2, 5, 8, 12, 30]
     * SUM = 17
     * 2 and 30 are initially the pointers.
     * since 30 is greater than 17, pointers rae 2 and 12.
     * Since 2 is the smaller one, pointers are 5 and 12 -> Answer.
     * Move left pointer when smaller than SUM and move right pointer when greater than SUM.
     * Until both pointers are same.
     * I've solved this with recursion, but you can solve it with a while (start < end) {} loop
     * Time complexity : O(n).
     * Auxiliary Space : O(1).
     */
    public static boolean isSumPresentPair(int[] ints, int sum, int l, int h) {
        int currentSum = ints[l] + ints[h];

        // Base case
        if (l == h) {
            return false;
        }

        if (currentSum == sum) {
            return true;
        }

        if (currentSum > sum) {
            return isSumPresentPair(ints, sum, l, h - 1);
        } else {
            return isSumPresentPair(ints, sum, l + 1, h);
        }
    }

    /**
     * Similarly, find if the SUM exists for a triplet (Sum of there elements).
     * Naive solution would take : O(n*3), but can solve in O(n*2).
     * For every element, subtract it from the total sum and see if there is a pair.
     * Time complexity : O(n^2).
     * However the complexity even for un-sorted array is O(n^2) :
     * O(n log n) for sorting + O(n^2) for solving the sorted array
     * O(n^2) using hashing.
     */
    public static boolean isSumPresentTriplet(int[] ints, int sum) {
        for (int i = 0; i < ints.length; i++) {
            int currentSUm = sum - ints[i];
            if (isSumPresentPair(ints, currentSUm, 0, ints.length - 1)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Similar problem based on tow pointer, find if there is a value matching a^2 + b^2 = c^2.
     * Also asked as : Find if there is a pythagoras triplet in the given array.
     */
}
