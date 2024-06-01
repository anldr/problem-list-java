package leetcode.Vol101to200;

import commonutils.leetcode.ListNode;

/**
 * 更加简洁的版本
 */
public class LeetCode148_3 {
    public ListNode sortList(ListNode head) {
        int totNode = 0;
        for (ListNode ptr = head; ptr != null; ptr = ptr.next) {
            totNode++;
        }

        ListNode dummyNode = new ListNode();
        dummyNode.next = head;
        for (int curLen = 1; curLen < totNode; curLen = curLen << 1) {
            ListNode curNode = dummyNode;
            for (int j = 1; j + curLen <= totNode; j = j + (curLen << 1)) {
                ListNode ptr1 = curNode.next;
                ListNode ptr2 = ptr1;
                for (int k = 1; k <= curLen; k++) {
                    ptr2 = ptr2.next;
                }

                // 合并链表
                int idx1 = 0;
                int idx2 = 0;
                while (idx1 < curLen && idx2 < curLen && ptr1 != null && ptr2 != null) {
                    if (ptr1.val <= ptr2.val) {
                        curNode.next = ptr1;
                        curNode = curNode.next;
                        ptr1 = ptr1.next;
                        idx1++;
                    } else {
                        curNode.next = ptr2;
                        curNode = curNode.next;
                        ptr2 = ptr2.next;
                        idx2++;
                    }
                }
                while (idx1 < curLen && ptr1 != null) {
                    curNode.next = ptr1;
                    curNode = curNode.next;
                    ptr1 = ptr1.next;
                    idx1++;
                }
                while (idx2 < curLen && ptr2 != null) {
                    curNode.next = ptr2;
                    curNode = curNode.next;
                    ptr2 = ptr2.next;
                    idx2++;
                }

                // 合并之后的链表的最后一个节点指向，下一个需要合并的区间的第一个节点
                curNode.next = ptr2;
            }
        }

        return dummyNode.next;
    }
}
