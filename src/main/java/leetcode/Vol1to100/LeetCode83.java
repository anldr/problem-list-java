package leetcode.Vol1to100;

import commonutils.leetcode.ListNode;

public class LeetCode83 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode ptr = head;
        while (ptr.next != null) {
            if (ptr.val == ptr.next.val) {
                ptr.next = ptr.next.next;
            } else {
                ptr = ptr.next;
            }
        }
        return head;
    }
}
