package leetcode.Vol1to100;

public class LeetCode50 {
    public double myPow(double x, int n) {
        long absN = Math.abs((long)n);
        double result = 1;
        while (absN > 0) {
            if ((absN & 1) == 1) {
                result = result * x;
            }
            x = x * x;
            absN = absN >> 1;
        }

        if (n < 0) {
            return 1 / result;
        }
        return result;
    }
}
