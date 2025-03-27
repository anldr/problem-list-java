package leetcode.Vol401to500;

import java.util.Arrays;
import java.util.Comparator;

public class LeetCode452 {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(o -> o[0]));

        int result = 1;
        int leftRange = points[0][0];
        int rightRange = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] <= rightRange) {
                leftRange = Math.max(leftRange, points[i][0]);
                rightRange = Math.min(rightRange, points[i][1]);
            } else {
                result++;
                rightRange = points[i][1];
            }
        }

        return result;
    }
}
