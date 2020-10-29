package algorithms;

/**
 * Greedy Algorithms: Best Optimisation Algo.
 * A greedy algorithm is any algorithm that follows the problem-solving heuristic of making the
 * locally optimal choice at each stage
 *
 * https://en.wikipedia.org/wiki/Greedy_algorithm
 * Example: Given the coins 5, 10, 1 and 2.
 * What is the minimum number of coins to form 15 (5 + 10 -> 2)
 */
public class Greedy {

    /**
     * Activity Selection Problem
     * (a, b) -> a: start time and b: end time.
     * Maximum no of activities that can happen on a single tasking machine.
     * [(2, 3), (1, 4), (5, 8), (6, 10)]
     * (2, 3) and (1, 4) cannot be selected as the time overlaps (Single task machine).
     * (2, 3) and (5, 8) can be selected, or (1, 4) and (5, 8)..
     * Output: 2
     */
}
