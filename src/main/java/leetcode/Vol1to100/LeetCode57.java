package leetcode.Vol1to100;

import java.util.ArrayList;
import java.util.List;

public class LeetCode57 {
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) {
            return new int[][]{{newInterval[0], newInterval[1]}};
        }

        int idx = 0;
        int leftRange;
        int rightRange;
        if (intervals[0][0] <= newInterval[0]) {
            idx = 1;
            leftRange = intervals[0][0];
            rightRange = intervals[0][1];
        } else {
            leftRange = newInterval[0];
            rightRange = newInterval[1];
        }

        List<int[]> result = new ArrayList<>();
        for (int i = idx; i < intervals.length; i++) {
            if (idx >= 1 && intervals[i][0] >= newInterval[0]) {
                idx--;
                if (newInterval[0] <= rightRange) {
                    rightRange = Math.max(rightRange, newInterval[1]);
                } else {
                    result.add(new int[]{leftRange, rightRange});
                    leftRange = newInterval[0];
                    rightRange = newInterval[1];
                }
            }
            if (intervals[i][0] <= rightRange) {
                rightRange = Math.max(rightRange, intervals[i][1]);
            } else {
                result.add(new int[]{leftRange, rightRange});
                leftRange = intervals[i][0];
                rightRange = intervals[i][1];
            }
        }

        if (idx >= 1) {
            if (newInterval[0] <= rightRange) {
                result.add(new int[]{leftRange, Math.max(rightRange, newInterval[1])});
            } else {
                result.add(new int[]{leftRange, rightRange});
                result.add(new int[]{newInterval[0], newInterval[1]});
            }
        } else {
            result.add(new int[]{leftRange, rightRange});
        }

        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        int[][] rng = new int[][]{{1,5}};
        int[] rng2 = new int[]{2,7};
        insert(rng, rng2);


        rng = new int[][]{{1,2},{3,5},{6,7},{8,10},{12,16}};
        rng2 = new int[]{4,8};
        insert(rng, rng2);
    }
}
