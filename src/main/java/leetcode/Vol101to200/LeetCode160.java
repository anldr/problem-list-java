package leetcode.Vol101to200;

import commonutils.leetcode.ListNode;

public class LeetCode160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode ptA = headA;
        ListNode ptB = headB;
        while (ptB != ptA) {
            ptA = ptA == null ? headB : ptA.next;
            ptB = ptB == null ? headA : ptB.next;
        }

        return ptB;
    }
}
