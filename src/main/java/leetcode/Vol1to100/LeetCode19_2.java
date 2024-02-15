package leetcode.Vol1to100;

import commonutils.acwing.ListNode;

public class LeetCode19_2 {
    int curIndex = 0;

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return head;
        }

        head.next = removeNthFromEnd(head.next, n);
        curIndex++;
        if (curIndex == n) {
            return head.next;
        }

        return head;
    }
}
