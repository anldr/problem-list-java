package leetcode.Vol201to300;

import commonutils.leetcode.ListNode;

public class LeetCode234 {
    private ListNode frontNode = null;

    public boolean isPalindrome(ListNode head) {
        frontNode = head;
        return recursivelyCheck(head);
    }

    public boolean recursivelyCheck(ListNode curNode) {
        if (curNode != null) {
            if (!recursivelyCheck(curNode.next)) {
                return false;
            }
            if (curNode.val != frontNode.val) {
                return false;
            }
            frontNode = frontNode.next;
        }

        return true;
    }
}
