package leetcode.Vol1to100;

import commonutils.leetcode.ListNode;

import java.util.PriorityQueue;

public class LeetCode23_2 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }

        PriorityQueue<NewNode> nodeQue = new PriorityQueue<>();
        for (ListNode node : lists) {
            if (node != null) {
                nodeQue.offer(new NewNode(node.val, node));
            }
        }

        ListNode dummyNode = new ListNode(-1);
        ListNode moveNode = dummyNode;
        while (!nodeQue.isEmpty()) {
            NewNode temp = nodeQue.poll();
            moveNode.next = temp.node;
            moveNode = moveNode.next;
            if (temp.node.next != null) {
                nodeQue.offer(new NewNode(temp.node.next.val, temp.node.next));
            }
        }

        return dummyNode.next;
    }

    class NewNode implements Comparable<NewNode> {
        private int val;

        private ListNode node;

        public NewNode(int val, ListNode node) {
            this.val = val;
            this.node = node;
        }

        public int compareTo(NewNode o) {
            return this.val - o.val;
        }
    }
}
