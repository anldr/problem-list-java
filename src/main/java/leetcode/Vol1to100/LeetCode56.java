package leetcode.Vol1to100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LeetCode56 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> {
            return o1[0] - o2[0];
        });

        List<int[]> result = new ArrayList<>();
        int leftRange = intervals[0][0];
        int rightRange = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= rightRange) {
                rightRange = Math.max(rightRange, intervals[i][1]);
            } else {
                result.add(new int[]{leftRange, rightRange});
                leftRange = intervals[i][0];
                rightRange = intervals[i][1];

            }
        }
        result.add(new int[]{leftRange, rightRange});

        return result.toArray(new int[result.size()][]);
    }
}
