package acwing.Vol1to100;

import commonutils.acwing.TreeNode;

import java.util.*;

public class AcWing45_2 {
    public List<List<Integer>> printFromTopToBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        boolean zigzag = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> levelResult = new ArrayList<>();
            List<TreeNode> levelNode = new ArrayList<>();
            for (int i = 1; i <= size; i++) {
                TreeNode temp = queue.pollFirst();
                levelResult.add(temp.val);
                levelNode.add(temp);
            }
            for (int i = levelNode.size() - 1; i >=0; i--) {
                if (zigzag) {
                    addNodeFromRight(queue, levelNode.get(i));
                } else {
                    addNodeFromLeft(queue, levelNode.get(i));
                }
            }

            zigzag = !zigzag;
            result.add(levelResult);
        }

        return result;
    }

    public void addNodeFromLeft(Deque<TreeNode> queue, TreeNode node) {
        if (node.left != null) {
            queue.add(node.left);
        }
        if (node.right != null) {
            queue.add(node.right);
        }
    }

    public void addNodeFromRight(Deque<TreeNode> queue, TreeNode node) {
        if (node.right != null) {
            queue.add(node.right);
        }
        if (node.left != null) {
            queue.add(node.left);
        }
    }
}
