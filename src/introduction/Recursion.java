package introduction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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
        hanoi(2, "A", "B", "C");

        System.out.println(jos(5, 3));

        System.out.println(atoi("12345", 4, 0));

        List<Integer> ints = new ArrayList<Integer>();
        ints.add(10);
        ints.add(5);
        ints.add(2);
        ints.add(3);
        ints.add(6);
        subsetSum(ints, 0, 0);

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

    /**
     * TOWER OF HANOI
     * For those who don't know this game,
     * There are 3 towers A, B, C and tower A has certain number of disks
     * And all the disks of tower A has to be moved to tower B (You must be thinking, "That's easy")
     * But in the exact same order, so use tower B as the auxiliary tower.

     * Rules :
     * 1. Only one disk moves at a time.
     * 2. No larger disc above smaller disc (Even in auxiliary tower).
     * 3. Only the top disc of the tower can be moved.

     * Output :
     * Print the moves to be done to transfer all disc from A to C.
     * Hint : A (3 disc), takes 7 steps to move to C (Note that you can use tower A as well as auxiliary tower).
     *
     * Another hint (n = 3) :
     * 1. Move n - 1 discs from A to B, using C as auxiliary tower.
     * 2. Move larger/ bottom disk from A to C
     * 3. Move 2 discs in B to C using A as auxiliary tower
     */
    // FROM, AUX, TO
    // We say C is aux for n == 1 as well, though aux is not used.

    /**
     * T(n) = T(n - 1) + T(n - 1) + 1
     * T(n) = 2T(n - 1) + 1
     * Therefore, in the recursion tree, every level : 1, 2, 4, 8..
     * Complexity : 2^n
     * Number of movements : 2^n - 1 (For n = 3, 7 movements).
     */
    public static void hanoi(int n, String a, String b, String c) {
        if (n == 1) {
            // Base case, when there is only one disc, move from A to C
            System.out.println("Move disk " + n + " from " +  a + " to " + c);
            return;
        }
        // Move n - 1 discs from A to B, using C as auxiliary tower.
        hanoi(n - 1, a, c, b);

        // Move n -1 discs in B to C using A as auxiliary tower
        System.out.println("Move disk " + n + " from " +  a + " to " + c);
        hanoi(n - 1, b, a, c);
    }


    /**
     * JOSEPHUS PROBLEM
     * n people standing in a circle, kill every kth person.
     * And find the position of the survivor.
     * n = 7  and k = 3
     * Think of it as a Pistol is given to the 0th person and 2nd person is killed,
     * Pistol is now with 3rd person (Including him, move 3) - 5th person is now killed.
     * Pistol is now with 6th person - 1st person is killed.
     * And so on. (Survivor is person with index 3 - Which is the output).
     * Hint : When K = 2, the next person is killed (As the person holding the pistol is considered).
     *
     * Complexity :
     * T(n) = T(n - 1) + c
     * Therefore, O(n)
     */
    public static int jos(int n, int k) {
        if (n == 1) {
            return 0;
        }

        return (jos(n - 1, k) + k) % n;
    }

    /**
     * Find number of sub sets for the given sum
     * Example : Input : {10, 5, 2, 3, 6}, sum = 8
     * 2 subsets are possible with sum 8 : [5, 3] and [6, 2]
     * Output : 2
     * Corner case: If sum = 0, then output is always 1 (Empty set).

     * This problem is very similar to "powerSet", where we print all the possible subsets of a string.
     * Time complexity : 2^n
     */
    public static void subsetSum(List<Integer> ints, int current, int index) {

        // Now that you've the SUM of all the possible subset, add a condition for the given sum.
        if (index == ints.size()) {
            System.out.println(current);
            System.out.println("===========");
            return;
        }

        subsetSum(ints, current, index + 1);
        subsetSum(ints, current + ints.get(index), index + 1);

    }

    /* MORE PRACTICE PROBLEMS */
    /* https://www.geeksforgeeks.org/recursion-practice-problems-solutions/ */

    /**
     * function takes a string (which represents an integer) as an argument and returns its value.
     * The idea is separate the last digit, recursively compute result for remaining n-1 digits,
     * multiply the result with 10 and add the obtained value to last digit.
     */
    public static int atoi(String str, int index, int sum) {
        String[] strings = str.split("");

        if (index == -1) {
            return sum;
        }

        sum = sum + (Integer.parseInt(strings[index]) * (int) Math.pow(10, strings.length - 1 - index));
        return atoi(str, index - 1, sum);
    }
}
