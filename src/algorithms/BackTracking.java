package algorithms;

public class BackTracking {

    /**
     * In most cases, a backtracking solution will have a isSafe function, which prevents generation of further recursions.
     *
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
        }
        else {
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
}
