package leetcode.Vol101to200;

public class LeetCode162 {
    public int findPeakElement(int[] nums) {
        return binSearch(nums, 0 , nums.length - 1);
    }

    private int binSearch(int[] nums, int l, int r) {
        while (l < r) {
            int mid = (l + r) >> 1;
            if (nums[mid] > nums[mid + 1]) {
                r = mid;
            } else {
                l = mid +1;
            }
        }
        return l;
    }
}
