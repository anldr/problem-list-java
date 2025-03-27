package leetcode.Vol101to200;

import commonutils.leetcode.Node;

import java.util.ArrayDeque;
import java.util.Deque;

public class LeetCode117_2 {
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }

        Deque<Node> queue = new ArrayDeque<>();
        queue.addLast(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            Node preNode = queue.pollFirst();
            boolean temp = preNode.left != null && queue.add(preNode.left);
            temp = preNode.right != null && queue.add(preNode.right);
            for (int i = 1; i < size; i++) {
                preNode.next = queue.getFirst();
                preNode = queue.pollFirst();
                temp = preNode.left != null && queue.add(preNode.left);
                temp = preNode.right != null && queue.add(preNode.right);
            }
            preNode.next = null;
        }
        return root;
    }
}
