package leetcode.Vol1to100;

import commonutils.leetcode.ListNode;

public class LeetCode92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) {
            return head;
        }

        ListNode dummyNode = new ListNode();
        dummyNode.next = head;
        ListNode ptr = dummyNode;

        for (int i = 1; i <= left - 1; i++) {
            ptr = ptr.next;
        }

        ListNode preNode = null;
        ListNode curNode = ptr.next;
        for (int i = left; i <= right; i++) {
            ListNode next = curNode.next;
            curNode.next = preNode;
            preNode = curNode;
            curNode = next;
        }
        ptr.next.next = curNode;
        ptr.next = preNode;

        return dummyNode.next;
    }
}
