package leetcode.Vol1to100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null ||candidates.length == 0) {
            return new ArrayList<>();
        }

        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        dfs(candidates, 0, target, new ArrayList<>(), result);
        return result;
    }

    private void dfs(int[] candidates, int idx, int sum, List<Integer> path, List<List<Integer>> result) {
        if (0 == sum) {
            result.add(new ArrayList<>(path));
            return ;
        }

        for (int i = idx; i < candidates.length; i++) {
            if (sum >= candidates[i]) {
                path.add(candidates[i]);
                dfs(candidates, i, sum - candidates[i], path, result);
                path.remove(path.size() - 1);
            } else {
                return ;
            }
        }
    }
}
