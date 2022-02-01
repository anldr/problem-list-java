package leetcode.Vol701to800;

/**
 * author: xuchen
 * created: 2022/1/18 0:25
 * <p>
 * Description:
 * 1、如何高效计算n!的末尾0的个数
 * 2、如何分析出用二分推算答案
 */
public class LeetCode793 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.preimageSizeFZF(0));

        System.out.println(solution.preimageSizeFZF(5));

        System.out.println(solution.preimageSizeFZF(1000000000));
    }

    static class Solution {
        public int preimageSizeFZF(int k) {
            long l = 0;
            long r = k * 10L + 1;
            while (l < r) {
//                System.out.println("l: " + l + " r: " + r);
                long mid = (l + r) >> 1;
                long num = trailingZeroes(mid);
                if (num == k) {
                    return 5;
                } else if (num < k) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }

            return 0;
        }

        public long trailingZeroes(long n) {
            if (n == 0) {
                return 0;
            }
            return n / 5 + trailingZeroes(n / 5);
        }
    }
}
