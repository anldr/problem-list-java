package leetcode.Vol1to100;

import commonutils.leetcode.ListNode;

public class LeetCode83_2 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode dummyNode = new ListNode(0, head);
        ListNode ptr = dummyNode;
        while (ptr.next != null && ptr.next.next != null) {
            int val = ptr.next.val;
            if (ptr.next.next.val == val) {
                while (ptr.next != null && ptr.next.val == val) {
                    ptr.next = ptr.next.next;
                }
            } else {
                ptr = ptr.next;
            }
        }

        return dummyNode.next;
    }
}
