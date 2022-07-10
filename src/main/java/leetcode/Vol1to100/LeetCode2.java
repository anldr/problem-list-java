package leetcode.Vol1to100;

import commonutils.leetcode.ListNode;

public class LeetCode2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int mod = 0;
        ListNode head = new ListNode();
        ListNode dummyNode = head;
        while (l1 != null && l2 != null) {
            int addTemp = l1.val + l2.val + mod;
            ListNode nodeTemp = new ListNode(addTemp % 10);
            mod = addTemp / 10;
            dummyNode.next = nodeTemp;
            dummyNode = nodeTemp;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            int addTemp = l1.val + mod;
            ListNode nodeTemp = new ListNode(addTemp % 10);
            mod = addTemp / 10;
            dummyNode.next = nodeTemp;
            dummyNode = nodeTemp;
            l1 = l1.next;
        }

        while (l2 != null) {
            int addTemp = l2.val + mod;
            ListNode nodeTemp = new ListNode(addTemp % 10);
            mod = addTemp / 10;
            dummyNode.next = nodeTemp;
            dummyNode = nodeTemp;
            l2 = l2.next;
        }

        if (mod != 0) {
            ListNode nodeTemp = new ListNode(mod % 10);
            dummyNode.next = nodeTemp;
        }

        return head.next;
    }
}
