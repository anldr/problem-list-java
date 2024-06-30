package leetcode.Vol1to100;

import commonutils.leetcode.ListNode;

public class LeetCode25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummyNode = new ListNode(-1);
        ListNode preNode = dummyNode;
        dummyNode.next = head;
        while (head != null) {
            ListNode tail = preNode;
            for (int i = 0; i < k; i++) {
                tail = tail.next;
                if (tail == null) {
                    return dummyNode.next;
                }
            }

            ListNode next = tail.next;
            ListNode[] result = reverseList(head, tail);
            head = result[0];
            tail = result[1];
            preNode.next = head;
            preNode = tail;
            head = next;
        }

        return dummyNode.next;
    }

    private ListNode[] reverseList(ListNode head, ListNode tail) {
        ListNode preNode = tail.next;
        ListNode movePtr = head;
        while (preNode != tail) {
            ListNode next = movePtr.next;
            movePtr.next = preNode;
            preNode = movePtr;
            movePtr = next;
        }
        return new ListNode[]{tail, head};
    }
}
