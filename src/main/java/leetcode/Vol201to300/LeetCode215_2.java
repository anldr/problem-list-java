package leetcode.Vol201to300;

import algorithm_template.Heap;

import java.util.Comparator;

public class LeetCode215_2 {
    public int findKthLargest(int[] nums, int k) {
        Heap<Integer> pQue = new Heap<>(nums.length, Comparator.comparingInt(a -> a));
        for (int i = 0; i < nums.length; i++) {
            pQue.insert(nums[i]);
        }

        for (int i = 1; i < k; i++) {
            pQue.poll();
        }

        return pQue.peek();
    }
}
