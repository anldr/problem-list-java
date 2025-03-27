package leetcode.Vol201to300;

import java.util.ArrayList;
import java.util.List;

public class LeetCode228 {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums.length == 0) {
            return result;
        }

        int left = 0;
        int right = 1;
        while (right < nums.length) {
            if (nums[right] > nums[right - 1] + 1) {
                result.add(buildRange(nums[left], nums[right - 1]));
                left = right;
            }
            right++;
        }
        result.add(buildRange(nums[left], nums[right - 1]));

        return result;
    }

    private String buildRange(int a, int b) {
        if (a == b) {
            return String.valueOf(a);
        }
        return a + "->" + b;
    }
}
