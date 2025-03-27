package leetcode.Vol101to200;

import commonutils.leetcode.TreeNode;

public class LeetCode104 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return maxDepth(root, 1);
    }

    public int maxDepth(TreeNode root, int maxDepth) {
        if (root == null) {
            return maxDepth - 1;
        }

        return Math.max(maxDepth(root.left, maxDepth + 1), maxDepth(root.right, maxDepth + 1));
    }
}
