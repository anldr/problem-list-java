package leetcode.Vol1to100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
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

        int lastIdx = idx;
        int val = candidates[idx];
        while (lastIdx < candidates.length && candidates[lastIdx] == val) {
            lastIdx++;
        }

        dfs(candidates, lastIdx, sum, result, path);
        int cnt = 1;
        for (int i = idx; i < lastIdx; i++) {
            if (sum >= val) {
                cnt++;
                path.add(val);
                sum = sum - val;
                dfs(candidates, lastIdx, sum, result, path);
            } else {
                break;
            }
        }

        for (int k = 1; k < cnt; k++) {
            path.remove(path.size() - 1);
        }
    }
}
