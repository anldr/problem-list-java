package leetcode.Vol101to200;

import commonutils.leetcode.ListNode;

public class LeetCode142 {
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode slowPt = head;
        ListNode fastPt = head;
        while (fastPt != null) {
            if (fastPt.next == null) {
                return null;
            }

            slowPt = slowPt.next;
            fastPt = fastPt.next.next;
            if (slowPt == fastPt) {
                break;
            }
        }

        if (slowPt == fastPt) {
            ListNode stNode = head;
            while (stNode != slowPt) {
                stNode = stNode.next;
                slowPt = slowPt.next;
            }
            return stNode;
        }

        return null;
    }
}
