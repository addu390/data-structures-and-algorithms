package problems.leetcode.stack;

import java.util.ArrayList;
import java.util.List;

// Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
// Input: n = 3
// Output: ["((()))","(()())","(())()","()(())","()()()"]
public class GenerateParentheses {

    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(0, 0, n, "", result);
        return result;
    }

    private static void backtrack(int openCount, int closeCount, int parenthesisCount, String string, List<String> result) {
        if (openCount == closeCount && openCount == parenthesisCount) {
            result.add(string);
            return;
        }

        if (openCount < parenthesisCount) {
            backtrack(openCount + 1, closeCount, parenthesisCount, string + "(", result);
        }

        if (openCount > closeCount) {
            backtrack(openCount, closeCount + 1, parenthesisCount, string + ")", result);
        }
    }

    public static void main(String[] args) {
        System.out.print(generateParenthesis(3));
    }
}
