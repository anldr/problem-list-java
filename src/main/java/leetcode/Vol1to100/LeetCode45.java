package leetcode.Vol1to100;

import commonutils.leetcode.TreeNode;

import java.util.*;

public class LeetCode45 {
    public List<List<Integer>> printFromTopToBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        boolean zigzag = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> levelResult = new ArrayList<>();
            for (int i = 1; i <= size; i++) {
                TreeNode temp = queue.pollFirst();
                levelResult.add(temp.val);
                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
            }
            if (zigzag) {
                Collections.reverse(levelResult);
            }

            zigzag = !zigzag;
            result.add(levelResult);
        }

        return result;
    }
}
