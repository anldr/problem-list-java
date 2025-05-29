package leetcode.Vol201to300;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class LeetCode215 {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pQue = new PriorityQueue<>(Arrays.stream(nums).boxed().collect(Collectors.toList()));

        for (int i = 1; i < k; i++) {
            pQue.poll();
        }

        return pQue.element();
    }
}
