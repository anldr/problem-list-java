package leetcode.Vol1to100;

import commonutils.leetcode.ListNode;

public class LeetCode24 {
    class Solution {
        public ListNode swapPairs(ListNode head) {
            ListNode dummy = new ListNode();
            ListNode dummyPre = dummy;
            ListNode pre = head;

            if (pre != null && pre.next == null) {
                return head;
            }

            while (pre != null && pre.next != null) {
                dummyPre.next = pre.next;
                ListNode temp = pre.next.next;
                pre.next.next = pre;
                pre.next = temp;
                dummyPre = dummyPre.next.next;
                pre = pre.next;
            }

            return dummy.next;
        }
    }
}
