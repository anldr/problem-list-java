package leetcode.Vol1to100;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LeetCode26 {
    public static int removeDuplicates(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                nums[index++] = nums[i];
            }
        }
        return index;
    }

    public static void main(String[] args) {
        log.info(String.valueOf(removeDuplicates(new int[]{1,1,2})));
        log.info(String.valueOf(removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4})));
    }
}
