package dataStructures;


import dataStructures.impl.MyStack;

import java.util.ArrayDeque;
import java.util.Objects;

/**
 * Stack Data Structure, A linear Data Structure.
 * Think of it at a Box open at the top and closed on all the other sides (First In Last Out).
 * Insertion: PUSH, Removal: POP.
 * Operations: push, pop, isEmpty, peek (return the value of top of the stack), size.
 *
 * Underflow and Overflow:
 * Underflow: pop/peek on an empty stack.
 * Overflow: push on a full stack.
 *
 * Backing data structure:
 * 1. Array Implementation of Stack in Java (Search for MyStack.java)
 */
public class Stack {

    public static void main(String[] args) {
        stack();

        int[] span = new int[]{13, 15, 12, 14, 16};
        stockSpan(span);
        stockSpanV2(span);
        previousGreatestElement(span);
        nextGreatestElement(span);
    }

    /**
     * Application of stack data structure:
     * 1. Function calls (LIFO).
     * 2. Checking for balanced parenthesis.
     * 3. Reversing items.
     * 4. Infix to prefix/postfix.
     * 5. Evaluation of prefix/postfix.
     * 6. Stock span problem and it's variations.
     * 7. Undo/Redo operations.

     * Stack - Java Collections:
     * Stack and ArrayDeque
     * Collection -> List -> Vector -> Stack
     * Collection -> Queue -> Deque -> ArrayDeque
     * Preferred: ArrayDeque, as Vector has an unnecessary over head of being thread safe.
     */
    public static void stack() {
        MyStack stack = new MyStack();
        stack.push(10);
        stack.push(20);
        System.out.println(stack.pop());
        System.out.println(stack.peek());

        ArrayDeque<Integer> s2 = new ArrayDeque<>();
        s2.push(10);
        s2.push(20);
        s2.pop();

        System.out.println(isBalanced("{()}"));
        System.out.println(isBalanced("{()}]"));



    }

    /**
     * Check if there are balanced parenthesis.
     * ie, number of opening and closing are same and valid (positions).
     * Solving this using a stack is the best approach.
     * The approach is simple: the last opening bracket has to close first.
     * Hence when ever you see a opening bracket, push it to the stack.
     * Whenever there is a closing bracket, the the peek/pop bracket should be of the same type!
     * If NOT, the parenthesis are not balanced.
     */

    public static boolean isBalanced(String s) {
        String[] strings = s.split("");
        ArrayDeque<String> stack = new ArrayDeque<>();

        for (int i = 0; i < strings.length; i++) {
            if (Objects.equals(strings[i], "{") || Objects.equals(strings[i], "(") || Objects.equals(strings[i], "[")) {
                stack.push(strings[i]);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                else if (!matchBracket(stack.peek(), strings[i])) {
                    return false;
                }

                else {
                    stack.pop();
                }

            }
        }
        return stack.isEmpty();
    }

    private static boolean matchBracket(String s1, String s2) {
        if (s1.equals("{") && s2.equals("}") || s1.equals("(") && s2.equals(")") || s1.equals("[") && s2.equals("]")
        ) {
            return true;
        } else {
            return false;
        }

    }

    /**
     * Two stacks in a single array.
     * The top for stack one is arr[0] and top for stack two is arr[arr.size]
     * The stack two does not start from middle of the array for efficient use of space between the two stacks.

     * K stacks in an array:
     * Input - push(stack number), but all the stack are present in the same array.
     * The easy approach: have start and end defined for each stack, but this would result - inefficient use of space.
     * Though there is space in the second stack, the first stack cannot push more elements.
     *
     * Solution:
     * stackArray - The actual stack
     * Array top[]: holds the top of all the K arrays, which is initially [-1, -1, -1] for K = 3.
     * Let's say the stack names are 0, 1, 2.
     * stack.push(10, 0) -> push 10 to 0th stack
     * stack.push(20, 0) -> push 20 to 0th stack
     *
     * nextArray: Holds the next element in the stack, example: next of 20 is 10. [1, 2, 3.., -1]
     * Variable freeTop: 0 (initial value)
     *
     * Example: stack.push(10, 0)
     * 1. Now that freeTop is 0, stackArray[freeTop] = 10
     * 2. freeTop = freeTop + 1 -> (freeTop = 1)
     * 3. Update nextArray[] with previous Top -> nextArray[0] = -1. (next element of the stack is below it).
     * 4. Update top[] -> top[0] = 0
     */

