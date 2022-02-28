package leetcode.Vol2101to2200;

import java.util.Arrays;

/**
 * author: xuchen
 * created: 2022/2/3 12:53
 * <p>
 * Description:
 */
public class LeetCode2148 {
    class Solution {
        public int countElements(int[] nums) {
            if (nums.length < 3) {
                return 0;
            }

            Arrays.sort(nums);
            int minn = nums[0];
            int maxx = nums[nums.length - 1];

            int left = 0;
            while (nums[left] != minn) {
                left++;
            }

            int right = nums.length - 1;
            while (nums[right] != maxx) {
                right--;
            }

            return right - left > 0 ? right - left + 1 : 0;
        }
    }
}
