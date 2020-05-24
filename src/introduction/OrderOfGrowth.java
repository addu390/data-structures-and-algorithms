package introduction;


/**
 * This program can be written in different ways, but to choose the best
 * We rely on Asymptotic Notations.
 *
 * Complexity : O(1) - Constant.
 *
 * Order of growth, consider for n = infinite.
 * Time taken > 0
 * Number of steps (n) > 0
 *
 * If f(n) is growing faster than g(n)
 * for n tends to infinity f(n)/ g(n) = Infinite.
 * for n tends to infinity g(n)/ f(n) = Zero.
 *
 * Direct way to compare order of growth :
 * 1. Ignore lower order terms.
 * 2. Ignore leading constants.
 *
 * C < log log n < log n < n^(1/3) < n^(1/2) < n < n^2 < n^3 < n^4 < 2^n < n^2
 *
 * Example : order of growth of 2n^2 + n + c is n^2
 * Example : order of growth of 100n + c is n
 *
 * Mathematical notations sued to represent order of growth :
 * 1. Big O : Represent exact order of growth or Upper.
 * 2. Theta : Represent exact order of growth.
 * 3. Omega : Represent exact order of growth or Lower.
 *
 * Big O notation :
 * f(n) <= c x g(n) for all n >= n'
 * Where g(n) is the direct order of growth
 * And f(n) is the actual order of growth with constants.
 * And easiest way to get the value of C is (co-efficient of highest order of f(n)) + 1
 * From this find n', if this is proved, it means that the Big O notation is correct.
 */
public class OrderOfGrowth {

    public static void main(String[] args) {

        int n = 3;
        int sum = (n * (n + 1))/2;
        System.out.println("The sum is : " + sum);
    }


    public static void asymptoticNotations() {
        /**
         * Order of growth : O(n)
         */
        int[] ints = new int[5];
        int n = 100;
        for (int i = 0; i < n; i++) {
            // Operations here
        }

        // ================================
        /**
         * In this case, the complexity when n is even is O(n).
         * And complexity is constant when n is odd.
         *
         * So we consider best, average and worst case.
         * Best case : Constant
         * Average case : If even and odd are equal, O(n)
         * Worst case : O(n)
         */
        if (n % 2 != 0 ) {
            return;
        }
        for (int i = 0; i < n; i++) {
            // Operations here
        }

        // ================================
        /**
         * Linear search
         * Time complexity (Worst case) : O(n)
         */
        int r = 10;
        for (int i = 0; i < ints.length; i++) {
            if (ints[i] == r) {
                return;
            }
        }
    }
}
