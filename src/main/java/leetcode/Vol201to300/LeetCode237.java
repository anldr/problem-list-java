package leetcode.Vol201to300;

import common_structure.leetcode.ListNode;

public class LeetCode237 {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
