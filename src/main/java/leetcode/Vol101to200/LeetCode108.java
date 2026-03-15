package leetcode.Vol101to200;

import common_structure.leetcode.TreeNode;

public class LeetCode108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return dfs(nums, 0, nums.length - 1);
    }

    private TreeNode dfs(int[] nums, int left, int right) {
        if (left == right) {
            return new TreeNode(nums[left]);
        }

        if (left > right) {
            return null;
        }

        int mid = (left + right) >> 1;
        return new TreeNode(nums[mid], dfs(nums, left, mid - 1), dfs(nums, mid + 1, right));
    }
}
