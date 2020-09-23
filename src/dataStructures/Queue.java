package dataStructures;

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
public class Queue {

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
     */
    public static void queue() {

    }
}
