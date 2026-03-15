package leetcode.Vol1to100;

import java.util.ArrayDeque;
import java.util.Deque;

public class LeetCode4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i = 0;
        int j = 0;
        int n = nums1.length;
        int m = nums2.length;
        double result = 0.0;
        Deque<Integer> stack = new ArrayDeque<>();
        while (i < n && j < m) {
            if (nums1[i] < nums2[j]) {
                stack.push(nums1[i++]);
            } else {
                stack.push(nums2[j++]);
            }
            if (stack.size() >= (n + m + 1) / 2) {
                break;
            }
        }

        while (i < n) {
            if (stack.size() >= (n + m + 1) / 2) {
                break;
            }
            stack.push(nums1[i++]);
        }

        while (j < m) {
            if (stack.size() >= (n + m + 1) / 2) {
                break;
            }
            stack.push(nums2[j++]);
        }

        result = stack.pop();
        if (((n + m ) & 1) == 0) {
            if (i < n && j < m) {
                result = (result + Math.min(nums1[i], nums2[j])) / 2.0;
            } else if (i < n) {
                result = (result + nums1[i]) / 2.0;
            } else if (j < m) {
                result = (result + nums2[j]) / 2.0;
            }
        }

        return result;
    }
}
