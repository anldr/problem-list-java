package leetcode.Vol101to200;

import commonutils.leetcode.ListNode;

public class LeetCode147 {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummyNode = new ListNode();
        while (head != null) {
            ListNode next = head.next;
            ListNode ptr = dummyNode;
            while (ptr.next != null && ptr.next.val <= head.val) {
                ptr = ptr.next;
            }
            head.next = ptr.next;
            ptr.next = head;
            head = next;
        }

        return dummyNode.next;
    }
}
