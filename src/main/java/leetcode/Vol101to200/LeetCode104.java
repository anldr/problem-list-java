package leetcode.Vol101to200;

import commonutils.leetcode.TreeNode;

public class LeetCode104 {
    public int maxDepth(TreeNode root) {
        int result = 0;
        if (root == null) {
            return result;
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
