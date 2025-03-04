package leetcode.Vol1to100;

import commonutils.leetcode.ListNode;

public class LeetCode19_3 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return head;
        }

        ListNode dummyNode = new ListNode();
        ListNode secPtr = dummyNode;
        ListNode firNode = head;
        dummyNode.next = head;
        for (int i = 1; i <= n; i++) {
            firNode = firNode.next;
        }

        while (firNode != null) {
            firNode = firNode.next;
            secPtr = secPtr.next;
        }
        secPtr.next = secPtr.next.next;

        return dummyNode.next;
    }
}
