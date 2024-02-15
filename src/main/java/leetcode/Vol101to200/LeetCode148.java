package leetcode.Vol101to200;

import commonutils.leetcode.ListNode;

public class LeetCode148 {
    public ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        }

        // step1. 计算链表长度
        int listLen = 0;
        ListNode tempNode = head;
        while (tempNode != null) {
            listLen++;
            tempNode = tempNode.next;
        }

        // step2. 逐步递增长度,两两合并
        ListNode dummyNode = new ListNode(-1, head);
        for (int curLength = 1; curLength < listLen; curLength <<= 1) {
            ListNode preNode = dummyNode;
            ListNode curNode = dummyNode.next;
            while (curNode != null) {
                ListNode link1 = curNode;
                for (int i = 1; i < curLength && curNode.next != null; i++) {
                    curNode = curNode.next;
                }

                ListNode link2 = curNode.next;
                curNode.next = null;
                curNode = link2;
                for (int i = 1; i < curLength && curNode != null && curNode.next != null; i++) {
                    curNode = curNode.next;
                }

                ListNode next = null;
                if (curNode != null) {
                    next = curNode.next;
                    curNode.next = null;
                }

                preNode.next = mergeList(link1, link2);
                while (preNode.next != null) {
                    preNode = preNode.next;
                }
                curNode = next;
            }
        }

        return dummyNode.next;
    }

    public ListNode mergeList(ListNode link1, ListNode link2) {
        ListNode dummyNode = new ListNode(-1);
        ListNode curNode = dummyNode;
        while (link1 != null && link2 != null) {
            if (link1.val <= link2.val) {
                curNode.next = link1;
                curNode = curNode.next;
                link1 = link1.next;
            } else {
                curNode.next = link2;
                curNode = curNode.next;
                link2 = link2.next;
            }
        }
        while (link1 != null) {
            curNode.next = link1;
            curNode = curNode.next;
            link1 = link1.next;
        }
        while (link2 != null) {
            curNode.next = link2;
            curNode = curNode.next;
            link2 = link2.next;
        }

        return dummyNode.next;
    }
}
