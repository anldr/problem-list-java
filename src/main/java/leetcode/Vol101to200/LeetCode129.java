package leetcode.Vol101to200;

import commonutils.leetcode.TreeNode;

public class LeetCode129 {
    private int sum = 0;
    public int sumNumbers(TreeNode root) {
        sumNumbers(root, 0);
        return sum;
    }

    private void sumNumbers(TreeNode root, int num) {
        if (root.left == null && root.right == null) {
            sum = sum + num * 10 + root.val;
            return ;
        }

        sumNumbers(root.left, num * 10 + root.val);
        sumNumbers(root.left, num * 10 + root.val);
    }
}
