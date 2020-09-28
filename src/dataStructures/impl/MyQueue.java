package dataStructures.impl;

import java.util.Objects;

public class MyQueue {
    Node head;
    Node tail;
    int size;

    MyQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    public void enqueue(int x) {
        Node temp = new Node(x);
        if (Objects.isNull(head)) {
            head = temp;
            tail = temp;
        } else {
            tail.next = temp;
            tail = temp;
        }
        size++;
    }

    public void dequeue() {
        if (Objects.isNull(head)) {
            return;
        } else {
            head.next = head;

            // Handle the case, where there is only one element.
            if (Objects.isNull(head)) {
                tail = null;
            }
            size--;
        }
    }
}
