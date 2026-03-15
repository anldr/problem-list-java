package leetcode.Vol201to300;

public class LeetCode202 {
    public boolean isHappy(int n) {
        int k = 50;
        while (k-- > 0) {
            if (n == 1) {
                return true;
            }
            n = getNext(n);
        }
        return false;
    }

    private int getNext(int n) {
        int total = 0;
        while (n != 0) {
            int x = n % 10;
            n = n / 10;
            total = total + x * x;
        }
        return total;
    }
}
