package problems.leetcode.stack;

import java.util.Stack;

public class SimplifyPath {

    // "." is current directory.
    // ".." going back by a directory
    // "/a" going to directory a
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();

        StringBuilder stringBuilder = new StringBuilder();

        String[] paths = path.split("/");

        for (int i = 0; i < paths.length; i++) {
            if (!stack.isEmpty() && paths[i].equals("..")) {
                stack.pop();
            } else if (!paths[i].equals("..") && !paths[i].equals(".") && !paths[i].equals("")) {
                stack.add(paths[i]);
            }
        }

        if (stack.isEmpty()) {
            return "/";
        }

        while (!stack.isEmpty()) {
            stringBuilder.insert(0, stack.pop()).insert(0,"/");
        }

        return stringBuilder.toString();
    }
}
