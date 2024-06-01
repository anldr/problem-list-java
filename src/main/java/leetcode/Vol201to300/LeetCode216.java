package leetcode.Vol201to300;

import java.util.ArrayList;
import java.util.List;

public class LeetCode216 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(k ,n, 1, result, new ArrayList<>());
        return result;
    }

    private void dfs(int dep, int sum, int start, List<List<Integer>> result, List<Integer> path) {
        if (dep == 0) {
            if (sum == 0) {
                result.add(new ArrayList<>(path));
                return ;
            }
            return ;
        }

        for (int i = start; i <= 10 - dep; i++) {
            path.add(i);
            dfs(dep - 1, sum - i, i + 1, result, path);
            path.remove(path.size() - 1);
        }
    }
}
