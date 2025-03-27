package leetcode.Vol201to300;

import commonutils.leetcode.TreeNode;

public class LeetCode230 {
    private int count;
    private int result = Integer.MAX_VALUE;
    public int kthSmallest(TreeNode root, int k) {
        getK(root, k);
        return result;
    }

    private void getK(TreeNode root, int k) {
        if (count >= k) {
            return ;
        }

        if (root.left != null) {
            getK(root.left, k);
        }
        count++;
        if (count == k) {
            result = root.val;
            return ;
        }
        if (root.right != null) {
            getK(root.right, k);
        }
    }
}
