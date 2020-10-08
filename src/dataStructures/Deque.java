package dataStructures;

import java.util.ArrayDeque;

/**
 * Doubly ended queue -> Deque
 * insertFront
 * insertRear
 * getFront
 * getRear
 * isFull
 * isEmpty
 * size
 *
 * Implementation:
 * 1. Array: Circular Array (With indexes for Front and Rear - Or Size).
 * 2. LinkedList: Using a doubly linked list with pointers for Head and Rear.
 *
 * Deque:
 * 1. Can be used as a a stack or a queue.
 * 2. Buffer.
 * 3. Steal process scheduling algorithm. (If p2 queue is free, it can take elements from p1 rear).
 * 4. 2 priority queue - Add a priority item to the front of the queue, if not to the rear.
 */
public class Deque {

    public static void main(String[] args) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.addLast(1);
        deque.addFirst(10);
        deque.removeFirst();
        deque.removeLast();

    }

}
