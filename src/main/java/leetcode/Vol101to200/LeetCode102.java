package leetcode.Vol101to200;

import commonutils.leetcode.TreeNode;

import java.util.*;

public class LeetCode102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        queue.push(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> temp = new ArrayList<>();
            for (int i = 1; i <= size; i++) {
                TreeNode node = queue.pollFirst();
                temp.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            result.add(temp);
        }

        return result;
    }
}