    /**
     * Stock span, what is span: consecutive number of days before the current number
     * (including the current number - so minimum span is 1) which is lesser or equal.
     * Example: [13, 15, 12, 14, 16]: [1, 2, 1, 2, 5]
     * Given an array, find the stock span of the array.
     * Naive approach: O(n^2)
     */
    public static void stockSpan(int[] array) {
        int[] spanArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            int span = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (array[j] <= array[i]) {
                    span = span + 1;
                } else {
                    break;
                }
             }
            spanArray[i] = span;
        }

        for (int i = 0; i < spanArray.length; i++) {
            System.out.println(spanArray[i]);
        }
    }

    /**
     * Efficient solution for stock span.
     * For element find the closest greater element on the left of it.
     * SPAN = Current index - index of closest greater element is the span.
     * If there is no closest greater element, then SPAN = current + 1
     */
    public static void stockSpanV2(int[] array) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int[] spanArray = new int[array.length];

        stack.push(0);
        spanArray[0] = 1;

        for (int i = 1; i < array.length; i++) {
            while (!stack.isEmpty() && array[stack.peek()] <= array[i]) {
                stack.pop();
            }
            spanArray[i] = stack.isEmpty() ? i + 1 : i - stack.peek();
            stack.push(i);
        }

        System.out.println("=====================");
        for (int i = 0; i < spanArray.length; i++) {
            System.out.println(spanArray[i]);
        }
    }

    /**
     * Previous greater element on the left of every element in an array.
     * The implementation is similar as explained above.
     */
    public static void previousGreatestElement(int[] array) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        int[] spanArray = new int[array.length];

        stack.push(array[0]);
        spanArray[0] = -1;

        for (int i = 1; i < array.length; i++) {
            while (!stack.isEmpty() && stack.peek() <= array[i]) {
                stack.pop();
            }
            spanArray[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(array[i]);
        }

        System.out.println("=====================");
        for (int i = 0; i < spanArray.length; i++) {
            System.out.println(spanArray[i]);
        }
    }

    /**
     * Similarly, the next greatest element:
     * It is the exact same version of the prior problem, instead start traversing the array in the reverse direction.
     */
    public static void nextGreatestElement(int[] array) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        int[] spanArray = new int[array.length];

        stack.push(array[array.length - 1]);
        spanArray[array.length - 1] = -1;

        for (int i = array.length - 2; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= array[i]) {
                stack.pop();
            }
            spanArray[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(array[i]);
        }

        System.out.println("=====================");
        for (int i = 0; i < spanArray.length; i++) {
            System.out.println(spanArray[i]);
        }
    }

    /**
     * Largest rectangle area in a histogram:
     * Naive solution: Find the total area possible for each bar, by finding the left and right min.
     * ie. stop after you find a smaller bar on the left and right of the current bar.
     * Complexity: O(n^2)
     *
     * Better solution O(n):
     * Find previous and next smaller element to find the area.
     * Just like the previousGreatestElement and nextGreatestElement, find previousSmallestElement and nextSmallestElement
     * Find the area for all such rectangles to find the biggest one
     * But because of the pre-computation of two arrays, the auxiliary space complexity is O(2n) -> O(n)
     */

    /**
     * Give a matrix (list if lists) -> of 1s and 0s
     * Find the largest rectangle with 1s - Sub matrix with 1s.
     * It is a largest rectangle area in a histogram,
     * example:
     * [[0, 1, 1, 0]
     *  [1, 1, 1, 1]
     *  [1, 1, 1, 1]
     *  [1, 1, 1, 0]]
     *
     *  Start from the start and find the area for each row:
     * [[0, 1, 1, 0]
     *  [1, 2, 2, 1]
     *  [2, 3, 3, 2]
     *  [3, 4, 0, 0]]
     *  Note: when zero is the base, it's not incremented (as that is not a contd 1s).
     */

    /**
     * get minimum from a stack at O(1)
     *
     * Solution #1: Have an Auxiliary stack such that the minimum element is always at the top.
     * Aux stack: Push the first element.
     * Push only if the successive push elements are smaller than the current aux peek.
     * As of pop, pop only when it is equal.
     * For aux: Push when it is smaller and pop when it is equal.
     *
     * Solution #2: Without Aux stack.
     */

}
