package leetcode.Vol501to600;

import commonutils.leetcode.TreeNode;

public class LeetCode530 {
    private int minResult = Integer.MAX_VALUE;

    private TreeNode preNode;

    public int getMinimumDifference(TreeNode root) {
        inOrder(root);
        return minResult;
    }

    private void inOrder(TreeNode root) {
        if (root.left != null) {
            inOrder(root.left);
        }

        if (preNode == null) {
            preNode = root;
        } else {
            minResult = Math.min(minResult, root.val - preNode.val);
            preNode = root;
        }

        if (root.right != null) {
            inOrder(root.right);
        }

    }
}
