package leetcode.Vol101to200;

public class LeetCode135 {
    public static int candy(int[] ratings) {
        int n = ratings.length;
        int result = n;

        for (int i = 0; i < n; i++) {
            int start = i > 0 && ratings[i - 1] < ratings[i] ? i - 1 : i;

            while (i + 1 < n && ratings[i] < ratings[i + 1]) {
                i++;
            }
            int top = i;

            while (i + 1 < n && ratings[i] > ratings[i + 1]) {
                 i++;
            }
            int dec = i;

            int p1 = top - start;
            int p2 = dec - top;
            result += p1 * (p1 - 1) / 2 + p2 * (p2 - 1) / 2 + Math.max(p1, p2);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,2,2,2,2,2,3};
        candy(nums);
    }
}
