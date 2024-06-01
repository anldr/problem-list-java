package leetcode.Vol1to100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode39_2 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return new ArrayList<>();
        }

        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        dfs(candidates, 0, target, result, new ArrayList<>());
        return result;
    }

    private void dfs(int[] candidates, int idx, int sum, List<List<Integer>> result, List<Integer> path) {
        if (sum == 0) {
            result.add(new ArrayList<>(path));
            return;
        }

        if (idx >= candidates.length) {
            return;
        }

        dfs(candidates, idx + 1, sum, result, path);
        int cnt = 1;
        for (; ; cnt++) {
            if (sum >= candidates[idx]) {
                path.add(candidates[idx]);
                sum = sum - candidates[idx];
                dfs(candidates, idx + 1, sum, result, path);
            } else {
                break;
            }
        }

        for (int k = 1; k < cnt; k++) {
            path.remove(path.size() - 1);
        }
    }
}
