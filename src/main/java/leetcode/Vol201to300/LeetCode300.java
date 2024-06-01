package leetcode.Vol201to300;

public class LeetCode300 {
    public int lengthOfLIS(int[] nums) {
        int result = -1;
        int[] arr = new int[nums.length + 7];

        for (int i = 0; i < nums.length; i++) {
            arr[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    arr[i] = Math.max(arr[i], arr[j] + 1);
                }
            }
            result = Math.max(result, arr[i]);
        }

        return result;
    }
}
