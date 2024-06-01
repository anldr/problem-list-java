package leetcode.Vol301to400;

import commonutils.leetcode.TreeNode;

public class LeetCode337 {
    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] result = dfs(root);
        return Math.max(result[0], result[1]);
    }

    private int[] dfs(TreeNode node) {
        if (node == null) {
            return new int[]{0, 0};
        }

        int[] left = dfs(node.left);
        int[] right = dfs(node.right);
        int retL = node.val + left[1] + right[1];
        int retR = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

        return new int[]{retL, retR};
    }
}
