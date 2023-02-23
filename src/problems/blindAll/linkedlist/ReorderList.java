package problems.blindAll.linkedlist;

// In a linkedList, easiest way to find the mid: Show and Fast pointer,
// when fast.next is null, slow is the mid point.

// Input: L0 → L1 → … → Ln - 1 → Ln
// Output: L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …

// In even case: division by half.
// In odd case, the first half is bigger, since it start with L0.
public class ReorderList {

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        ListNode mid = middleNode(head);
        ListNode first = head;
        ListNode second = reverse(mid);

        while (first != null && second != null) {
            ListNode temp1 = first.next;
            first.next = second;
            first = temp1;

            ListNode temp2 = second.next;
            second.next = first;
            second = temp2;
        }

        // Set next to tail for last node.
        if (first != null) {
            first.next = null;
        }
    }

    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // Mid point
        return slow;
    }

    public ListNode reverse(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode previous = null;
        ListNode current = head;

        while (current != null) {
            ListNode temp = current.next;
            current.next = previous;
            previous = current;
            current = temp;
        }
        return previous;
    }

    public static void main(String[] args) {

    }
}
