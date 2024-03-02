package leetcode.Vol101to200;

import commonutils.leetcode.TreeNode;

public class LeetCode114 {
    private TreeNode preNode = null;
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        TreeNode left = root.left;
        TreeNode right = root.right;
        if (preNode != null) {
            preNode.left = null;
            preNode.right = root;
        }
        preNode = root;

        flatten(left);
        flatten(right);
    }
}
