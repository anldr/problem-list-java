package leetcode.Vol201to300;

import commonutils.leetcode.TreeNode;

public class LeetCode222 {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int high = 0;
        TreeNode node = root;
        while (node.left != null) {
            high++;
            node = node.left;
        }

        int left = 1 << high;
        int right = (1 << high) - 1;
        while (left < right) {
            int mid = (left + right + 1) >> 1;
            if (checkExist(root, high, mid)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }

    private boolean checkExist(TreeNode root, int high, int target) {
        int bits = 1 << (high - 1);
        while(root != null && bits > 0) {
            if ((bits & target) > 0) {
                root = root.right;
            } else {
                root = root.left;
            }
            bits = bits >> 1;
        }
        return root != null;
    }
}
