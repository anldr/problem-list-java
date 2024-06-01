package leetcode.Vol601to700;

import commonutils.leetcode.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class LeetCode653 {
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }

        Deque<TreeNode> leftTree = new LinkedList<>();
        Deque<TreeNode> rightTree = new LinkedList<>();
        TreeNode node = root;
        leftTree.addLast(node);
        while(node.left != null) {
            leftTree.addLast(node.left);
            node = node.left;
        }
        node = root;
        rightTree.addLast(node);
        while(node.right != null) {
            rightTree.addLast(node.right);
            node = node.right;
        }

        while(!leftTree.isEmpty() && !rightTree.isEmpty()) {
            TreeNode leftVal = leftTree.peekLast();
            TreeNode rightVal = rightTree.peekLast();
            if (leftVal.val == rightVal.val) {
                return false;
            }

            if (leftVal.val + rightVal.val == k) {
                return true;
            }
            if (leftVal.val + rightVal.val < k) {
                getLeft(leftTree);
            } else {
                getRight(rightTree);
            }
        }

        return false;
    }

    private void getLeft(Deque<TreeNode> leftTree) {
        TreeNode node = leftTree.removeLast();
        TreeNode temp = node.right;
        while(temp != null) {
            leftTree.addLast(temp);
            temp = temp.left;
        }
    }

    private void getRight(Deque<TreeNode> rightTree) {
        TreeNode node = rightTree.removeLast();
        TreeNode temp = node.left;
        while(temp != null) {
            rightTree.addLast(temp);
            temp = temp.right;
        }
    }
}
