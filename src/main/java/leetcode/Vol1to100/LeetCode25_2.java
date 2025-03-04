package leetcode.Vol1to100;

import commonutils.leetcode.ListNode;

public class LeetCode25_2 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return head;
        }

        int totalLen = getLen(head);
        ListNode dummyNode = new ListNode();
        ListNode ptr = dummyNode;
        dummyNode.next = head;
        while (totalLen >= k) {
            totalLen = totalLen - k;
            ListNode preNode = null;
            ListNode curNode = ptr.next;
            for (int i = 1; i <= k; i++) {
                ListNode nextNode = curNode.next;
                curNode.next = preNode;
                preNode = curNode;
                curNode = nextNode;
            }

            ListNode ptrNext = ptr.next;
            ptr.next.next = curNode;
            ptr.next = preNode;
            ptr = ptrNext;
        }

        return dummyNode.next;
    }

    private int getLen(ListNode head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
    }
}
