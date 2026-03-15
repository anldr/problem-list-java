package leetcode.Vol101to200;

public class LeetCode190 {
    public static int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i <= 31; i++) {
            result = (result << 1) + (n >> i & 1);
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 6;
        reverseBits(n);
    }
}
