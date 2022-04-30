package problems.leetcode.linkedlist;

public class RemoveElement {

    public static ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }

        ListNode root = head;

        while (root.next != null) {
            if (root.next.val == val) {
                root.next = root.next.next;
            } else {
                root = root.next;
            }
        }

        if (head.val == val) {
            return head.next;
        } else {
            return head;
        }
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(7);
        root.next = new ListNode(7);
        root.next.next = new ListNode(7);
        root.next.next.next = new ListNode(7);
        removeElements(root, 7);
    }
}
