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
     */
}
