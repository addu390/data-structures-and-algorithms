package dataStructures.impl;

import java.util.ArrayList;

/**
 * Array implementation, Similarly the backing data-structure can be a LinkedList.
 * Using a Singly Linked List: Push and Pop the head of the LinkedList.
 * ie. Push operation changes the head of the LinkedList to the new element pushed.
 * Pop on the other hand, removed the head by making head.next the head.
 * Peek: Return head.
 * Hence, push, peek and pop operations take O(1) time complexity.
 * So size and isEmpty, maintain an other variable to keep track of the size.
 */
public class MyStack {

    ArrayList<Integer> arr;

    public MyStack() {
        arr = new ArrayList<>();
    }

    public void push(int data) {
        arr.add(data);
    }

    public int pop() {
        int result = arr.get(arr.size() - 1);
        arr.remove(arr.size() - 1);
        return result;
    }

    public int peek() {
        return arr.get(arr.size() - 1);
    }

    public int size() {
        return arr.size();
    }

    public boolean isEmpty() {
        return arr.isEmpty();
    }
}
