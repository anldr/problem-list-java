package acwing.Vol1401to1500;

import commonutils.acwing.ListNode;

public class AcWing1451_2 {
    public ListNode quickSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        doQuickSort(head, null);

        return head;
    }

    private void doQuickSort(ListNode head, ListNode tail) {
        if (head != tail) {
            int x = head.val;
            ListNode leftNode = head;
            ListNode rightNode = head.next;
            while (rightNode != tail) {
                if (rightNode.val < x) {
                    leftNode = leftNode.next;
                    swap(leftNode, rightNode);
                }
                rightNode = rightNode.next;
            }
            if (leftNode != head) {
                swap(leftNode, head);
            }

            doQuickSort(head, leftNode);
            doQuickSort(leftNode.next, tail);
        }
    }

    private void swap(ListNode node1, ListNode node2) {
//        node1.val = node1.val ^ node2.val;
//        node2.val = node1.val ^ node2.val;
//        node1.val = node1.val ^ node2.val;
        int temp = node1.val;
        node1.val = node2.val;
        node2.val = temp;
    }
}
