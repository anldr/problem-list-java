package leetcode.Vol501to600;

import commonutils.leetcode.TreeNode;

public class LeetCode538 {
    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return root;
        }
        convertBST(root.right);
        sum += root.val;
        root.val = sum;
        convertBST(root.left);

        return root;
    }
}
