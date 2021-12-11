package leetcode.Vol201to300;

public class LeetCode260 {
    class Solution {
        public int[] singleNumber(int[] nums) {
            int xOr = 0;
            for (int i : nums) {
                xOr = xOr ^ i;
            }
            xOr = xOr & (-xOr);
            int a = 0;
            int b = 0;
            for (int i : nums) {
                if ((i & xOr) != 0) {
                    a = a ^ i;
                } else {
                    b = b ^ i;
                }
            }

            return new int[]{a, b};
        }
    }
}
