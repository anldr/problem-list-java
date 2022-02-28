package leetcode.Vol1201to1300;

/**
 * author: xuchen
 * created: 2022/2/2 12:29
 * <p>
 * Description:
 * 1、前缀和的思路
 */
public class LeetCode1248 {
    class Solution {
        public int numberOfSubarrays(int[] nums, int k) {
            int result = 0;
            int len = nums.length;
            int[] kNums = new int[len];

            int sum = 0;
            kNums[0] = 1;
            for (int i = 0; i < len; i++) {
                sum = sum + (nums[i] & 1);
                kNums[sum]++;
                if (sum >= k) {
                    result = result + kNums[sum - k];
                }
            }

            return result;
        }
    }
}
