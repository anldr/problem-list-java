package leetcode.Vol1to100;

import commonutils.leetcode.ListNode;

public class LeetCode86 {
    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return null;
        }

        ListNode smallDummy = new ListNode();
        ListNode largeDummy = new ListNode();
        ListNode smallPtr = smallDummy;
        ListNode largePtr = largeDummy;

        while (head != null) {
            if (head.val < x) {
                smallPtr.next = head;
                smallPtr = smallPtr.next;
            } else {
                largePtr.next = head;
                largePtr = largePtr.next;
            }
            head = head.next;
        }
        largePtr.next = null;
        smallPtr.next = largeDummy.next;

        return smallDummy.next;
    }
}
