package leetcode.Vol1to100;

import commonutils.leetcode.TreeNode;

public class LeetCode100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if ((p == null && q != null) || (p != null && q == null)) {
            return false;
        }

        if (p == null && q == null) {
            return true;
        }

        boolean result = q.val == p.val;
        return result && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
