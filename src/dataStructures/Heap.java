package dataStructures;

/**
 * Common use-case: Priority Queue
 * Min heap (lowest value is at the top) and Max heap (highest value at the top)
 * Complete binary tree: all levels are filled and last level may not be but filled from left.
 * Binary Heap is a Complete Binary tree
 *
 * The entire BST can be store in an array.
 * with i being the index, left(i) = 2i + 2, right(i) = 2i + 2, parent(i) = (i - 1)/2
 *
 * Min Heap: All the descendants are always greater than the node.
 * The root node is always the smallest value in the entire heap.
 * Similarly Max heap, the root node has the highest value in the heap.
 *
 * Taking the array implementation of MIn Heap, the insertions are not O(1).
 * As we have to ensure the the descendants are always greater.
 * Array representation of tye below MIN Heap: [10, 30, 40, 35, 36, 42 48]
 * Min Heap:
 * 10   -> 30 -> 35
 *            -> 36
 *      -> 40 -> 42
 *            -> 48
 * MIN HEAP Insert (Time complexity O(log N) - N being the size of the heap):
 * 1. Insert the element to the last index (To ensure it's a complete binary tree).
 * 2. Compare the element with parent -> (i-1)/2
 * 3. If element is Smaller than the parent -> swap with parent.
 * Keeping doing this, until the parent is smaller than the element or the root node is reached.
 * Complexity is the height of the binary tree -> log(size of tree)
 *
 * Heapify Operation: For building the heap and extract minimum.
 * Let's take an example, where an element is violating the property of a MIN heap.
 * How do we fix the min heap?
 * Check for the minimum of the left and right node, if there is a smaller element, swap and continue for rest of the sib-trees.
 * Heapify time complexity: O(log N)
 * With recursion, space complexity: O(H - Height)
 * Iterative solution: O(1) space complexity.
 *
 * To get min element, time complexity is O(1)
 * Extract minimum element:
 * 1. Swap Root with last index.
 * 2. Size =  size--
 * 3. Call heapify, hence complexity is same a Heapify -> O(log n)
 *
 * Given a index to delete the element.
 * Replace the value with negative Infinity, swap with last index and call heapify.
 *
 * Convert an array to a Min Heap:
 * One way is to call min heapify for all the nodes/elements in the array starting from the last parent index (X) until index 0.
 * X = ((size -1) -1)/2
 * Time complexity: Although it looks like O(n log n), it's O(n)
 *
 * Heap sort: Works similar to Selection/bubble sort - To first find the max element.
 * Similarly in heap sort, find the Max heap of the array -> O(n)
 * and then pop the max element and call heapify.
 * Hence the overall time complexity: O(n log n)
 *
 * Build heap: O(n)
 * Heap sort: O(n log n)
 *
 */
public class Heap {

}
