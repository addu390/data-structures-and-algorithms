package problems.blindAll.linkedlist;

/**
 * Floyd's Tortoise and Hare
 * Think of it as a gap between slow and fast, slow increase by 1 and fast decreses it by 2
 */
public class CycleInLinkedList {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
