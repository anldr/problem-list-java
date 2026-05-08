package leetcode.Vol1to100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LeetCode15 {
    public List<List<Integer>> threeSum(int[] nums) {
        int target = 0;
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i >= 1 && nums[i] == nums[i - 1]) {
                continue;
            }

            if (nums[i] + nums[nums.length -2] + nums[nums.length - 1] < target) {
                continue;
            }

            if (nums[i] + nums[i + 1] + nums[i + 2] > 0) {
                break;
            }

            int ptr1 = i + 1;
            int ptr2 = nums.length - 1;
            while (ptr1 < ptr2) {
                int sum = nums[i] + nums[ptr1] + nums[ptr2];
                if (sum > 0) {
                    ptr2--;
                } else if (sum < 0) {
                    ptr1++;
                } else {
                    result.add(Stream.of(nums[i], nums[ptr1], nums[ptr2]).collect(Collectors.toList()));
                    do {
                        ptr2--;
                    } while (ptr2 > ptr1 && nums[ptr2] == nums[ptr2 + 1]);
                    do {
                        ptr1++;
                    } while (ptr2 > ptr1 && nums[ptr1] == nums[ptr1 - 1]);
                }
            }
        }

        return result;
    }
}
