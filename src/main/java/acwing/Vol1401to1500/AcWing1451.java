package acwing.Vol1401to1500;

import commonutils.acwing.ListNode;

public class AcWing1451 {
    public ListNode quickSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode lHead = new ListNode(-1);
        ListNode mHead = new ListNode(-1);
        ListNode rHead = new ListNode(-1);
        ListNode leftNode = lHead;
        ListNode midNode = mHead;
        ListNode rightNode = rHead;

        int x = head.val;
        while (head != null) {
            if (head.val < x) {
                leftNode.next = head;
                leftNode = leftNode.next;
            } else if (head.val == x) {
                midNode.next = head;
                midNode = midNode.next;
            } else {
                rightNode.next = head;
                rightNode = rightNode.next;
            }
            head = head.next;
        }

        leftNode.next = null;
        midNode.next = null;
        rightNode.next = null;

        lHead.next = quickSortList(lHead.next);
        rHead.next = quickSortList(rHead.next);

        getTail(lHead).next = mHead.next;
        getTail(mHead).next = rHead.next;

        return lHead.next;
    }

    private ListNode getTail(ListNode node) {
        if (node == null) {
            return node;
        }
        while(node.next != null) {
            node = node.next;
        }
        return node;
    }
}
