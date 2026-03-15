package leetcode.Vol1to100;

import java.util.ArrayList;
import java.util.List;

public class LeetCode77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> subAns = new ArrayList<>();
        dfs(n, k ,subAns, ans);
        return ans;
    }

    private void dfs(int n, int k, List<Integer> subAns, List<List<Integer>> ans) {
        int need = k - subAns.size();
        if (need == 0) {
            ans.add(new ArrayList<>(subAns));
            return ;
        }

        for (int i = n; i >= need ; i--) {
            subAns.add(i);
            dfs(i - 1, k, subAns, ans);
            subAns.remove(subAns.size() - 1);
        }
    }
}
