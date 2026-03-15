package leetcode.Vol301to400;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LeetCode373 {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> que = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        que.add(new int[]{nums1[0] + nums2[0], 0, 0});

        List<List<Integer>> result = new ArrayList<>(k);
        while (k-- > 0) {
            int[] nums = que.poll();
            int i = nums[1];
            int j = nums[2];
            result.add(Stream.of(nums1[i], nums2[j]).collect(Collectors.toList()));
            if (j == 0 && i < nums1.length - 1) {
                que.add(new int[]{nums1[i + 1] + nums2[j], i + 1, j});
            }
            if (j < nums2.length - 1) {
                que.add(new int[]{nums1[i] + nums2[j + 1], i , j + 1});
            }
        }

        return result;
    }
}
