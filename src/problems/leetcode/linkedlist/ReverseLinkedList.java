package problems.leetcode.linkedlist;

 class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode current = head;
        ListNode previous = null;

        while (current != null) {

            ListNode temp = current.next;
            current.next = previous;
            previous = current;
            current = temp;
        }

        return previous;

    }
}
