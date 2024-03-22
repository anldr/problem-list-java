package leetcode.Vol401to500;

import commonutils.leetcode.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode437 {
    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> prefixSum = new HashMap<>();
        prefixSum.put(0L, 1);
        return recursiveSum(root, targetSum, 0, prefixSum);
    }

    private int recursiveSum(TreeNode root, int targetSum, long curSum, Map<Long, Integer> prefixSum) {
        if (root == null) {
            return 0;
        }

        int result = 0;
        curSum = curSum + root.val;
        result += prefixSum.getOrDefault(curSum - targetSum, 0);

        prefixSum.put(curSum, prefixSum.getOrDefault(curSum, 0) + 1);
        result += recursiveSum(root.left, targetSum, curSum, prefixSum);
        result += recursiveSum(root.right, targetSum, curSum, prefixSum);
        prefixSum.put(curSum, prefixSum.get(curSum) - 1);

        return result;
    }
}
