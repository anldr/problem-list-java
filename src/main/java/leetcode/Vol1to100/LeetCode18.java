package leetcode.Vol1to100;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@Slf4j
public class LeetCode18 {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new LinkedList<>();

        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                for (int k = j + 1, u = nums.length - 1; k < nums.length; k++) {
                    if (k > j + 1 && nums[k] == nums[k - 1]) {
                        continue;
                    }
                    while (u > k && ((long)nums[i] + nums[j] + nums[k] + nums[u]) > target) {
                        u--;
                    }
                    if (((long)nums[i] + nums[j] + nums[k] + nums[u]) == target && u > k) {
                        List<Integer> subArr = Arrays.asList(nums[i], nums[j], nums[k], nums[u]);
                        result.add(subArr);
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        log.info(fourSum(new int[]{2,2,2,2,2}, 8).toString());
        log.info(fourSum(new int[]{1,0,-1,0,-2,2}, 0).toString());
        log.info(fourSum(new int[]{1000000000,1000000000,1000000000,1000000000}, -294967296).toString());
    }
}
