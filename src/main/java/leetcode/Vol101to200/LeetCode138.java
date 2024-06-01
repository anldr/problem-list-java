package leetcode.Vol101to200;

import commonutils.leetcode.ListNode;
import commonutils.leetcode.Node;

public class LeetCode138 {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        // 复制节点，并串联成一个交替链表（1->1'->2->2'->3->3'...）
        Node ptr = head;
        while (ptr != null) {
            Node newCopy = new Node(ptr.val);
            newCopy.next = ptr.next;
            ptr.next = newCopy;
            ptr = newCopy.next;
        }

        // 复制随机节点
        ptr = head;
        while (ptr != null) {
            ptr.next.random = ptr.random == null ? null : ptr.random.next;
            ptr = ptr.next.next;
        }

        // 将链表分开
        ptr = head;
        Node result = ptr.next;
        Node copyPtr = ptr.next;
        while (ptr != null) {
            ptr.next = copyPtr.next;
            ptr = ptr.next;
            copyPtr.next = ptr == null ? null : ptr.next;
            copyPtr = copyPtr.next;
        }

        return result;
    }
}
