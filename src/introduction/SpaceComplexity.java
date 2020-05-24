package introduction;

public class SpaceComplexity {

    /**
     * Space complexity and Auxiliary space
     * Auxiliary space : Order of growth of extra space or temporary space created to solve a problem.

     * Selection sort, Insertion sort, bubble sort : Space complexity = O(n) and Auxiliary space = O(1)
     * Merge sort : Space complexity = O(n) and Auxiliary space = O(n)
     * Quick sort : Space complexity = O(n) and Auxiliary space = O(log n) - Best case and O(n) - worst case
     *
     * For this reason, more than space complexity, Auxiliary space is used for comparision.
     */
    public static void main(String[] args) {
        System.out.println(sumOfNTerms(5));
        System.out.println(fibonacci(10));
        System.out.println(fibonacciTwo(10));
        System.out.println(fibonacciThree(10));

    }

    public static void forLoop() {

        int n = 100;
        int[] ints = new int[10];
        /**
         * With the increase of value of n, space remains the same.
         * Space complexity : O(1) - Constant
         */
        for (int i = 0; i < n; i++) {
            // O(1) work.
        }

        /**
         * In this case, since n is the the length of the array.
         * As n increases, so does the size of the array.
         * Space complexity : O(n)
         * Auxiliary space : O(1)
         */
        n = ints.length;
        for (int i = 0; i < n; i++) {
            // O(1) work.
        }
    }

    /**
     * For n = 5
     * sumOfNTerms(5) | sumOfNTerms(4) | sumOfNTerms(3) | sumOfNTerms(2) | sumOfNTerms(1) | sumOfNTerms(0)
     * Until sumOfNTerms(0) is completed, all of the rest would be waiting for the break;
     * Which means, we need have space for (n + 1) function calls.
     * Therefore, Space complexity = O(n + 1) = O(n)
     * Auxiliary space = O(n + 1) = O(n)
     */
    public static int sumOfNTerms(int n) {
        if (n <= 0) {
            return 0;
        }
        return n + sumOfNTerms(n - 1);
    }

    /**
     * For recursive methods, find Space complexity and Auxiliary space using a recursive tree.
     * A simple formula to find Auxiliary space for a recursion : Equal to the height of the tree
     * (Maximum length from ROOT node to LEAF mode)

     * Let's take an example for fibonacci(4)
     * fibonacci(4) -> fibonacci(3) -> fibonacci(2) -> fibonacci(1)
     *                                              -> fibonacci(0)
     *                              -> fibonacci(1)
     *              -> fibonacci(2) -> fibonacci(1)
     *                              -> fibonacci(0)
     * From the above tree, the height of the TREE is 4.
     * Which is n, Auxiliary space = O(n)

     * It is equal to the height of the tree, as at any moment
     * The number of elements in the call stack is always lesser than height of the tree.
     */
    public static int fibonacci(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    /**
     * Both time complexity and Auxiliary space = O(n)
     * O(n + 1) = O(n)
     */
    public static int fibonacciTwo(int n) {
        int[] ints = new int[n + 1];
        ints[0] = 0;
        ints[1] = 1;
        for (int i = 2; i <= n; i++) {
            ints[i] = ints[i - 1] + ints[i - 2];
        }
        return ints[n];
    }

    /**
     * This method is not recursive anymore, not it uses an array
     * Space complexity and Auxiliary space = O(1)
     */
    public static int fibonacciThree(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int a = 0; int b = 1;
        int c = 0;
        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }
}
