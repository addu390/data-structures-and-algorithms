package problems;

import java.util.Arrays;

public class Memo {

    static int[] memo;

    /**
     * Time complexity of Fibo is now O(n)
     * But with a space complexity of O(n+1)
     */
    static int fib(int n)
    {
        if(memo[n]==-1) {
            int res;

            if(n == 0 || n == 1) {
                return n;
            }
            else {
                res = fib(n-1)+fib(n-2);
            }

            memo[n]=res;
        }

        return memo[n];
    }

    public static void main (String[] args) {

        int n = 6;

        memo = new int[n+1];

        // Fill with -1, if -1 -> Not computed
        // Optionally we can use a hashmap.

        // Note: It may not be filled with -1 for all problems.
        // The value has to be picked such that - It is never a possible solution in the recursion.
        Arrays.fill(memo,-1);

        System.out.println(fib(n));

    }
}
