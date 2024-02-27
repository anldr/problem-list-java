package leetcode.Vol201to300;

import commonutils.leetcode.ListNode;

public class LeetCode234_2 {
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }

        ListNode frontHalf = frontHalf(head);
        ListNode backHalf = reverse(frontHalf.next);

        while (backHalf != null) {
            if (head.val != backHalf.val) {
                return false;
            }
            head = head.next;
            backHalf = backHalf.next;
        }

        ListNode point1 = head;
        ListNode point2 = backHalf;
        boolean result = true;
        while (point2 != null && result) {
            if (point1.val != point2.val) {
                result = false;
            }
            point1 = point1.next;
            point2 = point2.next;
        }
        frontHalf.next = reverse(backHalf);

        return result;
    }

    public ListNode frontHalf(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode reverse(ListNode head) {
        ListNode preNode = null;
        ListNode curNode = head;
        while (curNode != null) {
            ListNode next = curNode.next;
            curNode.next = preNode;
            preNode = curNode;
            curNode = next;
        }

        return preNode;
    }
}
