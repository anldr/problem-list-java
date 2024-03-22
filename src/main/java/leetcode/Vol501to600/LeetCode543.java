package leetcode.Vol501to600;

import commonutils.leetcode.TreeNode;

public class LeetCode543 {
    private int result;

    public int diameterOfBinaryTree(TreeNode root) {
        result = 0;
        recursiveTree(root, 1);
        return result;
    }

    private int recursiveTree(TreeNode node, int dep) {
        int leftDep = dep;
        int rightDep = dep;
        if (node.left != null) {
            leftDep = recursiveTree(node.left, dep + 1);
        }
        if (node.right != null) {
            rightDep = recursiveTree(node.right, dep + 1);
        }

        result = Math.max(result, leftDep + rightDep - dep -dep);

        return Math.max(leftDep, rightDep);
    }
}
