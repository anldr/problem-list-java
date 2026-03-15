package leetcode.Vol1to100;

import java.util.function.BiFunction;

public class LeetCode34_3 {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }

        int firstIndex = binSearch(nums, target, (a, b) -> a >= b);
        if (firstIndex >= nums.length || nums[firstIndex] != target) {
            return new int[]{-1, -1};
        }

        int secondIndex = binSearch(nums, target, (a, b) -> a > b);
        return new int[]{firstIndex, nums[secondIndex] == target ? secondIndex : secondIndex - 1};
    }

    private int binSearch(int[] nums, int target, BiFunction<Integer, Integer, Boolean> func) {
        int l = 0;
        int r = nums.length - 1;

        while (l < r) {
            int mid = (l + r) >> 1;
            if (func.apply(nums[mid], target)) {
                r = mid;
            } else  {
                l = mid + 1;
            }
        }
        return l;
    }
}
