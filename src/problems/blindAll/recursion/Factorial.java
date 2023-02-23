package problems.blindAll.recursion;

public class Factorial {

    public static void main(String[] args) {

    }

    /**
     * Explanation :
     * fact(4) -> fact(3) -> fact(2) -> fact(1) -> fact(0)
     * fact(4) returns 4*6 <- fact(3) returns 3*2 <- fact(2) returns 2*1 <- fact(1) returns 1*1 <- (returns 1)
     * Final answer : 24
     * Note : Until the last or base problem returns (fact(0)), all the functions calls are in the function call stack.
     * (Once the call stack reaches the base case, it's starts unwinding, parent calls starts resuming from the point where they left)
     * Every time a child call is over, it is popped from the call stack, at the end of the problem, the stack is empty.
     */
    public static int factorialHead(int n) {
        // In this n = 0 is the base, where the problem
        // cannot be broken down to a much smaller problem
        if (n == 0) {
            return 1;
        }
        return n * factorialHead(n - 1);
    }

    public static int factorialTail(int n, int k) {
        if (k == 1) {
            return n;
        }
        return factorialTail(n * k, k - 1);
    }
}
