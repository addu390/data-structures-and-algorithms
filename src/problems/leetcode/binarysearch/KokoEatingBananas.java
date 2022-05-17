package problems.leetcode.binarysearch;

public class KokoEatingBananas {

    // Brute force (try all values of k) -> Binary Search.
    // https://leetcode.com/problems/koko-eating-bananas/

    /**
     * Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas.
     * The guards have gone and will come back in h hours.
     *
     * Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas
     * and eats k bananas from that pile. If the pile has less than k bananas, she eats all of them instead
     * and will not eat any more bananas during this hour.
     *
     * Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.
     *
     * Return the minimum integer k such that she can eat all the bananas within h hours.
     */
    // Koko can eat one pile of banana in an hour; hence h >= length(piles).
    // time complexity: O(max values of piles * len of p) - Choosing k 1 to max of p.
    // Applying Binary Search on k = O(log max-p * len p).
    public static int minEatingSpeed(int[] piles, int h) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int  i = 0; i < piles.length; i++) {
            max = Math.max(piles[i], max);
        }

        int start = 1;
        int end = max;

        while (start <= end) {
            int mid = (start + end)/2;
            int currentHours = numberOfHours(piles, mid);

            if (currentHours > h) {
                start = mid + 1;
            } else {
                min = Math.min(mid, min);
                end = mid - 1;
            }
        }

        return min;
    }

    private static int numberOfHours(int[] piles, int k) {
        int result = 0;
        for (int  i = 0; i < piles.length; i++) {
            // 3/6 = 0, but we want to 3/6 as 1
            result = result + (piles[i]/k) + (piles[i] % k == 0 ? 0 : 1);
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.print(minEatingSpeed(new int[]{30,11,23,4,20}, 6));
    }
}
