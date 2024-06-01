package leetcode.Vol1to100;

import commonutils.leetcode.ListNode;

public class LeetCode61 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }

        int totNode = 0;
        ListNode ptr = head;
        while (true) {
            totNode++;
            if (ptr.next == null) {
                ptr.next = head;
                break;
            }
            ptr = ptr.next;
        }

        ptr = head;
        int idx = totNode - k % totNode;
        for (int i = 1; i < idx; i++) {
            ptr = ptr.next;
        }

        ListNode result = ptr.next;
        ptr.next = null;

        return result;
    }
}
