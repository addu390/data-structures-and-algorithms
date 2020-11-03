package algorithms;

public class BackTracking {

    /**
     * In most cases, a backtracking solution will have a isSafe function, which prevents generation of further recursions.
     * Backtracking is a general algorithm for finding all (or some) solutions to some computational problems,
     * notably constraint satisfaction problems, that incrementally builds candidates to the solutions,
     * and abandons a candidate ("backtracks") as soon as it determines that the candidate
     * cannot possibly be completed to a valid solution
     */
    public static void main(String[] args) {

        String str = "ABC";
        int n = str.length();
        permute(str, 0, n - 1);

        System.out.println(Math.floor(0.99));

    }

    /**
     * N queen problem: in a N x N chess board, place queens such that they do not attach each other.
     * Print all permutations that does not contain a given sub-string.
     * Rat in a Maze - A binary matric, with 0 (Block) and 1 (Pass), rat starts from top left and cheese at bottom right.
     (https://www.geeksforgeeks.org/rat-in-a-maze-backtracking-2/) - If there is a way, return the matrix with the path taken.
     * Sudoku Problem.
     */


    /**
     * Print all permutations which do not have a substring.
     * Example: Print all permutations of ABC, which do not contain sub-string "AB"
     * Below is the algorithm for all permutations (permute), add an if condition to check for a sub-string would work.
     * Time complexity: O(n*n!)
     */
    public static void permute(String str, int l, int r) {
        if (l == r) {
            System.out.println(str);
        } else {
            for (int i = l; i <= r; i++) {

                // Stop the permutation if the substring is found.
                if (isSafe(str, l, i, r)) {
                    str = swap(str, l, i);
                    permute(str, l + 1, r);

                    // Swap - Get the original string back.
                    str = swap(str, l, i);
                }
            }
        }
    }

    private static String swap(String a, int i, int j) {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }

    private static boolean isSafe(String str, int i, int l, int r) {
        // If previous character was 'A'
        // and  character is 'B', then
        // do not proceed and cut down the
        // recursion tree.
        if (l != 0 && str.charAt(l - 1) == 'A'
                && str.charAt(i) == 'B')
            return false;

        // This condition is explicitly required
        // for cases when last two characters
        // are "BA". We do not want them to
        // swapped and become "AB"
        if (r == l + 1 && str.charAt(i) == 'A'
                && str.charAt(l) == 'B'
                || r == l + 1 && l == i
                && str.charAt(r) == 'B'
                && str.charAt(l) == 'A')
            return false;

        return true;
    }

    /**
     * Su-do-ku: To solve it, the naive approach is (Number of spaces)^9
     * But the idea here is to solve it with lesser time complexity, using backtracking.
     * A perfect example for backtracking:
     * <p>
     * Start from 1 to 9
     * The isSafe function checks if that element is already present in the same row/column
     * Check if that element is already present in the sub-box.
     * If False, try with the next number.
     * But there is a possibility that a condition fails, in such cases, back track to the parent call and change the element.
     * Back to the parent's parent and so on until a correct solution is obtained.
     * Solution: https://www.geeksforgeeks.org/sudoku-backtracking-7/
     * <p>
     * Solution:
     * 1. o(n^2) -> Find an empty cell (If There are no empty cells, returns True)
     * 2. For the empty cell, check for safety for 1 (if False, increment until 9).
     * 3. If True from IsSafe, put the element in the grid and move to the next empty cell -> Recursively call the function,
     * since the position is filled, the next slot will be selected.
     * 4. If the function name is "sudoku" for example, if (sudoku()) { return true;} else {a[i][j] = 0}
     * replacing it with zero to backtrack and try with the next number, for example if 3 failed eventually, try with 4.
     * 5. In the worsrt case, if none of them work, return False.
     */
}

