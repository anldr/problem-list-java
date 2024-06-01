package leetcode.Vol401to500;

import java.util.Arrays;

public class LeetCode473 {
    public boolean makesquare(int[] matchsticks) {
        if (matchsticks == null || matchsticks.length < 4) {
            return false;
        }

        int sum = 0;
        for (int i = 0; i < matchsticks.length; i++) {
            sum = sum + matchsticks[i];
        }
        if (sum % 4 != 0) {
            return false;
        }

        int avg = sum / 4;
        Arrays.sort(matchsticks);
        if (matchsticks[matchsticks.length - 1] > avg) {
            return false;
        }

        boolean[] vis = new boolean[matchsticks.length];
        return dfs(matchsticks, avg, avg, 0, 0, vis);
    }

    private boolean dfs(int[] matchsticks, int avg, int target, int count, int idx, boolean[] vis) {
        if (target == 0) {
            count++;
            if (count == 4) return true;
            return dfs(matchsticks, avg, avg, count, 0, vis);
        }

        for (int i = idx; i < matchsticks.length; i++) {
            if (!vis[i] && matchsticks[i] <= target) {
                vis[i] = true;
                if (dfs(matchsticks, avg, target - matchsticks[i], count, i + 1, vis)) {
                    return true;
                }
                vis[i] = false;
            }
        }

        return false;
    }
}
