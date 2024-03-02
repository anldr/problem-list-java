package leetcode.Vol101to200;

import commonutils.leetcode.TreeNode;

public class LeetCode114_2 {
    public void flatten(TreeNode root) {
        TreeNode curNdoe = root;
        while (curNdoe != null) {
            if (curNdoe.left != null) {
                TreeNode preNdoe = curNdoe.left;
                while (preNdoe.right != null) {
                    preNdoe = preNdoe.right;
                }

                preNdoe.right = curNdoe.right;
                curNdoe.right = curNdoe.left;
                curNdoe.left = null;
            }
            curNdoe = curNdoe.right;
        }
    }
}
