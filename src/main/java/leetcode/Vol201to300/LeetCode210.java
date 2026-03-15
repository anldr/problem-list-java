package leetcode.Vol201to300;

import java.util.ArrayList;
import java.util.List;

public class LeetCode210 {
    private List<List<Integer>> neighbors;

    private int[] visit;

    private int[] result;

    private boolean valid;

    private int index;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses == 0) {
            return null;
        }

        valid = true;
        index = numCourses - 1;
        visit = new int[numCourses];
        result = new int[numCourses];
        neighbors = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            neighbors.add(new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            neighbors.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        for (int i = 0; i < numCourses && valid; i++) {
            if (visit[i] == 0) {
                dfs(i);
            }
        }

        if (!valid) {
            return new int[0];
        }

        return result;
    }

    private void dfs(int u) {
        visit[u] = 1;

        for (int v : neighbors.get(u)) {
            if (visit[v] == 0) {
                dfs(v);
                if (!valid) {
                    return ;
                }
            } else if (visit[v] == 1) {
                valid = false;
            }
        }
        visit[u] = 2;
        result[index--] = u;
    }
}
