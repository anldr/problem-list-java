package leetcode.Vol201to300;

/**
 * author: xuchen
 * created: 2022/2/3 13:08
 * <p>
 * Description:
 *
 * 给定一个包含n + 1 个整数的数组nums ，其数字都在 1 到 n之间（包括 1 和 n），可知至少存在一个重复的整数。
 *
 * 假设 nums 只有 一个重复的整数 ，找出 这个重复的数 。
 *
 * 你设计的解决方案必须不修改数组 nums 且只用常量级 O(1) 的额外空间。
 *
 *
 * 1 <= n <= 105
 * nums.length == n + 1
 * 1 <= nums[i] <= n
 * nums 中 只有一个整数 出现 两次或多次 ，其余整数均只出现 一次
 *
 * Tips：
 * 1、快慢指针,这是什么奇技淫巧
 */
public class LeetCode287 {
    class Solution {
        public int findDuplicate(int[] nums) {
            int slow = 0;
            int fast = 0;

            do {
                slow = nums[slow];
                fast = nums[nums[fast]];
            } while (slow != fast);

            slow = 0;
            while (slow != fast) {
                slow = nums[slow];
                fast = nums[fast];
            }

            return slow;
        }
    }
}
