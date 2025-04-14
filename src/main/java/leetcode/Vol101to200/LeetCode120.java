package leetcode.Vol101to200;

import java.util.List;

public class LeetCode120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int level = triangle.size();
        if (level == 1) {
            return triangle.get(0).get(0);
        }

        int idx = 0;
        int[][] dp = new int[2][level];
        int result = Integer.MAX_VALUE;
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < triangle.size(); i++) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                if (j == 0) {
                    dp[(idx + 1) % 2][0] = dp[idx][0] + triangle.get(i).get(j);
                } else if (j == triangle.get(i).size() - 1) {
                    dp[(idx + 1) % 2][j] = dp[idx][triangle.get(i - 1).size() - 1] + triangle.get(i).get(j);
                } else {
                    dp[(idx + 1) % 2][j] = Math.min(dp[idx][j], dp[idx][j - 1]) + triangle.get(i).get(j);
                }

                if (i == triangle.size() - 1) {
                    result = Math.min(dp[(idx + 1) % 2][j], result);
                }
            }
            idx = (idx + 1) % 2;
        }

        return result;
    }
}
