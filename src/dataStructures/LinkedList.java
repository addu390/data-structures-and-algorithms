package dataStructures;

public class LinkedList {

    static Node head;

    static class Node {

        int data;
        Node next;

        Node(int d)
        {
            data = d;
            next = null;
        }
    }

    public static void main(String[] args) {
        findMiddle();
    }

    /**
     * Array-list: Store data in contiguous location.
     * Problem?: Since it is contiguous, pre-allocation of memory, however this is solved with dynamic sized arrays.
       Which is once again contiguous, incase the prior memory allocation don't have space,
       data is copied to a new location with higher size.
       The problem is, complexity becomes O(n) when the size has to be increased.
     * Problem 2: Insertion to the middle is costly, because rest of the elements should be moved (costly operation).
     * Problem 3: The same applies for deletion for an element.
     * Problem 4: Efficient implementation of queue and dequeue is not easy with arrays.
     */

    /**
     * Linear data-store.
     * But data need not have to be contiguous.
     * Because a reference of the next/previous is stored.
     * Deletion and insertion is not costly and pre-allocation of memory is not required.
     *
     * In a "singly linked list", to add ana element to the last, the complexity is O(n)
     * As we will have to traverse to the last node starting from the head.
     * However this problem is solved with Doubly linked list.
     *
     * In a doubly linked list, we have reference to next and previous,
     * precious of the "head" is "null" and next of "tail" is "null"
     * Can be traversed from both ways.
     * Advantage: With the known node to be deleted, complexity is O(1).
     * Where as in a singly linked list, to get the previous node, we will have to traverse from the HEAD.
     * And doubly linked list can support deletion of the previous node of a given node.
     * Perfect to implement a d-queue.
     *
     * Disadvantage: is the overhead to update next & previous for every operation
     * and extra space for each node to hold the reference of next and previous.
     *
     * Circular Linked List: The last node (tail) is connected back to the head.
     * Next of TAIL is referenced to head, typically, any node can be considered as the head.
     * Further, circular linked list can be a doubly linked list as well,
       the previous of the head would reference to the TAIL
     * Perfect for a Queue implementation.
     * Round Robin problems.
     */
    public static void linkedList() {
        java.util.LinkedList linkedList = new java.util.LinkedList();

        linkedList.addFirst(10);
        linkedList.addFirst(20);
        linkedList.addFirst(30);
    }

    /**
     * Find the middle of a singly linked list.
     * Use 2 pointers, one that increments one at a time and the other that increments 2 at a time.
     * Therefore, when pointer #2 reaches the end, pointer #1 would point to the middle.
     */
    public static void findMiddle() {
        LinkedList list = new LinkedList();
        list.head = new Node(85);
        list.head.next = new Node(15);
        list.head.next.next = new Node(4);
        list.head.next.next.next = new Node(20);

        Node slow = list.head;
        Node fast = list.head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        System.out.println(slow.data);
    }

    public static Node reverse(Node head) {
        Node current = head;
        Node previous = null;

        while (current != null) {
            Node next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        return previous;
    }

    /**
     * Check if a singly linked list has a loop.
     * Method #1: The brute force approach if with a complexity of O(n^2)
     *
     * Method #2: O(n) solution would be have an other field in Node called "isVisited" and check the boolean in next operation.
     * But this approach, changes the structure of Node class.
     *
     * Method #3: This approach modifies the linked list, after next next operation, the previous Node "next" points to a dummy node.
     * Therefore, whenever the next of Node is the "dummy node", it refers to presence of Loop in the LinkedList.
     * Destroys the linked list.
     *
     * Method #4: Store all nodes in a HashSet and check if it is already present, if yes -> there's a loop.
     * Space complexity of O(size of linked list).
     *
     * Method #5: Floyd's Cycle: 2 pointers, one moves one point at a time, and the other moves points at a time.
     * If there is a loop, the two pointers will meet.
     */

    /**
     * LRU Cache Design:
     * LRU: Least Recently Used
     * Based on temporal locality: Which means that an item accessed now is very likely to be accessed in the near future.
     * The most recently used item is at the top, in case of a MISS, the last item is removed and the new item is added to the top.
     * Terminology: HIT and MISS.
     * Data structure for this implementation?
     * If an Array is used, Both HIT and MISS will have a time complexity of O(n).
     *
     * Find a data structure such that HIT and MISS has a complexity of O(1) on an average.
     * Quick Answer: Doubly Linked List with Hashing.
     * Step #1: Number 10 is accessed (MISS), Create a Doubly Linked List with Head (Node) as 10 and a HashMap with (10, Node).
     * Step #2: Number 20 is accessed (MISS), Change head to 20 and HashMap with (10, Node) and (20, Node).
     * Step #3: Number 10 is accessed (HIT), check in the HaspMap (10 is present), Make that node the Head of the Linked List.
     * To remove the last Node, a tail pointer (c++) or reference (Java) is maintained in the Linked List.
     */

    /**
     * Given a Singly Linked List, check if the LinkedList is Palindrome or not.
     * Naive Approach: To use a stack (First In Last Out).
     * First For loop: PUSH all elements of the linked list into the Stack.
     * Second For loop: POP elements and check if the elements match - If YES: PALINDROME.
     * O(n) time complexity and Auxiliary space.
     *
     * An other approach with O(n) time complexity and O(1) Auxiliary Space.
     * Find the middle node using two pointer (SLOW - x1 and FAST - x2).
     * Reverse all elements after middle node.
     * Compare Node from First and Middle.
     * If they are same - PALINDROME.
     */

    /**
     * Linked List problems: http://cslibrary.stanford.edu/105/LinkedListProblems.pdf
     */


}
