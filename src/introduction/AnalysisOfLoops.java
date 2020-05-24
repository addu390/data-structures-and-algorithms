package introduction;

public class AnalysisOfLoops {

    public static void main(String[] args) {
        subsequentForLoop();

    }


    public static void simpleForLoop() {
        /**
         * For a given value of c, the loop runs for (n/c) times.
         * ie, if n = 100 and c = 2
         * 0, 2, 4, 6.. 100 (50 times - n/c)
         * Direct time complexity = O(n)
         */
        int c = 2;
        int n = 100;
        for (int i = 0; i < n; i = i + c) {
            // O(1) work.
        }


        /**
         * n/2 times
         * Example : n = 10, c = 2
         * 10, 8, 6, 4, 2
         * Direct time complexity = O(n)
         */
        for (int i = n; i > 0; i = i - c) {
            // O(1) work.
        }

        /**
         * Example : n = 35, c = 2
         * 0, 4, 8, 16, 32 (5 times)
         * Equation : c^k-1 (Where k is the number of iterations)
         *
         * Solving : c^k-1 < n
         * k-1 < log c(base) n
         * k < log c(base) n + 1
         * So time complexity is log c(base) n => O(log n)
         * Base does not matter for Big O, as that would be a constant.
         */
        for (int i = 1; i < n; i = i * c) {
            // O(1) work.
        }

        /**
         * Very similar to the prior example,
         * the time complexity is O(log n)
         * Example : n = 32, c = 2
         * 32, 16, 8, 4, 2 (5 times)
         */
        for (int i = n; i > 0; i = i/c) {
            // O(1) work.
        }

        /**
         * For c = 2
         * 2, 2^2 = 4, 4^2 = 16, 16^2 = 256..
         * [2, 2^c, (2^c)^c = 2^(c square)..]
         * 2^(c^(k-1)) - where k is the number of times this runs.
         * 2^(c^(k-1)) < n
         * c^(k-1) < log 2(base) n
         * k-1 < log k(base) (log 2(base) n)
         * k < log k(base) (log 2(base) n) + 1
         * Time complexity : log log n
         */
        for (int i = 2; i < n; i = (int) Math.pow(i, c)) {
            // O(1) work.
        }
    }

    public static void subsequentForLoop() {

        int c = 2;
        int n = 100;

        /**
         * Cases where we have to find the complexity of a function with multiple loops
         * First loop : O(log n)
         * Second loop : O(n)
         * Third loop : Since n is fixed to 100, O(1)
         * So the total time complexity = O(log n) + O(n) + O(1) = O(n) (By ignoring the lower order).
         */
        for (int i = 1; i < n; i = i * c) {
            System.out.println(i);
            // O(1) work.
        }

        for (int i = 0; i < n; i = i + c) {
            // O(1) work.
        }

        for (int i = 0; i < 100; i = i + c) {
            // O(1) work.
        }
    }

    /**
     * Time complexity of this function :
     * O(n log n) + O(n^2) = O(n^2) - Ignore lower orders.
     */
    public static void nestedForLoop() {

        int c = 2;
        int n = 100;

        /**
         * First loop : O(n)
         * Second loop : O(log n)
         * Complexity : O(n) * O(log n) = O(n log n)
         */
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j = j * c) {
                System.out.println(i);
                // O(1) work.
            }
        }

        /**
         * First loop : O(n)
         * Second loop : O(n)
         * Complexity : O(n) * O(n) = O(n^2)
         */
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j++) {
                System.out.println(i);
                // O(1) work.
            }
        }

    }

    /**
     * Time complexity :
     * To get time complexity for recursions, we use "Recursion tree method"
     * We draw a recursion tree and compute the total work done.
     *
     * Divide the equation into recursive and non-recursive part.
     *
     * For loop -> O(n) -> Cn
     * Recursion twice : 2t(n/2)
     * t(n) = 2t(n/2) + Cn

     * The root node is non-recursive part.
     * cn -> t(n/2)
     *    -> t(n/2)
     *
     * Further expanding it, bu substituting t(n/2) in t(n) = 2t(n/2) + Cn
     *
     * cn -> c(n/2) -> t(n/4)
     *              -> t(n/4)
     *
     *    -> c(n/2) -> t(n/4)
     *              -> t(n/4)
     *
     * So in the root, work done : cn
     * In the next : c(n/2) + c(n/2) = cn
     * In the nest : c(n/4) + c(n/4) + c(n/4) + c(n/4) = cn
     *
     * So for every level, work done is cn, we will know the complexity by finding the height of the tree.
     * In this case, the height of the tree is log n (If the number is divided by 2 in every Iteration, number of iterations = log 2(base) n)
     * Therefore, log n * cn = n log n
     */
    public static void recursiveFunctionOne(int n) {

        if (n <= 1) {
            return;
        }

        for (int i = 0; i < n; i++) {
            // O(1) work.
        }
        recursiveFunctionOne(n/2);
        recursiveFunctionOne(n/2);

    }


    /**
     * In this case, the equation is : t(n) = 2t(n-1) + c

     * So, c is the root of the recursion tree and at every step,
     * The amount of work done would be c, 2c, 4c..
     * This is a geometric progression, sum of c(1 + 2 + 4 + 8..)
     * The height of the tree is n
     *
     * Since it's a geometric progression (a * r^n - 1)/ (r - 1) for n terms (since n is reduced by 1 for every iteration)
     * Direct time complexity ignoring constants is 2^n
     * Therefore, 2^n is the time complexity.
     */
    public static void recursiveFunctionTwo(int n) {
        // O(1) work.

        recursiveFunctionTwo(n - 1);
        recursiveFunctionTwo(n - 1);

    }

    /**
     * Similarly consider the equation t(n) = 2t(n/2) + c
     * From the recursion tree : c, 2c, 4c..
     * Length of the tree : log n
     * So from geometric progression (a * r^n - 1)/ (r - 1) :
     *  r = 2 and n = log n, r^n = 2^(log 2(base) n) = n
     * Time complexity = n.


     * In certain cases, it would be hard to get the complexity from recursion tree
     * But we will still be able to get the upper bound.
     * Example : t(n) = t(n/4) + t(n/2) + cn
     *
     */
}
