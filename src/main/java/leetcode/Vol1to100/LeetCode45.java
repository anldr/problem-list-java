package leetcode.Vol1to100;

public class LeetCode45 {
    public int jump(int[] nums) {
        int idx = 0;
        int step = 0;
        int maxPos = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxPos = Math.max(maxPos, i + nums[i]);
            if (i == idx) {
                idx = maxPos;
                step++;
            }
        }

        return step;
    }
}
