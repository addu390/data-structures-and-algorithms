package Introduction;

/**
 * Applications :
 * First step for dynamic programming is to come up with a solution using recursion.
 * Backtracking problem.
 * Divide and conquer, merge sort etc use recursive solutions.
 * Most of tree problems.

 * The idea is to break a problem into smaller problems, until it cannot be any further.
 */
public class Recursion {

    public static void main(String[] args) {
        // Driver code.
        System.out.println("Factorial is : " + factorial(4));

        practiceProblemOne(3);
        System.out.println("========================");

        practiceProblemTwo(5);
        System.out.println("========================");

        practiceProblemThree(5);
        System.out.println("========================");

        practiceProblemThreeDash(5, 1);

        System.out.println("Factorial is : " + factorialDash(4, 3));
        System.out.println(palindrome("AABAA", 0, 4));
        System.out.println(palindrome("ABBA", 0, 3));

    }

    /**
     * Let's start with a simple problem.
     * Find Factorial of a number.

     * Explanation :
     * fact(4) -> fact(3) -> fact(2) -> fact(1) -> fact(0)
     * fact(4) returns 4*6 <- fact(3) returns 3*2 <- fact(2) returns 2*1 <- fact(1) returns 1*1 <- (returns 1)
     * Final answer : 24
     * Note : Until the last or base problem returns (fact(0)), all the functions calls are in the function call stack.
     * (Once the call stack reaches the base case, it's starts unwinding, parent calls starts resuming from the point where they left)
     * Every time a child call is over, it is popped from the call stack, at the end of the problem, the stack is empty.
     */
    public static int factorial(int n) {
        // In this n = 0 is the base, where the problem
        // cannot be broken down to a much smaller problem
        if (n == 0) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    /**
     * Guess the output of the problem without running it.
     * Output : 3 2 1 1 2 3
     */
    public static void practiceProblemOne(int n) {
        if (n < 1) {
            return;
        } else {
            System.out.println(n);
            practiceProblemOne(n - 1);
            System.out.println(n);
        }
    }

    /**
     * Given a value of n, Example : 5, print 5 4 3 2 1
     */
    public static void practiceProblemTwo(int n) {
        if (n == 0) {
            return;
        }
        System.out.println(n);
        practiceProblemTwo(n - 1);
    }

    /**
     * Given a value of n, Example : 5, print 1 2 3 4 5
     */
    public static void practiceProblemThree(int n) {
        if (n == 0) {
            return;
        }
        practiceProblemThree(n - 1);
        System.out.println(n);
    }

    /**
     * TAIL RECURSION :
     * When the recursion function is the last thing that happens in the functions, it's called TAIL RECURSION
     * (TAIL RECURSION is faster), ie, practiceProblemTwo is faster than practiceProblemThree.
     * And this is because if compiler optimisation ("Go to start")
     * It is faster because of "tail call elimination", in practiceProblemTwo the control has to be go back to parent to
       complete the rest after recursion (when child function call is complete)
     * Example : Quick sort if TAIL RECURSIVE function (Hence faster than merge sort)
     */

    // Re-write practiceProblemThree as TAIL RECURSIVE

    /**
     * problem practiceProblemThree is now TAIL RECURSIVE
     */
    public static void practiceProblemThreeDash(int n, int k) {
        if (n == 0) {
            return;
        }
        System.out.println(k);
        practiceProblemThreeDash(n - 1, k + 1);
    }

    /**
     * Refer the function : factorial
     * Which is current not tail recursive, as the control has to be give to parent to multiple by n.
     * Re-write to make it tail recursive.
     */
    public static int factorialDash(int n, int k) {
        if (k == 1) {
            return n;
        }
        return factorialDash(n * k, k - 1);
    }

    /**
     * Given a string, check if it is PALINDROME or not.
     * Example :  A A B A A is palindrome.
     */
    public static boolean palindrome(String string, int i, int k) {
        String[] strings = string.split("");

        if (strings[i].equals(strings[k])) {
            // Base case
            // i == k is for odd string and k - i == 1 for even string.
            if (i == k || k - i == 1) {
                return true;
            }
        } else {
            return false;
        }
        return palindrome(string, i + 1, k - 1);
    }

    /**
     * PATTERN :
     * A Recursion problem always has a base case (Last smaller problem)
     * and a recursion return call (unless there are global variables involved)
     */

}
