package leetcode.Vol101to200;

import commonutils.leetcode.TreeNode;

public class LeetCode124 {
    private int answer = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxSum(root);
        return answer;
    }

    private int maxSum(TreeNode node) {
        int lefSum = 0;
        int rightSum = 0;
        if (node.left != null) {
            lefSum = maxSum(node.left);
        }
        if (node.right != null) {
            rightSum = maxSum(node.right);
        }

        int temp =  Math.max(Math.max(lefSum, rightSum) + node.val, node.val);
        answer = Math.max(answer, Math.max(temp, lefSum + rightSum + node.val));

        return temp;
    }
}
