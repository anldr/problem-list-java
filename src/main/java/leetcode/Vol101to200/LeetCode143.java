package leetcode.Vol101to200;

import commonutils.leetcode.ListNode;

public class LeetCode143 {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null ||head.next.next == null) {
            return ;
        }

        int totNode = 0;
        ListNode ptr = head;
        while(ptr != null) {
            totNode++;
            ptr = ptr.next;
        }

        ptr = head;
        int midIdx = totNode / 2;
        for (int i = 1; i < midIdx; i++) {
            ptr = ptr.next;
        }

        ListNode preNode = null;
        ListNode curNode = ptr.next;
        ptr.next = null;
        while (curNode != null) {
            ListNode nextNode = curNode.next;
            curNode.next = preNode;
            preNode = curNode;
            curNode = nextNode;
        }

        ptr = head;
        ListNode ptr2 = preNode;
        while (ptr != null && ptr2 != null) {
            ListNode next1 = ptr.next;
            ListNode next2 = ptr2.next;
            ptr.next = ptr2;
            ptr2.next = next1 == null ? next2 : next1;
            ptr = next1;
            ptr2 = next2;
        }
    }
}
