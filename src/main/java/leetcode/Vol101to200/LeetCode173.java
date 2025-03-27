package leetcode.Vol101to200;

import commonutils.leetcode.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class LeetCode173 {
    class BSTIterator {
        private Deque<TreeNode> queue;

        public BSTIterator(TreeNode root) {
            this.queue = new ArrayDeque<>();
            while(root != null) {
                queue.addLast(root);
                root = root.left;
            }

        }

        public int next() {
            TreeNode node = this.queue.pollLast();
            if (node.right != null) {
                TreeNode root = node.right;
                while (root != null) {
                    queue.addLast(root);
                    root = root.left;
                }
            }

            return node.val;
        }

        public boolean hasNext() {
            return !queue.isEmpty();
        }
    }
}
