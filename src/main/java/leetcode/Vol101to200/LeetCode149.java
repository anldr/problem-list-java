package leetcode.Vol101to200;

import java.util.HashMap;
import java.util.Map;

public class LeetCode149 {
    public int maxPoints(int[][] ps) {
        int n = ps.length;
        int result = 1;

        for (int i = 0; i < n; i++) {
            int maxNum = 0;
            Map<String, Integer> map = new HashMap<>();
            // 计算由i点出发的直线经过的最多的点数
            for (int j = i + 1; j < n; j++) {
                int x1 = ps[i][0], y1 = ps[i][1];
                int x2 = ps[j][0], y2 = ps[j][1];
                int a = x1 - x2, b = y1 - y2;
                int g = gcd(a, b);
                String key = (a / g) + "_" + (b / g);
                map.put(key, map.getOrDefault(key, 0) + 1);
                maxNum = Math.max(maxNum, map.get(key));
            }
            result = Math.max(result, maxNum + 1);
        }

        return result;
    }

    int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
