package problems.blindAll.stack;

import java.util.HashSet;
import java.util.Stack;

public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        if (tokens.length == 1) {
            return Integer.parseInt(tokens[0]);
        }
        Stack<Integer> stack = new Stack<>();
        HashSet<String> set = new HashSet<>();
        set.add("+");
        set.add("-");
        set.add("*");
        set.add("/");

        for (int i = 0; i < tokens.length; i++) {
            if (set.contains(tokens[i])) {
                int one = stack.pop();
                int two = stack.pop();

                int result;

                if (tokens[i].equals("+")) {
                    result = two + one;
                } else if (tokens[i].equals("-")) {
                    result = two - one;
                } else if (tokens[i].equals("*")) {
                    result = two * one;
                } else {
                    result = two / one;
                }

                stack.push(result);

                if (i == tokens.length - 1) {
                    return result;
                }
            } else {
                stack.push(Integer.parseInt(tokens[i]));
            }
        }

        return -1;

    }
}
