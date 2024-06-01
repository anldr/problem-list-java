package leetcode.Vol1to100;

import commonutils.leetcode.ListNode;

public class LeetCode82 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode ptr = head;
        ListNode dummyNode = new ListNode(-101);
        ListNode preNode = dummyNode;
        while (ptr != null) {
            if (ptr.next != null && ptr.val == ptr.next.val) {
                int curVal = ptr.val;
                while (ptr != null) {
                    if (ptr.val != curVal) {
                        break;
                    }
                    ptr = ptr.next;
                }
            } else {
                preNode.next = ptr;
                preNode = preNode.next;
                ptr = ptr.next;
            }
        }
        preNode.next = null;

        return dummyNode.next;
    }
}
