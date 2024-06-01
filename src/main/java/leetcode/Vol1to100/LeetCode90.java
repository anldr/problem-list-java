package leetcode.Vol1to100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }

        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        dfs(nums, 0, result, new ArrayList<>());
        return result;
    }

    private void dfs(int[] nums, int dep, List<List<Integer>> result, List<Integer> path) {
        if (dep >= nums.length) {
            result.add(new ArrayList<>(path));
            return ;
        }

        int tot = 0;
        int val = nums[dep];
        while(dep < nums.length && val == nums[dep]) {
            dep++;
            tot++;
        }

        dfs(nums, dep, result, path);
        for (int i = 0; i < tot; i++) {
            path.add(val);
            dfs(nums, dep, result, path);
        }

        for (int i = 0; i < tot; i++) {
            path.remove(path.size() - 1);
        }
    }
}
