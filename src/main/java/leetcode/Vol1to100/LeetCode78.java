package leetcode.Vol1to100;

import java.util.ArrayList;
import java.util.List;

public class LeetCode78 {
    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();
        dfs(nums, 0, result, new ArrayList<>());
        return result;
    }

    private void dfs(int[] nums, int dep, List<List<Integer>> result, List<Integer> path) {
        if (dep == nums.length) {
            result.add(new ArrayList<>(path));
            return ;
        }

        dfs(nums, dep + 1, result, path);
        path.add(nums[dep]);
        dfs(nums, dep + 1, result, path);
        path.remove(path.size() - 1);
    }
}
