package leetcode.Vol101to200;

import commonutils.leetcode.ListNode;

public class LeetCode141 {
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }

        ListNode moveNode1 = head;
        ListNode moveNode2 = head;
        while (moveNode2 != null) {
            if (moveNode2.next == null) {
                return false;
            }

            moveNode1 = moveNode1.next;
            moveNode2 = moveNode2.next.next;
            if (moveNode1 == moveNode2) {
                return true;
            }
        }

        return false;
    }
}
