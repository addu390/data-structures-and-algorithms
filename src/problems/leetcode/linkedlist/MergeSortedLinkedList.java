package problems.leetcode.linkedlist;

public class MergeSortedLinkedList {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        final ListNode result = new ListNode();
        ListNode holder = result;

        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                holder.next = list2;
                list2 = list2.next;
            } else {
                holder.next = list1;
                list1 = list1.next;
            }
            holder = holder.next;
        }
        holder.next = list1 != null ? list1 : list2;
        return result.next;
    }
}
