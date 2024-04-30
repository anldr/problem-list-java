package leetcode.Vol901to1000;

import java.util.LinkedList;
import java.util.List;

public class LeetCode986 {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        if (firstList.length == 0 || secondList.length == 0) {
            return new int[0][];
        }

        List<int[]> result = new LinkedList<>();
        int index1 = 0;
        int index2 = 0;
        while (index1 < firstList.length && index2 < secondList.length) {
            if (firstList[index1][0] <= secondList[index2][1]
                && firstList[index1][1] >= secondList[index2][0]) {
                int left = Math.max(firstList[index1][0], secondList[index2][0]);
                int right = Math.min(firstList[index1][1], secondList[index2][1]);
                result.add(new int[]{left, right});
            }

            if (firstList[index1][1] > secondList[index2][1]) {
                index2++;
            } else {
                index1++;
            }
        }

        return result.toArray(new int[result.size()][]);
    }
    /**
     * [0,  2]  [5,      10]   [13,    23]   [24,    25]
     *   [1,     5]   [8,   12]   [15,        24]   [25,26]
     *
     * [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
     */
}
