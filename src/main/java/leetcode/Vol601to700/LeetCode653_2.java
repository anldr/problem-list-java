package leetcode.Vol601to700;

import commonutils.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode653_2 {
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }

        List<Integer> inOrder = new ArrayList<>();
        dfs(root, inOrder);

        int leftIdx = 0;
        int rightIdx = inOrder.size() - 1;
        while (leftIdx != rightIdx) {
            if(inOrder.get(leftIdx) + inOrder.get(rightIdx) == k) {
                return true;
            }
            if(inOrder.get(leftIdx) + inOrder.get(rightIdx) < k) {
                leftIdx++;
            } else {
                rightIdx--;
            }
        }
        return false;
    }

    private void dfs(TreeNode root, List<Integer> inOrder) {
        if (root != null) {
            dfs(root.left, inOrder);
            inOrder.add(root.val);
            dfs(root.right, inOrder);
        }
    }
}
