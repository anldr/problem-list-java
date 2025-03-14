package leetcode.Vol201to300;

public class LeetCode209 {
    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int left = 0;
        int right = 0;
        int result = nums.length + 7;
        while (right < nums.length) {
            sum = sum + nums[right];
            while (sum >= target) {
                result = Math.min(result, right - left + 1);
                sum = sum - nums[left];
                left++;
            }
            right++;
        }

        return result > nums.length ? 0 : result;
    }
}
