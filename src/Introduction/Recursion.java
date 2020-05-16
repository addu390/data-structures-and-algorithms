package Introduction;

import java.util.Arrays;
import java.util.Collections;

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
        System.out.println("Palindrome: " + palindrome("AABAA", 0, 4));
        System.out.println("Palindrome: " + palindrome("ABBA", 0, 3));

        System.out.println("Sum of numbers: " + sumOfNumbers(12345, 0, 0));

        System.out.println("Sum of numbers: " + sumOfNumbers(12345));

        System.out.println("Max rope cuts: " + ropePieces(5, 1, 2, 5));

        powerSet("abc", "", 0);

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

     * Writing base cases in recursion :
     * Finding and writing the base case is quite crucial so that we don't end up in Stack overflow error.
     * Base case is when the problem cannot be broken into much smaller problems.
     * Example : For factorial, the base case is n = 0;
     */

    /**
     * Find the nth fibonacci number (0 1 1 2 3 5 8), example :
     * Input : n = 3, output : 2
     */
    public static int fibo(int n) {
        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }
        return fibo(n - 1) + fibo(n - 2);
    }

    /**
     * Write a recursive function to find sum of all digits in a number.
     * This problem can be solved in several, since we already solved the palindrome using recursion,
     * A similar technique would be :
     */
    public static int sumOfNumbers(int n, int sum, int k) {
        String[] strings = Integer.toString(n).split("");
        if (strings.length == k) {
            return sum;
        }

        sum = sum + Integer.parseInt(strings[k]);
        return sumOfNumbers(n, sum, k + 1);
    }

    /**
     * There's a better way of solving this.
     * Hint #1 : n / 10 will give the number without the last digit (For integers).
     * Hint #2 : n % 10 will give the last digit of the number (Reminder when divided by 10).
     */
    public static int sumOfNumbers(int n) {

        if (n < 10) {
            return n;
        }

        return sumOfNumbers(n / 10) + (n % 10);

    }

    /**
     * A slightly harder problem in recursion :
     * Given a rope of length n, you need to fine the maximum number of pieces you can make such
     * that the length of every piece is in the set {a, b, c} for the given three values a, b, c.

     * Example : n = 5, a = 5, b = 3, c = 1
     * Output : 5

     * Example : n = 5, a = 2, b = 4, c = 6
     * Output : -1 (Since the rope length is odd and pieces are even)

     * Example : n = 23, a = 12, b = 11, c = 9
     * Output : 2

     * The idea is to construct a recursion tree, ever each node will have 3 child,
     * the last node will be -1 (Cannot be exactly cut to any of the three choices) or
     * 0 if it was exactly cut.
     * Now, at each level the max of the 3 are taken (Number of exact cuts).

     * Note that this solution is not the best way, better way would be using dynamic programming.
     * Upper bound time complexity is 3^n
     * With DP (Dynamic programming), it can be solved with O(n) - Will be discussed in the DP section.
     */
    public static int ropePieces(int n, int a, int b, int c) {

        if (n == 0) {
            return 0;
        }

        if (n < 0) {
            return -1;
        }

        int res = Collections.max(Arrays.asList(
                ropePieces(n - a, a, b, c),
                ropePieces(n - b, a, b, c),
                ropePieces(n - c, a, b, c)));

        if (res < 0) {
            return -1;
        }
        // Common mistake: Don't return 0 if n == 0, as 0 means to say that it was a exact cut,
        // So we should return 1.
        return res + 1;

    }

    /**
     * Input : "abc"
     * Output : "", "a", "b", "c", "ab", "ac", "bc", "abc"
     * This problem is already discussed (powerSet in BitwiseOperators)
     * Solve using recursion.
     */
    public static void powerSet(String s, String current, int index) {
        String[] strings = s.split("");

        if (index == strings.length) {
            System.out.println(current);
            return;
        }

        powerSet(s, current, index + 1);
        powerSet(s, current + strings[index], index + 1);
    }


}
