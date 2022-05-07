package problems.leetcode;

public class Driver {

    public static void main(String[] args) {
        // A general tip to subtract with the start of the number '0' or the character 'a'
        // to get the offset, in other words the ith number or alphabet.
        char input = '5';
        int test = input - '0'; // 5

        /**
         * https://www.youtube.com/watch?v=DKCbsiDBN6c
         *
         * Backtracking: When there are multiple solutions and you want all the solutions.
         * The brute force approach (Example: Generate Parenthesis)
         * An other: 3 spots, 3 people, how many possible arrangements: 3!
         * All arrangements: State Space Tree.
         * Backtracking problem will have constraints, check for those and add that to the solution.
         *
         * Notes:
         * - Brute Force approach finds all the possible solutions and selects desired solution per given the constraints.
         * - Dynamic Programming also uses Brute Force approach to find the OPTIMUM solution, either maximum or minimum.
         * - Backtracking also uses Brute Force approach but to find ALL the solutions.
         * - Solutions to the Backtracking problems can be represented as State-Space Tree.
         * - The constrained applied to find the solution is called Bounding function.
         * - Backtracking follows Depth-First Search method.
         * - Branch and Bound is also a Brute Force approach, which uses Breadth-First Search method.
         *
         * Graph Coloring,N Queens, Sum of subsets, etc.
         */


        /**
         *** Bucket Sort:
         * Index i represents the number and value represents the count.
         * This way, iterating the bucket sort-array gives the sorted array.
         * However, the catch is, the max number has to be known and the time complexity is O(max number);
         * Example: [1, 1, 1, 2, 2, 100] -> [0:0, 1:3, 2:2, 3:0, 4:0 ....... 99:0, 100:1]
         *
         *** Variation os Bucket Sort:
         * Index i represents the count and value is a list of numbers with that count.
         * Time complexity O(n) and this arrangement is used to get Top k frequent elements.
         * Example: [1, 1, 1, 2, 2, 100] -> [1:[100], 2:[2], 3:[1], 4:[], 5:[], 6:[]].
         * <count:List<Input Number>>
         */
    }
}
