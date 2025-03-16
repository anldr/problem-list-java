package leetcode.Vol201to300;

import java.util.ArrayDeque;
import java.util.Deque;

public class LeetCode239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int idx = 0;
        int[] result = new int[nums.length - k + 1];
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            while (!queue.isEmpty() && nums[i] > nums[queue.getLast()]) {
                queue.pollLast();
            }
            if (!queue.isEmpty() && (i - queue.getFirst()) >= k) {
                queue.pollFirst();
            }

            queue.addLast(i);
            if (i >= (k - 1)) {
                result[idx++] = nums[queue.getFirst()];
            }
        }

        return result;
    }
}
