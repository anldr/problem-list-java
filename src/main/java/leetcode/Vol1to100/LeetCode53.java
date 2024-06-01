package leetcode.Vol1to100;

public class LeetCode53 {
    public int maxSubArray(int[] nums) {
        int preVal = 0;
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            preVal = Math.max(preVal + nums[i], nums[i]);
            result = Math.max(result, preVal);
        }

        return result;
    }
}
