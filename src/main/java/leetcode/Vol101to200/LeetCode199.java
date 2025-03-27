package leetcode.Vol101to200;

import commonutils.leetcode.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

public class LeetCode199 {
    private Map<Integer, Integer> levelRight = new HashMap<>();

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        int idx = 1;
        levelRight.put(idx, root.val);
        dfs(root, idx);
        return new ArrayList<>(levelRight.values());
    }

    private void dfs(TreeNode root, int idx) {
        if (root != null) {
            if (root.right != null) {
                int val = levelRight.getOrDefault(idx + 1, -101);
                if (val == -101) {
                    levelRight.put(idx + 1, root.right.val);
                }
                dfs(root.right, idx + 1);
            }
            if (root.left != null) {
                int val = levelRight.getOrDefault(idx + 1, -101);
                if (val == -101) {
                    levelRight.put(idx + 1, root.left.val);
                }
                dfs(root.left, idx + 1);
            }
        }
    }
}
