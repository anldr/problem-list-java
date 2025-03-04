package leetcode.Vol101to200;

import commonutils.leetcode.ListNode;

public class LeetCode143_2 {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return ;
        }

        ListNode slowPtr = head;
        ListNode fastPtr = head;

        while (fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next;
            if (fastPtr.next != null) {
                fastPtr = fastPtr.next;
            }
        }

        ListNode preNode = null;
        ListNode curNode = slowPtr.next;
        while (curNode != null) {
            ListNode nextNode = curNode.next;
            curNode.next = preNode;
            preNode = curNode;
            curNode = nextNode;
        }

        boolean flag = true;
        slowPtr.next = null;
        ListNode firLink = head;
        ListNode secLink = preNode;
        while (firLink != null && secLink != null) {
            if (flag) {
                ListNode nextNode = firLink.next;
                firLink.next = secLink;
                firLink = nextNode;
            } else {
                ListNode nextNode = secLink.next;
                secLink.next = firLink;
                secLink = nextNode;
            }
            flag = !flag;
        }
    }
}
