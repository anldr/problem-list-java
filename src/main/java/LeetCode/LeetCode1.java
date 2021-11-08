package LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LeetCode1 {
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> hashTable = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                if (hashTable.containsKey(target - nums[i])) {
                    return new int[]{hashTable.get(target - nums[i]), i};
                }
                hashTable.put(nums[i], i);
            }

            return new int[2];
        }

//        private int findNum(int[] nums, int target) {
//            int left = 0;
//            int right = nums.length;
//            while (left < right) {
//                int mid = (left + right) >> 1;
//                if (nums[mid] > target) {
//                    right = mid - 1;
//                } else {
//                    left = mid;
//                }
//            }
//            return left;
//        }
    }
}
