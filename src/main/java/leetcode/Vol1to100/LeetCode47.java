package leetcode.Vol1to100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode47 {
    private boolean[] vis;

    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }

        Arrays.sort(nums);
        vis = new boolean[nums.length];
        List<List<Integer>> result = new ArrayList<>();
        dfs(nums, 0, result, new ArrayList<>());
        return result;
    }

    private void dfs(int[] nums, int dep, List<List<Integer>> result, List<Integer> path) {
        if (dep == nums.length) {
            result.add(new ArrayList<>(path));
            return ;
        }

        for (int i = 0; i < nums.length; i++) {
            if (vis[i] || (i - 1 >= 0 && !vis[i - 1] && nums[i - 1] == nums[i])) {
                continue;
            }

            vis[i] = true;
            path.add(nums[i]);
            dfs(nums, dep + 1, result, path);
            path.remove(path.size() - 1);
            vis[i] = false;
        }
    }
}
