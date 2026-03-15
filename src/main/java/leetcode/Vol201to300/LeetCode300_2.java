package leetcode.Vol201to300;

import java.util.Arrays;

public class LeetCode300_2 {
    public static int lengthOfLIS(int[] nums) {
        int[] arr = new int[nums.length];
        arr[0] = nums[0];
        int index = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > arr[index]) {
                arr[++index] = nums[i];
            } else {
                int pos = Arrays.binarySearch(arr, 0, index + 1, nums[i]);
                arr[Math.abs((pos < 0) ? pos + 1 : pos)] = nums[i];
            }
        }

        return index + 1;
    }

    public static void main(String[] args) {
        int[] array = new int[]{2,3,5,6,8,9};
        System.out.println(Arrays.binarySearch(array, 1));
        System.out.println(Arrays.binarySearch(array, 4));
        System.out.println(Arrays.binarySearch(array, 6));
        System.out.println(Arrays.binarySearch(array, 10));

        array = new int[]{4,10,4,3,8,9};
        System.out.println(lengthOfLIS(array));

        array = new int[]{0,1,0,3,2,3};
        System.out.println(lengthOfLIS(array));

        array = new int[]{7,7,7,7,7,7,7};
        System.out.println(lengthOfLIS(array));
    }
}
