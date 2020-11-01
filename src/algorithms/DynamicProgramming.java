package algorithms;

/**
 * There's already a section of plain recursion,
 * The simple idea of dynamic programming is to store the result of sub-problems of recursion.
 * It is an optimisation over recursive solutions.
 * Ways of implementation:
 * 1. Memoization (Top Down)
 * 2. Tabulation (Bottom Up)
 * Applications:
 * 1. Bellman Ford Algo.
 * 2. Floyd Warshall Algo
 * 3. LCS (Longest common sub-sequence)
 * 4. Search Closest Word.
 * 5. Resource Allocation.
 * and much more.
 *
 * ie. In plain recursion, if some of the sub-problems are solved again and again:
 * They can be optimised by storing and using it the next time.
 */
public class DynamicProgramming {

    /**
     * Given n - Find the nth fibo number
     * Refer Class: Memo (Example for Memoization)
     */
    public static int fibo(int n) {

        if (n == 0 || n == 1) {
            return n;
        } else {
            return fibo(n - 1) + fibo(n - 2);
        }
    }

    /**
     * Similar to Memoization (Top down)
     * Tabulation is an other way of implementing Dynamic Programming (Bottom up)
     * Let's say solution for N is required, we compute and store values for 0, 1, 3...N
     * Taking the same example to find fibo of nth element,
     */
    public static int fiboTabulation(int n) {
        int[] f = new int[n + 1];
        f[0] = 0;
        f[1] = 1;

        for (int i = 2; i < n; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f[n];
    }
}
