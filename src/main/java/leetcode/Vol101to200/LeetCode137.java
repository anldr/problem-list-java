package leetcode.Vol101to200;

public class LeetCode137 {
    public int singleNumber(int[] nums) {
        int a = 0;
        int b = 0;
        for (int i = 0; i < nums.length; i++) {
            a = (a ^ nums[i]) & ~b;
            b = (b ^ nums[i]) & ~a;
        }

        return a;
    }
}
