package leetcode.Vol101to200;

import commonutils.leetcode.ListNode;

public class LeetCode148_2 {
    public ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        }

        return sortList(head, null);
    }

    public ListNode sortList(ListNode head, ListNode tail) {
        if (head == null) {
            return null;
        }

        if (head.next == tail) {
            head.next = null;
            return head;
        }

        // step1. 快慢指针找中间
        ListNode slow = head;
        ListNode fast = head;
        while (fast != tail) {
            slow = slow.next;
            fast = fast.next;
            if (fast != tail) {
                fast = fast.next;
            }
        }

        ListNode mid = slow;
        ListNode link1 = sortList(head, mid);
        ListNode link2 = sortList(mid, tail);

        return mergeList(link1, link2);
    }

    public ListNode mergeList(ListNode link1, ListNode link2) {
        ListNode dummyNode = new ListNode(-1);
        ListNode curNode = dummyNode;
        while (link1 != null && link2 != null) {
            if (link1.val <= link2.val) {
                curNode.next = link1;
                link1 = link1.next;
                curNode = curNode.next;
            } else {
                curNode.next = link2;
                link2 = link2.next;
                curNode = curNode.next;
            }
        }
        curNode.next = link1 == null ? link2 : link1;

        return dummyNode.next;
    }
}
