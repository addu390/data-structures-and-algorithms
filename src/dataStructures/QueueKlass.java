package dataStructures;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Adding to a queue: enqueue
 * Removing from a queue: dequeue
 * FIFO: First In First Out
 *
 * Applications:
 * Single resource with multiple consumers which are to served in their arrival order.
 * Sync between slow and fast devices.
 * OS - Waiting for resources.
 * FCFS - First Come First Serve (FIFO)
 * Computer Networks, incase  when a fast link sends data to a slow link (Router queue for the flow link).
 */
public class QueueKlass {

    public static void main(String[] args) {

    }

    /**
     * enqueue
     * dequeue
     * size
     * getFront
     * getRear
     * isFull
     * isEmpty
     *
     * Array Implementation:
     * The simple implementation using an Array is to add an element to the queue and dequeue removes the index 0 and
     * does a left shift, hence complexity of dequeue is O(n)
     * However, this can be prevented using a circular Array.
     * Enqueue and dequeue with modulo capacity, hence adding to an array when capacity is full (but start index is free)
     * Dequeue: Size + 1 modulo size = 1.
     * Don't forget to increment the index of top.
     * MOD: is the reminder after diving from an other number (6/5 = 1)
     *
     * Variables required in Queue class:
     * Front
     * Size
     * Array
     * Rear (Not required), as Rear = (Front + Size - 1) % capacity.
     *
     * Enqueue: if (Full) - Return
     * rear = (rear + 1) % capacity
     * size ++
     *
     * Dequeue: If Empty - Return
     * front = (front + 1) % capacity
     * size --
     *
     * LinkedList Implementation:
     * Using a Singly linked list - To ensure Enqueue and Dequeue is O(1)
     * Pointers for Head and Tail are required.
     * Add items to the rear and current_rear.next = new rear (rear = new rear)
     * Remove elements from the front (Head).
     * (Front - remove it item, rear - add the item).
     */
    public static void queue() {

        /**
         * Java: Queue is an interface, the backing data structure can be an Array or a LinkedList.
         * Queue interface implementation: LinkedList and ArrayDequeue.
         * Collections - Queue - LinkedList and ArrayDequeue.
         * Preferred: Array dequeue - Since it's an array implementation and cache friendly.
         *
         * Implement a stack using queue.
         * Q1 and Q2 (Auxiliary)
         * 1. Pop all elements from Q1 and push to Q2
         * 2. Add new element to Q1
         * 3. Pop from Q2 and Push to Q1
         * Push complexity O(n), other operations are O(1)
         *
         * Reverse a queue: Use a stack to reverse the order and pop it back to the queue.
         * Time Complexity: O(n)
         */
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(10);
        q.offer(20);
        q.remove();
        q.remove();

    }

    public static void reverse(Queue<Integer> q) {
        if (q.isEmpty()) {
            return;
        }
        int x = q.peek();
        q.remove();

        reverse(q);
        q.add(x);
    }

    /**
     * Give two numbers, example: 5 and 6
     * Print the first N numbers containing only 5 and 6 in an ascending order.
     * Output: 5, 6, 55, 56, 65, 66, 555, 556, 656, 666
     * Add 5 and 6 to a queue, pop 5 and append 5 and 6 (55 and 56) - and add it to queue and pop 5.
     * and do the same for all elements in the queue.
     * ""   -> 5 -> 55 -> 555
     *                 -> 556
     *           -> 56
     *      -> 6 -> 65
     *           -> 66
     * Similar to the above tree.
     */
}
