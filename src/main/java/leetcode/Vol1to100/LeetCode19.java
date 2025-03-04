package leetcode.Vol1to100;

import commonutils.leetcode.ListNode;

public class LeetCode19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return head;
        }

        int total = getTotalNode(head);
        int removeIndex = total - n;

        if (removeIndex == 0) {
            return head.next;
        }

        int curIndex = 1;
        ListNode moveNode = head;
        while (moveNode != null) {
            if (curIndex == removeIndex) {
                moveNode.next = moveNode.next.next;
                break;
            }
            curIndex++;
            moveNode = moveNode.next;
        }

        return head;
    }

    public int getTotalNode(ListNode node) {
        int result = 0;
        while(node != null) {
            node = node.next;
            result++;
        }
        return result;
    }
}
