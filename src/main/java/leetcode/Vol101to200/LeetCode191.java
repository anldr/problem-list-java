package leetcode.Vol101to200;

public class LeetCode191 {
    public int hammingWeight(int n) {
        int result = 0;
        while (n > 0) {
            n = n & (n - 1);
            result++;
        }

        return result;
    }
}
